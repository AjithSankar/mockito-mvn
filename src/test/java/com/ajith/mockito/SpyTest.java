package com.ajith.mockito;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SpyTest {

    @Test
    public void testListSize_usingSpy() {
        ArrayList spyList = spy(ArrayList.class);
        when(spyList.size()).thenReturn(5);
        assertEquals(5 , spyList.size());
    }

    @Test
    public void testListGet_usingSpy() {
        //Spy act as real class and lets you override certain behavior
        ArrayList spyList = spy(ArrayList.class);
        spyList.add(1);
        spyList.add(2);
        when(spyList.get(anyInt())).thenReturn(1);
        assertEquals(1, spyList.get(0));
        assertEquals(1, spyList.get(10));
        assertEquals(1, spyList.get(60));

    }
}