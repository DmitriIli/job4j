package ru.job4j.search;

import ru.job4j.search.Task;

import java.util.Iterator;
import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        //TODO добавить вставку в связанный список.
        if (this.tasks.size() == 0) {
            this.tasks.add(task);
        } else {
            for (int i = 0; i < this.tasks.size(); i++) {
                if (task.getPriority() < this.tasks.get(i).getPriority()) {
                    this.tasks.add(i, task);
                    break;
                }
            }
        }


    }

    public Task take() {
        return this.tasks.poll();
    }
}