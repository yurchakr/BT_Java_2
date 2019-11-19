package by.bsuir;

import by.bsuir.autobase.entity.AutoBase;
import by.bsuir.autobase.controller.Controller;

import java.sql.SQLException;

/**
 * The type Main.
 */
public class Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        Controller.initializeAutobase();
        while (true){
            AutoBase.execute();
        }
    }
}
