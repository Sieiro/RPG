package Model;
public class Habilidade implements Dano, Selecionavel{
    private String nome;
    private String descricao;
    private int dano;
    private boolean recarga;
    
    public Habilidade(String nome, String descricao, int dano){
        this.nome = nome;
        this.descricao = descricao;
        this.dano = dano;
        this.recarga = false;
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
    public boolean emRecarga() {
        return this.recarga;
    }
    public void usar() {
        this.recarga = true;
    }
}
