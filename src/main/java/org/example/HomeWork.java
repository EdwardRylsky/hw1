package org.example;

import java.util.function.Predicate;

/**
 * Сигнатуры методов в данном классе не менять
 */
public class HomeWork {

    /**
     * <h1>Задание 1.</h1>
     * Реализовать метод, который подсчитывает количество подходящих по условию узлов от 0 до N.
     * <br/>
     * Пример 1:
     * список 1, 2, 3, 4, 5
     * условие x < 4
     * ответ 3
     * <br/>
     * Пример 2:
     * список 1, 2, 3, 4, 5
     * условие x < 0
     * ответ 0
     *
     * @param list односвязный список
     * @param pred условие
     * @param <T>  - тип хранимых значений в списке
     * @return количество узлов от 0 до N, где N позиция на которой первый раз условие вернуло false
     */
    public <T> int partitionBy(Node<T> list, Predicate<T> pred) {
        if (list == null || pred == null) {
            throw new IllegalArgumentException("list or pred can't be null");
        }

        int result = 0;

        if (list.getNext() == null) {
            if (list.getValue() != null) {
                return pred.test(list.getValue()) ? 1 : 0;
            } else return result;
        }

        while (list.getNext() != null) {
            if (list.getValue() != null) {
                if (pred.test(list.getValue())) {
                    result++;
                } else {
                    return result;
                }
            } else {
                return result;
            }
            list = list.getNext();
        }

        if (list.getValue() != null && pred.test(list.getValue())) {
            result++;
        }

        return result;
    }

    /**
     * <h1>Задание 2.</h1>
     * Реализовать метод поиска элемента на позиции N в переданном односвязном списке.
     *
     * @param list односвязный список
     * @param n    позиция искомого элемента
     * @param <T> тип хранимых значений в списке
     * @return сам элемент
     */
    public <T> T findNthElement(Node<T> list, int n) {
        return null;
    }
}
