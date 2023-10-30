package application;

import model.entities.*;
import model.exception.DomainException;


import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        boolean rodar = true;
        Scanner input = new Scanner(System.in);
        Agenda agenda = new Agenda();
            while (rodar){
                try {
                    System.out.printf("%n(1)Adicionar-contato|(2)Remover-contato|(3)Adicionar-telefone|(4)Remover-telefone|(5)Buscar-contato|(6)Exibir-listas|(7)Exit%n%n");
                    String menu = input.next();
                    input.nextLine();
                    String nome;
                    switch (menu) {
                        case ("1"):
                            System.out.print("Digite o nome do novo contato: ");
                            nome = input.nextLine();
                            System.out.println("Tipo de contato:");
                            System.out.println("(1)Comum(2)Favorito");
                            int contatoTipo = input.nextInt();
                            input.nextLine();
                            agenda.addContato(contatoTipo ,nome);
                            break;
                        case ("2"):
                            System.out.print("Digite o nome do contato:");
                            nome = input.nextLine();
                            agenda.removerContato(nome);
                            break;
                        case ("3"):
                            System.out.print("Digite o nome do contato:");
                            nome = input.nextLine();
                            System.out.print("Digite o telefone:");
                            // Removendo os espaços em branco da string trocando("" ," ")
                            String telefone = input.nextLine();
                            telefone = telefone.replace(" " ,"");
                            agenda.addTelefoneContato(nome ,new Telefones(telefone.substring(0 , 2) ,telefone.substring(2 ,4) ,telefone.substring(4 ,13)));
                            break;
                        case ("4"):
                            System.out.print("Digite o nome do contato:");
                            nome = input.nextLine();
                            agenda.buscandoContato(nome);
                            System.out.print("Digite a posição do numero que deseja remover:");
                            int contato = input.nextInt();
                            input.nextLine();
                            agenda.removerTelefoneContato(nome ,contato-1);
                            break;
                        case ("5"):
                            System.out.print("Digite o nome do contato:");
                            nome = input.nextLine();
                            agenda.buscandoContato(nome);
                            break;
                        case ("6"):
                            // Mostrando opções de listas
                            System.out.println("|(1)Favoritos|(2)Comuns|(3)Todos|");
                            // Escolhendo uma opção
                            int tipo = input.nextInt();
                            input.nextLine();
                            // Chamando o método que mostra lista
                            agenda.showingList(tipo);
                            break;
                        case ("7"):
                            // Encerrando Scanner
                            input.close();
                            // Exibindo messagem de encerramento
                            System.out.print("Encerrando...");
                            // Encerrando loop
                            rodar = false;
                            break;
                        default:
                            System.out.println("inválido!");
                            break;
                    }
                 }
                catch (DomainException domainException){
                    System.out.println(domainException.getMessage());
                }
                catch (RuntimeException runtimeException){
                    System.out.println("Error: " + runtimeException.getMessage());
                }
            }
    }
}