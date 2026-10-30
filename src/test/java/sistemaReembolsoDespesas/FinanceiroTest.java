package sistemaReembolsoDespesas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FinanceiroTest {

    @Test
    void devePagarComPixSemAlteracao() {
        Financeiro financeiro = new Financeiro();

        financeiro.pagarComPix(100f);

        assertEquals(100f, financeiro.getValorPago(), 0.001f);
    }

    @Test
    void devePagarComTransferenciaAplicandoTaxa() {
        Financeiro financeiro = new Financeiro();

        financeiro.pagarComTransferencia(100f);

        assertEquals(98f, financeiro.getValorPago(), 0.001f);
    }

    @Test
    void devePagarComCartaoCorporativoSemAcrescimoParaTresParcelasOuMenos() {
        Financeiro financeiro = new Financeiro();

        financeiro.pagarComCartaoCorporativo(100f, 3);

        assertEquals(100f, financeiro.getValorPago(), 0.001f);
    }

    @Test
    void devePagarComCartaoCorporativoAplicandoAcrescimoParaMaisDeTresParcelas() {
        Financeiro financeiro = new Financeiro();

        financeiro.pagarComCartaoCorporativo(100f, 5);

        assertEquals(104f, financeiro.getValorPago(), 0.001f);
    }
}
