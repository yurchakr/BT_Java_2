package by.bsuir.autobase.dao.UserDao;

import by.bsuir.autobase.entity.User;

import java.util.ArrayList;

/**
 * The interface User dao.
 */
public interface IUserDAO {

    /**
     * Delete boolean.
     *
     * @param user the user
     * @return the boolean
     */
    boolean delete(User user);

    /**
     * Insert.
     *
     * @param user the user
     */
    void insert(User user);

    /**
     * Gets users.
     *
     * @return the users
     */
    ArrayList<User> getUsers();
    /*ArrayList<User> getBooksByTitle(String title);
    ArrayList<User> getBooksByAuthor(String author);*/
}
