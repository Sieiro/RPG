package Controller;
import java.util.*;
import Model.*;

public class SelecionarDano extends Evento {
    public SelecionarDano(int opt) {
        super(opt, "Menu de selecionar Habilidades e Magias aberto (opt " + opt + ")");
        List<String> lista = new ArrayList<String>();
        lista.add("Continuar");
        setOpcoes(lista);
    }
    
    // retira pontos de vida do jogador
    public void seleciona(Selecionavel sel) {
        //
        Mecanica.getInstancia().setSelecionado(sel);
        this.setMensagem("Você selecionou uma magia/habilidade.");
        this.setFimEvento(true);
    }
}
