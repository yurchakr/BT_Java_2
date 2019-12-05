package by.bsuir.autobase.entity;

/**
 * The type User.
 */
public abstract class User implements java.io.Serializable {

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    private String name;
    private String password;

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }
}
