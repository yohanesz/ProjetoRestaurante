package Model;

public class Pedido {

    private int id;
    private static int nextId = 0;
    private String nomeCliente;
    private int quantidade;
    private double preco = 15.99;
    private double valorTotal;
    private String status;
    private String funcionario;

    public Pedido(int quantidade, String nomeCliente, String funcionario) {
        this.id = nextId++;
        this.quantidade = quantidade;
        this.valorTotal = preco * quantidade;
        this.status = "Recebido";
        this.funcionario = funcionario;
        this.nomeCliente = nomeCliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Pedido.nextId = nextId;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    @Override
    public String toString() {
        return "| [" + id + "] nomeCliente=" + nomeCliente + ", quantidade=" + quantidade + ", preco=" + preco
                + ", valorTotal=" + valorTotal + ", status=" + status + ", funcionario=" + funcionario + "";
    }

}
