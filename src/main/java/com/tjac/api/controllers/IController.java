package com.tjac.api.controllers;


import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public interface IController <E,S,U>{

    public ResponseEntity<E> save(S body);

    public ResponseEntity<E> findOne(Long id);

    public ResponseEntity<List<E>> findAll();

    public ResponseEntity<E> update(Long id, U body);

    public ResponseEntity<?> delete(Long id);

}
