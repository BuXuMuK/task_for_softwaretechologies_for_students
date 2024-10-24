package org.softwaretechnologies;

public final class Elevator {
    /**     * Этаж, на котором сейчас находится лифт.     */
    private int currentFloor;
    /**
     * Самый верхний этаж, на который может подняться лифт.
     */
    private final int highestFloor;
    /**
     * Самый нижний этаж, на который может опуститься лифт.
     */
    private final int lowestFloor;

    /**
     * Создает лифт, который передвигается между lowestFloor и highestFloor
     * включительно.
     */
    public Elevator(int lowestFloor, int highestFloor) {
        this.currentFloor = lowestFloor;
        this.highestFloor = highestFloor;
        this.lowestFloor = lowestFloor;
    }

    /**
     * Спускает лифт на этаж ниже.
     */
    private void goDown() {
        currentFloor--;
    }

    /**
     * Поднимает лифт на этаж выше.
     */
    private void goUp() {
        currentFloor++;
    }

    /**
     * Функция передвигает лифт на указанный этаж.
     */
    public void goToExactFloor(int floor) {
        if (floor < lowestFloor || floor > highestFloor) {
            System.out.println("Указан неверный этаж");
            return; // Не изменяем текущий этаж
        }

        // Поднимаемся или спускаемся до нужного этажа
        while (currentFloor != floor) {
            System.out.println("Текущий этаж: " + currentFloor);
            if ((currentFloor < floor)) {
                goUp();
            } else {
                goDown();
            }

        }

        System.out.println("Вы достигли указанного этажа: " + floor);
    }

    /**
     * Этаж, на котором сейчас находится лифт.
     */
    public int getCurrentFloor() {
        return currentFloor;
    }
}