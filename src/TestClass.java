import java.util.ArrayList;
import java.util.Arrays;

public class TestClass {
    public static void main(String[] args) {

        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Box<Apple> appleBox2 = new Box<>();

        appleBox.addToBox(new Apple());
        appleBox.addToBox(new Apple());
        appleBox.addToBox(new Apple());
        appleBox.addToBox(new Apple());

        orangeBox.addToBox(new Orange());
        orangeBox.addToBox(new Orange());
        orangeBox.addToBox(new Orange());
        orangeBox.addToBox(new Orange());
        orangeBox.addToBox(new Orange());

        System.out.println("Вес коробки: " + appleBox.getWeight() + "f");
        System.out.println("Вес коробки: " + orangeBox.getWeight() + "f");
        System.out.println("Вес коробки: " + appleBox2.getWeight() + "f");

        System.out.println(appleBox.compare(orangeBox));

        appleBox.transferFruits(appleBox2);
        System.out.println("Вес первой коробки: " + appleBox.getWeight() + "f");
        System.out.println("Вес второй коробки: " + appleBox2.getWeight() + "f");

        // Тестирование задачи 2

        String[] array1 = {
                "один", "два", "три", "четыре", "пять", "шесть", "семь"
        };
        System.out.println(transformArray(array1));

        Integer[] array2 = {
                1, 2, 3, 4, 5, 6, 7
        };
        System.out.println(transformArray(array2));

        // Тестирование задачи 1

        changeIndex(array2, 3, 4);
        printArray(array2);

    }

    // 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);

    public static <T> T[] changeIndex(T[] arr2, int index1, int index2) {
        T t = arr2[index1];
        arr2[index1] = arr2[index2];
        arr2[index2] = t;
        return arr2;
    }

    // 2. Написать метод, который преобразует массив в ArrayList;

    public static <T> ArrayList<T> transformArray(T[] arr1) {
        return new ArrayList<>(Arrays.asList(arr1));
    }

    public static <T> void printArray(T[] arr) {
        for (T t : arr) {
            System.out.print(t + " ");
        }
    }
}