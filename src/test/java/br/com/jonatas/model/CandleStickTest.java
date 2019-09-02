package br.com.jonatas.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CandleStickTest {
    @Test
    public void maximoNaoPodeSerMenorQueMinimo(){
        LocalDateTime hoje = LocalDateTime.now();

        assertThrows(IllegalArgumentException.class, ()-> {
        CandleBuilder builder = new CandleBuilder();
        CandleStick candle = builder.comAbertura(10.0).comFechamento(20.0).comMinimo(300.0).comMaximo(100.0)
                .comVolume(100.0).comData(hoje).geraCandle();
        });
    }
}
