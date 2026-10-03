public class FabricaEmail implements FabricaNotificacoes{
    private final CanalCreator creator = new EmailCreator();

    @Override
    public Notificacao criarAlerta(){
        return new AlertaSeguranca(creator.criarCanal());
    }

    @Override
    public Notificacao criarPromocao(){
        return new Promocao(creator.criarCanal());
    }
}
