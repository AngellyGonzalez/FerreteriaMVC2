/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author HP 17-CN0
 */
public class Producto {
private int idProducto;
private String NombreProducto;
private String DescripcionProducto;
private int idCategoria; // Relación con Categoria
private float PrecioUnitario;
private int Stock;
private String Imagen;

    public Producto(int idProducto, String NombreProducto, String DescripcionProducto, int idCategoria, float PrecioUnitario, int Stock, String Imagen) {
        this.idProducto = idProducto;
        this.NombreProducto = NombreProducto;
        this.DescripcionProducto = DescripcionProducto;
        this.idCategoria = idCategoria;
        this.PrecioUnitario = PrecioUnitario;
        this.Stock = Stock;
        this.Imagen = Imagen;
    }

    public Producto() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public String getDescripcionProducto() {
        return DescripcionProducto;
    }

    public void setDescripcionProducto(String DescripcionProducto) {
        this.DescripcionProducto = DescripcionProducto;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public float getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(float PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }

   


}
