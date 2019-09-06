package ws;

import Config.LeitorXml;
import br.com.jonatas.model.Negociacao;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ClienteWebService {

    public List<Negociacao> getNegociacoes(){
        HttpURLConnection connection = null;

        try {
            URL url = new URL("http://argentumws.caelum.com.br/negociacoes");
            connection = (HttpURLConnection) url.openConnection();
            InputStream content = connection.getInputStream();

            return new LeitorXml().carregaXml(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            connection.disconnect();
        }
    }

    public static void main(String[] args) {
        ClienteWebService ws = new ClienteWebService();
        List<Negociacao> negociacoes = ws.getNegociacoes();

        for (Negociacao negociacao : negociacoes) {
            System.out.println(negociacao.getPreco());
        }
    }
}
