package sistemaReembolsoDespesas;

    public class FuncionarioEstagiario extends Funcionario {
        @Override
        public float getMediaCorteElegibilidade() { return 5.0f; }

            @Override
public String getTipoContrato() { return "FuncionarioEstagiario"; }
    }
