package model;

public class DVD extends Midia{
    private String sinopse;

    public DVD(int codigo, double preco, String nome, String sinopse) {
        super(codigo, preco, nome);
        this.sinopse = sinopse;
    }

    @Override
    public String getDetalhes() {
        return super.getDetalhes() + this.getSinopse() + " -!- ";
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public void inserirDados(String nome, double preco, int codigo, String sinopse) {
        super.inserirDados(nome, preco, codigo);
        this.sinopse = sinopse;
    }
}
