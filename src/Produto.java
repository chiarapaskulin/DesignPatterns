public class Produto {
    public String nome;
    public double valor;

    public Produto(String nome, double valor){
        this.nome = nome;
        this.valor = valor;
    }

    public double getValor(){
        return valor;
    }

    @Override
    public String toString() {
        return nome + " | R$" + valor;
    }
}
