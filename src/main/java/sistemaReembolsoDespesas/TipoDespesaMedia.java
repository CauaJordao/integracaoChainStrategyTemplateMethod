package sistemaReembolsoDespesas;

public class TipoDespesaMedia implements TipoDespesa {

    private static TipoDespesaMedia instancia = new TipoDespesaMedia();

    private TipoDespesaMedia() {}

    public static TipoDespesaMedia getInstancia() {
        return instancia;
    }
}
