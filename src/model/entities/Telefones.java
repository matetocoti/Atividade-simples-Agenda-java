package model.entities;

public class Telefones {

    //region ATRIBUTOS
    private String ddi;
    private String ddd;
    private String numero;
    //endregion



    //region CONSTRUTORES

    public Telefones(){

    }

    public Telefones(String ddi, String ddd, String numero) {
        // Programação defensiva
        


        this.ddi = ddi;
        this.ddd = ddd;
        this.numero = numero;

    }

    //endregion

    //region GETTERS AND SETTERS

    public String getDdi() {
        return ddi;
    }

    public void setDdi(String ddi) {
        this.ddi = ddi;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }


    //endregion

    @Override
    public String toString() {
        Contatos contatos = new ContatosComuns();
        return

                String.format("+%s %s %s" ,ddi ,ddd ,numero);
    }
}
