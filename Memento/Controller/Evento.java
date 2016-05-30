package Controller;
import java.util.*;
import Model.*;
public abstract class Evento
{
    private int opt;
    private String mensagem;
    private List<String> opcoes;
    private boolean fimEvento;
    
    public Evento(int opt, String mensagem) {
        this.opt = opt;
        this.mensagem = mensagem;
        this.fimEvento = false;
    }
    
    public String getMensagem() {
        return this.mensagem;
    }
    
    public void setMensagem(String m){
        this.mensagem = m;
    }
    
    public int getOpt() {
        return this.opt;
    }
    
    public List<String> getOpcoes() {
        return this.opcoes;
    }
    
    public void setOpcoes(List<String> opcoes) {
        this.opcoes = opcoes;
    }
    
    public boolean getFimEvento() {
        return this.fimEvento;
    }
    
    public void setFimEvento(boolean fim) {
        this.fimEvento = fim;
    }
}
