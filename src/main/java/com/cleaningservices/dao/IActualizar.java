package com.cleaningservices.dao;

public interface IActualizar <T, U, V>{
    public void actualizar(T id, U column ,V value);
}
