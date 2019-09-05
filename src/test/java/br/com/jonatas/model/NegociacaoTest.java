package br.com.jonatas.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class NegociacaoTest {

    @Test//(expected = IllegalArgumentException.class)
    public void negociacaoNaoPodeTerPrecoNegativo(){
        assertThrows(IllegalArgumentException.class, ()-> {
            new Negociacao(-20.0, 3, LocalDateTime.now());
        });
    }

    @Test
    public void dataNegociacaoNaoPodeSerNula(){
        assertThrows(IllegalArgumentException.class, ()-> {
            new Negociacao(-20.0, 3, null);
        });
    }

    @Test
    public void negociacaoNaoPodeTerQuantidadeMenorOuIgualaZero(){
        assertThrows(IllegalArgumentException.class, ()-> {
            new Negociacao(-20.0, -3, null);
        });
    }

    @Test
    public void testaSeEMesmoDia(){
        LocalDateTime hoje = LocalDateTime.of(2016,04,04, 12, 00);;
        LocalDateTime agora = LocalDateTime.of(2016,04,04, 02, 00);;
        Negociacao negociacao = new Negociacao(100.0, 20, hoje);
        Assertions.assertTrue(negociacao.isMesmoDia(agora));
    }
}