package View;

public class viewPedido {

    public static void menuAdminPedido() {
        viewLine.title("PEDIDO");
        viewLine.alignLeft("[1] - Novo pedido");
        viewLine.alignLeft("[2] - Alterar Pedido");
        viewLine.alignLeft("[3] - Cancelar pedido");
        viewLine.alignLeft("[4] - Consultar pedidos realizados");
        viewLine.alignLeft("[5] - Voltar");
        viewLine.Line();
        viewLine.input();
    }

    public static void menuPedido() {

        viewLine.title("PEDIDO");
        viewLine.alignLeft("[1] - Novo pedido");
        viewLine.alignLeft("[2] - Verificar pedidos");
        viewLine.alignLeft("[3] - Cancelar pedido");
        viewLine.alignLeft("[3] - Voltar");
        viewLine.Line();
        viewLine.input();

    }

    public static void listarPedidos() {
        viewLine.title("PEDIDO");
        viewLine.alignLeft("[1] - Verificar pedido do cliente");
        viewLine.alignLeft("[2] - Listar todos os pedidos");
        viewLine.alignLeft("[3] - Voltar");
        viewLine.Line();
        viewLine.input();
    }

}
