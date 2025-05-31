public class PilhaImpressao {
    private NoFila topo;
    private int tamanho = 0;
    private int capacidade;

    public PilhaImpressao(int capacidade) {
        this.capacidade = capacidade;
    }

    public boolean pilhaVazia() {
        return topo == null;
    }

    public boolean pilhaCheia() {
        return tamanho >= capacidade;
    }

    public void push(Documento doc) {
        if (pilhaCheia()) throw new RuntimeException("Pilha cheia");
        NoFila novo = new NoFila(doc);
        novo.setProximo(topo);
        topo = novo;
        tamanho++;
    }

    public Documento pop() {
        if (pilhaVazia()) throw new RuntimeException("Pilha vazia");
        Documento doc = topo.getDoc();
        topo = topo.getProximo();
        tamanho--;
        return doc;
    }

    public void listarPilha() {
        NoFila atual = topo;
        int pos = 1;
        while (atual != null) {
            System.out.println(pos + ": " + atual.getDoc());
            atual = atual.getProximo();
            pos++;
        }
    }

    public int buscarDocumento(String nomeArquivo) {
        NoFila atual = topo;
        int pos = 1;
        while (atual != null) {
            if (atual.getDoc().getArquivo().equals(nomeArquivo)) {
                return pos;
            }
            atual = atual.getProximo();
            pos++;
        }
        return -1;
    }
}
