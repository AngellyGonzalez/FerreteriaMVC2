/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Usuario;
import Util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP 17-CN0
 */
public class UsuarioDAO {

    public void crearUsuario(Usuario usuario) throws SQLException {
        String sql = """
        INSERT INTO Usuarios (
            usuario, 
            contraseña
        ) VALUES (?, ?)""";

        try (Connection c = ConexionBD.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getContrasena());
            stmt.executeUpdate();
        }
    }

    public List<Usuario> leerTodosUsuarios() throws SQLException {
        String sql = "SELECT * FROM Usuarios";
        List<Usuario> usuarios = new ArrayList<>();

        try (Connection c = ConexionBD.getConnection(); PreparedStatement stmt = c.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setContrasena(rs.getString("contraseña"));
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }

    // Método para actualizar un usuario
    public void actualizarUsuario(Usuario usuario) throws SQLException {
        String sql = "UPDATE Usuarios SET usuario = ?, contraseña = ? WHERE id_usuario = ?";

        try (Connection c = ConexionBD.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getContrasena());
            stmt.setInt(3, usuario.getIdUsuario());
            stmt.executeUpdate();
        }
    }

// Método para eliminar un usuario
    public void eliminarUsuario(int idUsuario) throws SQLException {
        String sql = "DELETE FROM Usuarios WHERE id_usuario = ?";

        try (Connection c = ConexionBD.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            stmt.executeUpdate();
        }
    }

    public static void main(String[] args) {
        try {
            UsuarioDAO dao = new UsuarioDAO();

            // Eliminar un usuario
            dao.eliminarUsuario(2); // ID a eliminar
            System.out.println("Usuario eliminado.");

            List<Usuario> usuarios = dao.leerTodosUsuarios();
            System.out.println("Lista de usuarios:");
            for (Usuario usu : usuarios) {
                System.out.println("ID: " + usu.getIdUsuario()
                        + ", Usuario: " + usu.getUsuario()
                        + ", Contraseña: " + usu.getContrasena());
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
