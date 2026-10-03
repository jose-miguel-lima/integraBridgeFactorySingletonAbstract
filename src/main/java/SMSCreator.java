public class SMSCreator extends CanalCreator{
    @Override
    Canal criarCanal() {
        return new CanalSMS();
    }
}
