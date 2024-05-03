package View;

import java.util.Scanner;

import Model.Pedido;

public class viewMain {

    static Scanner read = new Scanner(System.in);

    public static void inicioRegistro() {

        viewLine.title("INICIO");
        viewLine.alignLeft("[1] - Cadastrar");
        viewLine.Line();
        viewLine.input();
    }

    public static void erro() {

        viewLine.title("ERRO");
        viewLine.alignLeft("Opção inválida, tente novamente!");
        viewLine.Line();
    }

    public static void inicioClienteOuAdmin() {

        viewLine.title("INICIO");
        viewLine.alignLeft("[1] - Cliente");
        viewLine.alignLeft("[2] - Administrador");
        viewLine.Line();
    }

    public static void inicioBemVindo() {

        viewLine.title("INICIO");
        viewLine.alignLeft("Restaurante X-Corp!");
        viewLine.alignLeft(" ");
        viewLine.alignLeft("Insira o seu cpf: ");
        viewLine.Line();

    }

    public static void inicioClienteNaoCadastrado() {

        viewLine.title("INICIO");
        viewLine.alignLeft("Cliente não cadastrado!");
        viewLine.Line();
        viewLine.pressToContinue();
    }

    public static void menuOpcoes() {

        viewLine.title("MENU ADMINISTRADOR");
        viewLine.alignLeft("[1] - Clientes");
        viewLine.alignLeft("[2] - Pedidos");
        viewLine.alignLeft("[3] - Mesas");
        viewLine.alignLeft("[4] - Funcionários");
        viewLine.alignLeft("[5] - Caixa");
        viewLine.alignLeft("[6] - Estatísticas");
        viewLine.alignLeft("[7] - Voltar");
        viewLine.Line();
    }

    public static void menuCliente(Pedido pedidoAtual) {

        viewLine.title("MENU CLIENTE");
        viewLine.alignLeft("STATUS DO PEDIDO " + pedidoAtual.getId() + ": " + pedidoAtual.getStatus());
        viewLine.alignLeft("[1] - Pedido");
        viewLine.alignLeft("[2] - Mesa");
        viewLine.alignLeft("[3] - Próxima etapa");
        viewLine.alignLeft("[4] - Estatísticas");
        viewLine.alignLeft("[5] - Caixa");
        viewLine.alignLeft("[6] - Voltar");
        viewLine.Line();
        viewLine.input();

    }

}
