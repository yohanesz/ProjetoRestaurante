package View;

import java.util.Scanner;

public class viewCliente {

    static Scanner read = new Scanner(System.in);

    public static void menuAdminCliente() {
        viewLine.title("CLIENTES");
        viewLine.alignLeft("[1] - Cadastrar novo cliente");
        viewLine.alignLeft("[2] - Remover cliente");
        viewLine.alignLeft("[3] - Atualizar informação do cliente");
        viewLine.alignLeft("[4] - Consultar clientes cadastrados");
        viewLine.alignLeft("[5] - Voltar");
        viewLine.Line();
        viewLine.input();

    }

    public static void main(String[] args) {
        menuAdminCliente();
    }

    public static void register() {

        viewLine.title("Cadastro");

    }

    public static void inputNome() {

        System.out.print("| Digite o nome:");

    }

    public static void inputCpf() {
        System.out.print("| Digite o CPF:");
    }

    public static void inputNumero() {
        System.out.print("| Digite o número:");
    }

    public static void inputNumeroDePessoas() {
        System.out.print("| Digite o número de acompanhantes:");
    }

    public static void cadastrado() {

        viewLine.clear();
        viewLine.title("CADASTRO");
        viewLine.alignLeft("Cliente cadastrado com sucesso!");
        viewLine.Line();
        viewLine.pressToContinue();
        read.nextLine();
    }

    public static void removido() {
        viewLine.clear();
        viewLine.title("CADASTRO");
        viewLine.alignLeft("Cliente removido com sucesso!");
        viewLine.Line();
        viewLine.pressToContinue();
        read.nextLine();
    }

    public static void atualizado() {
        viewLine.clear();
        viewLine.title("CADASTRO");
        viewLine.alignLeft("Cliente atualizado com sucesso!");
        viewLine.Line();
        viewLine.pressToContinue();
        read.nextLine();
    }

    public static void logado(String nome) {

        viewLine.clear();
        viewLine.title("LOGIN");
        viewLine.alignLeft("Seja bem vindo " + nome + "!");
        viewLine.Line();
        viewLine.pressToContinue();
    }

}
