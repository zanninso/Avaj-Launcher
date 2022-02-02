public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private String weather[];

    private WeatherProvider() {
        weather = new String[]{"RAIN", "FOG", "SUN", "SNOW"};
    }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        double h = coordinates.getHeight() * 0.25;
        double lo = (coordinates.getLongitude() * 0.125);
        double la =  (coordinates.getLatitude() * 0.125);
        int weather_idx = (int)Math.round(Math.abs(h + lo - la)) % 4;
        return weather[weather_idx];
    }
}
