package br.com.jonatas.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CandleStick {
    private final double abertura;
    private final double fechamento;
    private final double minimo;
    private final double maximo;
    private final double volume;
    private LocalDateTime data;

    public CandleStick(double abertura, double fechamento, double minimo, double maximo, double volume, LocalDateTime data) {
        this.abertura = abertura;
        this.fechamento = fechamento;
        this.minimo = minimo;
        this.maximo = maximo;
        this.volume = volume;
        this.data = data;

        if(maximo < minimo){
            throw new IllegalArgumentException("Maximo não pode ser menor que o minimo");
        }

    }

    public boolean isAlto(){
        return this.fechamento >= this.abertura;
    }

    public boolean isBaixo(){
        return this.fechamento < this.abertura;
    }
}