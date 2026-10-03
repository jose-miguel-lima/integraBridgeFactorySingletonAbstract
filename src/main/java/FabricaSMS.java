public class FabricaSMS implements FabricaNotificacoes{
    private final CanalCreator creator = new SMSCreator();

    @Override
    public Notificacao criarAlerta() {
        return new AlertaSeguranca(creator.criarCanal());
    }
    @Override
    public Notificacao criarPromocao() {
        return new Promocao(creator.criarCanal());
    }
}
