package sistemaReembolsoDespesas;

public class AprovadorSupervisor extends Aprovador {

    public AprovadorSupervisor(Aprovador aprovadorSuperior) {
        this.listaDespesas.add(TipoDespesaPequena.getInstancia());
        this.setAprovadorSuperior(aprovadorSuperior);
    }

    public String getDescricaoAprovador() {
        return "Supervisor";
    }
}
