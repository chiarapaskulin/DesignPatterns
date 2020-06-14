import java.util.ArrayList;

public class Carrinho_ConcreteObserver implements Carrinho_Observer{

    private ArrayList<Produto> carrinho;
    private static Carrinho_ConcreteObserver cc;

    private Carrinho_ConcreteObserver(){
        carrinho = new ArrayList<>();
    }

    public static Carrinho_ConcreteObserver getInstance(){
        if(cc==null){
            cc = new Carrinho_ConcreteObserver();
        }
        return cc;
    }

    public void update(Produto p){
        if(p!=null){
            if(!carrinho.contains(p)) {
                carrinho.add(p);
            }
        }
    }

    public String listaProdutos(){
        String str = "";
        for(Produto p : carrinho){
            str += p.toString() + "\n";
        }
        return str;
    }

    public double valorTotal(){
        double valorTotal = 0;
        for(Produto p : carrinho){
            valorTotal += p.getValor();
        }
        return valorTotal;
    }
}