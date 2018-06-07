package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput {
    public String inputAnswer(String answer) {
        System.out.println("Введите" + answer);
        Scanner scanner = new Scanner(System.in);
        return new String(scanner.nextLine());
    }

    public void showMenu() {
        System.out.print("1. Edit item\n" + "2. Delete item\n" + "3. Find item by Id\n" +
                "4. Find items by name\n" + "5. Find All\n" + "6. Replace item\n"+"7. Exit Program\n");
    }

}
