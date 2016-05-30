package Model;
public class Mago extends Pessoa{
    public Mago(String nome, int vida, int sanidade){
        super(nome, vida, sanidade);
        setArma("Cajado de Madeira", "Descrição", 30);
        setArmadura("Trapos", "Descrição", 10);
    }
}
