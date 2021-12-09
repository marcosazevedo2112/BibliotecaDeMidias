package model;

public class CD extends Midia {
    private int numeroFaixas = 0;

    public CD(int codigo, double preco, String nome, int numeroFaixas) {
        super(codigo, preco, nome);
        this.numeroFaixas = numeroFaixas;
    }

    @Override
    public String getDetalhes() {
        return super.getDetalhes() + this.getNumeroFaixas() + " -!- ";
    }

    public int getNumeroFaixas() {
        return numeroFaixas;
    }

    public void setNumeroFaixas(int numeroFaixas) {
        this.numeroFaixas = numeroFaixas;
    }

    public void inserirDados(String nome, double preco, int codigo, int numeroFaixas) {
        super.inserirDados(nome, preco, codigo);
        this.numeroFaixas = numeroFaixas;
    }
}
