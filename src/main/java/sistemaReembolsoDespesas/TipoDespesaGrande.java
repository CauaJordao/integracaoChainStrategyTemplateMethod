package sistemaReembolsoDespesas;

public class TipoDespesaGrande implements TipoDespesa {

    private static TipoDespesaGrande instancia = new TipoDespesaGrande();

    private TipoDespesaGrande() {}

    public static TipoDespesaGrande getInstancia() {
        return instancia;
    }
}
