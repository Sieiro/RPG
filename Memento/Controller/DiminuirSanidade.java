package Controller;
import Model.*;
import java.util.ArrayList;
public class DiminuirSanidade extends Evento{
    public DiminuirSanidade(int opt) {
        super(opt, "Vila abandonada encontrada (opt " + opt + ")");
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Continuar");
        setOpcoes(lista);
    }
    
    public void continuar(Pessoa pessoa) {
        pessoa.setSanidade(pessoa.getSanidade() - 1);
        this.setMensagem("Você continou então sua vida...");
        this.setFimEvento(true);
    }
}
