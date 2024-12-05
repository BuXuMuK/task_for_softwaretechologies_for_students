package org.softwaretechnologies;

public class MilkCofe implements CofeInterface {
    private final CofeInterface cofe;
    private static final int MILK_COST = 10;

    // Конструктор, принимающий CofeInterface
    public MilkCofe(CofeInterface cofe) {
        this.cofe = cofe;
    }

    @Override
    public int getCost() {
        return cofe.getCost() + MILK_COST; // Возврат стоимости от кофе с добавлением стоимости молока
    }

    @Override
    public String description() {
        return cofe.description() + " + milk"; // Добавление к описанию
    }
}
