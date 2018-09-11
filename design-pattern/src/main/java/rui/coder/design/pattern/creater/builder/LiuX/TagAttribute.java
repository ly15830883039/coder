package rui.coder.design.pattern.creater.builder.LiuX;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 赵睿
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagAttribute {
    private String name;
    private String value;

    public String toXml(){
        return name + "=\"" + value+"\"";
    }
}
