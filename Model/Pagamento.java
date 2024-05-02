package Model;

public class Pagamento {

    private int id;
    private static int nextId = 1;
    private Cliente cliente;
    private double valor;

    public Pagamento(Cliente cliente, double valor) {
        this.id = nextId++;
        this.cliente = cliente;
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "| [" + id + "] cliente=" + cliente.getNome() + ", valor=" + valor + "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Pagamento.nextId = nextId;
    }
}
