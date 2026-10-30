package sistemaReembolsoDespesas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DespesaTest {

    private Aprovador criarCadeiaDeAprovadores() {
        Aprovador diretor = new AprovadorDiretor(null);
        Aprovador gerente = new AprovadorGerente(diretor);
        return new AprovadorSupervisor(gerente);
    }

    @Test
    void deveRetornarSupervisorParaDespesaPequena() {
        Despesa despesa = new Despesa();
        despesa.setTipoDespesa(TipoDespesaPequena.getInstancia());

        assertEquals("Supervisor aprovou a despesa.", criarCadeiaDeAprovadores().aprovarDespesa(despesa));
    }

    @Test
    void deveRetornarGerenteParaDespesaMedia() {
        Despesa despesa = new Despesa();
        despesa.setTipoDespesa(TipoDespesaMedia.getInstancia());

        assertEquals("Gerente aprovou a despesa.", criarCadeiaDeAprovadores().aprovarDespesa(despesa));
    }

    @Test
    void deveRetornarDiretorParaDespesaGrande() {
        Despesa despesa = new Despesa();
        despesa.setTipoDespesa(TipoDespesaGrande.getInstancia());

        assertEquals("Diretor aprovou a despesa.", criarCadeiaDeAprovadores().aprovarDespesa(despesa));
    }

    @Test
    void deveRetornarSemAprovadorDisponivelParaDespesaExtraordinaria() {
        Despesa despesa = new Despesa();
        despesa.setTipoDespesa(TipoDespesaExtraordinaria.getInstancia());

        assertEquals("Sem aprovador disponível para esta despesa.", criarCadeiaDeAprovadores().aprovarDespesa(despesa));
    }
}
