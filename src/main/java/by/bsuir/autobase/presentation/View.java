package by.bsuir.autobase.presentation;

import by.bsuir.autobase.entity.BodyType;
import by.bsuir.autobase.entity.FuelType;
import by.bsuir.autobase.entity.TruckCategory;

/**
 * The type View.
 */
public class View {

    /**
     * Get user data object [ ].
     *
     * @return the object [ ]
     */
    public static Object[] getUserData(){
        String name, password;

        System.out.println("\n1. Manager\n2. Customer");
        int res = ConsoleReader.getInt();
        System.out.print("\nEnter your name :");
        ConsoleReader.getString();
        name = ConsoleReader.getString();
        System.out.print("Enter your password :");
        password = ConsoleReader.getString();
        return new Object[] {res, name, password};
    }

    /**
     * Get vehicle data object [ ].
     *
     * @return the object [ ]
     */
    public static Object[] getVehicleData(){
        String make, model;
        double price, fuelConsumption;
        int power, year;
        FuelType fuelType;

        System.out.println("\n1. Car\n2. Truck");
        int res = ConsoleReader.getInt();
        System.out.print("\nEnter make :");
        ConsoleReader.getString();
        make = ConsoleReader.getString();
        System.out.print("Enter model :");
        model = ConsoleReader.getString();
        System.out.print("Enter price($) :");
        price = Double.parseDouble(ConsoleReader.getString());
        System.out.print("Enter fuelConsumption(l) :");
        fuelConsumption = Double.parseDouble(ConsoleReader.getString());
        System.out.print("Enter power(kW) :");
        power = ConsoleReader.getInt();
        System.out.print("Enter year :");
        year = ConsoleReader.getInt();
        System.out.print("Enter fuelType :\n");

        FuelType[] fuelTypes = FuelType.values();
        for(int i = 0; i < fuelTypes.length; i++){
            System.out.print("   " + i + ". " + fuelTypes[i].toString() + "\n");
        }
        fuelType = FuelType.valueOf((fuelTypes[ConsoleReader.getInt()]).toString());

        if (res == 1){
            int seatCount, doorCount;
            BodyType bodyType;

            System.out.print("Enter seatCount :");
            seatCount = ConsoleReader.getInt();
            System.out.print("Enter doorCount :\n");
            doorCount = ConsoleReader.getInt();

            BodyType[] bodyTypes = BodyType.values();
            for(int i = 0; i < bodyTypes.length; i++){
                System.out.print("   " + i + ". " + bodyTypes[i].toString() + "\n");
            }
            bodyType = BodyType.valueOf((bodyTypes[ConsoleReader.getInt()]).toString());

            return new Object[] {res, make, model, price, fuelConsumption,
                    power, year, fuelType, seatCount, doorCount, bodyType};
        }else {
            int capacity;
            TruckCategory truckCategory;

            System.out.print("Enter capacity :");
            capacity = ConsoleReader.getInt();

            TruckCategory[] truckCategories = TruckCategory.values();
            for (int i = 0; i < truckCategories.length; i++) {
                System.out.print("   " + i + ". " + truckCategories[i].toString() + "\n");
            }
            truckCategory = TruckCategory.valueOf((truckCategories[ConsoleReader.getInt()]).toString());

            return new Object[]{res, make, model, price, fuelConsumption,
                    power, year, fuelType, capacity, truckCategory};
        }
    }

    /**
     * Show message.
     *
     * @param message the message
     */
    public static void showMessage(String message){
        System.out.println(message);
    }

    /**
     * Get action int.
     *
     * @return the int
     */
    public static int getAction(){
        System.out.print("\nInput command('13' to see more info): ");
        return ConsoleReader.getInt();
    }

    /**
     * Get index int.
     *
     * @return the int
     */
    public static int getIndex(){
        System.out.print("\nInput index of vehicle: ");
        return ConsoleReader.getInt();
    }

    /**
     * Print available actions.
     */
    public static void printAvailableActions(){
        System.out.println("1. Exit");
        System.out.println("2. Log out");
        System.out.println("3. Buy vehicle");
        System.out.println("4. Show vehicles");
        System.out.println("5. Find by make");
        System.out.println("6. Find by year");
        System.out.println("7. Alphabet sort");
        System.out.println("8. Year sort");
        System.out.println("9. Add vehicle");
        System.out.println("10. Delete vehicle");
        System.out.println("11. Update");
        System.out.println("12. Show purchases");
    }
}
