package org.softwaretechnologies;

import org.softwaretechnologies.animals.Animal;
import org.softwaretechnologies.animals.AnimalType;
import org.softwaretechnologies.animals.Cat;
import org.softwaretechnologies.animals.Cow;
import org.softwaretechnologies.animals.Dog;

public class AnimalFactory {

    /**
     * Метод для создания животных по типу
     * @param name - имя животного
     * @param type - тип животного
     * @return животное, соответствующее каждому из типов.
     */
    public static Animal createAnimal(String name, AnimalType type) {
        switch (type) {
            case CAT:
                return new Cat(name);
            case COW:
                return new Cow(name);
            case DOG:
                return new Dog(name);
            default:
                throw new IllegalArgumentException("Unknown animal type: " + type);
        }
    }
}
