package Controller;

import java.util.Scanner;

import Model.Cliente;
import Model.DataBase;
import Model.Funcionarios;
import Model.ListaEncadeada;
import Model.Nodo;
import Model.Pedido;
import View.viewLine;
import View.viewPedido;

public class ControllerPedido {

    DataBase database = DataBase.getInstance();
    ListaEncadeada<Pedido> pedidos = database.getListaPedidos();

    ListaEncadeada<Cliente> clientes = database.getListaClientes();

    static Scanner read = new Scanner(System.in);

    public void iniciarAdminPedido() {

        boolean verificador = true;

        do {
            viewPedido.menuAdminPedido();
            int option = read.nextInt();
            read.nextLine();

            switch (option) {
                case 1:
                    novoPedido();
                    break;
                case 2:
                    alterarPedido();
                    break;
                case 3:
                    cancelarPedido();
                    break;
                case 4:
                    viewLine.title("PEDIDOS");
                    clientes.showList();
                    viewLine.Line();
                    viewLine.input();
                    int inputInt = read.nextInt();
                    Nodo<Cliente> cliente = clientes.getDadoById(inputInt);
                    listarPedidos(cliente.getDado().getNome());
                    break;
                case 5:
                    verificador = false;
                    break;

                default:
                    break;
            }

        } while (verificador);
    }

    public Pedido menuPedido(Funcionarios funcionario, Cliente clienteLogado) {

        boolean verificador = true;

        do {
            viewPedido.menuPedido();
            int option = read.nextInt();
            read.nextLine();

            if (option == 1) {
                Pedido pedidoRealizado = realizarPedido(funcionario, clienteLogado);
                return pedidoRealizado;

            } else if (option == 2) {

                listarPedidos(clienteLogado.getNome());

            } else if (option == 3) {
                cancelarPedido();
            } else if (option == 4) {

                verificador = false;
                break;
            }

        } while (verificador);

        return null;
    }

    public void listarPedidos(String nomeCliente) {
        boolean verificador = true;

        do {
            viewPedido.listarPedidos();
            int option = read.nextInt();
            read.nextLine();

            if (option == 1) {

                viewLine.title("PEDIDO");
                pedidos.showListWithCondition(nomeCliente);

                viewLine.Line();
                viewLine.pressToContinue();
                read.nextLine();

            } else if (option == 2) {

                viewLine.title("PEDIDO");
                pedidos.showList();
                viewLine.Line();
                viewLine.pressToContinue();
                read.nextLine();

            } else if (option == 3) {

                verificador = false;
            }

        } while (verificador);
    }

    public Pedido realizarPedido(Funcionarios funcionario, Cliente clienteLogado) {

        viewLine.title("PEDIDO");
        System.out.print("Insira a quantidade de itens do pedido: ");
        int quantidade = read.nextInt();
        read.nextLine();

        Pedido newPedido = new Pedido(quantidade, clienteLogado.getNome(), funcionario.getNome());
        newPedido.setId(clienteLogado.getId());
        pedidos.insertEnd(newPedido);
        viewLine.title("PEDIDO");
        viewLine.alignLeft("Pedido realizado com sucesso!");
        viewLine.Line();
        viewLine.pressToContinue();
        read.nextLine();

        return newPedido;

    }

    public void novoPedido() {
        viewLine.title("PEDIDO");
        System.out.print("Insira o nome do cliente: ");
        String nomeCliente = read.nextLine();
        System.out.print("Insira a quantidade de itens do pedido: ");
        int quantidade = read.nextInt();
        read.nextLine();
        System.out.print("Insira o nome do garçom: ");
        String nomeGarcom = read.nextLine();
        Pedido newPedido = new Pedido(quantidade, nomeCliente, nomeGarcom);
        pedidos.insertEnd(newPedido);
        viewLine.title("PEDIDO");
        viewLine.alignLeft("Pedido realizado com sucesso!");
        viewLine.Line();
        viewLine.pressToContinue();
        read.nextLine();
    }

    public void alterarPedido() {
        viewLine.title("PEDIDO");
        pedidos.showList();
        viewLine.Line();
        System.out.print("| Selecione o pedido desejado (id):");
        int inputId = read.nextInt();
        read.nextLine();
        System.out.print("| Informe o atributo que deseja alterar: ");
        String inputAtributo = read.nextLine().toLowerCase();
        System.out.print("| Insira o novo dado: ");
        String inputNovoDado = read.nextLine().toLowerCase();

        pedidos.update(inputId, inputAtributo, inputNovoDado);
        viewLine.title("PEDIDO");
        viewLine.alignLeft("Pedido atualizado com sucesso!");
        viewLine.Line();
        viewLine.pressToContinue();
        read.nextLine();

    }

    public void cancelarPedido() {
        viewLine.title("PEDIDO");
        pedidos.showList();
        viewLine.Line();
        System.out.print("| Selecione o pedido desejado (id): ");
        int inputId = read.nextInt();
        pedidos.deleteByValue(inputId);
        viewLine.title("PEDIDO");
        viewLine.alignLeft("Pedido cancelado com sucesso!");
        viewLine.Line();
        viewLine.pressToContinue();
        read.nextLine();

    }

    public void criarPedidoPadrao() {
        Pedido ped = new Pedido(2, "Yohanês", "Gustavo");
        Pedido ped2 = new Pedido(4, "Yohanês", "Gustavo");
        Pedido ped3 = new Pedido(2, "Eliton", "Pedro");
        Pedido ped4 = new Pedido(5, "Eliton", "Pedro");

        pedidos.insertEnd(ped);
        pedidos.insertEnd(ped2);
        pedidos.insertEnd(ped3);
        pedidos.insertEnd(ped4);
    }

}
