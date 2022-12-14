package br.ufjf.model;

import lombok.*;

import java.util.Observable;

@AllArgsConstructor
public class ViagemColetiva extends Observable {

    private String cidadeOrigem;
    private String cidadeDestino;

    public void avisarViagem() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Saindo de: "+ cidadeOrigem +
                " para " + cidadeDestino;
    }

}
