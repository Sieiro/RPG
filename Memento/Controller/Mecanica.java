package Controller;
import java.util.*;
import Model.*;

public class Mecanica {
	private static Mecanica instancia; 			// singleton
	private static Pessoa jogador; 				// jogador atual
	private static boolean vivo; 				// se o jogador esta vivo ou não
	private static int tempoAtual; 				// tempo atual em minutos
	private static ArrayList<Evento> eventos; 	// evento atual, se tiver um evento
	private static Selecionavel selecionado;	// algo selecionado
	private Random rand;
	
	// inicia as variaveis básicas do ambiente
	private Mecanica(Pessoa pessoa){
		this.jogador = pessoa;
		this.vivo = true;
		this.tempoAtual = 0;
	}
	
	public Pessoa getJogador() {
	    return this.jogador;
	}
	
	public static Mecanica getInstancia() {
		return instancia;
	}

	public boolean temEventos() {
		if(eventos.size() > 0)
			return true;
		return false;
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
		return eventos.get(eventos.size() - 1).getOpcoes();
	}
	
	// inicia um evento com um numero da ação previa feita
	public void iniciarEvento(Evento ev){
		//
		eventos.add(ev);
	}
	
	// opera o evento com um numero escolhido pelo usuario
	public void operarEvento(int opt) throws EventoException {
		//
		Evento eventoAtual = eventos.get(eventos.size() - 1);
		Evento ev;
		if(eventoAtual instanceof Batalha) {
			ev = (Batalha) eventoAtual;
			switch(opt) {
				case 1:
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
			ev = (Armadilha) eventoAtual;
			if(opt == 1) {
				ev.continuar(this.jogador);
			}
		}
		else if(eventoAtual instanceof NovoItem) {
			ev = (NovoItem) eventoAtual;
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
			ev = (NenhumEvento) eventoAtual;
			if(opt == 1) {
				ev.continuar();
			}
		}
		else if(eventoAtual instanceof Info) {
			// não implementado ainda
		}
		else if(eventoAtual instanceof DiminuirSanidade) {
			ev = (DiminuirSanidade) eventoAtual;
			if(opt == 1) {
				eventoAtual.continuar(this.jogador);
			}
		}
		else if(eventoAtual instanceof SelecionarItem) {
			// não implementado ainda
		}
		else if(eventoAtual instanceof SelecionarDano) {
			// não implementado ainda
		}
		else if(eventoAtual instanceof EventoPadrao) {
			ev = (EventoPadrao) eventoAtual;
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
		fechaEvento();
	}
	
	public void fechaEvento() {
		Evento ev = eventos.get(eventos.size() - 1);
		if(ev.getFimEvento) {
			ev.remove(eventos.size() - 1);
		}
	}

	public static int gerarNumero(int min, int max){
		return rand.nextInt((max - min) + 1) + min;
	}
}
