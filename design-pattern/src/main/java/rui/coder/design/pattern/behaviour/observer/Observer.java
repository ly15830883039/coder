package rui.coder.design.pattern.behaviour.observer;

public abstract class Observer {
   protected Subject subject;
   public abstract void update();
}