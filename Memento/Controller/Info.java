package Controller;
import java.util.*;
public class Info extends Evento{
    public Info(int opt) {
        super(opt, "");
        String str = "";
        str += "Nome: " + Mecanica.getInstancia().getJogador().getNome();
        str += "\nVida: " + Mecanica.getInstancia().getJogador().getVida();
        str += "\nSanidade: " + Mecanica.getInstancia().getJogador().getSanidade();
        str += "\nDias: " + Mecanica.getInstancia().getDias();
        setMensagem(str);        
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
