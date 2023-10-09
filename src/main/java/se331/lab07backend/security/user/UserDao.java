package se331.lab07backend.security.user;

public interface UserDao {
    User findByUsername(String username);

    User save(User user);
}