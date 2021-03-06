package ru.job4j.selection;

import org.junit.Test;

import java.beans.IntrospectionException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertListTest {
    @Test
    public void convertMatrixToList() {
        ConvertList list = new ConvertList();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }

    @Test
    public void convertListToArray() {
        ConvertList list = new ConvertList();
        int[][] expected = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        List<Integer> origin = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        int[][] result = list.toArray(origin, 3);
        assertThat(result, is(expected));
    }

    @Test
    public void convertToList(){
        ConvertList convertList = new ConvertList();
        List<Integer> expected = Arrays.asList(1,2,3,4,5);
        List<int[]> list =  new ArrayList<>();
        list.add(new int[]{1,2,3});
        list.add(new int[]{4,5});
        List<Integer> result = convertList.convert(list);
        assertThat(result,is(expected));
    }
}