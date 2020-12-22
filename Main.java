package java_core.block1.task2_1_number;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList(); //{ 1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4 }; /
        intList.add(1);
        intList.add(2);
        intList.add(5);
        intList.add(16);
        intList.add(-1);
        intList.add(-2);
        intList.add(0);
        intList.add(32);
        intList.add(3);
        intList.add(5);
        intList.add(8);
        intList.add(23);
        intList.add(4);
        System.out.println("Исходный список:" + intList);


        //1. Отфильтруйте положительные числа
        List<Integer> intListFilter = new ArrayList<>();
        for (int i = 0; i < intList.size(); i++) {
            if (intList.get(i) > 0) intListFilter.add(intList.get(i));
        }
        System.out.println("Список из положительных чисел:" + intListFilter);

        //"2. Найдите среди этих положительных чисел четные.\n" +
        List<Integer> intListPlus = new ArrayList<>();
        for (int i = 0; i < intListFilter.size(); i++) {
            if (intListFilter.get(i) % 2 == 0) intListPlus.add(intListFilter.get(i));
        }
        System.out.println("Список из положительных, четных чисел: " + intListPlus);

        //"3. Отсортируйте отфильтрованные числа в порядке возрастания.\n" +
        List<Integer> intListSort;
        intListSort = sortList(intListPlus);
        System.out.println("Список из положительных, четных, отфильтрованных в порядке возрастния чисел: " + intListSort);

    }

    private static List<Integer> sortList(List<Integer> list) {
        int min = 0;
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    isSorted = false;

                    min = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, min);
                }
            }
        }
        return list;
    }
}