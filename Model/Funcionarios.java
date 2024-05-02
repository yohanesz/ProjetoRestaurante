package Model;

public class Funcionarios {

    private static int nextId = 1;
    private int id;
    private String nome;
    private String cargo;
    private String escala;

    ListaEncadeada<Cliente> clienteAtendido = new ListaEncadeada<>();

    public Funcionarios(String nome, String cargo, String escala) {
        this.id = nextId++;
        this.nome = nome;
        this.cargo = cargo;
        this.escala = escala;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEscala() {
        return escala;
    }

    public void setEscala(String escala) {
        this.escala = escala;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Funcionarios.nextId = nextId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ListaEncadeada<Cliente> getClienteAtendido() {
        return clienteAtendido;
    }

    public void setClienteAtendido(ListaEncadeada<Cliente> clienteAtendido) {
        this.clienteAtendido = clienteAtendido;
    }

    @Override
    public String toString() {
        return "|[" + id + "] nome=" + nome + ", cargo=" + cargo + ", escala=" + escala
                + "]";
    }

}
