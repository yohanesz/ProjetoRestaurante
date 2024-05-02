package Model;

import java.lang.reflect.Field;

public class ListaEncadeada<T> {

    private Nodo<T> start;
    // private Nodo<T> fim; => AVALIAR O USO DE HASNEXT
    // private boolean hasNext;

    public boolean isEmpty() {
        return start == null;
    }

    public void insertBegin(T dado) {
        Nodo<T> newNodo = new Nodo<T>(dado);
        newNodo.setProx(start);
        start = newNodo;
    }

    public void insertEnd(T dado) {

        if (isEmpty()) {
            insertBegin(dado);
            return;
        }

        try {
            Nodo<T> newNodo = new Nodo<T>(dado);
            Nodo<T> aux = start;
            while (aux.getProx() != null) {

                aux = aux.getProx();
            }

            aux.setProx(newNodo);

        } catch (Exception e) {
            System.out.println("Erro ao inserir");
        }

    }

    public void showList() {
        if (isEmpty()) {
            System.out.println("Lista isEmpty!");
            return;
        }

        Nodo<T> aux = start;
        while (aux != null) {
            System.out.println(aux.getDado() + " ");
            aux = aux.getProx();
        }

        System.out.println();
    }

    public void showListWithCondition(String condition) {
        if (isEmpty()) {
            System.out.println("Lista isEmpty!");
            return;
        }

        Nodo<T> aux = start;
        while (aux != null) {

            if (aux.getDado().toString().contains(condition)) {
                System.out.println(aux.getDado() + " ");
            }

            aux = aux.getProx();
        }

    }

    public int count() {

        int countNodos = 0;
        Nodo<T> aux = start;

        while (aux != null) {
            countNodos++;
            aux = aux.getProx();
        }

        return countNodos;

    }

    public int countWithCondition(String condition) {

        int countNodos = 0;
        Nodo<T> aux = start;

        while (aux != null) {

            if (aux.getDado().toString().contains(condition)) {
                countNodos++;
            }

            aux = aux.getProx();
        }

        return countNodos;
    }

    public Nodo<T> getDadoById(int id) {
        if (isEmpty()) {
            System.out.println("A lista está vazia.");
            return null;
        }

        Nodo<T> aux = start;
        while (aux != null) {
            if (aux.getId() == id) {
                return aux;
            }
            aux = aux.getProx();
        }

        System.out.println("Cliente com o ID " + id + " não encontrado.");
        return null;
    }

    public boolean hasItem(String attributeName, String objectToCompare) {

        Nodo<T> aux = start;
        try {
            while (aux != null) {
                T object = aux.getDado();
                Field field = object.getClass().getDeclaredField(attributeName);
                field.setAccessible(true);
                Object fieldValue = field.get(object);

                if (fieldValue.equals(objectToCompare)) {
                    return true;
                }

                aux = aux.getProx();
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Erro ao acessar o atributo: " + e.getMessage());
        }

        return false;

    }

    public Nodo<T> hasItemWithReturn(String attributeName, String objectToCompare) {

        Nodo<T> aux = start;
        try {
            while (aux != null) {
                T object = aux.getDado();
                Field field = object.getClass().getDeclaredField(attributeName);
                field.setAccessible(true);
                Object fieldValue = field.get(object);

                if (fieldValue.equals(objectToCompare)) {
                    return aux;
                }

                aux = aux.getProx();
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Erro ao acessar o atributo: " + e.getMessage());
        }

        return null;

    }

    public void deleteByValue(int valor) {
        if (isEmpty())
            return;

        if (start.getId() == valor) {
            start = start.getProx();
            return;
        }

        Nodo<T> aux = start;
        while (aux.getProx() != null) {
            // verifica se o valor do proximo é iguao ao que eu quero excluir
            if (aux.getProx().getId() == valor) {
                aux.setProx(aux.getProx().getProx());
                return;
            }

            aux = aux.getProx();

        }
    }

    public void update(int id, String nomeAtributo, String novoDado) {
        try {
            Nodo<T> aux = getDadoById(id);
            T objeto = aux.getDado();

            Field campo = objeto.getClass().getDeclaredField(nomeAtributo);
            campo.setAccessible(true);

            if (campo.getType() == double.class) {
                double valor = Double.parseDouble(novoDado);
                campo.setDouble(objeto, valor);
            } else if (campo.getType() == String.class) {
                campo.set(objeto, novoDado);
            } else if (campo.getType() == int.class) {
                int valor = Integer.parseInt(novoDado);
                campo.set(objeto, valor);
            } else {
                System.out.println("Erro");
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Erro ao alterar o atributo: " + e.getMessage());
        }
    }

    public void getBooleanAttributeValue(String nomeAtributo, boolean condition) {
        Nodo<T> aux = start;

        while (aux != null) {
            try {
                T objeto = aux.getDado();

                Field campo = objeto.getClass().getDeclaredField(nomeAtributo);
                campo.setAccessible(true);

                Object valorCampo = campo.get(objeto);
                if (valorCampo instanceof Boolean && (boolean) valorCampo == condition) {
                    System.out.println(objeto);
                }

            } catch (NoSuchFieldException | IllegalAccessException | NullPointerException e) {
                System.err.println("Erro ao acessar o atributo: " + nomeAtributo);
                e.printStackTrace();
            }

            aux = aux.getProx();
        }

    }

}
