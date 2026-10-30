package sistemaReembolsoDespesas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReembolsoTest {

    @Test
    void deveManterValorIntegralParaPix() {
        Reembolso reembolso = new Reembolso(100f);

        float valorFinal = reembolso.calcularValorFinal(new FormaReembolsoPix());

        assertEquals(100f, valorFinal, 0.001f);
    }

    @Test
    void deveAplicarTaxaDeDoisPorCentoParaTransferencia() {
        Reembolso reembolso = new Reembolso(100f);

        float valorFinal = reembolso.calcularValorFinal(new FormaReembolsoTransferencia());

        assertEquals(98f, valorFinal, 0.001f);
    }

    @Test
    void deveManterValorIntegralParaCartaoCorporativoComTresParcelasOuMenos() {
        Reembolso reembolso = new Reembolso(100f);
        reembolso.setParcelas(3);

        float valorFinal = reembolso.calcularValorFinal(new FormaReembolsoCartaoCorporativo());

        assertEquals(100f, valorFinal, 0.001f);
    }

    @Test
    void deveAplicarAcrescimoParaCartaoCorporativoComMaisDeTresParcelas() {
        Reembolso reembolso = new Reembolso(100f);
        reembolso.setParcelas(5);

        float valorFinal = reembolso.calcularValorFinal(new FormaReembolsoCartaoCorporativo());

        // 2 parcelas excedentes (5 - 3), 2% de acréscimo por parcela: 100 + (100 * 0.02 * 2) = 104
        assertEquals(104f, valorFinal, 0.001f);
    }

    @Test
    void deveTratarParcelasInvalidasComoUmaParcelaNoCartaoCorporativo() {
        Reembolso reembolso = new Reembolso(100f);
        reembolso.setParcelas(0);

        float valorFinal = reembolso.calcularValorFinal(new FormaReembolsoCartaoCorporativo());

        assertEquals(100f, valorFinal, 0.001f);
    }
}
