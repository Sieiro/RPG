package Controller;
import java.util.*;
import Model.*;
import java.util.Random;
public class Mecanica {
    private static boolean turno;
    private static Mecanica instancia;          // singleton
    private static Pessoa jogador;              // jogador atual
    private static boolean vivo;                // se o jogador esta vivo ou não
    private static int tempoAtual;              // tempo atual em minutos
    private static int dias;
    private static List<Evento> eventos;   // evento atual, se tiver um evento
    private static Selecionavel selecionado;    // algo selecionado
    private static Random rand;
    // inicia as variaveis básicas do ambiente
    private Mecanica(Pessoa pessoa){
        this.turno = true;
        this.jogador = pessoa;
        this.vivo = true;
        this.tempoAtual = 0;
        this.rand = new Random();
    }
    
    public String check() {
        //checar se a pessoa esta viva, se ja passou o horario da noite (1440)
        fechaEvento();
        // jogador morreu
        if(!this.vivo) {
            eventos.clear();
            return "Você morreu.";
        }
        
        // reseta o tempo
        if(tempoAtual >= 1440) {
            tempoAtual = 0;
            dias++;
            // itera sobre todos os Danos de jogador e retira o cooldown
            return String.valueOf("" + dias + " Dia");
        }
        
        if(jogador.getSanidade() <= 0) {
            eventos.clear();
            return "Você ficou louco!";
        }
        return null;
    }
    
    public boolean getVivo() {
        return this.vivo;
    }
    
    public void setVivo(boolean b) {
        this.vivo = b;
    }
    
    public int getDias() {
        return this.dias;
    }
    
    public Evento ultimoEvento() {
        return eventos.get(eventos.size() - 1);
    }
    
    public String getMensagem() {
        Evento ev = ultimoEvento();
        return ev.getMensagem();
    }
    
    public void setSelecionado(Selecionavel sel) {
        this.selecionado = sel;
    }
    
    public Pessoa getJogador() {
        return this.jogador;
    }
    
    public static Mecanica getInstancia() {
        return instancia;
    }
    
    public void monstroAtaque() {
        Evento eventoAtual = ultimoEvento();
        Batalha ev = (Batalha) eventoAtual;
        ev.recebe();
    }

    public boolean temEventos() {
        if(eventos.size() > 0)
            return true;
        return false;
    }
    
    public void passarTurno() {
        this.turno = true;
    }
    
    public boolean getTurno() {
        return this.turno;
    }

    public static Mecanica getInstancia(Pessoa pessoa) {
        if(instancia == null) {
            eventos = new ArrayList<Evento>();
            instancia = new Mecanica(pessoa);
            return instancia;
        }
        return instancia;
    }

    public List<String> getOpcoes() {
        return ultimoEvento().getOpcoes();
    }
    
    // inicia um evento com um numero da ação previa feita
    public void iniciarEvento(Evento ev) {
        //
        eventos.add(ev);
    }
    
    // opera o evento com um numero escolhido pelo usuario
    public void operarEvento(int opt) throws EventoException {
        //
        Evento eventoAtual = ultimoEvento();
        if(eventoAtual instanceof Batalha) {
            Batalha ev = (Batalha) eventoAtual;
            switch(opt) {
                case 1:
                    this.tempoAtual += gerarNumero(20, 60);
                    this.turno = false;
                    try {
                        ev = (Batalha) eventoAtual;
                        ev.atacar();
                    }
                    catch (EventoException ex) {
                        throw new EventoException(ex);
                    }
                    break;
                    //
                case 2:
                    if(Mochila.getInstancia().getDanoQuantidade() == 0) {
                        ev.setMensagem("Você não tem nenhuma Magia ou Habilidade!");
                        break;
                    }
                    this.tempoAtual += gerarNumero(20, 60);
                    this.turno = false;
                    if(selecionado == null) {
                        iniciarEvento(new SelecionarDano(opt));
                    }
                    else {
                        if(selecionado instanceof Dano) {
                            try {
                                ev.atacar((Dano) selecionado);
                            }
                            catch (EventoException ex) {
                                throw new EventoException(ex);
                            }
                        }
                        else
                            throw new EventoException("Você não selecionou uma Habilidade/Magia!");
                    }
                    break;
                    //
                case 3:
                    if(Mochila.getInstancia().getItemQuantidade() == 0) {
                        ev.setMensagem("Você não tem nenhum item!");
                        break;
                    }                
                    this.tempoAtual += gerarNumero(20, 60);
                    this.turno = false;
                    if(selecionado == null)
                        iniciarEvento(new SelecionarItem(opt));
                    else {
                        if(selecionado instanceof Consumivel) {
                            try {
                                ev.atacar((Consumivel) selecionado);
                            }
                            catch (EventoException ex) {
                                throw new EventoException(ex);
                            }
                        }
                        else
                            throw new EventoException("Você não selecionou um item!");
                    }
                    break;
                case 4: // fugir
                    this.tempoAtual += gerarNumero(60, 100);
                    this.turno = false;
                    ev.fugir();
                    break;
            }
        }
        else if(eventoAtual instanceof Armadilha) {
            this.tempoAtual += gerarNumero(10, 30);
            Armadilha ev = (Armadilha) eventoAtual;
            if(opt == 1) {
                ev.continuar();
            }
        }
        else if(eventoAtual instanceof NovoItem) {
            this.tempoAtual += gerarNumero(10, 30);
            NovoItem ev = (NovoItem) eventoAtual;
            switch(opt) {
                case 1:
                    ev.pegarItem();
                    break;
                case 2:
                    ev.descartarItem();
                    break;
            }
        }
        else if(eventoAtual instanceof NenhumEvento) {
            this.tempoAtual += gerarNumero(10, 15);
            NenhumEvento ev = (NenhumEvento) eventoAtual;
            if(opt == 1) {
                ev.continuar();
            }
        }
        else if(eventoAtual instanceof Info) {
            this.tempoAtual += gerarNumero(3, 5);
            Info ev = (Info) eventoAtual;
            if(opt == 1) {
                ev.continuar();
            }
        }
        else if(eventoAtual instanceof DiminuirSanidade) {
            this.tempoAtual += gerarNumero(10, 30);
            DiminuirSanidade ev = (DiminuirSanidade) eventoAtual;
            if(opt == 1) {
                ev.continuar();
            }
        }
        else if(eventoAtual instanceof SelecionarItem) {
            // não implementado ainda
        }
        else if(eventoAtual instanceof SelecionarDano) {
            // não implementado ainda
        }
        else if(eventoAtual instanceof EventoPadrao) {
            this.tempoAtual += gerarNumero(30, 45);
            EventoPadrao ev = (EventoPadrao) eventoAtual;
            switch(opt) {
                case 1:
                    this.tempoAtual += gerarNumero(10, 15);
                    ev.info();
                    break;
                case 2:
                    this.tempoAtual += gerarNumero(180, 360);
                    this.jogador.setSanidade(this.jogador.getSanidade() + gerarNumero(5, 10));
                    this.jogador.setVida(this.jogador.getVida() + gerarNumero(5, 10));
                    if(jogador.getSanidade() > 100) jogador.setSanidade(100);
                    if(jogador instanceof Mago) {
                        if(jogador.getVida() > 250) jogador.setVida(250);
                    }
                    else if(jogador instanceof Cavaleiro) {
                        if(jogador.getVida() > 300) jogador.setVida(250);
                    }
                    ev.dormir();
                    break;
                case 3:
                    this.tempoAtual += gerarNumero(45, 60);
                    this.jogador.setSanidade(this.jogador.getSanidade() + gerarNumero(13, 25));
                    if(jogador.getSanidade() > 100) jogador.setSanidade(100);
                    ev.fogueira();
                    break;
                case 4:
                    this.tempoAtual += gerarNumero(15, 25);
                    ev.explorar();
                    break;
                case 5:
                    ev.sair();
                    break;
            }
        }
    }
    
    public void fechaEvento() {
        Evento ev;
        for(int i = 0; i < eventos.size() && eventos.size() > 0; i++) {
            ev = eventos.get(i);
            if(ev.getFimEvento()) {
                eventos.remove(i);
                i = -1;
            }
        }
    }

    public static int gerarNumero(int min, int max){
        return rand.nextInt((max - min) + 1) + min;
    }
}
