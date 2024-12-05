package org.softwaretechnologies;

public class Cofe implements CofeInterface {
    private static final int BASE_COST = 50;
    private static final String DESCRIPTION = "only cofe";

    @Override
    public int getCost() {
        return BASE_COST;
    }

    @Override
    public String description() { // Изменено название метода на description()
        return DESCRIPTION;
    }
}
