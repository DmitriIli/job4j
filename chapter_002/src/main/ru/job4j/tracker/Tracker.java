package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private Item[] items = new Item[100];
    int countItem = 0;
    Item[] result = new Item[100];

    public Item[] add(Item item) {

        this.items[countItem++] = item;
        return this.items;
    }

    public void replace(String id, Item item) {
        int count = 0;
        for (Item i : this.items) {
            if (i.id.equals(id)) {
                items[count] = item;
                break;
            }
            count++;
        }
    }

    public void delete(String id) {
        int count = 0;
        for (Item item : this.items) {
            if (item.id.equals(id)) {
                for (int i = count; i < this.items.length - 1; i++) {
                    items[i] = items[i + 1];
                }
                break;
            }
        }
        this.items = Arrays.copyOf(this.items, this.items.length - 1);
    }

    public void findAll() {
        Item[] array = new Item[100];
        int count = 0;
        for (Item item : this.items) {
            if (item != null) {
                array[count++] = item;
            }
        }
        result = Arrays.copyOf(array, count);

    }

    public void findByName(String key) {
        Item[] itm = new Item[100];
        int count = 0;
        for (Item item : items) {
            if(item == null){break;}
            System.out.println(item.getName());
            if (item.getName().equals(key)) {
                itm[count++] = item;
            }

        }
        result = Arrays.copyOf(itm, count);
    }

    public Item findById(String id) {
        Item searching_item = new Item();
        for (Item item : items) {
            if (item.getId().equals(id)) {
                searching_item = item;
                break;
            }
        }
        return searching_item;
    }

    public Item[] removeNull(Item[] items) {
        Item[] temp = new Item[items.length];
        int count = 0;
        for (Item item : items) {
            if (item != null) {
                temp[count++] = item;
            }
        }
        return temp = Arrays.copyOf(temp, count);
    }

    public void print(Item[] items) {
        for (Item item : items) {
            System.out.println("ID: " + item.getId() + ", name:" + item.getName() + ", description: "
                    + item.getDescription());
        }
    }

    public void print(Item item) {
        System.out.println("ID: " + item.getId() + ", name:" + item.getName() + ", description: "
                + item.getDescription());
    }
}
