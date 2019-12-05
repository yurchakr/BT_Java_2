package by.bsuir.autobase.dao;

import by.bsuir.autobase.dao.PurchaseDao.PurchaseDAO;
import by.bsuir.autobase.dao.UserDao.UserDAO;
import by.bsuir.autobase.dao.VehicleDao.VehicleDAO;

/**
 * The type Dao factory.
 */
public class DaoFactory {

    private static UserDAO userDao = new UserDAO();

    private static VehicleDAO vehicleDAO = new VehicleDAO();

    private static PurchaseDAO purchaseDAO = new PurchaseDAO();

    /**
     * Gets user dao.
     *
     * @return the user dao
     */
    public static UserDAO getUserDAO()
    {
        return userDao;
    }


    /**
     * Gets vehicle dao.
     *
     * @return the vehicle dao
     */
    public static VehicleDAO getVehicleDAO()
    {
        return vehicleDAO;
    }

    /**
     * Get purchase dao purchase dao.
     *
     * @return the purchase dao
     */
    public static PurchaseDAO getPurchaseDAO(){ return purchaseDAO; }
}
