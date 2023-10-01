package com.cleaningservices;

import com.cleaningservices.daoImpl.*;
import com.cleaningservices.entity.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        UsuarioDAOImpl usuarioDao = new UsuarioDAOImpl();
        EmpleadoDAOImpl empleadoDao = new EmpleadoDAOImpl();
        CategoriaProductoDAOImpl categoriaProductoDao = new CategoriaProductoDAOImpl();
        MetodoPagoDAOImpl metodoPagoDao = new MetodoPagoDAOImpl();
        ProductoDAOImpl productoDao = new ProductoDAOImpl();
        OrdenCompraDAOImpl ordenCompraDao = new OrdenCompraDAOImpl();

        UsuarioEntity usuario = new UsuarioEntity("Lin", "Yasira",
                "Quintero", "lyqs@hotmail", 3206789567L,
                LocalDate.of(1993,11, 30));

        EmpleadoEntity empleado = new EmpleadoEntity("EJECUTIVO","CAJERO",
                "CC", 123456722l, 3);

        CategoriaProductoEntity categoriaProducto = new CategoriaProductoEntity("LIMPIEZA HOGAR", "DETERGENTE");

        MetodoPagoEntity metodoPago = new MetodoPagoEntity("EFECTIVO");

        ProductoEntity producto = new ProductoEntity("DETERGENTE", 1,
                "LB", 5000);

        OrdenCompraEntity ordenCompra = new OrdenCompraEntity(1 ,10, 1, 1, LocalDate.now(), 1, 5000);

        usuarioDao.insertar(usuario);
        empleadoDao.insertar(empleado);
        categoriaProductoDao.insertar(categoriaProducto);
        metodoPagoDao.insertar(metodoPago);
        productoDao.insertar(producto);
        ordenCompraDao.insertar(ordenCompra);
        usuarioDao.mostrarTabla();
        System.out.println("--------------------------------------------------");
        empleadoDao.mostrarTabla();
        System.out.println("--------------------------------------------------");
        categoriaProductoDao.mostrarTabla();
        System.out.println("--------------------------------------------------");
        metodoPagoDao.mostrarTabla();
        System.out.println("--------------------------------------------------");
        productoDao.mostrarTabla();
        System.out.println("--------------------------------------------------");
        ordenCompraDao.mostrarTabla();
    }
}