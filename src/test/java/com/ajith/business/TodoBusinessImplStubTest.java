package com.ajith.business;

import com.ajith.service.TodoService;
import com.ajith.service.TodoServiceStub;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TodoBusinessImplStubTest {

    @Test
    public void retrieveTodos_usingStub() {
        TodoService todoService = new TodoServiceStub();
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);
        List<String> todoList = todoBusiness.retrieveTodosRelatedToSpring("test");
        assertEquals(1, todoList.size());
    }
}