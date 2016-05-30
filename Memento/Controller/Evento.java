package Controller;

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
        return this.descricao;
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
    
    private boolean getFimEvento() {
        return this.fimEvento;
    }
    
    private void setFimEvento(boolean fim) {
        this.fimEvento = fim;
    }
}
