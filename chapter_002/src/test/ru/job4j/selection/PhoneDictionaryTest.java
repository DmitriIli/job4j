package ru.job4j.selection;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Dmitri", "Grebenev", "534872", "Kirov")
        );
        List<Person> persons = phones.find("Petr");
        assertThat(persons.iterator().next().getSurname(), is("irov"));
    }
}