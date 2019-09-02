package br.com.jonatas.model;

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
}