package Model;
public abstract class Pessoa extends Humanoide{
    private int sanidade;

    public Pessoa(String nome, int vida, int sanidade){
        super(nome, vida);
        this.sanidade = sanidade;
    } 
    public int getSanidade(){
        return this.sanidade;
    }    
}
