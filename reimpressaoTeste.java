import java.util.Scanner;

public class reimpressaoTeste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PilhaImpressao pilha = new PilhaImpressao(3); 
        int opcao;

        do {
            System.out.println("1 - Solicitar reimpressão");
            System.out.println("2 - Executar reimpressão");
            System.out.println("3 - Consultar documento");
            System.out.println("4 - Ver pilha");
            System.out.println("5 - Sair");
            opcao = sc.nextInt();
            sc.nextLine();

            switch(opcao) {
                case 1:
                    if (pilha.pilhaCheia()) {
                        System.out.println("A pilha esta cheia!");
                        break;
                    }
                    System.out.print("Nome do arquivo: ");
                    String nome = sc.nextLine();
                    System.out.print("Usuario: ");
                    String usuario = sc.nextLine();
                    Documento doc = new Documento(nome, usuario);
                    pilha.push(doc);
                    break;

                case 2:
                    try {
                        Documento d = pilha.pop();
                        d.imprimir();
                        System.out.println("Reimprimindo: " + d.getArquivo());
                        System.out.println("Tempo de espera: " + d.tempoEspera() + " minutos");
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Nome do arquivo: ");
                    String busca = sc.nextLine();
                    int pos = pilha.buscarDocumento(busca);
                    if (pos != -1)
                        System.out.println("Documento na poscao " + pos);
                    else
                        System.out.println("Documento não foi encontrado");
                    break;

                case 4:
                    pilha.listarPilha();
                    break;
            }
        } while (opcao != 5);
        sc.close();
    }
}
