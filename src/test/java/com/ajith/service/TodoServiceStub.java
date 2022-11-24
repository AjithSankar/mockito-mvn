package com.ajith.service;

import java.util.List;

public class TodoServiceStub implements TodoService {

    @Override
    public List<String> retrieveTodos(String user) {
        return List.of("Learn Mockito", "Learn docker" , "Learn Kubernetes", "Learn Spring");
    }
}