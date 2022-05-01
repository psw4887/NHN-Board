package com.nhnacademy.repository;

import com.nhnacademy.data.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserDataLoad implements UserRepository {

    private final Map<String, User> userMemory = new ConcurrentHashMap<>();

    @Override
    public void add(User user) {
        this.userMemory.put(user.getId(), user);
    }

    @Override
    public void modify(User user) {
        this.userMemory.put(user.getId(), user);
    }

    @Override
    public User remove(String id) {
        return this.userMemory.remove(id);
    }

    @Override
    public User getUser(String id) {
        return this.userMemory.get(id);
    }

    @Override
    public List<User> getUsers() {
        return new ArrayList<>(this.userMemory.values());
    }
}
