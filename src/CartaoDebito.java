import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CartaoDebito implements MetodoPagamento{

    @Override
    public void detalhesPagamento(){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Insira o número do seu cartão:");
            reader.readLine();
            System.out.println("Insira a data de validade do seu cartão:");
            reader.readLine();
            System.out.println("Insira o código do seu CVV:");
            reader.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void pagar(double valor){
        System.out.println("Pagando R$" + valor + " utilizando Cartão de Débito...");
        System.out.println("Pagamento feito com sucesso.");
    }
}
