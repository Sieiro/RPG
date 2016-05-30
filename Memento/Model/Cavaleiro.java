package Model;
public class Cavaleiro extends Pessoa{
    public Cavaleiro(String nome, int vida, int sanidade){
        super(nome, vida, sanidade);
        setArma(new Arma("Espada de Madeira", "Descrição", 15));
        setArmadura(new Armadura("Trapos", "Descrição", 10));
    }
}
