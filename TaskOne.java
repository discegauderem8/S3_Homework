/*+На вход некоторому исполнителю подаётся два числа (a, b). У исполнителя есть две команды
- команда 1 (к1): увеличить а в с раз, а умножается на c
- команда 2 (к2): увеличить на d, к a прибавляется d
написать программу, которая выдаёт набор команд, позволяющий число a превратить в число b или сообщить, что это невозможно
Пример 1: а = 1, b = 7, c = 2, d = 1
ответ: к2, к2, к2, к2, к2, к2, k2 или к1, к1, к2, к2, к2
Можно начать с более простого – просто подсчёта общего количества вариантов
Пример 2: а = 11, b = 7, c = 2, d = 1
ответ: нет решения.
*Подумать над тем, как сделать минимальное количество команд*/


import java.io.FileWriter;
import java.util.Scanner;

public class TaskOne {
    public static int a;
    public static int b;
    public static int c;
    public static int d;

    public static void main(String[] args) {


        try (Scanner iScanner = new Scanner(System.in)) {
            System.out.println("Введите число a: ");
            a = Integer.parseInt(iScanner.nextLine());
            System.out.println("Введите число b: ");
            b = Integer.parseInt(iScanner.nextLine());
            System.out.println("Введите число c (множитель): ");
            c = Integer.parseInt(iScanner.nextLine());
            System.out.println("Введите число d (слагаемое): ");
            d = Integer.parseInt(iScanner.nextLine());
        } catch (Exception e) {
            String errorText = e.getClass().getSimpleName();
            System.out.println("Ошибка типа: " + errorText);
        }
        try (FileWriter fw = new FileWriter("file.txt", false)) {
            fw.write("Кратчайшая последовательность арифметических операций для преобразования числа a в число b: "); //очищаем файл от предыдущих записей
            fw.append("\n");
        } catch (Exception e) {
            String errorText = e.getClass().getSimpleName();
        }

        System.out.println(optimizedCounter(a, b, c, d, 0));

    }

    private static String optimizedCounter(int a, int b, int c, int d, int count) {
        StringBuilder result = new StringBuilder();
        if (a * c <= b) {
            try (FileWriter fw = new FileWriter("file.txt", true)) {
                fw.write("a * c");
                fw.append("\n");
            } catch (Exception e) {
                String errorText = e.getClass().getSimpleName();
            }
            System.out.println("a * c");
            return optimizedCounter(a * c, b, c, d, count + 1);
        }
        if (a + d <= b) {
            try (FileWriter fw = new FileWriter("file.txt", true)) {
                fw.write("a + d");
                fw.append("\n");
            } catch (Exception e) {
                String errorText = e.getClass().getSimpleName();
            }
            System.out.println("a + d");
            return optimizedCounter(a + d, b, c, d, count + 1);
        } else {
            return "Итого вышло " + count + " вычислений";
        }

    }

}
