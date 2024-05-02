package Controller;

import java.util.Scanner;

import Model.Cliente;
import Model.Dados;
import Model.DataBase;
import Model.Fila;
import Model.ListaEncadeada;
import Model.Mesa;
import View.viewEstatistica;

public class ControllerEstatistica {

    DataBase database = DataBase.getInstance();
    Fila<Cliente> clientesParaAlmocar = database.getFilaParaAlmocar();
    Fila<Cliente> filaDoCaixa = database.getFilaDoCaixa();

    static Scanner read = new Scanner(System.in);
    ListaEncadeada<Cliente> clientes = database.getListaClientes();
    ListaEncadeada<Mesa> mesas = database.getListaMesas();

    public void iniciarAdminEstatistica() {

        boolean verificador = true;

        do {
            viewEstatistica.menuEstatistica();
            int option = read.nextInt();
            read.nextLine();

            switch (option) {
                case 1:
                    viewEstatistica.pessoasNaFila(clientesParaAlmocar.getTamanho());
                    break;
                case 2:
                    viewEstatistica.pessoasNaFilaDoCaixa(filaDoCaixa.getTamanho());
                    break;
                case 3:
                    viewEstatistica.pessoasAlmocando(Dados.getNumeroDePessoasAlmocando());
                    break;
                case 4:
                    viewEstatistica.pessoasAtendidas(Dados.getNumeroDePessoasAtendidas());
                    break;
                case 5:
                    viewEstatistica.mesasLivres(mesas.countWithCondition("false"));
                    break;
                case 6:
                    verificador = false;
                    break;
            }

        } while (verificador);

    }

}
