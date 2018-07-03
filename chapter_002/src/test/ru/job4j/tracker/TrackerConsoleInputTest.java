package ru.job4j.tracker;

import org.junit.Test;

import java.beans.IntrospectionException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerConsoleInputTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        StubInput stubInput = new StubInput(new String[]{"0","name", "desriprion","7"});
        Item item = new Item("test1", "testDescription", "123");
        tracker.add(item);
        tracker.findAll();
        assertThat(tracker.result[0], is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", "123");
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", "1234");
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteItemThenTrackerReturnNewItems() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("name1", "descr1", "1"));
        tracker.add(new Item("name2", "descr2", "2"));
        tracker.delete("1");
        tracker.findAll();
        assertThat(tracker.result[0].name, is("name2"));
    }

    @Test
    public void whenFindAllThenTrackerReturnNewItems() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("name1", "descr1", "1"));
        tracker.add(new Item("name2", "descr2", "2"));
        tracker.add(new Item("name3", "descr3", "3"));
        tracker.findAll();
        assertThat(tracker.result[1], is(tracker.findById("2")));
    }

    @Test
    public void whenFindByNameThenReturnNewItems() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("name", "descr", "1"));
        tracker.findByName("name");
        assertThat(tracker.result[0].getName(), is("name"));
    }

    @Test
    public void whenFindByIDThenReturnNewItems() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("name", "descr", "1"));
        assertThat(tracker.findById("1").getName(), is("name"));
    }
    @Test
    public void whenReplaceItemThenReturnItems(){
        Tracker tracker = new Tracker();
        tracker.add(new Item("1","1","1"));
        tracker.replace("1",new Item("2","2","2"));
        assertThat(tracker.findById("2").getName(), is("2"));
    }

}
