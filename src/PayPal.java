import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PayPal implements MetodoPagamento{

    @Override
    public void detalhesPagamento(){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Insira seu e-mail:");
            reader.readLine();
            System.out.println("Insira sua senha:");
            reader.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void pagar(double valor){
        System.out.println("Pagando R$" + valor + " utilizando PayPal...");
        System.out.println("Pagamento feito com sucesso.");
    }
}
