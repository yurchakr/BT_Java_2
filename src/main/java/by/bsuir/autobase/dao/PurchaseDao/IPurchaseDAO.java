package by.bsuir.autobase.dao.PurchaseDao;

import by.bsuir.autobase.entity.Purchase;

import java.util.ArrayList;

/**
 * The interface Purchase dao.
 */
public interface IPurchaseDAO {

    /**
     * Insert.
     *
     * @param purchase the purchase
     */
    void insert(Purchase purchase);

    /**
     * Gets purchases.
     *
     * @return the purchases
     */
    ArrayList<Purchase> getPurchases();
}
