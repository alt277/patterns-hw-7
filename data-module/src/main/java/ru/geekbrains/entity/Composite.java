package ru.geekbrains.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Composite implements Component {

    private final List<Component> components = new ArrayList<>();

    @Override
    public void show() {
        System.out.printf("Performing your Car: ");
        for (Component operation : components) {
            operation.show();
        }
        System.out.print("}");
    }

    public Component add(Component... components) {
        this.components.addAll(Arrays.asList(components));
        return this;
    }
}
