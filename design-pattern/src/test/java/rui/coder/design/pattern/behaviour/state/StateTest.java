package rui.coder.design.pattern.behaviour.state;

import org.junit.jupiter.api.Test;

class StateTest {

    @Test
    void doAction() {
        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);

        System.out.println(context.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context);

        System.out.println(context.getState().toString());
    }
}