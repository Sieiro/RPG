package Model;
public class Cavaleiro extends Pessoa{
    public Cavaleiro(String nome, int vida, int sanidade){
        super(nome, vida, sanidade);
        setArma("Espada de Madeira", "Descrição", 15);
        setArmadura("Trapos", "Descrição", 10);
    }
}
