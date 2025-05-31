import java.util.Scanner;

public class testeImpressora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        impressaoFila fila = new impressaoFila(3);
        int opcao;

        do {
            System.out.println("1- Enviar documento");
            System.out.println("2- Imprimir proximo doc");
            System.out.println("3- Consultar posicao do doc");
            System.out.println("4- Ver fila");
            System.out.println("5- Sair");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    if (fila.filaCheia()) {
                        System.out.println("A fila esta cheia!");
                        break;
                    }
                    System.out.print("Nome do arquivo: ");
                    String nome = sc.nextLine();
                    System.out.print("Nome do usuario: ");
                    String usuario = sc.nextLine();
                    fila.enfileirar(new Documento(nome, usuario));
                    break;

                case 2:
                    try {
                        Documento doc = fila.desenfileirar();
                        doc.imprimir();
                        System.out.println("Imprimindo: " + doc.getArquivo());
                        System.out.println("Tempo de espera: " + doc.tempoEspera() + " minutos");
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Digite o nome do arquivo: ");
                    String busca = sc.nextLine();
                    Documento doc = fila.buscarDocumento(busca);
                    if (doc != null) {
                        System.out.println(doc);
                        System.out.println("Posiçao na fila: " + fila.posicaoDocumento(busca));
                    } else {
                        System.out.println("Documento não foi encontrado");
                    }
                    break;

                case 4:
                    fila.mostrarFila();
                    break;

                case 5:
                    System.out.println("Finalizado");
                    break;

                default:
                    System.out.println("Essa opçao nao é valida");
            }

        } while (opcao != 5);
        sc.close();
    }
}
