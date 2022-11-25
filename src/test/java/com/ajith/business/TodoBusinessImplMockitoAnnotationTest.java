package com.ajith.business;

import com.ajith.service.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockitoAnnotationTest {

    @Mock
    TodoService todoServiceMock;
    @InjectMocks
    TodoBusinessImpl todoBusiness;

    @Test
    public void retrieveTodos_usingMock() {
        List<String> todoListActual = List.of( "Learn Spring");
        when(todoServiceMock.retrieveTodos("test")).thenReturn(todoListActual);

        List<String> todoList = todoBusiness.retrieveTodosRelatedToSpring("test");
        assertEquals(todoListActual, todoList);
    }
}