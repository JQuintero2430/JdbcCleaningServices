package com.cleaningservices;

import com.cleaningservices.entity.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

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

    }
}