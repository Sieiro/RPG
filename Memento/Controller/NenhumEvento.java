package Controller;
import java.util.ArrayList;
import Model.*;
public class NenhumEvento extends Evento {
    public NenhumEvento(int opt) {
        super(opt, "Nenhum Evento encontrado...");
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("Continuar");
        setOpcoes(lista);
    }
    
    // retira pontos de vida do jogador
    public void continuar() {
        //
        Pessoa pessoa = Mecanica.getInstancia().getJogador();
        this.setMensagem("Você continou então sua vida...");
        pessoa.setSanidade(pessoa.getSanidade() - 5);
        this.setFimEvento(true);
    }
}
