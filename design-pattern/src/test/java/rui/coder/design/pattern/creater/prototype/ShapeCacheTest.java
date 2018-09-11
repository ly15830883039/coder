package rui.coder.design.pattern.creater.prototype;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rui.coder.design.pattern.creater.prototype.Shape;
import rui.coder.design.pattern.creater.prototype.ShapeCache;

import java.util.stream.IntStream;

class ShapeCacheTest {

    @BeforeEach
    void setUp() {
        ShapeCache.loadCache();
    }

    @Test
    void name() {
        IntStream.rangeClosed(1,3).forEach( i ->{
            Shape clonedShape =ShapeCache.getShape(i+"");
            System.out.println("Shape : " + clonedShape.getType());
        });
    }
}