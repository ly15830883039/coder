package rui.coder.design.pattern.behaviour.state;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class    Context {

    private State state;

    public Context() {
        state = null;
    }
}