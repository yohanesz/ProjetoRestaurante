package Controller;

import java.util.Scanner;

import Model.Cliente;
import Model.DataBase;
import Model.ListaEncadeada;
import Model.Mesa;
import Model.Nodo;
import View.viewLine;
import View.viewMesas;

public class ControllerMesa {

    DataBase database = DataBase.getInstance();
    ListaEncadeada<Mesa> mesas = database.getListaMesas();
    ListaEncadeada<Cliente> clientes = database.getListaClientes();

    static Scanner read = new Scanner(System.in);

    public void iniciarAdminMesa() {
        boolean verificador = true;

        do {
            viewMesas.menuAdminMesa();
            int option = read.nextInt();
            read.nextLine();

            switch (option) {
                case 1:
                    alocarMesa();
                    break;
                case 2:
                    desalocarMesa();
                    break;
                case 3:
                    listarMesasOcupadas();
                    break;
                case 4:
                    verificador = false;
                    break;
                default:
                    break;
            }
        } while (verificador);

    }

    public void iniciarMesaCliente(Cliente clienteLogado) {

        boolean verificador = true;

        do {
            viewMesas.mesaCliente();
            int option = read.nextInt();
            read.nextLine();

            switch (option) {
                case 1:
                    alocarMesaCliente(clienteLogado);
                    break;
                case 2:
                    desalocarMesaCliente(clienteLogado);
                    break;
                case 3:
                    verificador = false;
                    break;

                default:
                    break;
            }

        } while (verificador);
    }

    public void criarMesasPadrao() {

        Mesa mesa1 = new Mesa();
        Mesa mesa2 = new Mesa();
        Mesa mesa3 = new Mesa();
        Mesa mesa4 = new Mesa();

        mesas.insertEnd(mesa1);
        mesas.insertEnd(mesa2);
        mesas.insertEnd(mesa3);
        mesas.insertEnd(mesa4);
    }

    public void criarMesa() {
        viewLine.title("MESAS");
        viewLine.alignLeft("Deseja criar uma nova mesa? ");
        viewLine.alignLeft("[1] - Sim");
        int option = read.nextInt();
        read.nextLine();

        if (option == 1) {

            Mesa mesa = new Mesa();
            mesas.insertEnd(mesa);
            viewLine.title("MESAS");
            viewLine.alignLeft("Mesa criada com sucesso!");
        }

        viewLine.Line();
        viewLine.pressToContinue();
        read.nextLine();
    }

    public void listarMesasDisponiveis() {
        viewLine.title("MESAS DISPONÍVEIS");
        mesas.getBooleanAttributeValue("ocupada", false);
        viewLine.Line();
    }

    public void listarMesasOcupadas() {
        viewLine.title("MESAS OCUPADAS");
        mesas.getBooleanAttributeValue("ocupada", true);
        viewLine.Line();
        viewLine.pressToContinue();
        read.nextLine();
    }

    public void listarMesas() {
        viewLine.title("MESAS");
        viewLine.Line();
    }

    public void alocarMesaCliente(Cliente cliente) {

        viewLine.title("MESAS");
        listarMesasDisponiveis();
        System.out.print("| Selecione a mesa:");
        int inputOption = read.nextInt();
        read.nextLine();
        Nodo<Mesa> mesaSelecionada = mesas.getDadoById(inputOption);
        mesaSelecionada.getDado().setOcupada(true);
        mesaSelecionada.getDado().setCliente(cliente.getNome());

        if (cliente.getIdMesa() != 0) {
            Mesa mesaAnterior = mesas.getDadoById(cliente.getIdMesa()).getDado();
            mesaAnterior.setOcupada(false);
        }

        cliente.setIdMesa(inputOption);

        viewLine.title("MESAS");
        viewLine.alignLeft("Mesa alocada com sucesso!");
        viewLine.Line();
        viewLine.pressToContinue();
        read.nextLine();

    }

    public void desalocarMesaCliente(Cliente cliente) {

        int idMesa = cliente.getIdMesa();
        Nodo<Mesa> mesaOcupada = mesas.getDadoById(idMesa);
        mesaOcupada.getDado().setOcupada(false);
        cliente.setIdMesa(0);

    }

    public void alocarMesa() {

        viewLine.title("MESAS");
        clientes.showList();
        viewLine.Line();
        System.out.print("Selecione o cliente desejado(id): ");
        int clienteSelecionado = read.nextInt();
        Nodo<Cliente> clienteAtual = clientes.getDadoById(clienteSelecionado);
        Cliente cliente = clienteAtual.getDado();

        viewLine.title("MESAS");
        listarMesasDisponiveis();
        System.out.print("| Selecione a mesa:");
        int inputOption = read.nextInt();
        read.nextLine();
        Nodo<Mesa> mesaSelecionada = mesas.getDadoById(inputOption);
        mesaSelecionada.getDado().setOcupada(true);
        mesaSelecionada.getDado().setCliente(cliente.getNome());

        if (cliente.getIdMesa() != 0) {
            Mesa mesaAnterior = mesas.getDadoById(cliente.getIdMesa()).getDado();
            mesaAnterior.setOcupada(false);
        }

        cliente.setIdMesa(inputOption);

        viewLine.title("MESAS");
        viewLine.alignLeft("Mesa alocada com sucesso!");
        viewLine.Line();
        viewLine.pressToContinue();
        read.nextLine();
    }

    public void desalocarMesa() {

        viewLine.title("MESAS");
        clientes.showList();
        viewLine.Line();
        System.out.print("Selecione o cliente desejado(id): ");
        int clienteSelecionado = read.nextInt();
        Nodo<Cliente> clienteAtual = clientes.getDadoById(clienteSelecionado);
        Cliente cliente = clienteAtual.getDado();

        int idMesa = cliente.getIdMesa();
        Nodo<Mesa> mesaOcupada = mesas.getDadoById(idMesa);
        mesaOcupada.getDado().setOcupada(false);
        cliente.setIdMesa(0);
    }

    public boolean verificarCapacidade(Mesa mesa, Cliente cliente) {

        if (mesa.getCapacidade() >= cliente.getNumAcompanhantes()) {
            return true;
        }

        return false;
    }

}
