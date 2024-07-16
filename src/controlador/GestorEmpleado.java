package controlador;

import modelo.*;
import bd.Conexion;
import java.sql.*;

public class GestorEmpleado {

    public boolean agregarEmpleado(Empleado emp) throws SQLException {
        try (Connection conexion = Conexion.getConexion()) {
            if (!existeDepartamento(emp.getDepartamentoId(), conexion)) {
                throw new IllegalArgumentException("El departamento con ID " + emp.getDepartamentoId() + " no existe.");
            }

            String query = "INSERT INTO empleados(run, nombre, apellido, departamento_id, responsable_de_area) VALUES(?, ?, ?, ?, ?)";

            try (PreparedStatement ins = conexion.prepareStatement(query)) {
                ins.setString(1, emp.getRun());
                ins.setString(2, emp.getNombre());
                ins.setString(3, emp.getApellido());
                ins.setInt(4, emp.getDepartamentoId());
                ins.setBoolean(5, emp.isResponsableDeArea());

                int filasAfectadas = ins.executeUpdate();
                return filasAfectadas > 0;
            }
        }
    }
    
    public boolean eliminarEmpleado(String run) throws SQLException {
        try (Connection conexion = Conexion.getConexion()) {
            // Obtener el ID del empleado antes de eliminarlo
            int idEmpleado = obtenerIdEmpleadoPorRun(run, conexion);

            // Actualizar la referencia en la tabla departamentos
            actualizarReferenciaDepartamentos(idEmpleado, conexion);

            // Eliminar al empleado
            String query = "DELETE FROM empleados WHERE run=?";
            try (PreparedStatement del = conexion.prepareStatement(query)) {
                del.setString(1, run);
                int filasAfectadas = del.executeUpdate();
                return filasAfectadas > 0;
            }
        }
    }
    
    public boolean actualizarEmpleado(String runAntiguo, String runNuevo, String nombre, String apellido, int idDepartamento, Boolean responsableDeArea) throws SQLException {
        try (Connection conexion = Conexion.getConexion()) {
            if (!runAntiguo.equals(runNuevo) && validarRun(runNuevo)) {
                throw new IllegalArgumentException("El nuevo RUN ya está en uso.");
            }

            if (!existeDepartamento(idDepartamento, conexion)) {
                throw new IllegalArgumentException("El departamento con ID " + idDepartamento + " no existe.");
            }

            String query = "UPDATE empleados SET run=?, nombre=?, apellido=?, departamento_id=?, responsable_de_area=? WHERE run=?";
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, runNuevo);
                ps.setString(2, nombre);
                ps.setString(3, apellido);
                ps.setInt(4, idDepartamento);

                if (responsableDeArea == null) {
                    ps.setNull(5, Types.BOOLEAN); // Establece el valor como NULL
                } else {
                    ps.setBoolean(5, responsableDeArea);
                }

                ps.setString(6, runAntiguo);

                int filasAfectadas = ps.executeUpdate();
                return filasAfectadas > 0;
            }
        }
    }
    
    public boolean validarRun(String run) throws SQLException {
        try (Connection conexion = Conexion.getConexion()) {
            String query = "SELECT * FROM empleados WHERE run=?";
            try (PreparedStatement bus = conexion.prepareStatement(query)) {
                bus.setString(1, run);
                ResultSet rs = bus.executeQuery();
                return rs.next();
            }
        }
    }
    
    private boolean existeDepartamento(int idDepartamento, Connection conexion) throws SQLException {
        String query = "SELECT id FROM departamentos WHERE id = ?";
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, idDepartamento);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // Retorna true si encuentra un departamento con ese ID
        }
    }
    
    private void actualizarReferenciaDepartamentos(int idEmpleado, Connection conexion) throws SQLException {
        // Actualizar las referencias en la tabla departamentos
        String query = "UPDATE departamentos SET responsable_de_area_id = NULL WHERE responsable_de_area_id = ?";
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, idEmpleado);
            ps.executeUpdate();
        }
    }

    private int obtenerIdEmpleadoPorRun(String run, Connection conexion) throws SQLException {
        String query = "SELECT id FROM empleados WHERE run=?";
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1, run);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        }
        return -1; // Si no se encuentra el empleado, se retorna -1
    }

    public int obtenerIdUltimoEmpleado() throws SQLException {
        int idUltimoEmpleado = -1;
        Connection conexion = null;
        PreparedStatement consulta = null;
        ResultSet resultado = null;

        try {
            // Establecer conexión
            conexion = Conexion.getConexion();

            // Consulta para obtener el ID del último empleado agregado
            String sql = "SELECT MAX(id) AS max_id FROM Empleados";
            consulta = conexion.prepareStatement(sql);

            // Ejecutar consulta
            resultado = consulta.executeQuery();

            // Obtener el ID del último empleado
            if (resultado.next()) {
                idUltimoEmpleado = resultado.getInt("max_id");
            }
        } finally {
            // Cerrar recursos
            if (resultado != null) {
                resultado.close();
            }
            if (consulta != null) {
                consulta.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }

        return idUltimoEmpleado;
    }

    public int obtenerIdEmpleado(String runNuevo) {
        int idEmpleado = -1; // Valor por defecto en caso de no encontrar el empleado

        try {
            Connection conexion = Conexion.getConexion();
            try (PreparedStatement ps = conexion.prepareStatement("SELECT id FROM empleados WHERE run = ?")) {
                ps.setString(1, runNuevo);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        idEmpleado = rs.getInt("id");
                    }
                }
            }
        } catch (SQLException e) {
        System.err.println("Error al realizar la operación en la base de datos: " + e.getMessage());
        }

        return idEmpleado;
    }
    
    public Integer obtenerIdEmpleadoPorNombreCompleto(String nombreCompleto) throws SQLException {
        Connection conexion = Conexion.getConexion();
        String query = "SELECT id FROM empleados WHERE CONCAT(nombre, ' ', apellido) = ?";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setString(1, nombreCompleto);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt("id");
        }
        return null; // Devolver null si no se encuentra el empleado
    }
    
    public int obtenerIdEmpleadoPorRun(String run) throws SQLException {
        try (Connection conexion = Conexion.getConexion()) {
            String query = "SELECT id FROM empleados WHERE run=?";
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, run);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return rs.getInt("id");
                    }
                }
            }
        }
        return -1; // Retorna -1 si no se encuentra el empleado
    }
    
    public boolean empleadoTieneEquiposAsignados(String run) throws SQLException {
        int empleadoId = obtenerIdEmpleadoPorRun(run);
        if (empleadoId == -1) {
            throw new IllegalArgumentException("Empleado con RUN " + run + " no encontrado.");
        }

        try (Connection conexion = Conexion.getConexion()) {
            String query = "SELECT COUNT(*) FROM equipos WHERE responsable_de_area_id=? OR asignado_id=?";
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setInt(1, empleadoId);
                ps.setInt(2, empleadoId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return rs.getInt(1) > 0;
                    }
                }
            }
        }
        return false;
    }

}