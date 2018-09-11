package rui.coder.design.pattern.creater.builder.LiuX;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author 赵睿
 */
class TagBuilderTest {
    @Test
    public void testToXML() {

        TagBuilder builder = new TagBuilder("order");

        String xml = builder
                .addChild("line-items")
                    .addChild("line-item").setAttribute("pid", "P3677").setAttribute("qty", "3")
                    .addSibling("line-item").setAttribute("pid", "P9877").setAttribute("qty", "10")
                .toXML();

        String expected = "<order>"
                + "<line-items>"
                + "<line-item pid=\"P3677\" qty=\"3\"/>"
                + "<line-item pid=\"P9877\" qty=\"10\"/>"
                + "</line-items>"
                + "</order>";

        System.out.println(xml);
        assertEquals(expected, xml);
    }
}
