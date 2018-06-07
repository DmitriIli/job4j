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

    ConsoleInput input = new ConsoleInput();
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
    public StartUI(ConsoleInput input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой языки --------------");
        String name = this.input.inputAnswer("Введите имя заявки :");
        String desc = this.input.inputAnswer("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            input.showMenu();
            String answer = this.input.inputAnswer("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (DELETE.equals(answer)) {
                this.tracker.delete(this.input.inputAnswer("введите ID заявки: "));
            } else if (FINDEBYID.equals(answer)) {
                this.tracker.print(this.tracker.findById(this.input.inputAnswer("введите ID заявки: ")));
            } else if (FINDBYNAME.equals(answer)) {
                this.tracker.findByName(this.input.inputAnswer("введите имя заявки: "));
                this.tracker.print(this.tracker.result);
            } else if (FINDALL.equals(answer)) {
                this.tracker.findAll();
                this.tracker.print(this.tracker.result);
            } else if (REPLACE.equals(answer)) {
                this.tracker.replace(this.input.inputAnswer("Введите ID"), new Item("new name", "new descr"));
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
