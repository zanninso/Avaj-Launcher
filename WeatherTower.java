public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
    }

    void changeWeather() throws NegativeCoordinatesException, OutOfRangeException {
        conditionsChanged();
    }
}
