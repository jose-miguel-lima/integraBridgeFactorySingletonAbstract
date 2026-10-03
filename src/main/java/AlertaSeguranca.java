public class AlertaSeguranca extends Notificacao{
    AlertaSeguranca(Canal canal) { super(canal); }

    String notificar(String conteudo) {
        return canal.enviar("ALERTA", conteudo);
    }
}
