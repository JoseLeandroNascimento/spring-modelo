package com.tjac.api.service;

import java.util.List;

public interface IService <E,S,U>{

    public E save(S body);

    public E findOne(Long id);

    public List<E> findAll();

    public E update(Long id, U body);

    public void delete(Long id);
}
