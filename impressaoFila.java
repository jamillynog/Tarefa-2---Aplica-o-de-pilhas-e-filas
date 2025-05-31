public class impressaoFila {
    Documento[] dados;
    int primeiro, ultimo, ocupacao;

    public impressaoFila(int capacidade) {
        dados = new Documento[capacidade];
        primeiro = 0;
        ultimo = 0;
        ocupacao = 0;
    }

    public boolean filaVazia() {
        return ocupacao == 0;
    }

    public boolean filaCheia() {
        return ocupacao == dados.length;
    }

    private int proximaPosicao(int posicao) {
        return (posicao + 1) % dados.length;
    }

    public void enfileirar(Documento doc) {
        if (filaCheia()) throw new RuntimeException("Fila cheia");
        dados[ultimo] = doc;
        ultimo = proximaPosicao(ultimo);
        ocupacao++;
    }

    public Documento desenfileirar() {
        if (filaVazia()) throw new RuntimeException("Fila vazia");
        Documento doc = dados[primeiro];
        primeiro = proximaPosicao(primeiro);
        ocupacao--;
        return doc;
    }

    public void mostrarFila() {
        if (filaVazia()) {
            System.out.println("Fila vazia");
            return;
        }
        for (int i = primeiro, cont = 0; cont < ocupacao; cont++, i = proximaPosicao(i)) {
            System.out.println((cont + 1) + ": " + dados[i]);
        }
    }

    public Documento buscarDocumento(String nomeArquivo) {
        for (int i = primeiro, cont = 0; cont < ocupacao; cont++, i = proximaPosicao(i)) {
            if (dados[i].getArquivo().equals(nomeArquivo)) {
                return dados[i];
            }
        }
        return null;
    }

    public int posicaoDocumento(String nomeArquivo) {
        for (int i = primeiro, cont = 0; cont < ocupacao; cont++, i = proximaPosicao(i)) {
            if (dados[i].getArquivo().equals(nomeArquivo)) {
                return cont + 1;
            }
        }
        return -1;
    }
}
