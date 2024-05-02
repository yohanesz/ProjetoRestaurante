package View;

public class viewMesas {

    public static void menuAdminMesa() {
        viewLine.title("MESA");
        viewLine.alignLeft("[1] - Alocar mesa para cliente");
        viewLine.alignLeft("[2] - Liberar mesa");
        viewLine.alignLeft("[3] - Consultar mesas ocupadas");
        viewLine.alignLeft("[4] - Voltar");
        viewLine.Line();
        viewLine.input();

    }

    public static void mesaCliente() {
        viewLine.title("MESA");
        viewLine.alignLeft("[1] - Alocar mesa");
        viewLine.alignLeft("[2] - Liberar mesa");
        viewLine.alignLeft("[3] - Voltar");
        viewLine.Line();
        viewLine.input();

    }

}
