package Controller;
import Model.*;
import java.util.*;
public class Batalha extends Evento
{
    private Inimigo inimigo;
    private boolean turno;
    
    public Batalha(int opt) {
        super(opt, "");
        this.inimigo = gerarInimigo();
        setMensagem("Batalha com: " + inimigo.getNome() + " Encontrada!");
        List<String> lista = new ArrayList<>();
        lista.add("Ataque Normal");
        lista.add("Usar Habilidade ou Magia");
        lista.add("Usar Item");
        this.turno = true;
        //lista.add("Usar Item");
        lista.add("Fugir");
        this.setOpcoes(lista);
    }
    
    public Inimigo gerarInimigo() {
        //Inimigo("Orc", 150, 35, 10)
        int chance = Mecanica.getInstancia().gerarNumero(1,4);
        //public Inimigo(String nome, int vida, int defesa, int ataque){
        switch(chance) {
            case 1:
                return new Inimigo("Lobo", 75, 6, 50);
            case 2:
                return new Inimigo("Goblin", 150, 10, 35);
            case 3:
                return new Inimigo("Orc", 220, 13, 50);
            default:
                return new Inimigo("Espectro", 20, 75, 25);
        }
    }
    
    // ataca um inimigo com base em sua arma equipada
    
    public void atacar() throws EventoException {
        //
        Pessoa pessoa = Mecanica.getInstancia().getJogador();
        Arma arma = pessoa.getArma();
        int dano = arma.getAtaque() - this.inimigo.getDefesa();
        if(dano < 0) dano = 0;
        int vidaAnterior = this.inimigo.getVida();
        if(pessoa instanceof Mago) {
            this.inimigo.setVida(vidaAnterior - (dano));
        }
        else if(pessoa instanceof Cavaleiro) {
            this.inimigo.setVida(vidaAnterior - ((dano) * (Mecanica.gerarNumero(100, 150) / 100)));
        }
        else
            throw new EventoException("Personagem de nenhuma classe!");
        
        if(this.inimigo.getVida() <= 0) {
            this.setFimEvento(true);
            this.setMensagem("Você matou seu inimigo: " + this.inimigo.getNome());
            Mecanica.getInstancia().iniciarEvento(new NovoItem(7)); // novo item!
        }
        else {
            this.setMensagem("Você ataca seu inimigo: " + this.inimigo.getNome() + ". Dano: " + (vidaAnterior - this.inimigo.getVida()) + "(" + this.inimigo.getVida() + ")");
        }
    }
    
    
    // ataca um inimigo com base em uma habilidade/magia
    public void atacar(Dano dano) throws EventoException {
        // se não tiver em cooldown
        int vidaAnterior = this.inimigo.getVida();
        if(!dano.emRecarga()) {
            this.inimigo.setVida(this.inimigo.getVida() - dano.getDano());
        }
        else
            throw new EventoException("Habilidade/Magia em Recarga!");
        
        if(this.inimigo.getVida() <= 0) {
            this.setFimEvento(true);
            this.setMensagem("Você matou seu inimigo: " + this.inimigo.getNome());
            Mecanica.getInstancia().iniciarEvento(new NovoItem(7)); // novo item!
        }
        else {
            this.setMensagem("Você ataca seu inimigo: " + this.inimigo.getNome() + ". Dano: " + (vidaAnterior - this.inimigo.getVida()) + "(" + this.inimigo.getVida() + ")");
        }
    }
    
    // ataca um inimigo com base em um item
    public void atacar(Item item) throws EventoException {
        //
        int vidaAnterior = this.inimigo.getVida();
        if(item instanceof Dano) {
            Dano it = (Dano) item;
            this.inimigo.setVida(this.inimigo.getVida() - it.getDano());
        }
        else
            throw new EventoException("Este item não pode ser usado como arma!");
            
        if(this.inimigo.getVida() <= 0) {
            this.setFimEvento(true);
            this.setMensagem("Você matou seu inimigo: " + this.inimigo.getNome());
            Mecanica.getInstancia().iniciarEvento(new NovoItem(7)); // novo item!
        }
        else {
            this.setMensagem("Você ataca seu inimigo: " + this.inimigo.getNome() + ". Dano: " + (vidaAnterior - this.inimigo.getVida()) + "(" + this.inimigo.getVida() + ")");
        }
    }
    
    // monstro te ataca
    public void recebe() {
        Pessoa pessoa = Mecanica.getInstancia().getJogador();
        int vidaAnterior = pessoa.getVida();
        int dano = inimigo.getAtaque() - pessoa.getArmadura().getDefesa();
        if(dano < 0) dano = 0;
        pessoa.setVida(vidaAnterior - (dano));
        if(pessoa.getVida() <= 0) {
            this.setFimEvento(true);
            Mecanica.getInstancia().passarTurno();
            this.setMensagem("Seu inimigo te matou!");
            Mecanica.getInstancia().setVivo(false);
        }
        Mecanica.getInstancia().passarTurno();
        this.setMensagem("Seu inimigo te ataca! Dano: " + (vidaAnterior - pessoa.getVida()) + "(" + pessoa.getVida() + ")" );
    }
    
    // fugir do combate; chance de morrer ao tentar
    public void fugir() {
        //
        Pessoa pessoa = Mecanica.getInstancia().getJogador();
        int chance = Mecanica.gerarNumero(0, 100);
        if(chance < 65) {
            recebe();
        }
        else {
            setFimEvento(true);
            this.setMensagem("Você consegue fugir...");
        }
    }
}