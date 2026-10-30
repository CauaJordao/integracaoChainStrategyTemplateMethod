package sistemaReembolsoDespesas;

public class Financeiro {

    private float valorPago;

    public float getValorPago() {
        return valorPago;
    }

    public void pagarComPix(float valor) {
        Reembolso reembolso = new Reembolso(valor);
        this.valorPago = reembolso.calcularValorFinal(new FormaReembolsoPix());
    }

    public void pagarComTransferencia(float valor) {
        Reembolso reembolso = new Reembolso(valor);
        this.valorPago = reembolso.calcularValorFinal(new FormaReembolsoTransferencia());
    }

    public void pagarComCartaoCorporativo(float valor, int parcelas) {
        Reembolso reembolso = new Reembolso(valor);
        reembolso.setParcelas(parcelas);
        this.valorPago = reembolso.calcularValorFinal(new FormaReembolsoCartaoCorporativo());
    }
}
