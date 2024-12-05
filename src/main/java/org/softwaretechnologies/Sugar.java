package org.softwaretechnologies;

public class Sugar implements CofeInterface {
    private final CofeInterface cofe;
    private static final int SUGAR_COST = 20;

    // Конструктор, принимающий CofeInterface
    public Sugar(CofeInterface cofe) {
        this.cofe = cofe;
    }

    @Override
    public int getCost() {
        return cofe.getCost() + SUGAR_COST; // Добавить стоимость сахара
    }

    @Override
    public String description() {
        return cofe.description() + " + sugar"; // Добавить к описанию
    }
}

