package Model;

public class Inimigo extends Humanoide{
    private int defesa;
    private int ataque;
    
    public Inimigo(String nome, int vida, int defesa, int ataque){
        super(nome, vida);
        this.defesa = defesa;
        this.ataque = ataque;
    }
    public int getDefesa(){
        return this.defesa;
    }
    public int getAtaque(){
        return this.ataque;
    }
    public void setDefesa(int d){
        this.defesa = d;
    }
    public void setAtaque(int a){
        this.ataque = a;
    }
}

