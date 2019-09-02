package br.com.jonatas.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

class FactoryCandleTest {
    @Test
    public void sequenciaDeNegociacoesSimples(){
        LocalDateTime hoje = LocalDateTime.now();

        Negociacao negociacao = new Negociacao(40.0, 100, hoje);
        Negociacao negociacao2 = new Negociacao(35.0,100, hoje);
        Negociacao negociacao3 = new Negociacao(45.0,100, hoje);
        Negociacao negociacao4 = new Negociacao(20.0,100, hoje);

        List<Negociacao> negociacoes = Arrays.asList(negociacao, negociacao2, negociacao3, negociacao4);

        FactoryCandle fabrica = new FactoryCandle();

        CandleStick candle = fabrica.geraCandleParaData(negociacoes, hoje);
    }
}