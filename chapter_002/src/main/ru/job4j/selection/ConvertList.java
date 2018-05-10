package ru.job4j.selection;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<Integer>();
        for (int[] arr : array) {
            for (int i : arr) {
                list.add(i);
            }
        }
        return list;
    }

    public int[][] toArray(List<Integer> list, int rows) {
        int[][] arr = new int[rows][rows];
        int i = 0;
        int j = 0;
        for (Integer ind : list) {
            if ((i + j + 2) <= list.size()) {
                arr[i][j] = ind;
            } else {
                arr[i][j] = 0;
            }
            if (j < rows - 1) {
                j++;
            } else {
                j = 0;
                i++;
            }
            if (i == rows) break;
        }
        return arr;
    }
}
