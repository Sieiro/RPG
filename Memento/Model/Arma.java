package Model;
public class Arma extends Item implements Equipavel{
    private int ataque;
    public Arma(String nome, String descricao, int ataque){
    super(nome, descricao);
    this.ataque = ataque;
    }
    
    public int getAtaque(){
        return this.ataque;
    }
    
    public void setAtaque(int a){
        this.ataque = a;
    }
}
