package Controller;
import java.util.*;
public class Info extends Evento{
    public Info(int opt) {
        super(opt, "Não implementado (opt " + opt + ")");
        List<String> lista = new ArrayList<String>();
        lista.add("Continuar");
        setOpcoes(lista);
    }
    
    // retira pontos de vida do jogador
    public void continuar() {
        //
        this.setMensagem("Você continou então sua vida...");
        this.setFimEvento(true);
    }
}
