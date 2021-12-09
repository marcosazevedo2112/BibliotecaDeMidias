package model;

public abstract class Midia {
    private int codigo;
    private double preco;
    private String nome;

    public Midia(int codigo, double preco, String nome) {
        this.codigo = codigo;
        this.preco = preco;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo(){
        return this.getClass().getTypeName();
    }

    public String getDetalhes(){
        return this.nome +
                " -!- " + Double.toString(preco) +
                " -!- " + Integer.toString(codigo) + " -!- ";
    }

    public void printDados(){
        System.out.println("Tipo: " + this.getTipo() + "\nDetalhes: " + this.getDetalhes());
    }

    public void inserirDados(String nome, double preco, int codigo){
        this.nome = nome;
        this.preco = preco;
        this.codigo = codigo;
    }
}