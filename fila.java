import java.time.LocalDateTime;

public class fila {

    private String arquivo;
    private String usuario;
    private LocalDateTime horaPedido;
    private LocalDateTime horaImpresso;


    public fila(String arquivo, String usuario) {
        this.arquivo = arquivo;
        this.usuario = usuario;
        this.horaImpresso = horaImpresso;
    }
}