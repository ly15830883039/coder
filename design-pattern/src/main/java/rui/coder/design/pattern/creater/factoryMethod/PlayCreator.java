package rui.coder.design.pattern.creater.factoryMethod;

/**
 * @author 赵睿
 */
public class PlayCreator implements Creator {

    private Play play=new Play();

    @Override
    public Behaviour create() {
        return play;
    }
}
