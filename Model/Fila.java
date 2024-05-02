package Model;

public class Fila<T> {

    private Nodo<T> inicio;
    private Nodo<T> fim;
    private int tamanho = 0;

    public int getTamanho() {
        return tamanho;
    }

    public boolean estaVazio() {
        return tamanho == 0;
    }

    public T getInicio() {
        if (!estaVazio()) {
            return inicio.getDado();
        } else {
            System.out.println("Fila está vazia");
            return null;
        }

    }

    public void inserir(T dado) {

        Nodo<T> novoItem = new Nodo<T>(dado);

        if (estaVazio()) {
            inicio = novoItem;
            fim = novoItem;
        } else {
            fim.setProx(novoItem);
            fim = novoItem;
        }
        tamanho++;

    }

    public T remover() {
        if (estaVazio()) {
            System.out.println("Fila está vazia");
            return null;
        }

        T valor = inicio.getDado();
        inicio = inicio.getProx();
        tamanho--;

        if (estaVazio()) {
            fim = null;
        }

        return valor;

    }

}
