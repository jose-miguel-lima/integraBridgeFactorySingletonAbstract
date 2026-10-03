public class EmailCreator extends CanalCreator{
    @Override
    Canal criarCanal(){
        return new CanalEmail();
    }
}
