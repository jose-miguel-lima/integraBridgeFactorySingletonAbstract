public class Promocao extends Notificacao{
    Promocao(Canal canal) { super(canal); }

    String notificar(String conteudo) {
        return canal.enviar("OFERTA", conteudo);
    }
}
