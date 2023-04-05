package com.tjac.api.dto;

public interface IDto <E>{

    // Deve retorna a entidade
    public E toModel();
}
