package sistemaReembolsoDespesas;

public class AprovadorGerente extends Aprovador {

    public AprovadorGerente(Aprovador aprovadorSuperior) {
        this.listaDespesas.add(TipoDespesaMedia.getInstancia());
        this.setAprovadorSuperior(aprovadorSuperior);
    }

    public String getDescricaoAprovador() {
        return "Gerente";
    }
}
