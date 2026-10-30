package sistemaReembolsoDespesas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SistemaReembolsoTest {
    private Funcionario funcionario(float mediaTecnica, float mediaComportamental) {
        Funcionario f = new FuncionarioCLT();
        f.setAvaliacaoTecnica(mediaTecnica);
        f.setAvaliacaoComportamental(mediaComportamental);
        return f;
    }

    private Despesa despesa(TipoDespesa tipo) {
        Despesa d = new Despesa();
        d.setTipoDespesa(tipo);
        return d;
    }

    @Test
    void deveIntegrarTemplateChainStrategyParaAprovarEPagarPix() {
        ResultadoReembolso resultado = SistemaReembolso.criarPadrao().processar(
            funcionario(8f,8f), despesa(TipoDespesaPequena.getInstancia()), 100f, new FormaReembolsoPix(), 1);
        assertTrue(resultado.isAprovado());
        assertTrue(resultado.getMensagem().contains("Supervisor"));
        assertEquals(100f, resultado.getValorPago(), 0.001f);
    }

    @Test
    void deveEncaminharAoGerenteEAplicarEstrategiaTransferencia() {
        ResultadoReembolso resultado = SistemaReembolso.criarPadrao().processar(
            funcionario(8f,8f), despesa(TipoDespesaMedia.getInstancia()), 200f,
            new FormaReembolsoTransferencia(), 1);
        assertTrue(resultado.isAprovado());
        assertTrue(resultado.getMensagem().contains("Gerente"));
        assertEquals(196f, resultado.getValorPago(), 0.001f);
    }

    @Test
    void deveEncaminharAoDiretorEAplicarJurosDoCartao() {
        ResultadoReembolso resultado = SistemaReembolso.criarPadrao().processar(
            funcionario(8f,8f), despesa(TipoDespesaGrande.getInstancia()), 100f,
            new FormaReembolsoCartaoCorporativo(), 5);
        assertTrue(resultado.isAprovado());
        assertTrue(resultado.getMensagem().contains("Diretor"));
        assertEquals(104f, resultado.getValorPago(), 0.001f);
    }

    @Test
    void naoDevePagarFuncionarioInelegivel() {
        ResultadoReembolso resultado = SistemaReembolso.criarPadrao().processar(
            funcionario(4f,4f), despesa(TipoDespesaPequena.getInstancia()), 100f,
            new FormaReembolsoPix(), 1);
        assertFalse(resultado.isAprovado());
        assertEquals(0f, resultado.getValorPago(), 0.001f);
        assertTrue(resultado.getMensagem().contains("não elegível"));
    }

    @Test
    void naoDevePagarDespesaSemAprovador() {
        ResultadoReembolso resultado = SistemaReembolso.criarPadrao().processar(
            funcionario(8f,8f), despesa(TipoDespesaExtraordinaria.getInstancia()), 100f,
            new FormaReembolsoPix(), 1);
        assertFalse(resultado.isAprovado());
        assertEquals(0f, resultado.getValorPago(), 0.001f);
    }

    @Test
    void naoDeveProcessarValorInvalido() {
        assertThrows(IllegalArgumentException.class, () -> SistemaReembolso.criarPadrao().processar(
            funcionario(8f,8f), despesa(TipoDespesaPequena.getInstancia()), -10f,
            new FormaReembolsoPix(), 1));
    }
}
