package sistemaReembolsoDespesas;

/** Resultado imutável de um pedido de reembolso. */
public final class ResultadoReembolso {
    private final boolean aprovado;
    private final String mensagem;
    private final float valorPago;

    private ResultadoReembolso(boolean aprovado, String mensagem, float valorPago) {
        this.aprovado = aprovado;
        this.mensagem = mensagem;
        this.valorPago = valorPago;
    }

    public static ResultadoReembolso aprovado(String mensagem, float valorPago) {
        return new ResultadoReembolso(true, mensagem, valorPago);
    }

    public static ResultadoReembolso recusado(String motivo) {
        return new ResultadoReembolso(false, motivo, 0f);
    }

    public boolean isAprovado() { return aprovado; }
    public String getMensagem() { return mensagem; }
    public float getValorPago() { return valorPago; }
}
