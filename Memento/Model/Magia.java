package Model;
public class Magia implements Dano, Selecionavel{
    private String nome;
    private String descricao;
    private int dano;
    
    public Magia(String nome, String descricao, int dano){
        this.nome = nome;
        this.descricao = descricao;
        this.descricao = descricao;
    }  
    public void setNome(String n){
        this.nome = n;
    }
    public String getNome(){
        return this.nome;
    }
    public void setDescricao(String d){
        this.descricao = d;
    }
    public String getDescricao(){
        return this.descricao;
    }
    public void setDano(int da){
        this.dano = da;
    }
    public int getDano(){
        return this.dano;
    }
}
