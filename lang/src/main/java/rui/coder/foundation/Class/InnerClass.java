package rui.coder.foundation.Class;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("内部类")
public class InnerClass {

    class Contents{
        private int i=11;
        public int getI() {
            return i;
        }
    }

    class Destination{
        private String label;

        public Destination(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }

    public void ship(String dest){
        Contents c=new Contents();
        Destination d=new Destination(dest);
    }

    @DisplayName("parcel11")
    @Test
    void userIn(){
        
    }


}
