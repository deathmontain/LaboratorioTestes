package br.com.jonatas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class CandleStick {
    private final double abertura;
    private final double fechamento;
    private final double minimo;
    private final double maximo;
    private final double volume;
    private LocalDateTime data;

//    public boolean isAlto(){
//        return this.fechamento > this.abertura;
//    }
//
//    public boolean isBaixo(){
//        return this.fechamento < this.abertura;
//    }
}