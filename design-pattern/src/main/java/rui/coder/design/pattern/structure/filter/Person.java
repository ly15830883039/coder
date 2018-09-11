package rui.coder.design.pattern.structure.filter;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 人
 */
@AllArgsConstructor
@Data
public class Person {

    private String name;
    /**
     * 性别
     */
    private String gender;
    /**
     * 婚姻状态
     */
    private String maritalStatus;
}