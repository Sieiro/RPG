package Model;
public abstract class Pessoa extends Humanoide{
    private int loucura;

    public Pessoa(String nome, int vida, int loucura){
        super(nome, vida);
        this.loucura = loucura;
    } 
}
