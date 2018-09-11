package rui.coder.design.pattern.creater.builder.LiuX;

/**
 * @author 赵睿
 */
public class TagBuilder {
    private TagNode root;

    private TagNode currentNode;

    private TagNode parrentNode;

    public TagBuilder(String name) {
        root = new TagNode(name);
        currentNode = root;
        parrentNode = root;
    }

    public TagBuilder addChild(String name) {
        TagNode node = new TagNode(name);
        currentNode.addChildren(node);
        parrentNode=currentNode;
        currentNode = node;
        return this;
    }
    public TagBuilder addSibling(String name) {
        TagNode node = new TagNode(name);
        parrentNode.addChildren(node);
        currentNode=node;
        return this;
    }

    public TagBuilder setAttribute(String name, String value) {
        currentNode.addAttributes(new TagAttribute(name, value));
        return this;
    }



    public String toXML() {
        return root.toXml();
    }
}
