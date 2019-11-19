package by.bsuir.autobase.dao.UserDao;

import by.bsuir.autobase.entity.AutoBase;
import by.bsuir.autobase.entity.User;
import by.bsuir.Serialize.Serialize;

import java.io.*;
import java.util.ArrayList;

/**
 * The type User dao.
 */
public class UserDAO implements IUserDAO{

    private static String filePath = getDatabasePath();
    private static Serialize<User> serializer = new Serialize<User>();

    public boolean delete(User user){
        throw new UnsupportedOperationException();
    }

    public void insert(User user){
        ArrayList<User> users = getUsers();
        if (users == null) {
            users = new ArrayList<User>();
        }
        users.add(user);
        AutoBase.setUsers(users);
        serializer.serialize(filePath, users);
    }

    /**
     * Get user by name user.
     *
     * @param name the name
     * @return the user
     */
    public User getUserByName(String name){
        ArrayList<User> users = serializer.deserialize(filePath);
        if (users != null){
            for (User user: users
            ) {
                if (user.getName().equals(name)) {
                    return user;
                }
            }
        }
        return null;
    }

    public ArrayList<User> getUsers(){
        return serializer.deserialize(filePath);
    }

    private static String getDatabasePath(){
        return new File("").getAbsolutePath()+"\\data\\users.xml";
    }
}
