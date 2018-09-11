package rui.coder.design.pattern.creater.builder.LiuX;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

import static java.util.Arrays.asList;

/**
 * @author 赵睿
 */
@Data
@NoArgsConstructor
public class TagNode {
    private String name;
    private String value;

    private List<TagNode> childrenNodes;


    private Map<String,String> attributes;


    public TagNode(String name) {
        this.name = name;
    }

    public TagNode addChildren(TagNode... tagNodes) {
        return addChildren(asList(tagNodes));
    }

    public TagNode addChildren(List<TagNode> tagNodes) {
        if (childrenNodes == null) {
            this.childrenNodes = new ArrayList<>();
        }
        childrenNodes.addAll(tagNodes);
        return this;
    }

    public TagNode addAttributes(TagAttribute... tagAttributes) {
        return addAttributes(asList(tagAttributes));
    }

    public TagNode addAttributes(List<TagAttribute> tagAttributes) {
        if (attributes == null) {
            attributes = new TreeMap<>();
        }
        for (TagAttribute tagAttribute : tagAttributes) {
            attributes.put(tagAttribute.getName(),tagAttribute.getValue());
        }
        return this;
    }

    public String toXml() {
        StringBuilder builder = new StringBuilder("<")
                .append(this.name);
        toXmlAppendAttribute(builder);

        toXmlAppendChildrenNode(builder);
        return builder.toString();
    }

    private void toXmlAppendChildrenNode(StringBuilder builder) {
        if (this.childrenNodes == null || this.childrenNodes.size() == 0) {
            emptyNode(builder);
        } else {
            builder.append(">");
            for (TagNode childrenNode : childrenNodes) {
                builder.append(childrenNode.toXml());
            }
            builder.append("</")
                    .append(name)
                    .append(">");
        }
    }

    private void emptyNode(StringBuilder builder) {
        if (value == null) {
            builder.append("/>");
        } else {
            builder.append(value);
            builder.append(">");
        }
    }

    private void toXmlAppendAttribute(StringBuilder builder) {
        if (this.attributes != null && this.attributes.size() > 0) {

            for (Map.Entry<String,String> entry : attributes.entrySet()) {
                builder.append(" ")
                        .append(entry.getKey())
                        .append("=\"")
                        .append(entry.getValue())
                        .append("\"")
                ;
            }
        }
    }
}
