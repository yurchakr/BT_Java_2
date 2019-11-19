package by.bsuir.autobase.entity;

/**
 * The type Truck.
 */
public class Truck extends Vehicle implements java.io.Serializable{

    /**
     * Instantiates a new Truck.
     */
    public Truck() {
    }

    /**
     * Instantiates a new Truck.
     *
     * @param _make            the make
     * @param _model           the model
     * @param _price           the price
     * @param _fuelConsumption the fuel consumption
     * @param _power           the power
     * @param _year            the year
     * @param _fuelType        the fuel type
     * @param _capacity        the capacity
     * @param _truckCategory   the truck category
     */
    public Truck(String _make, String _model, double _price, double _fuelConsumption,
                 int _power, int _year, FuelType _fuelType, int _capacity, TruckCategory _truckCategory){
        super(_make, _model, _price, _fuelConsumption, _power, _year, _fuelType);

        capacity = _capacity;
        truckCategory = _truckCategory;
    }

    private int capacity;
    private TruckCategory truckCategory;

    /**
     * Gets truck category.
     *
     * @return the truck category
     */
    public TruckCategory getTruckCategory() {
        return truckCategory;
    }

    /**
     * Sets truck category.
     *
     * @param truckCategory the truck category
     */
    public void setTruckCategory(TruckCategory truckCategory) {
        this.truckCategory = truckCategory;
    }

    /**
     * Gets capacity.
     *
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets capacity.
     *
     * @param capacity the capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "\n  Capacity: " + capacity +
                "\n  TruckCategory: " + truckCategory.toString();
    }
}
