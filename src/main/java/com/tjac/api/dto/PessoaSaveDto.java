package com.tjac.api.dto;

import com.tjac.api.model.Pessoa;
import lombok.Data;

@Data
public class PessoaSaveDto implements IDto<Pessoa>{

    private String name;
    private int idade;

    @Override
    public Pessoa toModel() {
        return new Pessoa(this.name,this.idade);
    }
}
