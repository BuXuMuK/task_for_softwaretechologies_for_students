package org.softwaretechnologies;

import org.softwaretechnologies.animals.Animal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Zoo {
    private final List<Animal> animalList = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animalList.add(animal);
    }

    /**
     * Метод должен возвращять список звуков животных.
     * Звуки животных должны быть отсортированы по имени животного.
     *
     * @return Звуки животных, в алфавитном порядке имени животного.
     */
    public List<String> soundAllAnimalsSortByName() {
        List<Animal> sortedAnimals = new ArrayList<>(animalList);

        // Сортируем животных по имени
        sortedAnimals.sort(Comparator.comparing(Animal::getName));

        List<String> sounds = new ArrayList<>();

        // Собираем звуки в отсортированном порядке
        for (Animal animal : sortedAnimals) {
            sounds.add(animal.sound());
        }

        return sounds;
    }
}
