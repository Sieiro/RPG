package Controller;
import java.util.*;
import Model.*;

public class SelecionarItem extends Evento {
    public SelecionarItem(int opt) {
        super(opt, "Menu de selecionar itens aberto (opt " + opt + ")");
        List<String> lista = new ArrayList<String>();
        lista.add("Continuar");
        setOpcoes(lista);
    }
    
    // retira pontos de vida do jogador
    public void seleciona(Selecionavel sel) {
        //
        Mecanica.getInstancia().setSelecionado(sel);
        this.setMensagem("Você selecionou um item.");
        this.setFimEvento(true);
    }
}
