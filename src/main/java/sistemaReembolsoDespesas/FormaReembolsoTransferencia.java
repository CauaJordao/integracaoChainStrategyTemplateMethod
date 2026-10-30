package sistemaReembolsoDespesas;

public class FormaReembolsoTransferencia implements FormaReembolso {

    private static final float TAXA_TRANSFERENCIA = 0.02f;

    public float calcularValorFinal(float valor, int parcelas) {
        return valor - (valor * TAXA_TRANSFERENCIA);
    }
}
