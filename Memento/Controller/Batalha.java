package Controller;
import Model.*;

public class Batalha extends Evento
{
    private Inimigo inimigo;
        
    public Batalha(int opt) {
        super(opt, "Batalha com um Orc (opt " + opt + ")");
        this.inimigo = Inimigo("Orc", 150, 10, 10);
        List<String> lista = new ArrayList<>();
        lista.add("Ataque Normal");
        lista.add("Habilidade");
        lista.add("Magia");
        //lista.add("Item");
        //lista.add("Fugir");
        this.setOpcoes(lista);
    }
    
    // ataca um inimigo com base em sua arma equipada
    public void atacar(Pessoa pessoa) throws EventoException {
        //
        Pessoa jogador = Mecanica.getPlayer();
        Arma arma = pessoa.getArma();
        int dano = arma.getAtaque() - this.inimigo.getDefesa();
        if(jogador instanceof Mago) {
            this.inimigo.setVida(this.inimigo.getVida() - (dano));
        }
        else if( jogador instanceof Cavaleiro) {
            this.inimigo.setVida(this.inimigo.getVida() - ((dano) * (Mecanica.gerarNumero(100, 150) / 100)));
        }
        else
            throw EventoException("Personagem de nenhuma classe!");
        
        if(this.inimigo.getVida() <= 0) {
            this.setFimEvento(true);
        }
        
        this.setMesangem("Você ataca seu inimigo: " + this.inimigo.getNome());
    }
    
    // ataca um inimigo com base em uma habilidade/magia
    public void atacar(Dano dano) throws EventoException {
        // se não tiver em cooldown
        if(!dano.emRecarga()) {
            this.inimigo.setVida(this.inimigo(getVida() - dano.getAtaque()));
        }
        else
            throw EventoException("Habilidade/Magia em Recarga!");
        
        if(this.inimigo.getVida() <= 0) {
            this.setFimEvento(true);
        }
        
        this.setMesangem("Você ataca seu inimigo: " + this.inimigo.getNome());
    }
    
    // ataca um inimigo com base em um item
    public void atacar(Item item) throws EventoException {
        //
        if(Item instanceof Dano) {
            this.inimigo.setVida(this.inimigo(getVida() - item.getAtaque()));
        }
        else
            throw EventoException("Este item não pode ser usado como arma!");
            
        if(this.inimigo.getVida() <= 0) {
            this.setFimEvento(true);
        }
        
        this.setMesangem("Você ataca seu inimigo: " + this.inimigo.getNome());
    }
    
    // monstro te ataca
    public void recebe(Pessoa pessoa) {
        pessoa.setVida(pessoa.getVida() - (inimigo.getAtaque() - pessoa.getArmadura().getDefesa()));
        if(pessoa.getVida() <= 0) {
            this.setFimEvento(true);
        }
        
        this.setMesangem("Seu inimigo te ataca!");
    }
    
    // fugir do combate; chance de morrer ao tentar
    public void fugir(Pessoa pessoa) {
        //
        int chance = Mecanica.getNumero(1, 10);
        if(chance < 6) {
            atacar(pessoa);
        }
        else {
            setFimEvento(true);
            this.setMesangem("Você consegue fugir...");
        }
    }
}
