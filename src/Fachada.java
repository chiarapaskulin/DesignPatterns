import java.util.Scanner;

public class Fachada {
    //cria carrinho
    //vê os produtos
    //adiciona produto
    //mostra itens carrinho
    //escolhe metodo pagamento
    //mostra Nota Fiscal e encerra

    Produtos_FakeBD produtos;
    Cliente_Subject cliente;
    Scanner scanner;

    public Fachada(){
        produtos = new Produtos_FakeBD();
        cliente = new Cliente_Subject();
        scanner = new Scanner(System.in);
    }

    public void criaCarrinho(){
        Carrinho_ConcreteObserver carrinho = Carrinho_ConcreteObserver.getInstance();
        cliente.addCarrinhoObserver(carrinho);
    }

    public String listaProdutos(){
        return produtos.listProdutos();
    }

    public void addProdutoCarrinho(String indiceProduto){
        Produto p = produtos.getProdutoByIndice(Integer.parseInt(indiceProduto));
        cliente.addProdutoCarrinho(p);
    }

    public String listaItensCarrinho(){
        double valorTotal = cliente.valorTotalCarrinho();
        String ret = "Itens do carrinho: \n";
        ret += cliente.listProdutosCarrinho() + "\n";
        ret += "Valor total: R$" + valorTotal;
        return ret;
    }

    public String pagamento(){
        MetodoPagamento mp = null;
        String input = "";
        boolean valido = false;
        int opcao = 0;

        while(!valido) {
            System.out.println("Escolha seu método de pagamento:");
            System.out.println("1 - Cartão de Débito");
            System.out.println("2 - Cartão de Crédito");
            System.out.println("3 - Boleto Bancário");
            System.out.println("4 - PayPal");

            input = scanner.nextLine();
            opcao = Integer.parseInt(input);

            if(opcao>=1 && opcao<=4){
                mp = FactoryMetodoPagamento.instanciaMP(opcao);
                valido = true;
            }else{
                System.out.println("Método de pagamento inválido... Tente novamente!");
            }
        }

        mp.detalhesPagamento();

        double valorTotal = cliente.valorTotalCarrinho();
        mp.pagar(valorTotal);

        return mostraNotaFiscal(opcao, valorTotal);
    }

    private String mostraNotaFiscal(int metodoPagamento, double valorTotal){
        String ret = "-------NOTA FISCAL------- \n";
        ret += "Itens: " + "\n";
        ret += cliente.listProdutosCarrinho() + "\n";
        ret += "Valor total: " + valorTotal + "\n";

        switch(metodoPagamento){
            case 1:
                ret += "Pagamento efetuado com Cartão de Débito.";
            case 2:
                ret += "Pagamento efetuado com Cartão de Crédito.";
            case 3:
                ret += "Pagamento efetuado com Boleto Bancário.";
            case 4:
                ret += "Pagamento efetuado com PayPal.";
        }
        return ret;
    }

    public void encerraCompra(){
        System.out.println("Encerrando sessão...");
        produtos = new Produtos_FakeBD();
        cliente = new Cliente_Subject();
        scanner = new Scanner(System.in);
    }
}
