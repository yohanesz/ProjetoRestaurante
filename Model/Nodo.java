package Model;

public class Nodo<T> {

    private T dado;
    private Nodo<T> prox;
    private Nodo<T> ant;

    public Nodo(T dado) {
        this.dado = dado;
        this.prox = null;
        this.ant = null;
    }

    public int getId() {
        IdRetriever<T> idRetriever = new IdRetriever<>();
        return idRetriever.getId(this.dado);
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public Nodo<T> getProx() {
        return prox;
    }

    public void setProx(Nodo<T> prox) {
        this.prox = prox;
    }

    public Nodo<T> getAnt() {
        return ant;
    }

    public void setAnt(Nodo<T> ant) {
        this.ant = ant;
    }

}
