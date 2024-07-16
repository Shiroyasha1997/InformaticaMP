package controlador;

import modelo.*;
import bd.Conexion;
import java.sql.*;

public class GestorEquipo {
    
    public boolean agregarEquipo(Equipo equipo) throws SQLException {
        try (Connection conexion = Conexion.getConexion()) {
            String query = "INSERT INTO Equipos(tipo, fecha, marca, orden_de_compra, modelo, numero_de_serie, mac, estado, responsable_de_area_id, asignado_id, sistema_operativo, ram, almacenamiento, ups, procesador) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement ins = conexion.prepareStatement(query)) {
                ins.setString(1, equipo.getTipo());
                ins.setString(2, equipo.getFecha());
                ins.setString(3, equipo.getMarca());
                ins.setString(4, equipo.getOrdenDeCompra());
                ins.setString(5, equipo.getModelo());
                ins.setString(6, equipo.getNumeroDeSerie());
                ins.setString(7, equipo.getMac());
                ins.setString(8, equipo.getEstado());

                if (equipo.getResponsableDeAreaId() != null) {
                    ins.setInt(9, equipo.getResponsableDeAreaId());
                } else {
                    ins.setNull(9, java.sql.Types.INTEGER);
                }

                if (equipo.getAsignadoId() != null) {
                    ins.setInt(10, equipo.getAsignadoId());
                } else {
                    ins.setNull(10, java.sql.Types.INTEGER);
                }

                ins.setString(11, equipo.getSistemaOperativo());
                ins.setString(12, equipo.getRam());
                ins.setString(13, equipo.getAlmacenamiento());
                ins.setBoolean(14, equipo.isUps());
                ins.setString(15, equipo.getProcesador());

                int filasAfectadas = ins.executeUpdate();
                return filasAfectadas > 0;
            }
        }
    }
    
    public boolean actualizarEquipo(Equipo equipo) throws SQLException {
        try (Connection conexion = Conexion.getConexion()) {
            String query = "UPDATE Equipos SET tipo=?, fecha=?, marca=?, orden_de_compra=?, modelo=?, numero_de_serie=?, mac=?, estado=?, responsable_de_area_id=?, asignado_id=?, sistema_operativo=?, ram=?, almacenamiento=?, ups=?, procesador=? WHERE id=?";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, equipo.getTipo());
                ps.setString(2, equipo.getFecha());
                ps.setString(3, equipo.getMarca());
                ps.setString(4, equipo.getOrdenDeCompra());
                ps.setString(5, equipo.getModelo());
                ps.setString(6, equipo.getNumeroDeSerie());
                ps.setString(7, equipo.getMac());
                ps.setString(8, equipo.getEstado());

                if (equipo.getResponsableDeAreaId() != null) {
                    ps.setInt(9, equipo.getResponsableDeAreaId());
                } else {
                    ps.setNull(9, java.sql.Types.INTEGER);
                }

                if (equipo.getAsignadoId() != null) {
                    ps.setInt(10, equipo.getAsignadoId());
                } else {
                    ps.setNull(10, java.sql.Types.INTEGER);
                }

                ps.setString(11, equipo.getSistemaOperativo());
                ps.setString(12, equipo.getRam());
                ps.setString(13, equipo.getAlmacenamiento());
                ps.setBoolean(14, equipo.isUps());
                ps.setString(15, equipo.getProcesador());
                ps.setInt(16, equipo.getId());

                int filasAfectadas = ps.executeUpdate();
                return filasAfectadas > 0;
            }
        }
    }
    
    public boolean eliminarEquipo(String numeroDeSerie) throws SQLException {
        try (Connection conexion = Conexion.getConexion()) {
            String query = "DELETE FROM equipos WHERE numero_de_serie=?";
            try (PreparedStatement del = conexion.prepareStatement(query)) {
                del.setString(1, numeroDeSerie);
                int filasAfectadas = del.executeUpdate();
                return filasAfectadas > 0;
            }
        }
    }

    public int obtenerIdEquipoPorNumeroDeSerie(String numeroDeSerie) throws SQLException {
        int idEquipo = 0; // Inicializamos el ID del equipo como 0

        try (Connection conexion = Conexion.getConexion()) {
            String query = "SELECT id FROM Equipos WHERE numero_de_serie = ?";
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, numeroDeSerie);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        idEquipo = rs.getInt("id"); // Obtenemos el ID del equipo si existe
                    }
                }
            }
        }

        return idEquipo;
    }

    private boolean validarEmpleado(int idEmpleado) {
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT COUNT(*) AS count FROM Empleados WHERE id = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, idEmpleado);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                return count > 0; // Retorna true si encuentra un empleado con ese ID
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar el empleado: " + e.getMessage());
        }
        return false;
    }
}
