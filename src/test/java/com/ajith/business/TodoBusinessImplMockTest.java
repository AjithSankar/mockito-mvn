package com.ajith.business;

import com.ajith.service.TodoService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TodoBusinessImplMockTest {

    @Test
    public void retrieveTodos_usingMock() {
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todoListActual = List.of( "Learn Spring");
        when(todoServiceMock.retrieveTodos("test")).thenReturn(todoListActual);

        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);
        List<String> todoList = todoBusiness.retrieveTodosRelatedToSpring("test");
        assertEquals(todoListActual, todoList);
    }
}