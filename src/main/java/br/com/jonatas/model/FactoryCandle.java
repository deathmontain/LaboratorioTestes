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
}