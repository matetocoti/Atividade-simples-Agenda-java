package model.entities;

import model.exception.DomainException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Agenda {

    // Lista de contatos da agenda, Pois Agenda Contatos  1 x *
    List<Contatos> contatosList = new ArrayList<>();

    //region CONSTRUTORES
    public Agenda() {
    }
    //endregion

    //region GETTERS
    public List<Contatos> getContatosList() {
        return contatosList;
    }
    //endregion

    //region MÉTODOS
    // Adicionando contato na agenda
    public void addContato(int tipoDeContato ,String nome) throws DomainException {

        boolean confirm = contatosList.add(tipoDoContato(tipoDeContato ,nome));

        if(confirm)System.out.println("Novo contato adicionado com exito!");

    }
    // Ele remove o contato desejado da agenda com base no nome do contato passado no argumento em String
    public void removerContato(String nome){
       boolean confirm = contatosList.removeIf(contatos -> Objects.equals(contatos.getNome(), nome));
       if(confirm){
           System.out.println("Contato removido com exito!");
       }
       else {
           System.out.println("Error: O contato não existe!");
       }
    }
    // Mostrando Lista de contatos
    public void showingList(int tipo) {

        // Contatos favoritos
        if (tipo == 1){
            System.out.printf("Lista de contatos favoritos:%n%n");
            contatosList.forEach(contatos  -> {
                if (contatos instanceof ContatosFavoritos) {
                    System.out.println(contatos);
                }
            });
        }// Contatos comuns
        else if (tipo == 2){
            System.out.printf("Lista de contatos:%n%n");
            contatosList.forEach(contatos  -> {
                if (contatos instanceof ContatosComuns) {
                    System.out.println(contatos);
                }
            });
        }// Todos os contatos Comuns e Favoritos
        else if (tipo == 3)
        {
            System.out.printf("Lista com todos os contatos:%n%n");
            contatosList.forEach(System.out::println);
        }
        else {
            System.out.println("Valor invalido!");
        }
    }
    // Método que busca 1 contato especifico na lista com base no nome
    public void buscandoContato(String nome){

        //Em java Stream é uma sequência de elementos que você pode processar de forma funcional.
        // Eles são usados principalmente para realizar operações em coleções de dados, como listas, conjuntos ou matrizes, de uma forma declarativa, sem a necessidade de escrever loops tradicionais.
        Stream<Contatos> contatosStream = contatosList.stream().filter(contatos -> contatos.getNome().equals(nome));
        contatosStream.forEach(System.out::println);
    }

    // Método para adicionar 1 telefone para 1 contato
    public void addTelefoneContato(String nome ,Telefones telefones){

        contatosList.forEach(contatos -> {
            if(contatos.getNome().equals(nome)){
               contatos.addNumero(telefones);
                System.out.println("Telefone Adicionado com exito!");
            }
        });
    }
    // Método para remover o telefone de 1 contato
    public void removerTelefoneContato(String nome,int telefone){

        contatosList.forEach(contatos -> {
            if (contatos.getNome().equals(nome)){
                contatos.removerNumero(telefone);
                System.out.println("Removido com exito!");
            }
        });
    }

    // Método auxiliar que retorna o tipo escolhido de contato
    private Contatos tipoDoContato(int tipo , String nome) throws DomainException {

        if(tipo == 1){
            return new ContatosComuns(nome);
        }
        else{
            return new ContatosFavoritos(nome);
        }

    }

    //endregion
}
