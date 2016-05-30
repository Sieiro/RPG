package Controller;
import Model.*;
import java.util.ArrayList;
public class Armadilha extends Evento {
    public Armadilha(int opt) {
        super(opt, "Armadilha encontrada (opt " + opt + ")");
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("Continuar");
        setOpcoes(lista);
    }
    
    // retira pontos de vida do jogador
    public void continuar(Pessoa pessoa) {
        //
        pessoa.setVida(pessoa.getVida() - 10);
        this.setMensagem("Você perdeu vida!");
        this.setFimEvento(true);
    }
}
