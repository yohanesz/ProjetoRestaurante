package Model;

public class Cliente {

    private static int nextId = 1;
    private int id = 0;
    private String nome;
    private String cpf;
    private String numero;
    private int idMesa;

    private int numAcompanhantes;

    public Cliente(String nome, String cpf, String numero) {
        this.id = nextId++;
        this.nome = nome;
        this.cpf = cpf;
        this.numero = numero;
        this.idMesa = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getNextId() {
        return nextId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void setNextId(int nextId) {
        Cliente.nextId = nextId;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", numero=" + numero + ", idMesa=" + idMesa
                + "]";
    }

    public int getNumAcompanhantes() {
        return numAcompanhantes;
    }

    public void setNumAcompanhantes(int numAcompanhantes) {
        this.numAcompanhantes = numAcompanhantes;
    }

}
