package by.bsuir.autobase.entity;

/**
 * The type Car.
 */
public class Car extends  Vehicle implements java.io.Serializable{

    private int seatCount;
    private BodyType bodyType;
    private int doorCount;

    /**
     * Instantiates a new Car.
     */
    public Car() {
    }

    /**
     * Instantiates a new Car.
     *
     * @param _make            the make
     * @param _model           the model
     * @param _price           the price
     * @param _fuelConsumption the fuel consumption
     * @param _power           the power
     * @param _year            the year
     * @param _fuelType        the fuel type
     * @param _seatCount       the seat count
     * @param _doorCount       the door count
     * @param _bodyType        the body type
     */
    public Car(String _make, String _model, double _price, double _fuelConsumption,
               int _power, int _year, FuelType _fuelType, int _seatCount, int _doorCount, BodyType _bodyType){
        super(_make, _model, _price, _fuelConsumption, _power, _year, _fuelType);

        seatCount = _seatCount;
        doorCount  =_doorCount;
        bodyType = _bodyType;
    }

    /**
     * Gets seat count.
     *
     * @return the seat count
     */
    public int getSeatCount() {
        return seatCount;
    }

    /**
     * Sets seat count.
     *
     * @param seatCount the seat count
     */
    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    /**
     * Gets body type.
     *
     * @return the body type
     */
    public BodyType getBodyType() {
        return bodyType;
    }

    /**
     * Sets body type.
     *
     * @param bodyType the body type
     */
    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    /**
     * Gets door count.
     *
     * @return the door count
     */
    public int getDoorCount() {
        return doorCount;
    }

    /**
     * Sets door count.
     *
     * @param doorCount the door count
     */
    public void setDoorCount(int doorCount) {
        this.doorCount = doorCount;
    }

    @Override
    public String toString() {

        return  super.toString() +
                "\n  SeatCount: " + seatCount +
                "\n  DoorCount: " + doorCount +
                "\n  BodyType: "+ bodyType.toString();
    }
}

