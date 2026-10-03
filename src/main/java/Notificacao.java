public abstract class Notificacao {
    protected final Canal canal;  // a "ponte"

    Notificacao(Canal canal) { this.canal = canal; }

    abstract String notificar(String conteudo);
}
