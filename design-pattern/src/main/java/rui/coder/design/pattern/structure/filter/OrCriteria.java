package rui.coder.design.pattern.structure.filter;

import lombok.AllArgsConstructor;

import java.util.List;

/**
 * 只需要满足其中一个
 */
@AllArgsConstructor
public class OrCriteria implements Criteria {

   private Criteria criteria;
   private Criteria otherCriteria;

   @Override
   public List<Person> meetCriteria(List<Person> persons) {
      List<Person> firstCriteriaItems = criteria.meetCriteria(persons);
      List<Person> otherCriteriaItems = otherCriteria.meetCriteria(persons);

      for (Person person : otherCriteriaItems) {
         if(!firstCriteriaItems.contains(person)){
            firstCriteriaItems.add(person);
         }
      }    
      return firstCriteriaItems;
   }
}