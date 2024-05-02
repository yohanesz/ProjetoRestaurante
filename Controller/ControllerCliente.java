package Controller;

import java.util.Scanner;

import View.viewLine;
import View.viewMain;
import View.viewCliente;

import Model.Nodo;

import Model.Cliente;
import Model.DataBase;
import Model.ListaEncadeada;

public class ControllerCliente {

    Scanner read = new Scanner(System.in);

    DataBase database = DataBase.getInstance();
    ListaEncadeada<Cliente> clientes = database.getListaClientes();

    public void iniciarAdminCliente() {
        boolean verificador = true;

        do {
            viewCliente.menuAdminCliente();
            int input = read.nextInt();
            read.nextLine();

            switch (input) {
                case 1:
                    iniciarCadastro();
                    break;
                case 2:
                    removerCliente();
                    break;
                case 3:
                    atualizarCliente();
                    break;
                case 4:
                    consultarClientes();
                    break;
                case 5:
                    verificador = false;
                    break;

                default:
                    break;
            }

        } while (verificador);
    }

    public Nodo<Cliente> iniciarAtendimento() {
        boolean verificador = true;

        do {

            viewMain.inicioBemVindo();
            System.out.print("| Cpf: ");
            String inputCpf = read.nextLine();

            Nodo<Cliente> clienteLogado = verificarSeTemCadastro(inputCpf);

            if (clienteLogado != null) {
                verificador = false;
                return clienteLogado;
            }

        } while (verificador);

        return null;
    }

    public Nodo<Cliente> verificarSeTemCadastro(String inputCpf) {

        if (clientes.hasItem("cpf", inputCpf)) {
            return logarCliente(inputCpf);

        } else {

            clienteNaoCadastrado();

        }

        return null;

    }

    public void clienteNaoCadastrado() {

        viewMain.inicioClienteNaoCadastrado();
        read.nextLine();
        iniciarCadastro();

    }

    public Nodo<Cliente> logarCliente(String inputCpf) {
        Nodo<Cliente> clienteLogado = clientes.hasItemWithReturn("cpf", inputCpf);
        String nomeCliente = clienteLogado.getDado().getNome();
        viewCliente.logado(nomeCliente);
        read.nextLine();

        return clienteLogado;
    }

    public void iniciarCadastro() {

        viewCliente.register();
        viewCliente.inputNome();
        String inputName = read.nextLine();
        viewCliente.inputCpf();
        String inputCpf = read.nextLine();
        viewCliente.inputNumero();
        String numero = read.nextLine();
        Cliente newClient = new Cliente(inputName, inputCpf, numero);
        clientes.insertEnd(newClient);
        viewCliente.cadastrado();

    }

    public void removerCliente() {
        viewLine.title("CLIENTES");
        clientes.showList();
        viewLine.Line();
        System.out.print("| Selecione o cliente desejado (id):");
        int inputId = read.nextInt();
        clientes.deleteByValue(inputId);
        viewCliente.removido();
    }

    public void atualizarCliente() {
        viewLine.title("CLIENTES");
        clientes.showList();
        viewLine.Line();
        System.out.print("| Selecione o cliente desejado (id):");
        int inputId = read.nextInt();
        read.nextLine();
        System.out.print("| Informe o atributo que deseja alterar: ");
        String inputAtributo = read.nextLine();
        System.out.print("| Insira o novo dado: ");
        String inputNovoDado = read.nextLine();

        clientes.update(inputId, inputAtributo, inputNovoDado);
        viewCliente.atualizado();
    }

    public void consultarClientes() {
        viewLine.title("CLIENTES");
        clientes.showList();
        viewLine.Line();
        viewLine.pressToContinue();
        read.nextLine();
    }

    public void criarClientePadrao() {
        Cliente clienteTeste = new Cliente("Yohanês", "123123", "999981356");
        clientes.insertEnd(clienteTeste);
    }

}
