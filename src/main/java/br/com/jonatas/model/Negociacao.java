package br.com.jonatas.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@EqualsAndHashCode
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

    public boolean mesmoDia(LocalDateTime outraData) {
        return this.data.getDayOfMonth() == outraData.getDayOfMonth()
                && data.getMonth() == outraData.getMonth();
    }
}