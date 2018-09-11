package rui.coder.design.pattern.creater.factoryMethod.simplefacotory;

/**
 * @author 赵睿
 */
public class Creator {

    private Play play=new Play();
    private Eat eat=new Eat();

    public Behaviour factoryMethod(String type) {
        switch (type) {
            case "play":
                return play;
            case "eat":
                return eat;
            default:
                return eat;
        }
    }
}
