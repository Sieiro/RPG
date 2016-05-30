package Controller;
import java.util.ArrayList;
public abstract class Evento
{
    private int opt;
    private String mensagem;
    private ArrayList<String> opcoes = new ArrayList<String>();
    private boolean fimEvento;
    
    public Evento(int opt, String mensagem) {
        this.opt = opt;
        this.mensagem = mensagem;
        this.fimEvento = false;
    }
    
    public String getMensagem() {
        return this.mensagem;
    }
    
    public int getOpt() {
        return this.opt;
    }
    
    public ArrayList<String> getOpcoes() {
        return this.opcoes;
    }
    
    public void setOpcoes(ArrayList<String> opcoes) {
        this.opcoes = opcoes;
    }
    
    private boolean getFimEvento() {
        return this.fimEvento;
    }
    
    private void setFimEvento(boolean fim) {
        this.fimEvento = fim;
    }
}
