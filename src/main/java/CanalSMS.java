public class CanalSMS implements Canal{
    @Override
    public String enviar(String titulo, String mensagem) {
        String texto = "[SMS] " + titulo + ": " + mensagem;
        RegistroEnvios.getInstance().registrar(texto);
        return texto;
    }
}
