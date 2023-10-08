package com.cleaningservices.entity;

import com.cleaningservices.crudinterfaces.IActualizar;
import com.cleaningservices.crudinterfaces.IBorrar;
import com.cleaningservices.crudinterfaces.IInsertar;
import com.cleaningservices.crudinterfaces.IMostrarTabla;
import com.cleaningservices.utilities.Connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductoEntity implements IInsertar<ProductoEntity>, IMostrarTabla, IActualizar, IBorrar {
    private int idProducto;
    private String nombreProducto;
    private int categoriaProducto;
    private String medidaProducto;
    private double precioProducto;
    private Connector connector = new Connector();

    public ProductoEntity(String nombreProducto, int categoriaProducto, String medidaProducto, double precioProducto) {
        this.nombreProducto = nombreProducto;
        this.categoriaProducto = categoriaProducto;
        this.medidaProducto = medidaProducto;
        this.precioProducto = precioProducto;
    }

    public ProductoEntity(int idProducto, String nombreProducto, int categoriaProducto, String medidaProducto, double precioProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.categoriaProducto = categoriaProducto;
        this.medidaProducto = medidaProducto;
        this.precioProducto = precioProducto;
    }

    @Override
    public void insertar(ProductoEntity producto) {
        String queryAddProducto = "INSERT INTO producto (NOMBRE, CATEGORIA_ID, MEDIDA, PRECIO) " +
                "VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connector.getConnection().prepareStatement(queryAddProducto)) {
            statement.setString(1, producto.getNombreProducto());
            statement.setInt(2, producto.getCategoriaProducto());
            statement.setString(3, producto.getMedidaProducto());
            statement.setDouble(4, producto.getPrecioProducto());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error General: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void mostrarTabla() {
        String queryMostrarData = "SELECT * FROM producto limit 20";

        try (Statement statement = connector.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(queryMostrarData)) {
            System.out.println("ID :  DATOS DEL PRODUCTO");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("ID_PRODUCTO") + " : " +
                        resultSet.getString("NOMBRE") + " " +
                        resultSet.getInt("CATEGORIA_ID") + " " +
                        resultSet.getString("MEDIDA") + " " +
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

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(int categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public String getMedidaProducto() {
        return medidaProducto;
    }

    public void setMedidaProducto(String medidaProducto) {
        this.medidaProducto = medidaProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }
}
