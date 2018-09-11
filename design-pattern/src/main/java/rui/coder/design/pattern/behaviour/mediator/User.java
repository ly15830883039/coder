package rui.coder.design.pattern.behaviour.mediator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {

    private String name;

    public void sendMessage(String message) {
            ChatRoom.showMessage(this, message);
    }
}