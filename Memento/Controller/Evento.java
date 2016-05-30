package Controller;

public abstract class Evento
{
    private int opt;
    private String descricao;
    
    public Evento(int opt, String desc) {
        this.opt = opt;
        this.descricao = desc;
    }
    
    public getDescricao() {
        return this.descricao;
    }
    
    public getOpt() {
        return this.opt;
    }
}
