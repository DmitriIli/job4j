package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person person : this.persons) {
            if (person.getName().contains(key) || person.getSurname().contains(key) || person.getAddress().contains(key)
                    || person.getPhone().contains(key)){
                result.add(person);
            }
        }
        return result;
    }
}