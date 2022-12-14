package br.ufjf.model;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    public void assinarInteresseViagem (ViagemColetiva viagemColetiva) {
        viagemColetiva.addObserver(this);
    }

    @Override
    public void update(Observable viagemColetiva, Object arg) {
        this.ultimaNotificacao = "Olá, "+this.nome+"! " +
                "Passando para avisar que a viagem que você deseja está disponível: \n"+
                viagemColetiva.toString();
    }
}
