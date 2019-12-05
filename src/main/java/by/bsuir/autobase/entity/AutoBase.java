package by.bsuir.autobase.entity;

import by.bsuir.Compare.CompareByMake;
import by.bsuir.Compare.CompareByModel;
import by.bsuir.Compare.CompareByYear;
import by.bsuir.autobase.controller.Controller;
import by.bsuir.autobase.dao.DaoFactory;
import by.bsuir.autobase.presentation.View;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * The type Auto base.
 */
public class AutoBase implements java.io.Serializable{

    private static double money;
    private static User currentUser;
    private static ArrayList<Vehicle> carList;
    private static ArrayList<User> users;
    private static ArrayList<Purchase> purchases;

    /**
     * Gets purchases.
     *
     * @return the purchases
     */
    public static ArrayList<Purchase> getPurchases() {
        return purchases;
    }

    /**
     * Sets purchases.
     *
     * @param purchases the purchases
     */
    public static void setPurchases(ArrayList<Purchase> purchases) {
        AutoBase.purchases = purchases;
    }


    /**
     * Gets money.
     *
     * @return the money
     */
    public static double getMoney() {
        return money;
    }

    /**
     * Sets money.
     *
     * @param money the money
     */
    public static void setMoney(double money) {
        AutoBase.money = money;
    }

    /**
     * Gets current user.
     *
     * @return the current user
     */
    public static User getCurrentUser() {
        return currentUser;
    }

    /**
     * Sets current user.
     *
     * @param currentUser the current user
     */
    public static void setCurrentUser(User currentUser) {
        AutoBase.currentUser = currentUser;
        if (currentUser != null){
            View.showMessage("Current user's name: " + AutoBase.getCurrentUser().getName());
        }
        else{
            View.showMessage("Logged out");
        }
    }

    /**
     * Gets car list.
     *
     * @return the car list
     */
    public static ArrayList<Vehicle> getCarList() {
        return carList;
    }

    /**
     * Sets car list.
     *
     * @param carList the car list
     */
    public static void setCarList(ArrayList<Vehicle> carList) {
        AutoBase.carList = carList;
    }

    /**
     * Gets users.
     *
     * @return the users
     */
    public static ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Sets users.
     *
     * @param users the users
     */
    public static void setUsers(ArrayList<User> users) {
        AutoBase.users = users;
    }

    /**
     * Instantiates a new Auto base.
     */
    public AutoBase() {
    }

    /**
     * Execute.
     */
    public static void execute(){
        boolean flag = false;
        do {
            Object[] result = Controller.authorizeRequest();
            User user = null;

            if ((int)result[0] == 1){
                user = new Manager();
            }
            else{
                user = new Customer();
            }

            user.setName((String)result[1]);
            user.setPassword((String)result[2]);

            User registeredUser = DaoFactory.getUserDAO().getUserByName((String)result[1]);

            if (registeredUser == null) {
                DaoFactory.getUserDAO().insert(user);
                flag = true;
                AutoBase.setCurrentUser(user);
            }
            else{
                if (registeredUser.getPassword().equals((String)result[2])){
                    flag = true;
                    AutoBase.setCurrentUser(user);
                }else {
                    View.showMessage("Not correct password\n");
                }
            }
        }while (!flag);

        chooseActionLoop();
    }

    /**
     * Choose action loop.
     */
    public static void chooseActionLoop(){
        boolean flag = true;
        Comparator<Vehicle> pcomp;

        while (flag) {
            int action = Controller.chooseActionRequest();
            switch (action) {
                case 1:
                    System.exit(0);
                    break;
                case 2:
                    flag = false;
                    logOut();
                    break;
                case 3:
                    Vehicle.buyVehicle();
                    break;
                case 4:
                    Vehicle.getVehicles();
                    break;
                case 5:
                    Controller.printListRequest(Vehicle.findByMake());
                    break;
                case 6:
                    Controller.printListRequest(Vehicle.findByYear());
                    break;
                case 7:
                    pcomp = new CompareByMake().thenComparing(new CompareByModel());
                    Vehicle.sort(pcomp);
                    Vehicle.getVehicles();
                    break;
                case 8:
                    pcomp = new CompareByYear();
                    Vehicle.sort(pcomp);
                    Vehicle.getVehicles();
                    break;
                case 9:
                    Vehicle.addVehicle();
                    break;
                case 10:
                    Vehicle.deleteVehicle(false);
                    break;
                case 11:
                    Vehicle.updateVehicle();
                    break;
                case 12:
                    Purchase.getPurchases();
                    break;

            }
        }
    }

    private static void logOut(){
        AutoBase.setCurrentUser(null);
    }
}

