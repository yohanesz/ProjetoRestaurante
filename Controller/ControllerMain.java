package Controller;

import java.util.Scanner;
import Model.Nodo;
import Model.Pedido;
import View.viewLine;
import View.viewMain;
import Model.Cliente;
import Model.Dados;
import Model.DataBase;
import Model.Fila;
import Model.Funcionarios;
import Model.ListaEncadeada;

public class ControllerMain {

    static Scanner read = new Scanner(System.in);

    ControllerCliente controllerCliente = new ControllerCliente();
    ControllerFuncionario controllerFuncionario = new ControllerFuncionario();
    ControllerMesa controllerMesa = new ControllerMesa();
    ControllerPedido controllerPedido = new ControllerPedido();
    ControllerEstatistica controllerEstatistica = new ControllerEstatistica();
    ControllerCaixa controllerCaixa = new ControllerCaixa();

    DataBase database = DataBase.getInstance();
    ListaEncadeada<Cliente> clientes = database.getListaClientes();
    Fila<Cliente> filaParaAlmocar = database.getFilaParaAlmocar();
    Fila<Cliente> filaDoCaixa = database.getFilaDoCaixa();

    public void iniciarAtributosPadrao() {
        controllerCliente.criarClientePadrao();
        Cliente clienteTeste = clientes.getDadoById(1).getDado();
        controllerCaixa.criarPagamentoPadrao(clienteTeste);
        controllerMesa.criarMesasPadrao();
        controllerFuncionario.cadastrarFuncionarioPadrao();
        controllerPedido.criarPedidoPadrao();
    }

    public void inicioClienteOuAdmin() {

        iniciarAtributosPadrao();
        boolean verificador = true;

        do {
            viewMain.inicioClienteOuAdmin();
            viewLine.input();
            int option = read.nextInt();
            read.nextLine();

            if (option == 1) {
                iniciarAtendimentoCliente();
            } else if (option == 2) {
                iniciarAtendimentoAdmin();
            } else {
                viewMain.erro();
                read.nextLine();
                verificador = false;
            }

        } while (verificador);

    }

    public void iniciarAtendimentoAdmin() {

        boolean verificador = true;

        do {

            viewMain.menuOpcoes();
            viewLine.input();
            int option = read.nextInt();

            switch (option) {
                case 1: // clientes
                    controllerCliente.iniciarAdminCliente();
                    break;
                case 2: // pedidos
                    controllerPedido.iniciarAdminPedido();
                    break;

                case 3:// Mesas
                    controllerMesa.iniciarAdminMesa();
                    break;

                case 4:// funcionarios
                    controllerFuncionario.iniciarAdminFuncionario();
                    break;

                case 5:// caixa
                    controllerCaixa.iniciarAdminCaixa();
                    break;

                case 6:// estatísticas
                    controllerEstatistica.iniciarAdminEstatistica();
                    break;

                case 7:// voltar
                    verificador = false;
                    break;

                default:
                    break;
            }

        } while (verificador);
    }

    public Nodo<Cliente> logarCliente() {
        Nodo<Cliente> clienteLogado = controllerCliente.iniciarAtendimento();
        return clienteLogado;
    }

    public Nodo<Funcionarios> escolherGarcom() {
        Nodo<Funcionarios> garcomEscolhido = controllerFuncionario
                .getFuncionario(controllerFuncionario.escolherGarçom());
        return garcomEscolhido;
    }

    public void iniciarAtendimentoCliente() {

        boolean verificadorInicio = true;

        do {
            viewLine.title("INICIO");
            viewLine.alignLeft("[1] - Iniciar atendimento");
            viewLine.alignLeft("[2] - Voltar");
            viewLine.Line();
            viewLine.input();
            int optionInicio = read.nextInt();
            read.nextLine();

            if (optionInicio == 1) {

                boolean verificador = true;
                do {

                    Nodo<Funcionarios> garcomEscolhido = escolherGarcom();
                    Nodo<Cliente> clienteLogado = logarCliente();

                    filaParaAlmocar.inserir(clienteLogado.getDado());

                    Pedido pedidoFeito = controllerPedido.menuPedido(garcomEscolhido.getDado(),
                            clienteLogado.getDado());

                    if (pedidoFeito == null) {
                        break;
                    }

                    viewMain.menuCliente(pedidoFeito);
                    int option = read.nextInt();
                    read.nextLine();

                    switch (option) {
                        case 1: // pedido
                            controllerPedido.iniciarAdminPedido();
                            break;

                        case 2: // mesa
                            controllerMesa.iniciarMesaCliente(clienteLogado.getDado());
                            break;

                        case 3: // proxima etapa
                            proximaEtapa(pedidoFeito, clienteLogado.getDado(), garcomEscolhido.getDado());
                            break;

                        case 4:
                            controllerEstatistica.iniciarAdminEstatistica();
                            break;

                        case 5:
                            controllerCaixa.iniciarAdminCaixa();
                            break;

                        case 6: // voltar
                            verificador = false;
                            break;

                        default:
                            break;
                    }

                } while (verificador);

            } else if (optionInicio == 2) {
                verificadorInicio = false;
                break;
            }

        } while (verificadorInicio);

    }

    public void proximaEtapa(Pedido pedido, Cliente clienteLogado, Funcionarios funcionario) {

        if (pedido.getStatus() == "Recebido") {
            pedido.setStatus("Em preparo");
            Dados.incrementPessoasAtendidas();
            pedido.setFuncionario(funcionario.getNome());

        } else if (pedido.getStatus() == "Em preparo") {
            pedido.setStatus("Pronto");
            pedido.setFuncionario(funcionario.getNome());

        } else if (pedido.getStatus() == "Pronto") {
            filaParaAlmocar.remover();
            pedido.setStatus("Entregue");
            Dados.incrementPessoasAlmocando();

        } else if (pedido.getStatus() == "Entregue") {
            pedido.setStatus("Finalizado");
            Dados.decrementPessoasAlmocando();
            filaDoCaixa.inserir(clienteLogado);
        }
    }

}
