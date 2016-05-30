package Model;
public abstract class Humanoide{
    private String nome;
    private int vida;
    
    public Humanoide(String nome, int vida){
        this.nome = nome;
        this.vida = vida;
    }
    public int getVida(){
        return this.vida;
    }
    public void setVida(int v){
       this.vida = v;
    }
    public void setNome(String n){
        this.nome = n;
    }
    public String getNome(){
        return this.nome;
    }
}
