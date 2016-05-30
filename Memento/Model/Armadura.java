package Model;
public class Armadura extends Item{
    private int defesa;
    public Armadura(String nome, String descricao, int defesa){
    super(nome, descricao);
    this.defesa = defesa;
    }
}
