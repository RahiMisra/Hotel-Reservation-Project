public class roomRates {

    private double kingBedroomRate;
    private double queenBedroomRate;
    private double suiteBedroomRate;

    public roomRates()
    {
        kingBedroomRate = 250;
        queenBedroomRate = 199.99;
        suiteBedroomRate = 500;
    }
    public roomRates(double kingBedroomRate, double queenBedroomRate, double suiteBedroomRate)
    {
        this.kingBedroomRate= kingBedroomRate;
        this.queenBedroomRate = queenBedroomRate;
        this.suiteBedroomRate = suiteBedroomRate;
    }
    public void setKingBedRate(double kingBedroomRate){
        this.kingBedroomRate = kingBedroomRate;
    }
    public void queenKingBedRate(double queenBedroomRate){
        this.queenBedroomRate = queenBedroomRate;
    }
    public void setSuiteBedroomPrice(double suiteBedroomRate){
        this.suiteBedroomRate = suiteBedroomRate;
    }
    public double getKingBedroomPrice(){
        return kingBedroomRate;
    }
    public double getQueenBedroomPrice(){
        return queenBedroomRate;

    }
    public double getSuiteBedroomPrice(){
        return suiteBedroomRate;
    }



}
