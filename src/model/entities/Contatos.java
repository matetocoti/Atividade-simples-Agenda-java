package model.entities;

//region IMPORTS
import model.exception.DomainException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

//endregion


// SuperClasse abstrata de contatos
public abstract class Contatos {

    // Obj de formatação de DataTime
    private static final DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    //region ATRIBUTOS
    private String nome;
    private LocalDateTime added;

    // Relação-Contato-Telefones(1 x 1,*)      1 Contato pode ter 1 ou varios telefones
    List<Telefones> telefonesList = new ArrayList<>();


    //endregion

    //region CONSTRUTORES


    public Contatos() {
    }

    public Contatos(String nome) throws DomainException {
        // Programação defensiva
        if (nome.trim().isEmpty()){
            throw new DomainException("Error: O campo do nome vazio!");
        }



        this.nome = nome;
        // a Data-Hora é padrão pois é sempre o now do momento da Inicialização da instancia
        // Então é paga de maneira automatica
        this.added = LocalDateTime.now();
    }


    //endregion

    //region GETTERS AND SETTERS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getAdded() {
        return added;
    }

    public List<Telefones> getTelefonesList() {
        return telefonesList;
    }

    //endregion

    //region MÉTODOS

    // Método que adiciona 1 numero de telefone  na lista de telefones do contato
    public  void addNumero(Telefones telefone){
        telefonesList.add(telefone);
    }


    // Método que remove 1 numero de telefone  na lista de telefones do contato
    public  void removerNumero(int telefone){
         telefonesList.remove(telefone);
    }






    // SubEscrevendo o método de toString
    @Override
    public String toString() {
        // Iniciando StringBuilder
        StringBuilder stringBuilder = new StringBuilder();


        stringBuilder.append("Nome: ");
        stringBuilder.append(nome);
        stringBuilder.append("\n");
        stringBuilder.append("Telefones: ");
        if (!telefonesList.isEmpty()) {
            stringBuilder.append(telefonesList);
        }else {
            stringBuilder.append("none");
        }
        stringBuilder.append("\n");
        stringBuilder.append("Data de adição: ");
        // Data-hora formatada
        stringBuilder.append(fmt1.format(added));
        stringBuilder.append("\n");
        // Retornando stringBuilder
        return String.valueOf(stringBuilder);
    }
    //endregion



}
