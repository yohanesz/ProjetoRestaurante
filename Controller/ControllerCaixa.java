package Controller;

import java.util.Scanner;

import Model.Cliente;
import Model.DataBase;
import Model.Fila;
import Model.ListaEncadeada;
import Model.Nodo;
import Model.Pagamento;
import Model.Pedido;
import View.viewCaixa;
import View.viewLine;

public class ControllerCaixa {

    static Scanner read = new Scanner(System.in);

    DataBase database = DataBase.getInstance();
    ListaEncadeada<Pagamento> pagamento = database.getListaPagamento();
    ListaEncadeada<Cliente> clientes = database.getListaClientes();
    ControllerPedido controllerPedido = new ControllerPedido();

    ListaEncadeada<Pedido> pedidos = database.getListaPedidos();
    Fila<Cliente> clientesCaixa = database.getFilaDoCaixa();

    public void iniciarAdminCaixa() {

        boolean verificador = true;

        do {

            viewCaixa.menuAdminCaixa();
            int option = read.nextInt();
            read.nextLine();

            switch (option) {
                case 1:
                    consultarPagamentos();
                    break;
                case 2:
                    emitirRecibo();
                    break;
                case 3:
                    verificador = false;
                    break;
                case 4:
                    Cliente clienteDaFila = clientesCaixa.getInicio();
                    controllerPedido.listarPedidos(clienteDaFila.getNome());
                    int intOption = read.nextInt();
                    Pedido pedidoParaRealizarPagamento = pedidos.getDadoById(intOption).getDado();
                    iniciarAtendimentoCaixa(clienteDaFila, pedidoParaRealizarPagamento);

                    break;
                default:
                    break;
            }
        } while (verificador);
    }

    public Cliente selecionarCliente() {
        viewLine.title("CAIXA");
        clientes.showList();
        System.out.print("Selecione o cliente desejado(id): ");
        int clienteSelecionado = read.nextInt();
        read.nextLine();
        Nodo<Cliente> cliente = clientes.getDadoById(clienteSelecionado);
        Cliente clienteAtual = cliente.getDado();

        return clienteAtual;
    }

    public void consultarPagamentos() {
        viewLine.title("CAIXA");
        pagamento.showList();
        viewLine.Line();
        viewLine.pressToContinue();
        read.nextLine();
    }

    public void emitirRecibo() {
        Cliente cliente = selecionarCliente();
        viewLine.title("CAIXA");
        pagamento.showListWithCondition(cliente.getNome());
        System.out.print("Selecione o pagamento desejado(id): ");
        int option = read.nextInt();
        read.nextLine();
        Nodo<Pagamento> nodoPagamento = pagamento.getDadoById(option);
        Pagamento pagamentoAtual = nodoPagamento.getDado();

        viewLine.title("RECIBO");
        viewLine.alignLeft("Valor: R$" + pagamentoAtual.getValor());
        viewLine.alignLeft("Cliente: " + pagamentoAtual.getCliente().getNome());
        viewLine.alignLeft("Cpf: " + pagamentoAtual.getCliente().getCpf());
        viewLine.Line();
        viewLine.pressToContinue();
        read.nextLine();
    }

    public void iniciarAtendimentoCaixa(Cliente clienteDaFila, Pedido pedido) {
        viewLine.title("CAIXA");
        double troco = calculo(pedido, clienteDaFila);
        Pagamento novoPagamento = new Pagamento(clienteDaFila, troco);
        pagamento.insertEnd(novoPagamento);

        viewLine.alignLeft("Valor devolvido: R$" + troco);
        viewLine.Line();
    }

    public double calculo(Pedido pedido, Cliente clienteLogado) {

        double valorRecebido = receberPagamento(pedido, clienteLogado);
        double troco = pedido.getValorTotal() - valorRecebido;

        return troco;

    }

    public double receberPagamento(Pedido pedido, Cliente clienteLogado) {

        viewLine.title("CAIXA");
        viewLine.alignLeft("O valor total do pedido foi: ");
        viewLine.alignLeft("R$ " + pedido.getValorTotal());
        viewLine.Line();
        System.out.println("| Quantia: R$: ");
        double quantia = read.nextDouble();
        viewLine.Line();
        read.nextLine();

        return quantia;
    }

    public void criarPagamentoPadrao(Cliente cliente) {

        Pedido pedido = new Pedido(3, cliente.getNome(), "Paulo");
        Pagamento pag = new Pagamento(cliente, pedido.getValorTotal());
        pagamento.insertEnd(pag);
    }

}
