public class Deque<T> {
    private int tam;
    private NodeDeque<T> cabeca;
    private NodeDeque<T> cauda;

    public Deque() {
        cabeca = new NodeDeque<>();
        cauda = new NodeDeque<>();
        cabeca.setProximo(cauda);
        cauda.setAnterior(cabeca);
        tam = 0;
    }

    public void addFirst(T element) {
        NodeDeque<T> no = new NodeDeque<>(element);
        no.setProximo(cabeca.getProximo());
        no.setAnterior(cabeca);
        cabeca.getProximo().setAnterior(no);
        cabeca.setProximo(no);
        tam++;
    }

    public void addLast(T element) {
        NodeDeque<T> no = new NodeDeque<>(element);
        no.setAnterior(cauda.getAnterior());
        no.setProximo(cauda);
        cauda.getAnterior().setProximo(no);
        cauda.setAnterior(no);
        tam++;
    }

    public T removeFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("Deque vazio");
        }
        NodeDeque<T> primeiro = cabeca.getProximo();
        cabeca.setProximo(primeiro.getProximo());
        primeiro.getProximo().setAnterior(cabeca);
        tam--;
        return primeiro.getInfo();
    }

    public T removeLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Deque vazio");
        }
        NodeDeque<T> ultimo = cauda.getAnterior();
        cauda.setAnterior(ultimo.getAnterior());
        ultimo.getAnterior().setProximo(cauda);
        tam--;
        return ultimo.getInfo();
    }

    public T getFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("Deque vazio");
        }
        return cabeca.getProximo().getInfo();
    }

    public T getLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Deque vazio");
        }
        return cauda.getAnterior().getInfo();
    }

    public int size() {
        return tam;
    }

    public boolean isEmpty() {
        return tam == 0;
    }

    public void print() throws Exception {
        if (isEmpty()) {
            throw new Exception("Deque vazio");
        }
        NodeDeque<T> no = cabeca.getProximo();
        while (no != cauda) {
            System.out.println(no.getInfo());
            no = no.getProximo();
        }
    }
}