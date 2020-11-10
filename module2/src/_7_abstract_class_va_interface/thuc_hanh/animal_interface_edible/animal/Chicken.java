package _7_abstract_class_va_interface.thuc_hanh.animal_interface_edible.animal;

import _7_abstract_class_va_interface.thuc_hanh.animal_interface_edible.edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "chuck chuck";
    }

    @Override
    public String howToEat() {
        return "co the an gao";
    }
}
