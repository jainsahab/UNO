package com.tw.uno;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class RandomTest {
    @Test
    public void testShouldShuffleTheListOfIntegers() {
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(2);
        temp.add(3);
        Random random = new Random(temp);

        List<Integer> result = new ArrayList<>();
        for (Object o : random.shuffleCards()) {
            result.add((Integer) o);
        }
        assertEquals(true, result.contains(1));
        assertEquals(true, result.contains(2));
        assertEquals(true, result.contains(3));
    }

    @Test
    public void testShouldShuffleTheListOfDoubles() {
        List<Double> temp = new ArrayList<>();
        temp.add(1.45);
        temp.add(2.67);
        temp.add(3.89);
        Random random = new Random(temp);
        List<Double> result = new ArrayList<>();
        for (Object o : random.shuffleCards()) {
            result.add((Double) o);
        }
        assertEquals(true, result.contains(1.45));
        assertEquals(true, result.contains(2.67));
        assertEquals(true, result.contains(3.89));
    }
}