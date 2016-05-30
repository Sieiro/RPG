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
    
    public void setNome(String n){
        this.nome = n;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public void setDescricao(String d){
        this.descricao = d;
    }
}
