package View;
import Controller.*;
import Model.*;
import java.util.ArrayList;
public class Main {
    private static Mecanica mecanica;
    private static int opt;
    private static String arg;

    public Main() {

    }

    public static void main() {
        imprimir(" - Memento - v1.0.a");
        imprimir("Digite qual classe deverá ser (1) Mago (2) Cavaleiro: ");
        opt = Keyboard.readInt();
        Pessoa pessoa;
        if(opt == 1) pessoa = new Mago(null,1,1);
        else if(opt == 2) pessoa = new Cavaleiro(null,1,1);
        imprimir("Digite seu nome: ");
        arg = Keyboard.readString();
        pessoa.setNome(arg);
        mecanica = Mecanica.getInstancia(pessoa);
        mecanica.iniciarEvento(new EventoPadrao());
        run();
    }

    public static void run() {
        while(mecanica.temEventos()) {
            int i=1;
            imprimir("Digite sua opção:");
            ArrayList<String> opcoes = mecanica.getOpcoes();
            for(String str : opcoes) {
                imprimir("" + i + ". " + str);
            }
            imprimir("");
            opt = Keyboard.readInt();
            mecanica.operarEvento(opt);
            imprimir(mecanica.getMessage());
        }
    }

    public static void imprimir(String msg) {
        System.out.println(msg);
    }
}
