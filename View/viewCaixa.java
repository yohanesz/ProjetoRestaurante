package View;

public class viewCaixa {

    public static void menuAdminCaixa() {
        viewLine.title("CAIXA");
        viewLine.alignLeft("[1] - Consultar histórico de pagamentos");
        viewLine.alignLeft("[2] - Emissão de recibo");
        viewLine.alignLeft("[3] - Voltar");
        viewLine.Line();
        viewLine.input();

    }

}
