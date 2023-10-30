package model.exception;

// Classe|SubClasse para tratar exceções de maneira personalizada
public class DomainException extends Exception {

    // Contrutor aproveitando o super()
    public DomainException(String messagem){super(messagem);}

}
