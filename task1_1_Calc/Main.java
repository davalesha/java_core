package java_core.block1.task1_1_Calc;

public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1, 1);

        // получается ошибка деления на 0 ArithmeticException
        // необходимо добавить обработчик исключений
        try {
            int c = calc.devide.apply(a, b);
            calc.println.accept(c);
        } catch (ArithmeticException e) {
            System.out.println("деление на 0");
        }

        int d = calc.abs(-10);
        calc.println.accept(d);

        int e = calc.abs(5);
        calc.println.accept(e);
    }
}
