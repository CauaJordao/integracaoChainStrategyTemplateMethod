package sistemaReembolsoDespesas;

public class Reembolso {

    private float valor;
    private int parcelas;

    public Reembolso(float valor) {
        this.valor = valor;
        this.parcelas = 1;
    }

    public float getValor() {
        return valor;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public float calcularValorFinal(FormaReembolso formaReembolso) {
        return formaReembolso.calcularValorFinal(valor, parcelas);
    }
}
