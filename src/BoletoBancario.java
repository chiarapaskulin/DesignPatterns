import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BoletoBancario implements MetodoPagamento{

    @Override
    public void detalhesPagamento(){
        System.out.println("O número do seu boleto é 738293847365016572395528300000274923600000000000");
    }

    @Override
    public void pagar(double valor){
        System.out.println("Pague o boleto no valor de R$" + valor + " para que sua compra seja confirmada.");
    }
}
