package com.person.rentalcar.shiro.security;


import com.person.rentalcar.model.User;

public class UserContext implements AutoCloseable {

    static final ThreadLocal<User> current = new ThreadLocal<>();

    public UserContext(User user) {
        current.set(user);
    }

    public static User getCurrentUser() {
        return current.get();
    }

    public static void setCurrentUser(User user) {
        current.set(user);
    }

    public void close() {
        current.remove();
    }
}
