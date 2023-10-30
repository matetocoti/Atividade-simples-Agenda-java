package model.entities;

import model.exception.DomainException;

public class ContatosFavoritos extends Contatos{


    public ContatosFavoritos() {
    }

    public ContatosFavoritos(String nome) throws DomainException {
        super(nome);
    }
}
