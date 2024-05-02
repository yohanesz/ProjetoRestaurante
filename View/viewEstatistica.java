package View;

import java.util.Scanner;

public class viewEstatistica {

    static Scanner read = new Scanner(System.in);

    public static void menuEstatistica() {

        viewLine.title("ESTATÍSTICAS");
        viewLine.alignLeft("[1] - Número de pessoas na fila para almoçar");
        viewLine.alignLeft("[2] - Número de pessoas na fila do caixa");
        viewLine.alignLeft("[3] - Número de pessoas almoçando");
        viewLine.alignLeft("[4] - Número de pessoas atendidas");
        viewLine.alignLeft("[5] - Número de mesas livres");
        viewLine.alignLeft("[6] - Voltar");
        viewLine.Line();

    }

    public static void pessoasNaFila(int num) {
        viewLine.title("ESTATÍSTICAS");
        viewLine.alignLeft("Número de pessoas na fila: " + num);
        viewLine.Line();
        viewLine.pressToContinue();
        read.nextLine();
    }

    public static void pessoasNaFilaDoCaixa(int num) {
        viewLine.title("ESTATÍSTICAS");
        viewLine.alignLeft("Número de pessoas na fila do caixa: " + num);
        viewLine.Line();
        viewLine.pressToContinue();
        read.nextLine();
    }

    public static void pessoasAlmocando(int num) {
        viewLine.title("ESTATÍSTICAS");
        viewLine.alignLeft("Número de pessoas almoçando: " + num);
        viewLine.Line();
        viewLine.pressToContinue();
        read.nextLine();
    }

    public static void pessoasAtendidas(int num) {
        viewLine.title("ESTATÍSTICAS");
        viewLine.alignLeft("Número de pessoas atendidas: " + num);
        viewLine.Line();
        viewLine.pressToContinue();
        read.nextLine();
    }

    public static void mesasLivres(int num) {
        viewLine.title("ESTATÍSTICAS");
        viewLine.alignLeft("Número de mesas livres: " + num);
        viewLine.Line();
        viewLine.pressToContinue();
        read.nextLine();

    }

}
