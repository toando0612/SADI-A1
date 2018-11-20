package jv.sadi.Decorator;

import jv.sadi.Decorator.Decorator;

public class Message implements Decorator {
    @Override
    public void himessage(String name) {
        System.out.println("Hi "+name);
    }
}
