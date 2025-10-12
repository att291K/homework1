package sbp.branching;

import sbp.common.Utils;

public class MyCycles
{
    private final Utils utils;

    public MyCycles(Utils utils)
    {
        this.utils = utils;
    }

    /**
     * Необходимо написать реализацию метода с использованием for()
     +     * Метод должен вызвать Utils#utilFunc1() на каждой итерации
     +     * Реализация Utils#utilFunc1() неизвестна
     +     * Должна присутствовать проверка возвращаемого значения от Utils#utilFunc1()
     * Результат проверяется через unit-test (все тесты должны выполниться успешно)
     * @param iterations - количество итераций
     * @param str - строка для вывода через утилиту {@link Utils}
     */
    public void cycleForExample(int iterations, String str)
    {
        /**
         * Метод с использованием for, на каждой итерации вызывается функция Utils#utilFunc1()
        при положительном ответе вызывается Utils#link(String)}
         * @param iterations - количество итераций
         * @param str - строка для вывода через утилиту {@link Utils}
         */

        for (int i = 0; i < iterations; i++) {
            if (utils.utilFunc1(str)) {
                utils.link(str);
            }
        }

    }



    /**
     * Необходимо написать реализацию метода с использованием while()
     +     * Метод должен вызвать Utils#utilFunc1() на каждой итерации
     +     * Реализация Utils#utilFunc1() неизвестна
     +     * Должна присутствовать проверка возвращаемого значения от Utils#utilFunc1()
     * Результат проверяется через unit-test (все тесты должны выполниться успешно)
     * @param iterations - количество итераций
     * @param str - строка для вывода через утилиту {@link Utils}
     */
    public void cycleWhileExample(int iterations, String str)
    {
        /**
         * метод с использованием while c шагом 3, на каждой итерации вызывается функция Utils#utilFunc1()
         * при положительном ответе вызывается Utils#link
         * @param iterations - количество итераций
         * @param str - строка для вывода через утилиту {@link Utils}
         */
        //System.out.println(iterations);
        while (iterations > 0) {
            if (utils.utilFunc1(str)) {
                utils.link(str);
            }
            iterations = iterations-3;
        }

    }

    /**
     * Необходимо написать реализацию метода с использованием while()
     +     * Метод должен вызвать Utils#utilFunc1() на каждой итерации
     +     * Реализация Utils#utilFunc1() неизвестна
     +     * Метод должен вызвать Utils#utilFunc1() на каждой итерации
     +     * Реализация Utils#utilFunc1() неизвестна
     * Должна присутствовать проверка возвращаемого значения
     * Результат проверяется через unit-test (все тесты должны выполниться успешно)
     * @param from - начальное значение итератора
     * @param to - конечное значение итератора
     * @param str - строка для вывода через утилиту {@link Utils}
     */
    public void cycleDoWhileExample(int from, int to, String str)
    {
        /**
         * метод с использованием do while, на каждой итерации вызывается функция Utils#utilFunc1()
        при положительном ответе вызывается Utils#link
         * @param from - начальное значение итератора
         * @param to - конечное значение итератора
         * @param str - строка для вывода через утилиту {@link Utils}
         */
        int iterations = from;
        do {
            if (utils.utilFunc1(str)) {
                utils.link(str);
            }
            iterations++;
        }while (iterations <= to);
    }
}
