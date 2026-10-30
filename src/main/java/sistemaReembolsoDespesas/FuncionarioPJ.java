package sistemaReembolsoDespesas;

    public class FuncionarioPJ extends Funcionario {
        @Override
        public float getMediaCorteElegibilidade() { return 6.0f; }

            @Override
public String getTipoContrato() { return "FuncionarioPJ"; }
    }
