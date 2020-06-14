import java.util.ArrayList;

public class Produtos_FakeBD {
    public ArrayList<Produto> produtosMercado;

    public Produtos_FakeBD(){
        produtosMercado = new ArrayList<>();
        produtosMercado.add(new Produto("Caneta", 1.50));
        produtosMercado.add(new Produto("Banana", 0.95));
        produtosMercado.add(new Produto("Carregador de Celular", 75.00));
        produtosMercado.add(new Produto("Jornal", 1.25));
        produtosMercado.add(new Produto("Farinha de Trigo", 2.99));
        produtosMercado.add(new Produto("Maizena", 5.50));
        produtosMercado.add(new Produto("Salsichão", 4.59));
    }

    public String listProdutos(){
        String ret = "";
        for(int i=0; i<produtosMercado.size(); i++){
            String indice = Integer.toString(i+1);
            ret += indice + " - " + produtosMercado.get(i).toString() + "\n";
        }
        return ret;
    }

    public Produto getProdutoByIndice(int indice){
        if(indice<=0 || indice>produtosMercado.size()){
            return null;
        }
        return produtosMercado.get(indice-1);
    }
}
