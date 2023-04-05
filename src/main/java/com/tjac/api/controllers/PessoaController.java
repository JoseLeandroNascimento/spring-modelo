package com.tjac.api.controllers;

import com.tjac.api.dto.PessoaSaveDto;
import com.tjac.api.dto.PessoaUpdateDto;
import com.tjac.api.model.Pessoa;
import com.tjac.api.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;



@RestController()
@RequestMapping(value="pessoas",produces = "application/hal+json")
public class PessoaController implements IController<Pessoa, PessoaSaveDto, PessoaUpdateDto>{

    @Autowired
    private PessoaService service;



    @PostMapping()
    public ResponseEntity<Pessoa> save(@RequestBody PessoaSaveDto body) {

        Pessoa registro = this.service.save(body);


        return ResponseEntity.ok().body(registro);
    }

    @GetMapping("{id}")
    public ResponseEntity<Pessoa> findOne(@PathVariable("id") Long id) {


        Pessoa registro = this.service.findOne(id);

        if(registro == null){

            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(registro);
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll() {

        List<Pessoa> registros = this.service.findAll();

        return new ResponseEntity<>(registros, HttpStatus.OK);
    }

    @GetMapping("findAllPage")
    public ResponseEntity<Page<Pessoa>> findAll(@RequestParam(value = "page",required = false,defaultValue = "0") int page, @RequestParam(value = "size",required = false,defaultValue = "10") int size){

        return ResponseEntity.ok().body(this.service.findAllPage(page,size));
    }

    @PutMapping("{id}")
    public ResponseEntity<Pessoa> update( @PathVariable("id") Long id,@RequestBody PessoaUpdateDto body) {

        Pessoa registro = this.service.update(id,body);

        return ResponseEntity.ok().body(registro);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {

        this.service.delete(id);

        return ResponseEntity.ok().build();
    }



}
