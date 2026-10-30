package sistemaReembolsoDespesas;

import java.util.Objects;

/** Integra Template Method, Chain of Responsibility e Strategy. */
public class SistemaReembolso {
    private final Aprovador cadeiaAprovacao;

    public SistemaReembolso(Aprovador cadeiaAprovacao) {
        this.cadeiaAprovacao = Objects.requireNonNull(cadeiaAprovacao, "Cadeia de aprovação obrigatória");
    }

    public static SistemaReembolso criarPadrao() {
        Aprovador diretor = new AprovadorDiretor(null);
        Aprovador gerente = new AprovadorGerente(diretor);
        return new SistemaReembolso(new AprovadorSupervisor(gerente));
    }

    public ResultadoReembolso processar(Funcionario funcionario, Despesa despesa, float valor,
                                        FormaReembolso forma, int parcelas) {
        Objects.requireNonNull(funcionario, "Funcionário obrigatório");
        Objects.requireNonNull(despesa, "Despesa obrigatória");
        Objects.requireNonNull(forma, "Forma de reembolso obrigatória");
        if (despesa.getTipoDespesa() == null) {
            throw new IllegalArgumentException("Tipo de despesa obrigatório");
        }
        if (!Float.isFinite(valor) || valor <= 0f) {
            throw new IllegalArgumentException("Valor deve ser positivo e finito");
        }

        // 1) Template Method: verifica elegibilidade conforme contrato.
        if (!"Elegível".equals(funcionario.verificarElegibilidadeReembolso())) {
            return ResultadoReembolso.recusado("Reembolso negado: funcionário não elegível.");
        }

        // 2) Chain of Responsibility: supervisor -> gerente -> diretor.
        String decisao = cadeiaAprovacao.aprovarDespesa(despesa);
        if (decisao.startsWith("Sem aprovador")) {
            return ResultadoReembolso.recusado("Reembolso negado: " + decisao);
        }

        // 3) Strategy: calcula o pagamento com a opção selecionada.
        Reembolso reembolso = new Reembolso(valor);
        reembolso.setParcelas(parcelas);
        float valorFinal = reembolso.calcularValorFinal(forma);
        return ResultadoReembolso.aprovado(decisao + " Reembolso realizado.", valorFinal);
    }
}
