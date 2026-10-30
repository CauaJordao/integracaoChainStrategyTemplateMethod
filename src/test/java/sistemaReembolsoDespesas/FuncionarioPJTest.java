package sistemaReembolsoDespesas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FuncionarioPJTest {

    @Test
    void deveRetornarElegivel() {
        FuncionarioPJ funcionario = new FuncionarioPJ();
        funcionario.setAvaliacaoTecnica(6.0f);
        funcionario.setAvaliacaoComportamental(6.0f);
        assertEquals("Elegível", funcionario.verificarElegibilidadeReembolso());
    }

    @Test
    void deveRetornarNaoElegivel() {
        FuncionarioPJ funcionario = new FuncionarioPJ();
        funcionario.setAvaliacaoTecnica(6.0f);
        funcionario.setAvaliacaoComportamental(5.9f);
        assertEquals("Não Elegível", funcionario.verificarElegibilidadeReembolso());
    }

    @Test
    void deveRetornarInformacoes() {
        FuncionarioPJ funcionario = new FuncionarioPJ();
        funcionario.setAvaliacaoTecnica(6.0f);
        funcionario.setAvaliacaoComportamental(5.9f);
        funcionario.setNome("Marcelo");
        funcionario.setMatricula(2);
        assertEquals("FuncionarioPJ{matricula=2, nome='Marcelo', resultado=Não Elegível}", funcionario.getInfo());
    }
}
