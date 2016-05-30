package Model;
public abstract class Pessoa extends Humanoide{
    private int sanidade;
    private Arma arma;
    private Armadura armadura;
    
    public Pessoa(String nome, int vida, int sanidade){
        super(nome, vida);
        this.sanidade = sanidade;
    } 
    public int getSanidade(){
        return this.sanidade;
    }    
    public void setSanidade(int s){
        this.sanidade = s;
    }
    public Arma getArma() {
        return arma;
    }
    public Armadura getArmadura() {
        return armadura;
    }
    public void setArma(Arma arma) {
        this.arma = arma;
    }
    public void setArmadura(Armadura armadura) {
        this.armadura = armadura;
    }
}
