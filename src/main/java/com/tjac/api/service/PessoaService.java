package com.tjac.api.service;

import com.tjac.api.dto.PessoaSaveDto;
import com.tjac.api.dto.PessoaUpdateDto;
import com.tjac.api.model.Pessoa;
import com.tjac.api.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PessoaService implements IService<Pessoa, PessoaSaveDto, PessoaUpdateDto>{

    @Autowired
    private PessoaRepository repo;

    @Override
    public Pessoa save(PessoaSaveDto body) {

        Pessoa registro = this.repo.save(body.toModel());

        return registro;
    }

    @Override
    public Pessoa findOne(Long id) {


        return this.repo.findById(id).orElse(null);
    }

    @Override
    public List<Pessoa> findAll() {

        return this.repo.findAll();
    }

    @Override
    public Pessoa update(Long id, PessoaUpdateDto body) {

        if(this.findOne(id) == null){

            return null;
        }

        Pessoa registroUpdate = body.toModel();
        registroUpdate.setId(id);

        return this.repo.save(registroUpdate);

    }

    @Override
    public void delete(Long id) {

        this.repo.deleteById(id);

    }

    public Page<Pessoa> findAllPage(int page,int size){

        PageRequest pageRequest = PageRequest.of(page,size, Sort.Direction.ASC,"name");

        return this.repo.findAll(pageRequest);

    }
}
