package Controller;
import java.util.Random;
import Model.*;
public class Mecanica {
	private static Mecanica instancia; 			// singleton
	private static Pessoa jogador; 				// jogador atual
	private static boolean vivo; 				// se o jogador esta vivo ou não
	private static int tempoAtual; 				// tempo atual em minutos
	private static List<Evento> eventos; 		// evento atual, se tiver um evento
	private static Selecionavel selecionado;	// algo selecionado
	Random rand;
	
	// inicia as variaveis básicas do ambiente
	private Mecanica(Pessoa pessoa){
		this.jogador = pessoa;
		this.vivo = true;
		this.tempoAtual = 0;
	}
	
	private static setInstancia(Pessoa pessoa) {
		this(pessoa);
	}
	
	private static getInstancia() {
		return instancia;
	}
	
	// inicia um evento com um numero da ação previa feita
	public void iniciarEvento(Evento ev){
		//
		eventos.add(ev);
	}
	
	// opera o evento com um numero escolhido pelo usuario
	public void operarEvento(int opt) throws EventoException {
		//
		Evento eventoAtual = gerarEvento(opt);
		if(eventoAtual instanceof Batalha) {
			switch(opt) {
				case 1:
					try {
						eventoAtual.atacar(jogador);
					}
					catch (EventoException ex) {
						throw new EventoException(ex);
					}
					break;
					//
				case 2:
					if(selecionado == null) {
						eventos.add(new SelecionarDano);
					}
					else {
						if(selecionado instanceof Dano) {
							try {
								eventoAtual.atacar((Dano) selecionado);
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
						eventos.add(new SelecionarItem);
					else {
						if(selecionado instanceof Item) {
							try {
								eventoAtual.atacar((Item) selecionado);
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
			if(opt == 1) {
				eventoAtual.continuar(jogador);
			}
		}
		else if(eventoAtual instanceof NovoItem) {
			switch(opt) {
				case 1:
					eventoAtual.pegarItem(jogador);
					break;
				case 2:
					eventoAtual.descartarItem();
					break;
			}
		}
		else if(eventoAtual instanceof NenhumEvento) {
			if(opt == 1) {
				eventoAtual.continuar();
			}
		}
		else if(eventoAtual instanceof Info) {
			// não implementado ainda
		}
		else if(eventoAtual instanceof DiminuirSanidade) {
			if(opt == 1) {
				eventoAtual.continuar(jogador);
			}
		}
		else if(eventoAtual instanceof SelecionarItem) {
			// não implementado ainda
		}
		else if(eventoAtual instanceof SelecionarDano) {
			// não implementado ainda
		}
		else if(eventoAtual instanceof EventoPadrao) {
			switch(opt) {
				case 1:
					eventoAtual.info();
					break;
				case 2:
					eventoAtual.dormir();
					break;
				case 3:
					eventoAtual.fogueira();
					break;
				case 4:
					eventoAtual.explorar();
					break;
				case 5:
					eventoAtual.sair();
					break;
			}
		}
		fechaEvento();
	}
	
	public void fechaEvento() {
		Evento ev = eventos.get(eventos.size() - 1)
		if(ev.getFimEvento) {
			ev.remove(eventos.size() - 1);
		}
	}

	public static int gerarNumero(int min, int max){
		return rand.nextInt((max - min) + 1) + min;
	}
}
