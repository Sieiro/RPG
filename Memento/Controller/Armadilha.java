package Controller;
import Model.*;
import java.util.*;
public class Armadilha extends Evento {
    public Armadilha(int opt) {
        super(opt, "Armadilha encontrada");
        List<String> lista = new ArrayList<String>();
        lista.add("Continuar");
        setOpcoes(lista);
    }
    
    // retira pontos de vida do jogador
    public void continuar() {
        //
        Pessoa pessoa = Mecanica.getInstancia().getJogador();
        pessoa.setVida(pessoa.getVida() - 10);
        pessoa.setSanidade(pessoa.getSanidade() - 5);
        this.setMensagem("Você perdeu vida!");
        this.setFimEvento(true);
    }
}
