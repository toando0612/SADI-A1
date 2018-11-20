package jv.sadi.Decorator;

import jv.sadi.Decorator.Decorator;

public class NewMessage implements Decorator {
    private Decorator decorator;

    public NewMessage(Decorator decorator) {
        this.decorator = decorator;
    }

    @Override
    public void himessage(String name) {
        decorator.himessage(name);
        System.out.println("Have a nice day! See you next time");
    }
}
