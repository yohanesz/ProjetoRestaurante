package Model;

public class Dados {

    private static int numeroDePessoasAlmocando;
    private static int numeroDePessoasAtendidas;

    public static void incrementPessoasAlmocando() {
        numeroDePessoasAlmocando++;
    }

    public static void incrementPessoasAtendidas() {
        numeroDePessoasAtendidas++;
    }

    public static void decrementPessoasAlmocando() {
        numeroDePessoasAlmocando--;
    }

    public static void decrementPessoasAtendidas() {
        numeroDePessoasAtendidas--;
    }

    public static int getNumeroDePessoasAlmocando() {
        return numeroDePessoasAlmocando;
    }

    public static void setNumeroDePessoasAlmocando(int numeroDePessoasAlmocando) {
        Dados.numeroDePessoasAlmocando = numeroDePessoasAlmocando;
    }

    public static int getNumeroDePessoasAtendidas() {
        return numeroDePessoasAtendidas;
    }

    public static void setNumeroDePessoasAtendidas(int numeroDePessoasAtendidas) {
        Dados.numeroDePessoasAtendidas = numeroDePessoasAtendidas;
    }

}
