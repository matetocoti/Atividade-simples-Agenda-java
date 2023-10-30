package model.entities;

import model.exception.DomainException;

public class ContatosComuns extends Contatos{

    public ContatosComuns() {
        super();
    }
    public ContatosComuns(String nome) throws DomainException {
        super(nome);
    }
}
