package Config;

import br.com.jonatas.model.Negociacao;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.time.LocalDateTime;

public class LeitorXMLOld {
    public static void main(String[] args) {
        Negociacao negociacao = new Negociacao(20.0, 10, LocalDateTime.now());
        XStream stream = new XStream(new DomDriver());
        stream.registerLocalConverter(Negociacao.class, "data", new LocalDateTimeConverter());
        String xml = stream.toXML(negociacao);

        System.out.println(xml);
    }
}
