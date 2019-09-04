package Config;

import br.com.jonatas.model.Negociacao;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.InputStream;
import java.util.List;

public class LeitorXml {
    public List<Negociacao> carregaXml(InputStream inputStream){
        XStream stream = new XStream(new DomDriver());
        stream.alias("negociacao", Negociacao.class);
        stream.allowTypesByWildcard(new String[] {
                "br.com.jonatas.model.**"
        });
        stream.registerLocalConverter(Negociacao.class, "data", new LocalDateTimeConverter());

        return (List<Negociacao>) stream.fromXML(inputStream);
    }
}