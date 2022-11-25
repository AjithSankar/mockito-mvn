package com.ajith.business;

import com.ajith.service.TodoService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ListMockTest {

    @Test
    public void testList_usingMock() {
        List mockList = mock(List.class);
        when(mockList.size()).thenReturn(3);
        assertEquals(3, mockList.size());
    }

    @Test
    public void testListget_usingMock() {
        List mockList = mock(List.class);
        when(mockList.get(anyInt())).thenReturn(3);
        assertEquals(3, mockList.get(0));
    }
}