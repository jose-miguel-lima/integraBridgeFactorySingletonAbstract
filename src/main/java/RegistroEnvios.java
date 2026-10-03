import java.util.ArrayList;
import java.util.List;

public class RegistroEnvios {
    private static final RegistroEnvios INSTANCIA = new RegistroEnvios();

    private final List<String> envios = new ArrayList<>();

    private RegistroEnvios() { }

    static RegistroEnvios getInstance() { return INSTANCIA; }

    void registrar(String texto) { envios.add(texto); }
    List<String> getEnvios() { return List.copyOf(envios); }
    void limpar() { envios.clear(); }
}
