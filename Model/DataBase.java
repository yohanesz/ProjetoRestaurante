package Model;

public class DataBase {

    private static DataBase instance;

    private ListaEncadeada<Funcionarios> funcionario;
    private ListaEncadeada<Cliente> cliente;
    private ListaEncadeada<Pedido> pedido;
    private ListaEncadeada<Mesa> mesa;
    private ListaEncadeada<Pagamento> pagamento;

    private Fila<Cliente> filaParaAlmocar;
    private Fila<Cliente> filaDoCaixa;

    private DataBase() {
        filaParaAlmocar = new Fila<>();
        filaDoCaixa = new Fila<>();
        cliente = new ListaEncadeada<>();
        pedido = new ListaEncadeada<>();
        mesa = new ListaEncadeada<>();
        pagamento = new ListaEncadeada<>();
        funcionario = new ListaEncadeada<>();
    }

    public static synchronized DataBase getInstance() {

        if (instance == null) {
            instance = new DataBase();
        }

        return instance;
    }

    public Fila<Cliente> getFilaParaAlmocar() {
        return filaParaAlmocar;
    }

    public Fila<Cliente> getFilaDoCaixa() {
        return filaDoCaixa;
    }

    public ListaEncadeada<Cliente> getListaClientes() {
        return cliente;
    }

    public ListaEncadeada<Pedido> getListaPedidos() {
        return pedido;
    }

    public ListaEncadeada<Mesa> getListaMesas() {
        return mesa;
    }

    public ListaEncadeada<Pagamento> getListaPagamento() {
        return pagamento;
    }

    public ListaEncadeada<Funcionarios> getListaFuncionarios() {
        return funcionario;
    }

}
