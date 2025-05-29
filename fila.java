import java.time.LocalDateTime;
import java.time.Duration;

public class fila {

    private String arquivo;
    private String usuario;
    private LocalDateTime horaPedido;
    private LocalDateTime horaImpresso;


    public fila(String arquivo, String usuario) {
        this.arquivo = arquivo;
        this.usuario = usuario;
        this.horaPedido = LocalDateTime.now();
    }

    public long calculoTempo() 
        return java.time.Duration.between(horaPedido, horaImpresso).toMinutes();
}