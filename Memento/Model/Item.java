package Model;
public abstract class Item{
    private String nome;
    private String descricao;
    
    public Item(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
    }
     
    public String getNome() {
        return this.nome;
    }
}
