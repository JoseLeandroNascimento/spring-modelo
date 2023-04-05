package com.tjac.api.dto;

import com.tjac.api.model.Pessoa;

public class PessoaUpdateDto implements IDto<Pessoa>{

    public String name;
    public int idade;

    @Override
    public Pessoa toModel() {
        return new Pessoa(this.name,this.idade);
    }
}
