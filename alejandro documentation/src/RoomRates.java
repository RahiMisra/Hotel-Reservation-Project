/**

 *The RoomRates class represents the different room rates for a hotel reservation system.
 *It has the rates for a king bedroom, queen bedroom, and suite bedroom.
 *@author (Alejandro Ortega)
 *@version (1.2)
 */
public class RoomRates {
    /**
     * represents the rate for a king bedroom.
     */
    private double kingBedroomRate;
    /**
     * represents the rate for a queen bedroom.
     */
    private double queenBedroomRate;
    /**
     * represents the rate for a suite bedroom.
     */
    private double suiteBedroomRate;

    /**

     Constructs a RoomRates object with default room rates.
     The default rates are $250 for a king bedroom, $199.99 for a queen bedroom,
     and $500 for a suite bedroom.
     */
    public RoomRates() {
        kingBedroomRate = 250;
        queenBedroomRate = 199.99;
        suiteBedroomRate = 500;
    }
    /**

     Constructs a RoomRates object with custom room rates.
     @param kingBedroomRate the rate for a king bedroom
     @param queenBedroomRate the rate for a queen bedroom
     @param suiteBedroomRate the rate for a suite bedroom
     */
    public RoomRates(double kingBedroomRate, double queenBedroomRate, double suiteBedroomRate) {
        this.kingBedroomRate = kingBedroomRate;
        this.queenBedroomRate = queenBedroomRate;
        this.suiteBedroomRate = suiteBedroomRate;
    }
    /**

     Sets the rate for a king bedroom.
     @param kingBedroomRate the rate for a king bedroom
     */
    public void setKingBedRate(double kingBedroomRate) {
        this.kingBedroomRate = kingBedroomRate;
    }
    /**

     Sets the rate for a queen bedroom.
     @param queenBedroomRate the rate for a queen bedroom
     */
    public void setQueenBedRate(double queenBedroomRate) {
        this.queenBedroomRate = queenBedroomRate;
    }
    /**

     Sets the rate for a suite bedroom.
     @param suiteBedroomRate the rate for a suite bedroom
     */
    public void setSuiteBedroomPrice(double suiteBedroomRate) {
        this.suiteBedroomRate = suiteBedroomRate;
    }
    /**

     Gets the rate for a king bedroom.
     @return the rate for a king bedroom
     */
    public double getKingBedroomPrice() {
        return kingBedroomRate;
    }
    /**

     Gets the rate for a queen bedroom.
     @return the rate for a queen bedroom
     */
    public double getQueenBedroomPrice() {
        return queenBedroomRate;
    }
    /**

     Gets the rate for a suite bedroom.
     @return the rate for a suite bedroom
     */
    public double getSuiteBedroomPrice() {
        return suiteBedroomRate;
    }
}
