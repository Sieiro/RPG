package View;
import Controller.*;
import Model.*;

public class Main {
    private static Mecanica mecanica;
    private static int opt;
    private static String arg;

    public Main() {

    }

    public static void main() {
        imprimir(" - Memento - v1.0.a");
        imprimir("Digite qual classe deverá ser (1) Mago (2) Cavaleiro: ");
        this.opt = Keyboard.readInt();
        Pessoa pessoa;
        if(opt == 1) pessoa = new Mago();
        else if(opt == 2) pessoa = new Cavaleiro();
        imprimir("Digite seu nome: ");
        this.arg = Keyboard.readString();
        Main.mecanica = new Mecanica()
    }

    public static void run() {

    }

    public void imprimir(String msg) {
        System.out.println(msg);
    }
}
