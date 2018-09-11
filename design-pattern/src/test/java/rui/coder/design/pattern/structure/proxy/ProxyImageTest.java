package rui.coder.design.pattern.structure.proxy;

import org.junit.jupiter.api.Test;

class ProxyImageTest {

    @Test
    void display() {
        Image image = new ProxyImage("test_10mb.jpg");

        //图像将从磁盘加载
        image.display();
        System.out.println("----");
        //图像将无法从磁盘加载
        image.display();
    }
}