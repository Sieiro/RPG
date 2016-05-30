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
    private static ArrayList<Evento> eventos;   // evento atual, se tiver um evento
    private static Selecionavel selecionado;    // algo selecionado
    private static Random rand;
    private static boolean fogueiraAcesa = false;
    // inicia as variaveis básicas do ambiente
    private Mecanica(Pessoa pessoa){
        this.turno = true;
        this.jogador = pessoa;
        this.vivo = true;
        this.tempoAtual = 0;
        this.rand = new Random();
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
        ev.recebe(jogador);
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
                    this.turno = false;
                    try {
                        ev = (Batalha) eventoAtual;
                        ev.atacar(this.jogador);
                    }
                    catch (EventoException ex) {
                        throw new EventoException(ex);
                    }
                    break;
                    //
                case 2:
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
            }
        }
        else if(eventoAtual instanceof Armadilha) {
            Armadilha ev = (Armadilha) eventoAtual;
            if(opt == 1) {
                ev.continuar(this.jogador);
            }
        }
        else if(eventoAtual instanceof NovoItem) {
            NovoItem ev = (NovoItem) eventoAtual;
            switch(opt) {
                case 1:
                    ev.pegarItem(jogador);
                    break;
                case 2:
                    ev.descartarItem();
                    break;
            }
        }
        else if(eventoAtual instanceof NenhumEvento) {
            NenhumEvento ev = (NenhumEvento) eventoAtual;
            if(opt == 1) {
                ev.continuar();
            }
        }
        else if(eventoAtual instanceof Info) {
            // não implementado ainda
        }
        else if(eventoAtual instanceof DiminuirSanidade) {
            DiminuirSanidade ev = (DiminuirSanidade) eventoAtual;
            if(opt == 1) {
                ev.continuar(this.jogador);
            }
        }
        else if(eventoAtual instanceof SelecionarItem) {
            // não implementado ainda
        }
        else if(eventoAtual instanceof SelecionarDano) {
            // não implementado ainda
        }
        else if(eventoAtual instanceof EventoPadrao) {
            EventoPadrao ev = (EventoPadrao) eventoAtual;
            switch(opt) {
                case 1:
                    ev.info();
                    break;
                case 2:
                    ev.dormir();
                    break;
                case 3:
                    ev.fogueira();
                    break;
                case 4:
                    ev.explorar();
                    break;
                case 5:
                    ev.sair();
                    break;
            }
        }
    }
    
    public void fechaEvento() {
        Evento ev = ultimoEvento();
        if(ev.getFimEvento()) {
            eventos.remove(eventos.size() - 1);
        }
    }

    public static int gerarNumero(int min, int max){
        return rand.nextInt((max - min) + 1) + min;
    }
}
