package sistemaReembolsoDespesas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FuncionarioCLTTest {

    @Test
    void deveRetornarElegivel() {
        FuncionarioCLT funcionario = new FuncionarioCLT();
        funcionario.setAvaliacaoTecnica(7.0f);
        funcionario.setAvaliacaoComportamental(7.0f);
        assertEquals("Elegível", funcionario.verificarElegibilidadeReembolso());
    }

    @Test
    void deveRetornarNaoElegivel() {
        FuncionarioCLT funcionario = new FuncionarioCLT();
        funcionario.setAvaliacaoTecnica(7.0f);
        funcionario.setAvaliacaoComportamental(6.9f);
        assertEquals("Não Elegível", funcionario.verificarElegibilidadeReembolso());
    }

    @Test
    void deveRetornarInformacoes() {
        FuncionarioCLT funcionario = new FuncionarioCLT();
        funcionario.setAvaliacaoTecnica(7.0f);
        funcionario.setAvaliacaoComportamental(6.9f);
        funcionario.setNome("Marcelo");
        funcionario.setMatricula(2);
        assertEquals("Funcionario{matricula=2, nome='Marcelo', resultado=Não Elegível}", funcionario.getInfo());
    }
}
