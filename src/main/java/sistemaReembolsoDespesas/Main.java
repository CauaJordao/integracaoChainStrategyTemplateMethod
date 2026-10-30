package sistemaReembolsoDespesas;

public class Main {
    public static void main(String[] args) {
        SistemaReembolso sistema = SistemaReembolso.criarPadrao();

        Funcionario clt = new FuncionarioCLT();
        clt.setNome("Ana");
        clt.setMatricula(101);
        clt.setAvaliacaoTecnica(8f);
        clt.setAvaliacaoComportamental(8f);

        Despesa despesa = new Despesa();
        despesa.setTipoDespesa(TipoDespesaMedia.getInstancia());

        ResultadoReembolso resultado = sistema.processar(clt, despesa, 200f, new FormaReembolsoPix(), 1);
        System.out.println(resultado.getMensagem());
        System.out.printf("Valor reembolsado: R$ %.2f%n", resultado.getValorPago());
    }
}
