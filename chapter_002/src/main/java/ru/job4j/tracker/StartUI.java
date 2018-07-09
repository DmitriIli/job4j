package ru.job4j.tracker;

public class StartUI {
    /**
     * Константы меню.
     */
    private static final String ADD = "1";
    private static final String DELETE = "2";
    private static final String FINDEBYID = "3";
    private static final String FINDBYNAME = "4";
    private static final String FINDALL = "5";
    private static final String REPLACE = "6";
    private static final String EXIT = "7";

    Input input = new ConsoleInput();
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой языки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    public void showMenu() {
        System.out.print("1. Add item\n" + "2. Delete item\n" + "3. Find item by Id\n" +
                "4. Find items by name\n" + "5. Find All\n" + "6. Replace item\n" + "7. Exit Program\n");
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        this.showMenu();
        boolean exit = false;
        while (!exit) {
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (DELETE.equals(answer)) {
                this.tracker.delete(this.input.ask("введите ID заявки: "));
            } else if (FINDEBYID.equals(answer)) {
                this.tracker.print(this.tracker.findById(this.input.ask("введите ID заявки: ")));
            } else if (FINDBYNAME.equals(answer)) {
                this.tracker.findByName(this.input.ask("введите имя заявки: "));
                this.tracker.print(this.tracker.result);
            } else if (FINDALL.equals(answer)) {
                this.tracker.findAll();
                this.tracker.print(this.tracker.result);
            } else if (REPLACE.equals(answer)) {
                this.tracker.replace(this.input.ask("Введите ID"), new Item(this.input.ask("введите имя")
                        , this.input.ask("введите описание")));
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
