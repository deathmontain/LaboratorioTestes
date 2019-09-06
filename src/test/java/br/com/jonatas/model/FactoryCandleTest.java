package br.com.jonatas.model;

import org.junit.jupiter.api.Assertions;
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

        Assertions.assertEquals(40.0, candle.getAbertura(), 0.00001);
        Assertions.assertEquals(20.0, candle.getFechamento(), 0.00001);
        Assertions.assertEquals(20.0, candle.getMinimo(), 0.00001);
        Assertions.assertEquals(45.0, candle.getMaximo(), 0.00001);
        Assertions.assertEquals(14000.0, candle.getVolume(), 0.00001);
    }

    @Test
    public void geraCandleStickComApenasUmaNegociacao(){
        LocalDateTime hoje = LocalDateTime.now();

        Negociacao negociacao = new Negociacao(40.0, 100, hoje);
        List<Negociacao> negociacoes = Arrays.asList(negociacao);
        FactoryCandle fabrica = new FactoryCandle();
        CandleStick candle = fabrica.geraCandleParaData(negociacoes, hoje);

        Assertions.assertEquals(40.0, candle.getAbertura(), 0.00001);
        Assertions.assertEquals(40.0, candle.getFechamento(), 0.00001);
        Assertions.assertEquals(40.0, candle.getMinimo(), 0.00001);
        Assertions.assertEquals(40.0, candle.getMaximo(), 0.00001);
        Assertions.assertEquals(4000.0, candle.getVolume(), 0.00001);
    }

    @Test
    public void geraCandleStickSemNegociacoes (){
        LocalDateTime hoje = LocalDateTime.now();

        Negociacao negociacao = new Negociacao(40.0, 100, hoje);
        List<Negociacao> negociacoes = Arrays.asList(negociacao);;
        FactoryCandle fabrica = new FactoryCandle();
        CandleStick candle = fabrica.geraCandleParaData(negociacoes, hoje);

        Assertions.assertEquals(40.0, candle.getAbertura(), 0.00001);
        Assertions.assertEquals(40.0, candle.getFechamento(), 0.00001);
        Assertions.assertEquals(40.0, candle.getMinimo(), 0.00001);
        Assertions.assertEquals(40.0, candle.getMaximo(), 0.00001);
        Assertions.assertEquals(4000.0, candle.getVolume(), 0.00001);
    }

    @Test
    public void negociacaoDeTresDiasDiferenteGeraTresCandlesDiferente(){
        LocalDateTime hoje = LocalDateTime.now();

        Negociacao negociacao = new Negociacao(50.0, 20, hoje);
        Negociacao negociacao2 = new Negociacao(100.0, 20, hoje);
        Negociacao negociacao3 = new Negociacao(150.0, 20, hoje);

        LocalDateTime amanha = hoje.plusDays(1);

        Negociacao negociacao4 = new Negociacao(50.0, 100, amanha);
        Negociacao negociacao5 = new Negociacao(10.0, 20, amanha);

        LocalDateTime depoisDeAmanha = hoje.plusDays(2)

        Negociacao negociacao6 = new Negociacao(35.0, 20, depoisDeAmanha);
        Negociacao negociacao7 = new Negociacao(35.0, 20, depoisDeAmanha);

        List<Negociacao> negociacoes = Arrays.asList(negociacao, negociacao2, negociacao3,
                negociacao4, negociacao5, negociacao6, negociacao7);

        FactoryCandle fabrica = new FactoryCandle();
        List<CandleStick> candles = fabrica.constroiCandles(negociacoes);

        Assertions.assertTrue(negociacoes.get(0).mesmoDia(candles.get(0).getData()));
        Assertions.assertTrue(negociacoes.get(1).mesmoDia(candles.get(1).getData()));
        Assertions.assertTrue(negociacoes.get(2).mesmoDia(candles.get(2).getData()));
        Assertions.assertEquals(6000.0, candles.get(0).getVolume(), 0.000001);
        Assertions.assertEquals(50.0, candles.get(0).getMinimo(), 0.000001);
        Assertions.assertEquals(150.0, candles.get(0).getMaximo(), 0.000001);
        Assertions.assertEquals(50.0, candles.get(0).getAbertura(), 0.000001);
        Assertions.assertEquals(150.0, candles.get(0).getFechamento(), 0.000001);
    }
}