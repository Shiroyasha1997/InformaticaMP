package controlador;

import modelo.*;
import bd.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestorDepartamento {

    public boolean actualizarDepartamentoResponsable(int departamentoId, Integer empleadoId) throws SQLException {
        String query = "UPDATE Departamentos SET responsable_de_area_id = ? WHERE id = ?";

        try (Connection conexion = Conexion.getConexion();
             PreparedStatement ps = conexion.prepareStatement(query)) {

            if (empleadoId == null) {
                ps.setNull(1, Types.INTEGER); // Establece el valor como NULL
            } else {
                ps.setInt(1, empleadoId);
            }

            ps.setInt(2, departamentoId);

            int filasActualizadas = ps.executeUpdate();

            return filasActualizadas > 0;
        }
    }

    public List<Departamento> obtenerTodosDepartamentos() throws SQLException {
        List<Departamento> departamentos = new ArrayList<>();
        String sql = "SELECT * FROM Departamentos";
        try (Connection conexion = Conexion.getConexion();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Departamento departamento = new Departamento();
                departamento.setId(rs.getInt("id"));
                departamento.setNombre(rs.getString("nombre"));
                departamento.setResponsableDeAreaId(rs.getInt("responsable_de_area_id"));
                departamentos.add(departamento);
            }
        }
        return departamentos;
    }

    public Departamento obtenerDepartamentoPorId(int departamentoId) throws SQLException {
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Departamento departamento = null;

        try {
            conexion = Conexion.getConexion();
            String query = "SELECT * FROM Departamentos WHERE id = ?";
            ps = conexion.prepareStatement(query);
            ps.setInt(1, departamentoId);
            rs = ps.executeQuery();

            if (rs.next()) {
                departamento = new Departamento();
                departamento.setId(rs.getInt("id"));
                departamento.setNombre(rs.getString("nombre"));
                departamento.setResponsableDeAreaId(rs.getInt("responsable_de_area_id"));
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }

        return departamento;
    }
}