import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        //cria carrinho
        //vê os produtos
        //adiciona produto
        //finaliza compra
        //escolhe metodo pagamento
        //dá informações
        //encerra
        Scanner scanner = new Scanner(System.in);

        Fachada fachada = new Fachada();

        fachada.criaCarrinho();

        System.out.println("Bem-vindo ao mercado online!");

        boolean maisProdutos = true;
        while(maisProdutos) {
            System.out.println("\nProdutos disponíveis:");
            System.out.println(fachada.listaProdutos());

            System.out.println("\nDigite o número do produto que você deseja adicionar no carrinho:");
            String produto = scanner.nextLine();
            int indice = Integer.parseInt(produto);
            while (indice < 1 || indice > 7) {
                System.out.println("Número inválido. Tente novamente.");
                produto = scanner.nextLine();
                indice = Integer.parseInt(produto);
            }
            fachada.addProdutoCarrinho(produto);

            System.out.println("\nDeseja adicionar mais produtos? 1-Sim 2-Não");
            String resposta = scanner.nextLine();
            if(resposta.equals("2")) maisProdutos = false;
        }

        String nf = fachada.pagamento();

        System.out.println(nf);
    }
}