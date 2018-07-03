package ru.job4j.tracker;

import org.junit.Test;

import java.beans.IntrospectionException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerStubInputTest {

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"1", "test name", "desc", "7"});
        //   создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        tracker.findAll();
        assertThat(tracker.result[0].getName(), is("test name"));
    }

    @Test
    public void whenDeleteItemThenTrackerReturnNewItems() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("name1", "descr1", "1"));
        tracker.add(new Item("name2", "descr2", "2"));
        Input input = new StubInput(new String[]{"2", "1", "7"});
        new StartUI(input, tracker).init();
        tracker.findAll();
        assertThat(tracker.result[0].name, is("name2"));
    }

    @Test
    public void whenFindByIDThenReturnNewItems() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("name", "descr", "1"));
        Input input = new StubInput(new String[]{"3", "1", "7"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById("1").getName(), is("name"));
    }

    @Test
    public void whenFindByNameThenReturnNewItems() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("name", "descr", "1"));
        Input input = new StubInput(new String[]{"4", "name", "7"});
        new StartUI(input, tracker).init();
        assertThat(tracker.result[0].getName(), is("name"));
    }

    @Test
    public void whenFindAllThenTrackerReturnNewItems() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("name1", "descr1", "1"));
        tracker.add(new Item("name2", "descr2", "2"));
        tracker.add(new Item("name3", "descr3", "3"));
        Input input = new StubInput(new String[]{"5", "7"});
        new StartUI(input, tracker).init();
        assertThat(tracker.result[1], is(tracker.findById("2")));
    }

    @Test
    public void whenReplaceItemThenTrackerReturnNewItems() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        tracker.add(new Item("test name", "desc", "123"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"6", "123", "test replace", "заменили заявку", "7"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        tracker.findAll();
        assertThat(tracker.result[0].getDescription(), is("заменили заявку"));
    }

}
