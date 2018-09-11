package rui.coder.design.pattern.structure.filter;

import java.util.List;

/**
 * 标准
 */
public interface Criteria {
    /**
     * 符合标砖
     */
    List<Person> meetCriteria(List<Person> persons);
}