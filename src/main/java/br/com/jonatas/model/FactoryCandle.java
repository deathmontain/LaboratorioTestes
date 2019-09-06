package br.com.jonatas.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FactoryCandle {

    public CandleStick geraCandleParaData(List<Negociacao> negociacoes, LocalDateTime data){
        double abertura = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
        double fechamento = negociacoes.isEmpty() ? 0 : negociacoes.get(negociacoes.size() - 1).getPreco();
        double volume = 0;
        double minimo = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
        double maximo = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();

        for (Negociacao negociacao : negociacoes) {
            volume += negociacao.getVolume();

            if(negociacao.getPreco() > maximo){
                maximo = negociacao.getPreco();
            } else if (negociacao.getPreco() < minimo){
                minimo = negociacao.getPreco();
            }
        }

        return new CandleStick(abertura, fechamento, minimo, maximo, volume, data);
    }

    public List<CandleStick> constroiCandles(List<Negociacao> negociacoes) {
        List<CandleStick> candle = new ArrayList<>();
        List<Negociacao> negociacoesDoDia = new ArrayList<>();
        LocalDateTime dataAtual = negociacoes.get(0).getData();

        for (Negociacao negociacao : negociacoes) {
            if(negociacao.mesmoDia(dataAtual)){
                negociacoesDoDia.add(negociacao);
            } else {
                CandleStick candleStick = geraCandleParaData(negociacoesDoDia, dataAtual);
                candle.add(candleStick);
                negociacoesDoDia = new ArrayList<>();
                dataAtual = negociacao.getData();
            }
        }
        CandleStick candleStick = geraCandleParaData(negociacoesDoDia, dataAtual);
        candle.add(candleStick);

        return candle;
    }
}