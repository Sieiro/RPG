package Controller;
import java.util.*;

public class EventoPadrao extends Evento {
    public EventoPadrao() {
        super(0, "");
        List<String> lista = new ArrayList<>();
        lista.add("Checar Informações");
        lista.add("Dormir");
        lista.add("Ascender Fogueira");
        lista.add("Explorar");
        lista.add("Sair do jogo");
        this.setOpcoes(lista);
    }
    
    public void info() {
        //
        Mecanica.getInstancia().iniciarEvento(gerarEvento(1));
    }
    
    public void dormir() {
        //
        Mecanica.getInstancia().iniciarEvento(gerarEvento(2));
    }
    
    public void fogueira() {
        //
        Mecanica.getInstancia().iniciarEvento(gerarEvento(3));
    }
    
    public void explorar() {
        //
        Mecanica.getInstancia().iniciarEvento(gerarEvento(4));
    }
    
    public void sair() {
        this.setMensagem("");
        this.setFimEvento(true);
    }

    public Evento gerarEvento(int opt) {
		// opt (1) Checar info (2) dormir (3) ascender fogueira (4) explorar (5) Sair do jogo
		int chance = Mecanica.gerarNumero(0, 100);
		switch(opt) {
			case 1:
				// checar info
				return new Info(opt);
			case 2:
				// dormir
				if(chance < 10)
					return new Batalha(opt);
				if(chance < 20)
					return new DiminuirSanidade(opt);
				return new NenhumEvento(opt); // não aconteceu nada
			case 3:
				// ascender fogueira
				if(chance < 5)
					return new DiminuirSanidade(opt);
				if(chance < 40)
					return new Batalha(opt);
				return new NenhumEvento(opt); // não aconteceu nada
			case 4:
				// explorar
				if(chance < 15)
					return new Batalha(opt);
				if(chance < 30)
					return new Armadilha(opt);
				if(chance < 45)
					return new NovoItem(opt);
				if(chance < 60)
					return new DiminuirSanidade(opt);
				return new NenhumEvento(opt); // não aconteceu nada
		}
		return new NenhumEvento(opt);
	}
}
