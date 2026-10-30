package sistemaReembolsoDespesas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FuncionarioEstagiarioTest {

    @Test
    void deveRetornarElegivel() {
        FuncionarioEstagiario funcionario = new FuncionarioEstagiario();
        funcionario.setAvaliacaoTecnica(5.0f);
        funcionario.setAvaliacaoComportamental(5.0f);
        assertEquals("Elegível", funcionario.verificarElegibilidadeReembolso());
    }

    @Test
    void deveRetornarNaoElegivel() {
        FuncionarioEstagiario funcionario = new FuncionarioEstagiario();
        funcionario.setAvaliacaoTecnica(5.0f);
        funcionario.setAvaliacaoComportamental(4.9f);
        assertEquals("Não Elegível", funcionario.verificarElegibilidadeReembolso());
    }

    @Test
    void deveRetornarInformacoes() {
        FuncionarioEstagiario funcionario = new FuncionarioEstagiario();
        funcionario.setAvaliacaoTecnica(5.0f);
        funcionario.setAvaliacaoComportamental(4.9f);
        funcionario.setNome("Marcelo");
        funcionario.setMatricula(2);
        assertEquals("FuncionarioEstagiario{matricula=2, nome='Marcelo', resultado=Não Elegível}", funcionario.getInfo());
    }
}
