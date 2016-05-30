package Controller;
import Model.*;

public class Batalha extends Evento
{
    private Inimigo inimigo;
    
    private String[] opcoes = {"Ataque normal", "Habilidade", "Magia"};
        
    public Batalha(int opt) {
        super(opt, "Você entrou em uma batalha quando selecionava a opção " + opt);
        this.inimigo = Inimigo(); // cria inimigo (aleatório?)
    }
    
    // ataca um inimigo com base em sua arma equipada
    public void atacar(Inimigo inimigo) {
        //
    }
    
    // ataca um inimigo com base em uma habilidade/magia
    public void atacar(Pessoa pessoa, Dano dano) {
        //
    }
    
    // ataca um inimigo com base em um item
    public void atacar(Pessoa pessoa, Item item) {
        //
    }
    
    // monstro te ataca
    public void atacar(Pessoa pessoa) {
        //
    }
    
    // fugir do combate; chance de morrer ao tentar
    public void fugir(Pessoa pessoa) {
        //
    }
    
    // pega as opções
    public String[] getOpcoes() {
        return this.opcoes;
    }
}
