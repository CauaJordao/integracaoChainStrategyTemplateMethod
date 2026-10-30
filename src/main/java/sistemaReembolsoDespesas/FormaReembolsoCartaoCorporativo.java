package sistemaReembolsoDespesas;

public class FormaReembolsoCartaoCorporativo implements FormaReembolso {

    private static final int PARCELAS_SEM_ACRESCIMO = 3;
    private static final float TAXA_ACRESCIMO_AO_MES = 0.02f;

    public float calcularValorFinal(float valor, int parcelas) {
        int quantidadeParcelas = Math.max(parcelas, 1);

        if (quantidadeParcelas <= PARCELAS_SEM_ACRESCIMO) {
            return valor;
        }

        int parcelasComAcrescimo = quantidadeParcelas - PARCELAS_SEM_ACRESCIMO;
        float acrescimo = valor * TAXA_ACRESCIMO_AO_MES * parcelasComAcrescimo;
        return valor + acrescimo;
    }
}
