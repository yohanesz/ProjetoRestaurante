package Controller;

import java.util.Scanner;

import Model.DataBase;
import Model.Funcionarios;
import Model.ListaEncadeada;
import Model.Nodo;
import View.viewFuncionarios;
import View.viewLine;
import View.viewMain;

public class ControllerFuncionario {

    DataBase database = DataBase.getInstance();
    ListaEncadeada<Funcionarios> funcionarios = database.getListaFuncionarios();

    static Scanner read = new Scanner(System.in);

    public void iniciarAdminFuncionario() {
        boolean verificador = true;

        do {

            viewFuncionarios.mainAdminFuncionarios();
            int option = read.nextInt();
            read.nextLine();

            switch (option) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    removerFuncionario();
                    break;
                case 3:
                    updateFuncionario();
                    break;
                case 4:
                    consultarFuncionarios();
                    break;
                case 5:
                    verificador = false;
                    break;

                default:
                    break;
            }

        } while (verificador);

    }

    public void cadastrarFuncionarioPadrao() {

        Funcionarios func1 = new Funcionarios("Gustavo", "Garçom", "Noite");
        Funcionarios func3 = new Funcionarios("Geraldo", "Garçom", "Dia");
        Funcionarios func4 = new Funcionarios("Carlos", "Cozinheiro", "Dia e Noite");

        funcionarios.insertEnd(func1);
        funcionarios.insertEnd(func3);
        funcionarios.insertEnd(func4);
    }

    public void cadastrarFuncionario() {
        viewLine.clear();
        viewLine.title("CADATRO");
        System.out.print("Nome: ");
        String nome = read.nextLine();
        System.out.print("Cargo:");
        String cargo = read.nextLine();
        System.out.print("Escala: ");
        String escala = read.nextLine();

        Funcionarios newFuncionario = new Funcionarios(nome, cargo, escala);
        funcionarios.insertEnd(newFuncionario);

        viewLine.title("CADASTRO");
        viewLine.alignLeft("Funcionario cadastrado com sucesso!");
        viewLine.Line();
        viewLine.pressToContinue();
        read.nextLine();

    }

    public void removerFuncionario() {

        viewLine.title("CADASTRO");
        funcionarios.showList();
        viewLine.Line();
        System.out.print("Selecione o funcionario desejado(id): ");
        int funcionarioSelecionado = read.nextInt();
        Nodo<Funcionarios> funcionario = funcionarios.getDadoById(funcionarioSelecionado);

        viewLine.clear();
        viewLine.title("CADASTRO");
        viewLine.alignLeft("Deseja remover o funcionario " + funcionario.getDado().getNome() + "?");
        viewLine.alignLeft("[1] - Sim");
        viewLine.alignLeft("[2] - Não");
        viewLine.Line();
        int option = read.nextInt();

        if (option == 1) {
            funcionarios.deleteByValue(funcionarioSelecionado);
            viewLine.title("CADASTRO");
            viewLine.alignLeft("Funcionario removido com sucesso!");
            viewLine.Line();
            viewLine.pressToContinue();
            read.nextLine();
        } else if (option == 2) {

        } else {
            viewMain.erro();
            read.nextLine();
        }
    }

    public void consultarFuncionarios() {
        viewLine.clear();
        viewLine.title("FUNCIONÁRIOS");
        funcionarios.showList();
        viewLine.Line();
        viewLine.pressToContinue();
        read.nextLine();
    }

    public Nodo<Funcionarios> getFuncionario(int id) {
        return funcionarios.getDadoById(id);
    }

    public int escolherGarçom() {

        viewLine.clear();
        viewLine.title("GARÇONS");
        viewLine.alignLeft("Selecione o garçom de sua preferência:");
        viewLine.alignLeft(" ");
        funcionarios.showListWithCondition("Garçom");
        viewLine.Line();
        viewLine.input();
        int id = read.nextInt();

        return id;
    }

    public void escolherCozinheiro() {
        viewLine.clear();
        viewLine.title("COZINHEIROS");
        funcionarios.showListWithCondition("Cozinheiro");
        viewLine.Line();
    }

    public void updateFuncionario() {

        viewLine.title("CADASTRO");
        funcionarios.showList();
        System.out.print("Selecione o funcionario desejado(id): ");
        int funcionarioSelecionado = read.nextInt();
        read.nextLine();
        System.out.print("Informe o atributo que deseja alterar: ");
        String atributo = read.nextLine();
        System.out.print("Insira o novo dado: ");
        String novoDado = read.nextLine();

        funcionarios.update(funcionarioSelecionado, atributo, novoDado);
        viewLine.title("CADASTRO");
        viewLine.alignLeft("Funcionario alterado com sucesso!");
        viewLine.Line();
        viewLine.pressToContinue();
        read.nextLine();

    }

}
