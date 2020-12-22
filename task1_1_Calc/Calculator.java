package java_core.block1.task1_1_Calc;

import java.util.function.*;

public class Calculator {
    //    не принимает никаких аргументов, но возвращает объект типа T:
    static Supplier<Calculator> instance = Calculator::new;

    //    принимает в качестве параметра два объекта типа T, выполняет
    //    над ними бинарную операцию и возвращает результат в виде объекта типа T
    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> devide = (x, y) -> x / y;

    //    принимает в качестве параметра объект типа T, выполняет над
    //    ними операции и возвращает результат операций в виде объекта типа T:

    UnaryOperator<Integer> pow = x -> x * x;
//    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;
    public Integer abs(int x){
        if ( x < 0) x =  -1 * x;
        return x;
    }








    //    проверяет соблюдение некоторого
    //    условия. Если оно соблюдается, то возвращается значение true
    Predicate<Integer> isPositive = x -> x > 0;

//    выполняет некоторое действие над объектом типа T, при этом ничего
//    не возвращая:
    Consumer<Integer> println = System.out :: println;
}
