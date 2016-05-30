package Model;
public class Armadura extends Item implements Equipavel{
    private int defesa;
    public Armadura(String nome, String descricao, int defesa){
    super(nome, descricao);
    this.defesa = defesa;
    }
    
    public int getDefesa(){
        return this.defesa;
    }
    
    public void setDefesa(int d){
        this.defesa = d;
    }
   
}
