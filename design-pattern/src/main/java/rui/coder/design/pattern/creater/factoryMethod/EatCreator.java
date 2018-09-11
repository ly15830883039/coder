package rui.coder.design.pattern.creater.factoryMethod;

/**
 * @author 赵睿
 */
public class EatCreator implements Creator {
    private Eat eat=new Eat();

    @Override
    public Behaviour create() {
        return eat;
    }
}
