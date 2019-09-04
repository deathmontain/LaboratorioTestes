package Config;

import br.com.jonatas.model.Negociacao;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.InputStream;
import java.util.List;

public class LeitorXml {
    public List<Negociacao> carregaXml(InputStream InputStream){
        XStream stream = new XStream(new DomDriver());
        stream.registerLocalConverter(Negociacao.class, "data", new LocalDateTimeConverter());
        stream.alias("negociacao", Negociacao.class);
        
        return (List<Negociacao>) stream.fromXML(InputStream);
    }
}