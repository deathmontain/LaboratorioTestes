package br.com.jonatas.model;

import Config.LocalDateTimeConverter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class LocalDateTimeConverterTest {
    LocalDateTime hoje = LocalDateTime.of(2016, 04, 04, 12, 00);

    @Test
    public void deveRetornarXmlComDataCorreta (){
        Negociacao negociacao = new Negociacao(10.0, 4, hoje);
        XStream stream = new XStream(new DomDriver());
        stream.alias("negociacao", Negociacao.class);
        stream.registerLocalConverter(Negociacao.class, "data", new LocalDateTimeConverter());
        String xmlConvertido = stream.toXML(negociacao);
        String xmlEsperado = "<negociacao>\n"
                             +"  <preco>10.0</preco>\n"
                             +"  <quantidade>4</quantidade>\n"
                             +"  <data>\n"
                             +"    <time>1459782000000</time>\n"
                             +"    <timeZone>America/Sao_Paulo</timeZone>\n"
                             +"  </data>\n"
                             +"</negociacao>";

        Assertions.assertEquals(xmlEsperado, xmlConvertido);
    }

    @Test
    public void deveConverterXmlParaNegociacaoCorreta(){
        String xml = "<negociacao>\n"
                +"  <preco>10.0</preco>\n"
                +"  <quantidade>4</quantidade>\n"
                +"  <data>\n"
                +"    <time>1459782000000</time>\n"
                +"    <timeZone>America/Sao_Paulo</timeZone>\n"
                +"  </data>\n"
                +"</negociacao>";

        XStream stream = new XStream(new DomDriver());
        XStream xstream = new XStream();
//        stream.addPermission(NoTypePermission.NONE); //NoTypePermission
//        stream.addPermission(NullPermission.NULL);
//        stream.addPermission(PrimitiveTypePermission.PRIMITIVES);/
//        stream.allowTypeHierarchy(Collection.class);
        stream.allowTypesByWildcard(new String[] {
                "br.com.jonatas.model.**"
        });

        stream.alias("negociacao", Negociacao.class);
        stream.registerLocalConverter(Negociacao.class, "data", new LocalDateTimeConverter());
        Negociacao negociacaoGerada = (Negociacao) stream.fromXML(xml);
        LocalDateTime localDateTime = LocalDateTime.of(2016,04,04, 12, 00);
        Negociacao negociacaoEsperada = new Negociacao(10.0,4, localDateTime);

        Assertions.assertEquals(negociacaoEsperada, negociacaoGerada);
    }
}