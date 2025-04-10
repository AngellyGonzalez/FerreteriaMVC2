/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Categoria;
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
public class CategoriaDAO {

    public void crearCategoria(Categoria categoria) throws SQLException {
        String sql = "INSERT INTO Categorias (nombre_categoria, descripcion_categoria) VALUES (?, ?)";
        try (Connection c = ConexionBD.getConnection(); PreparedStatement Stmt = c.prepareStatement(sql)) {
            Stmt.setString(1, categoria.getNombreCategoria());
            Stmt.setString(1, categoria.getDescripcionCategoria());
            Stmt.execute();
        }
    }

    // Método para leer todas las categorías
    public List<Categoria> leerTodasCategorias() throws SQLException {
        String sql = "SELECT * FROM Categorias";
        List<Categoria> categorias = new ArrayList<>();
        try (Connection c = ConexionBD.getConnection(); PreparedStatement stmt = c.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNombreCategoria(rs.getString("nombre_categoria"));
                categoria.setDescripcionCategoria(rs.getString("descripcion_categoria"));
                categorias.add(categoria);
            }
        }
        return categorias;
    }

    public void actualizarCategoria(Categoria categoria) throws SQLException {
        String sql = "UPDATE Categorias SET nombre_categoria = ?, descripcion_categoria = ? WHERE id_categoria = ?";

        try (Connection c = ConexionBD.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNombreCategoria());
            stmt.setString(2, categoria.getDescripcionCategoria());
            stmt.setInt(3, categoria.getIdCategoria());
            stmt.executeUpdate();
        }
    }

    // Método para eliminar una categoría
    public void eliminarCategoria(int idCategoria) throws SQLException {
        String sql = "DELETE FROM Categorias WHERE id_categoria = ?";

        try (Connection c = ConexionBD.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, idCategoria);
            stmt.executeUpdate();
        }
    }

    public static void main(String[] args) {
        try {

            CategoriaDAO dao = new CategoriaDAO();

            // Eliminar una categoría
            dao.eliminarCategoria(2); // ID a eliminar
            System.out.println("Categoría eliminada.");

            // Leer y mostrar todas las categorías
            List<Categoria> categorias = dao.leerTodasCategorias();
            System.out.println("\nLista de categorías:");
            for (Categoria cat : categorias) {
                System.out.println("ID: " + cat.getIdCategoria()
                        + ", Nombre: " + cat.getNombreCategoria()
                        + ", Descripción: " + cat.getDescripcionCategoria());

            }
        } catch (SQLException e) {
            System.out.println("Error al crear categoria: " + e.getMessage());
        }
    }

}
