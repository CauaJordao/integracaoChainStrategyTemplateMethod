package sistemaReembolsoDespesas;

public class TipoDespesaExtraordinaria implements TipoDespesa {

    private static TipoDespesaExtraordinaria instancia = new TipoDespesaExtraordinaria();

    private TipoDespesaExtraordinaria() {}

    public static TipoDespesaExtraordinaria getInstancia() {
        return instancia;
    }
}
