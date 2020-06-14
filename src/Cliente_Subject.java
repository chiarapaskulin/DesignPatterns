import java.util.ArrayList;
import java.util.List;

public class Cliente_Subject {
    //Lista de carrinhos do cliente (único por causa do singleton)
    private List<Carrinho_Observer> observers = new ArrayList<>();

    public void addCarrinhoObserver(Carrinho_Observer observer){
        this.observers.add(observer);
    }

    public void addProdutoCarrinho(Produto p){
        //adiciona Produto p nos carrinhos
        for(Carrinho_Observer observer: this.observers){
            observer.update(p);
        }
    }

    public String listProdutosCarrinho(){
        return observers.get(0).listaProdutos();
    }

    public double valorTotalCarrinho(){
        return observers.get(0).valorTotal();
    }
}
