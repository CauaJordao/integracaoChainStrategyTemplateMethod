package sistemaReembolsoDespesas;

import java.util.ArrayList;
import java.util.List;

public abstract class Aprovador {

    protected List<TipoDespesa> listaDespesas = new ArrayList<>();
    private Aprovador aprovadorSuperior;

    public Aprovador getAprovadorSuperior() {
        return aprovadorSuperior;
    }

    public void setAprovadorSuperior(Aprovador aprovadorSuperior) {
        this.aprovadorSuperior = aprovadorSuperior;
    }

    public abstract String getDescricaoAprovador();

    public String aprovarDespesa(Despesa despesa) {
        if (listaDespesas.contains(despesa.getTipoDespesa())) {
            return getDescricaoAprovador() + " aprovou a despesa.";
        }
        else if (aprovadorSuperior != null) {
            return aprovadorSuperior.aprovarDespesa(despesa);
        }
        else {
            return "Sem aprovador disponível para esta despesa.";
        }
    }
}
