package org.softwaretechnologies;

import java.util.Optional;

public class ExceptionTask {

    /**
     * Исправьте функцию printMessage не убирая вызов функции throwRuntimeException.
     * Функция printMessage должна выводить на экран сообщение:
     * Вызвана функция printMessage
     */
    public static void printMessage() {
        System.out.println("Вызвана функция printMessage");
        throwRuntimeException();
    }

    /**
     * Исправьте функцию printMessage2 не убирая вызов функции throwCatchableException.
     * Функция printMessage должна выводить на экран сообщение:
     * Вызвана функция printMessage2
     */
    public static void printMessage2() throws Exception {
        System.out.println("Вызвана функция printMessage2");
        throwCatchableException();
    }

    private static void throwCatchableException() throws Exception {
        throw new Exception();
    }

    private static void throwRuntimeException() {
        throw new RuntimeException();
    }

    /**
     * Если делитель равен 0, то инициируйте DivideOnNullException
     * @param dividend делимое
     * @param divisor делитель
     * @return dividend/divisor
     * @throws DivideOnNullException если divisor равен 0
     */
    public static int divide(int dividend, int divisor) throws DivideOnNullException {
        if (divisor == 0) {
            throw new DivideOnNullException("Деление на ноль не допускается");
        }
        return dividend / divisor;
    }

    /**
     * Исправьте возможные ошибки в функции.
     * Функция возвращает конкатенацию двух строк: наибольшую из двух строк с другой строкой.
     * Если один из параметров null, то должен возвращаться Optional со значением другой строки (не null).
     * Если обе строки равны null, то должен возвращаться пустой Optional.
     * @param first первая строка
     * @param second вторая строка
     * @return конкатенацию двух строк: кратчайшую из двух строк с другой строкой.
     */
    public static Optional<String> mergeStrings(String first, String second) {
        if (first == null && second == null) {
            return Optional.empty();
        }
        if (first == null) {
            return Optional.of(second);
        }
        if (second == null) {
            return Optional.of(first);
        }
        return Optional.of(first.length() > second.length() ? first + second : second + first);
    }

    // Пример класса исключения
    public static class DivideOnNullException extends Exception {
        public DivideOnNullException(String message) {
            super(message);
        }
    }
}
