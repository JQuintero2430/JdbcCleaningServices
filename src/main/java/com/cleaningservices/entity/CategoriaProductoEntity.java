package com.cleaningservices.entity;

import com.cleaningservices.dao.IActualizar;
import com.cleaningservices.dao.IBorrar;
import com.cleaningservices.dao.IInsertar;
import com.cleaningservices.dao.IMostrarTabla;
import com.cleaningservices.utilities.Connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CategoriaProductoEntity implements IInsertar<CategoriaProductoEntity>, IMostrarTabla, IActualizar, IBorrar {
    private int idCategoriaProducto;
    private String nombreCategoriaProducto;
    private String tipoCategoriaProducto;
    private Connector connector = new Connector();

    public CategoriaProductoEntity(String nombreCategoriaProducto, String tipoCategoriaProducto) {
        this.nombreCategoriaProducto = nombreCategoriaProducto;
        this.tipoCategoriaProducto = tipoCategoriaProducto;
    }

    public CategoriaProductoEntity(int idCategoriaProducto, String nombreCategoriaProducto, String tipoCategoriaProducto) {
        this.idCategoriaProducto = idCategoriaProducto;
        this.nombreCategoriaProducto = nombreCategoriaProducto;
        this.tipoCategoriaProducto = tipoCategoriaProducto;
    }

    @Override
    public void insertar(CategoriaProductoEntity entidad) {
        String queryAddCategoriaProducto = "INSERT INTO categoria_producto (NOMBRE_CATEGORIA_PRODUCTO, TIPO_CATEGORIA_PRODUCTO) " +
                "VALUES (?, ?)";

        try (PreparedStatement statement = connector.getConnection().prepareStatement(queryAddCategoriaProducto)) {
            statement.setString(1, entidad.getNombreCategoriaProducto());
            statement.setString(2, entidad.getTipoCategoriaProducto());
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
        String queryMostrarDataCategoriaProducto = "SELECT * FROM categoria_producto limit 20";

        try (Statement statement = connector.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(queryMostrarDataCategoriaProducto)) {
            System.out.println("ID :  DATOS DE LA CATEGORIA DE PRODUCTO");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("ID_CATEGORIA_PRODUCTO") + " : " +
                        resultSet.getString("NOMBRE_CATEGORIA_PRODUCTO") + " " +
                        resultSet.getString("TIPO_CATEGORIA_PRODUCTO"));
            }

        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error General: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public int getIdCategoriaProducto() {
        return idCategoriaProducto;
    }

    public void setIdCategoriaProducto(int idCategoriaProducto) {
        this.idCategoriaProducto = idCategoriaProducto;
    }

    public String getNombreCategoriaProducto() {
        return nombreCategoriaProducto;
    }

    public void setNombreCategoriaProducto(String nombreCategoriaProducto) {
        this.nombreCategoriaProducto = nombreCategoriaProducto;
    }

    public String getTipoCategoriaProducto() {
        return tipoCategoriaProducto;
    }

    public void setTipoCategoriaProducto(String tipoCategoriaProducto) {
        this.tipoCategoriaProducto = tipoCategoriaProducto;
    }
}
