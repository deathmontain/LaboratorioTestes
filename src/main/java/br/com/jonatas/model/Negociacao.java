package br.com.jonatas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class Negociacao {
    private final double preco;
    private final int quantidade;
    private final LocalDateTime data;

    public double getVolume(){
        return this.preco * this.quantidade;
    }
}