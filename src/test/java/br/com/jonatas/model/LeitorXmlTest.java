package br.com.jonatas.model;

import Config.LeitorXml;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

public class LeitorXmlTest {
    @Test
    public void carregaXmlComApenasUmanegociacao(){
        String xml =
                "<list>\n"
                +"  <negociacao>\n"
                +"    <preco>10.0</preco>\n"
                +"    <quantidade>4</quantidade>\n"
                +"    <data>\n"
                +"      <time>1459782000000</time>\n"
                +"      <timeZone>America/Sao_Paulo</timeZone>\n"
                +"    </data>\n"
                +"  </negociacao>\n"
                +"</list>";

        LeitorXml leitorXml = new LeitorXml();
        InputStream inputStream = new ByteArrayInputStream(xml.getBytes());
        List<Negociacao> listaNegociacao = leitorXml.carregaXml(inputStream);
        Negociacao negociacaosEsperada = new Negociacao(10.0, 4, LocalDateTime.of(2016, 4,
                04, 12, 00));
        Assertions.assertEquals(1, listaNegociacao.size());
        Assertions.assertEquals(negociacaosEsperada, listaNegociacao.get(0));
    }
}