import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class NotificacoesTest {

    // o Singleton guarda estado global: ta limpando antes de cada teste
    @BeforeEach
    void limparRegistro() {
        RegistroEnvios.getInstance().limpar();
    }

    @Nested
    class BridgeTest {
        @Test
        void deveRetornarAlertaPorSms() {
            Notificacao n = new AlertaSeguranca(new CanalSMS());
            assertEquals("[SMS] ALERTA: Login suspeito", n.notificar("Login suspeito"));
        }

        @Test
        void deveRetornarPromocaoPorEmail() {
            Notificacao n = new Promocao(new CanalEmail());
            assertEquals("[E-mail] OFERTA: 50% de desconto", n.notificar("50% de desconto"));
        }

        @Test
        void deveRetornarMesmoTipoDeNotificacaoComCanaisDiferentes() {
            String viaSms = new Promocao(new CanalSMS()).notificar("x");
            String viaEmail = new Promocao(new CanalEmail()).notificar("x");
            assertNotEquals(viaSms, viaEmail);
        }
    }

    @Nested
    class FactoryMethodTest {
        @Test
        void emailCreatorCriaCanalEmail() {
            assertTrue(new EmailCreator().criarCanal() instanceof CanalEmail);
        }

        @Test
        void smsCreatorCriaCanalSMS() {
            assertTrue(new SMSCreator().criarCanal() instanceof CanalSMS);
        }
    }

    @Nested
    class AbstractFactoryTest {
        @Test
        void deveRetornarNotificacoesPorSmsViaFabricaSMS() {
            FabricaNotificacoes fabrica = new FabricaSMS();
            assertEquals("[SMS] ALERTA: a", fabrica.criarAlerta().notificar("a"));
            assertEquals("[SMS] OFERTA: b", fabrica.criarPromocao().notificar("b"));
        }

        @Test
        void deveRetornarNotificacoesPorEmailViaFAbricaEmail() {
            FabricaNotificacoes fabrica = new FabricaEmail();
            assertEquals("[E-mail] ALERTA: a", fabrica.criarAlerta().notificar("a"));
            assertEquals("[E-mail] OFERTA: b", fabrica.criarPromocao().notificar("b"));
        }
    }

    @Nested
    class SingletonTest {
        @Test
        void deveSempreRetornarAMesmaInstancia() {
            assertSame(RegistroEnvios.getInstance(), RegistroEnvios.getInstance());
        }

        @Test
        void todosOsCanaisRegistramNoMesmoRegistro() {
            new FabricaSMS().criarAlerta().notificar("a");
            new FabricaEmail().criarPromocao().notificar("b");

            assertEquals(2, RegistroEnvios.getInstance().getEnvios().size());
            assertEquals("[SMS] ALERTA: a", RegistroEnvios.getInstance().getEnvios().get(0));
        }
    }
}
