public class NoFila {
    private Documento doc;
    private NoFila proximo;

    public NoFila(Documento doc) {
        this.doc = doc;
    }

    public Documento getDoc() {
        return doc;
    }

    public NoFila getProximo() {
        return proximo;
    }

    public void setProximo(NoFila proximo) {
        this.proximo = proximo;
    }
}
