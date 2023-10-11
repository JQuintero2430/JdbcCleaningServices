package com.cleaningservices.daointerface;

public interface IDAO {
    void insertar(Object entidad);
    void mostrarTabla();
    void actualizar(Integer id, String tabla, String column, String value);
    void eliminar(int id, String tabla);
}
