package rui.coder.design.pattern.structure.filter;

import lombok.AllArgsConstructor;

import java.util.List;

/**
 * 同时满足 某种标准
 */
@AllArgsConstructor
public class AndCriteria implements Criteria {

   private Criteria criteria;
   private Criteria otherCriteria;

   @Override
   public List<Person> meetCriteria(List<Person> persons) {
      List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);        
      return otherCriteria.meetCriteria(firstCriteriaPersons);
   }
}