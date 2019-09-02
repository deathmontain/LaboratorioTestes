package br.com.jonatas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Negociacao {
    private final double preco;
    private final int quantidade;
    private final LocalDateTime data;

    public Negociacao(double preco, int quantidade, LocalDateTime data) {
        if(preco < 0){
            throw new IllegalArgumentException("Preco não pode ser negativo");
        }

        if(quantidade < 0){
            throw new IllegalArgumentException("Quantidade não pode ser menor ou igual a zero");
        }

        if (data == null){
            throw new IllegalArgumentException("Data não pode ser nula");
        }

        this.preco = preco;
        this.quantidade = quantidade;
        this.data = data;
    }

    public double getVolume(){
        return this.preco * this.quantidade;
    }
}