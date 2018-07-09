package ru.job4j.selection;

import org.junit.Test;


import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void convertListToHashMap() {
        UserConvert userConvert = new UserConvert();
        List<User> list = new ArrayList<User>();
        list.add(new User(1, "name_1", "city_1"));
        list.add(new User(2, "name_2", "city_2"));
        userConvert.process(list);
        assertThat(userConvert.process(list).get(2).getName(), is("name_2"));
    }
}
