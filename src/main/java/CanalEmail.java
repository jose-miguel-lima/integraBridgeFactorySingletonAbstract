public class CanalEmail implements Canal{
    @Override
    public String enviar(String titulo, String mensagem) {
        String texto = "[E-mail] " + titulo + ": " + mensagem;
        RegistroEnvios.getInstance().registrar(texto);
        return texto;

    }
}
