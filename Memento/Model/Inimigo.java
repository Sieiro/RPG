package Model;

public class Inimigo extends Humanoide{
    private int defesa;
    private int ataque;
    
    public Inimigo(String nome, int vida, int defesa, int ataque){
        super(nome, vida);
        this.defesa = defesa;
        this.ataque = ataque;
    }
}

