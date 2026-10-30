package sistemaReembolsoDespesas;

public class TipoDespesaPequena implements TipoDespesa {

    private static TipoDespesaPequena instancia = new TipoDespesaPequena();

    private TipoDespesaPequena() {}

    public static TipoDespesaPequena getInstancia() {
        return instancia;
    }
}
