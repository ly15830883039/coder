package rui.coder.design.pattern.creater.prototype;

import lombok.Getter;
import lombok.Setter;

/**
 * 形状
 * @author 赵睿
 */
public abstract class Shape implements Cloneable{
    @Setter
    @Getter
    private String id;
    @Setter
    @Getter
    protected String type;
    abstract void draw();

    @Override
    public Shape clone() {
        Shape shape = null;
        try {
            shape= (Shape) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return shape;
    }
}
