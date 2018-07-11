package ru.job4j.strategy;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FigureConsoleOutTest {

    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(
                square.draw(),
                is(
                        new StringBuilder()
                                .append("++++")
                                .append("+  +")
                                .append("+  +")
                                .append("++++")
                                .toString()
                )
        );
    }
    @Test
    public void whenDrawTriangle() {
        Triangle triangle= new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                                .append("  +  ")
                                .append(" + + ")
                                .append("+   +")
                                .append("+++++")
                                .toString()
                )
        );
    }
}

