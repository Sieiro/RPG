package View;
import Controller.*;
import Model.*;
import java.util.*;
public class Main {
    private static Mecanica mecanica;
    private static int opt;
    private static String arg;

    private Main() {

    }

    public static void main(String[] args) {
        imprimir(" - Memento - v1.0.b");
        imprimir("Digite qual classe deverá ser (1) Mago (2) Cavaleiro: ");
        opt = Keyboard.readInt();
        Pessoa pessoa = null;
        switch(opt) {
            case 1:
                pessoa = new Mago(null, 250, 100);
                break;
            case 2:
                pessoa = new Cavaleiro(null, 300, 100);
                break;
            default:
                imprimir("Classe não selecionada... Fechando.");
        }
        if(pessoa != null) {
            imprimir("Digite seu nome: ");
            arg = Keyboard.readString();
            pessoa.setNome(arg);
            mecanica = Mecanica.getInstancia(pessoa);
            mecanica.iniciarEvento(new EventoPadrao());
            run();
        }
    }

    public static void run() {
        int i = 0;
        while(mecanica.temEventos()) {
            i = 1;
            if(Mecanica.getInstancia().getTurno()) {
                imprimir("Digite sua opção:");
                List<String> opcoes = mecanica.getOpcoes();
                for(String str : opcoes) {
                    imprimir("" + (i++) + ". " + str);
                }
                imprimir("");
                opt = Keyboard.readInt();
                try {
                    mecanica.operarEvento(opt);
                }
                catch (EventoException ex) {
                    imprimir(ex.getMessage());
                }
                imprimir(mecanica.getMensagem());
            }
            else {
                if(Mecanica.getInstancia().ultimoEvento() instanceof Batalha) {
                    mecanica.monstroAtaque();
                    imprimir(mecanica.getMensagem());
                }
                else {
                    Mecanica.getInstancia().passarTurno();
                }
            }
            arg = mecanica.check();
            if(arg != null) imprimir(arg);
        }
        imprimir("Game Over");
    }

    public static void imprimir(String msg) {
        System.out.println(msg);
    }
}
