package br.com.jonatas.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class CandleStickBuilderTest {
    @Test
    public void testeCandleBuild(){
        CandleBuilder builder = new CandleBuilder();
        CandleStick candle = builder.comAbertura(10.0).comFechamento(20.0).comMinimo(10.0).comMaximo(100.0)
                .comVolume(100.0).comData(LocalDateTime.now()).geraCandle();
    }
}