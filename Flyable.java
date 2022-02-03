public interface Flyable {
    public void updateConditions() throws NegativeCoordinatesException, OutOfRangeException;
    public void registerTower(WeatherTower weatherTower);
    public String getAid();
    public String getCoordinates();
}
