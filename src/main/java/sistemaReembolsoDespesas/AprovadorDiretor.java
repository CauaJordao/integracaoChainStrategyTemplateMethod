package sistemaReembolsoDespesas;

public class AprovadorDiretor extends Aprovador {

    public AprovadorDiretor(Aprovador aprovadorSuperior) {
        this.listaDespesas.add(TipoDespesaGrande.getInstancia());
        this.setAprovadorSuperior(aprovadorSuperior);
    }

    public String getDescricaoAprovador() {
        return "Diretor";
    }
}
