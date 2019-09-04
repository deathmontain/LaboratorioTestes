package Test.testes;

import br.com.jonatas.model.CandleStick;
import br.com.jonatas.model.FactoryCandle;
import br.com.jonatas.model.Negociacao;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class TesteCandleStickFactory {
    public static void main(String[] args) {
        LocalDateTime hoje = LocalDateTime.now();

        Negociacao negociacao = new Negociacao(40.0, 100, hoje);
        Negociacao negociacao2 = new Negociacao(35.0,100, hoje);
        Negociacao negociacao3 = new Negociacao(45.0,100, hoje);
        Negociacao negociacao4 = new Negociacao(20.0,100, hoje);

        List<Negociacao> negociacoes = Arrays.asList(negociacao, negociacao2, negociacao3, negociacao4);

        FactoryCandle fabrica = new FactoryCandle();

        CandleStick candle = fabrica.geraCandleParaData(negociacoes, hoje);

        System.out.println("Abertura: " + candle.getAbertura());
        System.out.println("Fechamento: " + candle.getFechamento());
        System.out.println("Maximo: " + candle.getMaximo());
        System.out.println("Minimo: " + candle.getMinimo());
        System.out.println("Total: " + candle.getVolume());
    }
}