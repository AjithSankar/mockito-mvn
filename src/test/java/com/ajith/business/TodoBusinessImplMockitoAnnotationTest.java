package com.ajith.business;

import com.ajith.service.TodoService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class TodoBusinessImplMockitoAnnotationTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
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