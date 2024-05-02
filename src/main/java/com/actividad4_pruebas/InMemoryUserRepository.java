package com.actividad4_pruebas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Repositorio de usuarios
public class InMemoryUserRepository {
    private Map<Integer, User> users = new HashMap<>();
    private int nextId = 1;

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public User getUserById(int id) {
        return users.get(id);
    }

    public void addUser(User user) {
        user.setId(nextId++);
        users.put(user.getId(), user);
    }

    public void updateUser(User user) {
        users.put(user.getId(), user);
    }

    public void deleteUser(int id) {
        users.remove(id);
    }
}
