public class FactoryMetodoPagamento{
    public static MetodoPagamento instanciaMP(int mp){
        //1 - Cartão de Débito
        //2 - Cartão de Crédito
        //3 - Boleto Bancário
        //4 - PayPal
        switch(mp){
            case 1:
                return new CartaoDebito();
            case 2:
                return new CartaoCredito();
            case 3:
                return new BoletoBancario();
            case 4:
                return new PayPal();
        }
        return null;
    }
}
