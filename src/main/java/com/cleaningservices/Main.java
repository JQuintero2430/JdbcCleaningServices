package com.cleaningservices;

import com.cleaningservices.daoImpl.UsuarioDAOImpl;
import com.cleaningservices.entity.UsuarioEntity;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        UsuarioDAOImpl usuarioDao = new UsuarioDAOImpl();

        UsuarioEntity usuario = new UsuarioEntity("Liz", "Quintero",
                "Suarez", "ljfa@hotmail", 3206789535L,
                LocalDate.of(1993,11, 30));

        usuarioDao.insertar(usuario);
        usuarioDao.mostrarTabla();
    }
}