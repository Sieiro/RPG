package Model;
public class Mago extends Pessoa{
    public Mago(String nome, int vida, int sanidade){
        super(nome, vida, sanidade);
        setArma(new Arma("Cajado de Madeira", "Descrição", 30));
        setArmadura(new Armadura("Trapos", "Descrição", 10));
    }
}
