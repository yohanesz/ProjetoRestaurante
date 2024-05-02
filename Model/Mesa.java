package Model;

public class Mesa {

    private int id = 0;
    private static int nextId = 1;
    private boolean ocupada;
    private String cliente;
    private int capacidade;

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    private Nodo<Funcionarios> garcomDaMesa;

    public Mesa() {
        this.id = nextId++;
        this.ocupada = false;
        garcomDaMesa = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Nodo<Funcionarios> getGarcomDaMesa() {
        return garcomDaMesa;
    }

    public void setGarcomDaMesa(Nodo<Funcionarios> garcomDaMesa) {
        this.garcomDaMesa = garcomDaMesa;
    }

    public int getNextId() {
        return nextId;
    }

    @Override
    public String toString() {
        return "Mesa [id=" + id + ", ocupada=" + ocupada + ", cliente=" + cliente
                + ", garcomDaMesa=" + garcomDaMesa + "]";
    }

    public static void setNextId(int nextId) {
        Mesa.nextId = nextId;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

}
