import java.time.*;

public class Documento {

    private String arquivo;
    private String usuario;
    private LocalDateTime horaPedido;
    private LocalDateTime horaImpresso;

    public Documento(String arquivo, String usuario) {
        this.arquivo = arquivo;
        this.usuario = usuario;
        this.horaPedido = LocalDateTime.now();
    }

    public String getArquivo() {
        return arquivo;
    }

    public String getUsuario() {
        return usuario;
    }

    public LocalDateTime getHoraPedido() {
        return horaPedido;
    }

    public void imprimir() {
        this.horaImpresso = LocalDateTime.now();
    }

    public long tempoEspera() {
        if (horaImpresso == null) return -1;
        return Duration.between(horaPedido, horaImpresso).toMinutes();
    }

    @Override
    public String toString() {
        return "Arquivo: " + arquivo + ", Usuário: " + usuario + ", Solicitado: " + horaPedido;
    }
}
