package com.cleaningservices.entity;



import com.cleaningservices.abstracts.AbstractEntity;
import com.cleaningservices.utilities.Connector;

import java.sql.*;
import java.time.LocalDate;

public class OrdenCompraEntity extends AbstractEntity {
    private int idOrdenCompra;
    private int compradorIdOrdenCompra;
    private int vendedorIdOrdenCompra;
    private int productoIdOrdenCompra;
    private int cantidadOrdenCompra;
    private LocalDate fechaOrdenCompra;
    private int metodoPagoIdOrdenCompra;
    private double precioOrdenCompra;
    private Connector connector = new Connector();

    public OrdenCompraEntity(int compradorIdOrdenCompra, int vendedorIdOrdenCompra, int productoIdOrdenCompra, int cantidadOrdenCompra, LocalDate fechaOrdenCompra, int metodoPagoIdOrdenCompra, double precioOrdenCompra) {
        this.compradorIdOrdenCompra = compradorIdOrdenCompra;
        this.vendedorIdOrdenCompra = vendedorIdOrdenCompra;
        this.productoIdOrdenCompra = productoIdOrdenCompra;
        this.cantidadOrdenCompra = cantidadOrdenCompra;
        this.fechaOrdenCompra = fechaOrdenCompra;
        this.metodoPagoIdOrdenCompra = metodoPagoIdOrdenCompra;
        this.precioOrdenCompra = precioOrdenCompra;
    }
    public OrdenCompraEntity(int idOrdenCompra, int compradorIdOrdenCompra, int vendedorIdOrdenCompra, int productoIdOrdenCompra,
                             int cantidadOrdenCompra, LocalDate fechaOrdenCompra, int metodoPagoIdOrdenCompra, double precioOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
        this.compradorIdOrdenCompra = compradorIdOrdenCompra;
        this.vendedorIdOrdenCompra = vendedorIdOrdenCompra;
        this.productoIdOrdenCompra = productoIdOrdenCompra;
        this.cantidadOrdenCompra = cantidadOrdenCompra;
        this.fechaOrdenCompra = fechaOrdenCompra;
        this.metodoPagoIdOrdenCompra = metodoPagoIdOrdenCompra;
        this.precioOrdenCompra = precioOrdenCompra;
    }

    @Override
    public void insertar(Object entidad) {
        if (entidad instanceof OrdenCompraEntity) {
            OrdenCompraEntity ordenCompra = (OrdenCompraEntity) entidad;
            String queryAddOrdenCompra = "INSERT INTO orden_compra (COMPRADOR_ID, VENDEDOR_ID, PRODUCTO_ID, CANTIDAD, " +
                    "FECHA_ORDEN, METODO_PAGO_ID, PRECIO) " + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement statement = connector.getConnection().prepareStatement(queryAddOrdenCompra)) {
                statement.setInt(1, ordenCompra.getCompradorIdOrdenCompra());
                statement.setInt(2, ordenCompra.getVendedorIdOrdenCompra());
                statement.setInt(3, ordenCompra.getProductoIdOrdenCompra());
                statement.setInt(4, ordenCompra.getCantidadOrdenCompra());
                statement.setDate(5, Date.valueOf(ordenCompra.getFechaOrdenCompra()));
                statement.setInt(6, ordenCompra.getMetodoPagoIdOrdenCompra());
                statement.setDouble(7, ordenCompra.getPrecioOrdenCompra());
                statement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Error SQL: " + e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("Error General: " + e.getMessage());
                e.printStackTrace();
            }
        }else {
            System.out.println("No se puede insertar el objeto");
        }

    }

    @Override
    public void mostrarTabla() {
        String queryMostrarData = "SELECT * FROM orden_compra limit 20";

        try (Statement statement = connector.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(queryMostrarData)) {
            System.out.println("ID :  DATOS DE LA ORDEN DE COMPRA");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("ID_ORDEN") + " : " +
                        resultSet.getInt("COMPRADOR_ID") + " " +
                        resultSet.getInt("VENDEDOR_ID") + " " +
                        resultSet.getInt("PRODUCTO_ID") + " " +
                        resultSet.getInt("CANTIDAD") + " " +
                        resultSet.getDate("FECHA_ORDEN") + " " +
                        resultSet.getInt("METODO_PAGO_ID") + " " +
                        resultSet.getDouble("PRECIO"));
            }
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error General: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public int getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(int idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public int getCompradorIdOrdenCompra() {
        return compradorIdOrdenCompra;
    }

    public void setCompradorIdOrdenCompra(int compradorIdOrdenCompra) {
        this.compradorIdOrdenCompra = compradorIdOrdenCompra;
    }

    public int getVendedorIdOrdenCompra() {
        return vendedorIdOrdenCompra;
    }

    public void setVendedorIdOrdenCompra(int vendedorIdOrdenCompra) {
        this.vendedorIdOrdenCompra = vendedorIdOrdenCompra;
    }

    public int getProductoIdOrdenCompra() {
        return productoIdOrdenCompra;
    }

    public void setProductoIdOrdenCompra(int productoIdOrdenCompra) {
        this.productoIdOrdenCompra = productoIdOrdenCompra;
    }

    public int getCantidadOrdenCompra() {
        return cantidadOrdenCompra;
    }

    public void setCantidadOrdenCompra(int cantidadOrdenCompra) {
        this.cantidadOrdenCompra = cantidadOrdenCompra;
    }

    public LocalDate getFechaOrdenCompra() {
        return fechaOrdenCompra;
    }

    public void setFechaOrdenCompra(LocalDate fechaOrdenCompra) {
        this.fechaOrdenCompra = fechaOrdenCompra;
    }

    public int getMetodoPagoIdOrdenCompra() {
        return metodoPagoIdOrdenCompra;
    }

    public void setMetodoPagoIdOrdenCompra(int metodoPagoIdOrdenCompra) {
        this.metodoPagoIdOrdenCompra = metodoPagoIdOrdenCompra;
    }

    public double getPrecioOrdenCompra() {
        return precioOrdenCompra;
    }

    public void setPrecioOrdenCompra(double precioOrdenCompra) {
        this.precioOrdenCompra = precioOrdenCompra;
    }
}
