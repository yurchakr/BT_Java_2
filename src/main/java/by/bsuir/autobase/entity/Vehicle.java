package by.bsuir.autobase.entity;


import by.bsuir.autobase.controller.Controller;
import by.bsuir.autobase.dao.DaoFactory;
import by.bsuir.autobase.presentation.ConsoleReader;
import by.bsuir.autobase.presentation.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * The type Vehicle.
 */
public abstract class Vehicle implements java.io.Serializable{

    private String make;
    private String model;
    private double price;
    private double fuelConsumption;
    private int power;
    private int year;
    private FuelType fuelType;
    private User manager;

    /**
     * Gets manager.
     *
     * @return the manager
     */
    public User getManager() {
        return manager;
    }

    /**
     * Sets manager.
     *
     * @param manager the manager
     */
    public void setManager(User manager) {
        this.manager = manager;
    }

    /**
     * Instantiates a new Vehicle.
     *
     * @param _make            the make
     * @param _model           the model
     * @param _price           the price
     * @param _fuelConsumption the fuel consumption
     * @param _power           the power
     * @param _year            the year
     * @param _fuelType        the fuel type
     */
    public Vehicle(String _make, String _model, double _price, double _fuelConsumption,
                   int _power, int _year, FuelType _fuelType){
        make = _make;
        model = _model;
        price = _price;
        fuelConsumption =_fuelConsumption;
        power = _power;
        year = _year;
        fuelType = _fuelType;
    }

    /**
     * Instantiates a new Vehicle.
     */
    public Vehicle() {
    }

    /**
     * Gets make.
     *
     * @return the make
     */
    public String getMake() {
        return make;
    }

    /**
     * Sets make.
     *
     * @param make the make
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Gets model.
     *
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets model.
     *
     * @param model the model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets fuel consumption.
     *
     * @return the fuel consumption
     */
    public double getFuelConsumption() {
        return fuelConsumption;
    }

    /**
     * Sets fuel consumption.
     *
     * @param fuelConsumption the fuel consumption
     */
    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    /**
     * Gets power.
     *
     * @return the power
     */
    public int getPower() {
        return power;
    }

    /**
     * Sets power.
     *
     * @param power the power
     */
    public void setPower(int power) {
        this.power = power;
    }

    /**
     * Gets year.
     *
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets year.
     *
     * @param year the year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Gets fuel type.
     *
     * @return the fuel type
     */
    public FuelType getFuelType() {
        return fuelType;
    }

    /**
     * Sets fuel type.
     *
     * @param fuelType the fuel type
     */
    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return  "\n  Make: " + make +
                "\n  Model: " + model +
                "\n  Price: "+ price +
                "\n  Feul Consumption: "+ fuelConsumption +
                "\n  Power: "+ power +
                "\n  Year: "+ year +
                "\n  Feul Type: "+ fuelType.toString() +
                (AutoBase.getCurrentUser() instanceof Manager ? "\n  Manager: " + manager.getName() : "");
    }

    /**
     * Add vehicle.
     */
    public static void addVehicle() {
        Vehicle vehicle;
        Object[] answer = Controller.addVehicleRequest();

        if ((int)answer[0] == 1){
            vehicle = new Car((String)answer[1], (String)answer[2], (double)answer[3],
                    (double)answer[4], (int)answer[5], (int)answer[6], (FuelType)answer[7],
                    (int)answer[8], (int)answer[9], (BodyType)answer[10]);
        }else{
            vehicle = new Truck((String)answer[1], (String)answer[2], (double)answer[3],
                    (double)answer[4], (int)answer[5], (int)answer[6], (FuelType)answer[7],
                    (int)answer[8], (TruckCategory)answer[9]);
        }
        vehicle.setManager(AutoBase.getCurrentUser());

        DaoFactory.getVehicleDAO().insert(vehicle);
    }

    /**
     * Get vehicles.
     */
    public static void getVehicles(){
        ArrayList<Object> vehicles = new ArrayList<Object>();
        if (DaoFactory.getVehicleDAO().getVehicles() != null)
            vehicles.addAll(DaoFactory.getVehicleDAO().getVehicles());

        Controller.printListRequest(vehicles);
    }

    /**
     * Delete vehicle vehicle.
     *
     * @param isPurchase the is purchase
     * @return the vehicle
     */
    public static Vehicle deleteVehicle(boolean isPurchase){
        Vehicle vehicle = null;
        int index = Controller.getVehicleRequest();
        ArrayList<Vehicle> vehicles = DaoFactory.getVehicleDAO().getVehicles();

        if (!(DaoFactory.getVehicleDAO().getVehicles().get(index - 1).getManager().getName().equals(AutoBase.getCurrentUser().getName())) &&
                !isPurchase)
            return vehicle;

        if (vehicles != null && index <= vehicles.size()){
            vehicle = DaoFactory.getVehicleDAO().getVehicles().get(index - 1);
            DaoFactory.getVehicleDAO().delete(index - 1);
        }

        return vehicle;
    }

    /**
     * Update vehicle.
     */
    public static void updateVehicle(){
        int index = Controller.getVehicleRequest();
        ArrayList<Vehicle> vehicles = DaoFactory.getVehicleDAO().getVehicles();


        if (vehicles != null && index <= vehicles.size()){
            DaoFactory.getVehicleDAO().delete(index - 1);
            addVehicle();
        }
    }

    /**
     * Buy vehicle.
     */
    public static void buyVehicle(){
        Vehicle boughtVehicle = deleteVehicle(true);
        Purchase purchase = new Purchase();
        purchase.setCustomer(AutoBase.getCurrentUser());
        purchase.setVehicle(boughtVehicle);
        DaoFactory.getPurchaseDAO().insert(purchase);
    }

    /**
     * Find by make array list.
     *
     * @return the array list
     */
    public static ArrayList<Object> findByMake(){
        ArrayList<Object> vehicles;
        View.showMessage("Input make");
        ConsoleReader.getString();
        String answer = ConsoleReader.getString();

        vehicles = new ArrayList<Object>(DaoFactory.getVehicleDAO().getVehiclesByMake(answer));
        return vehicles;
    }

    /**
     * Find by year array list.
     *
     * @return the array list
     */
    public static ArrayList<Object> findByYear(){
        ArrayList<Object> vehicles;
        View.showMessage("Input year");
        int answer = ConsoleReader.getInt();

        vehicles = new ArrayList<Object>(DaoFactory.getVehicleDAO().getVehiclesByYear(answer));
        return vehicles;
    }

    /**
     * Sort.
     *
     * @param cmp the cmp
     */
    public static void sort(Comparator<Vehicle> cmp){
        ArrayList<Vehicle> vehicles = DaoFactory.getVehicleDAO().getVehicles();
        Collections.sort(vehicles, cmp);
        DaoFactory.getVehicleDAO().save(vehicles);
    }
}