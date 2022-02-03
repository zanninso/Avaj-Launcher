public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    
    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }
    
    private String getWeatherMsg(String weather) {
        switch (weather) {
            case "SUN":
                return "This is hot.";
            case "RAIN":
                return "I like it when it rains hard.";
            case "FOG":    
                return "Try to get out from here.";
            case "SNOW":
                return "My rotor is going to freeze!";
            default:
                return "";
        }
    }

    public void updateConditions() throws NegativeCoordinatesException, OutOfRangeException
    {
        if (weatherTower == null)
            throw new RuntimeException("weatherTower not registred");
        String weather = weatherTower.getWeather(coordinates);
        int longitude = coordinates.getLongitude();
        int latitude = coordinates.getLatitude();
        int height = coordinates.getHeight();
        switch (weather) {
            case "SUN":
                longitude = Math.max(longitude, longitude + 10);
                height = Math.min(100, height + 2);
                break;
            case "RAIN":
                longitude = Math.max(longitude, longitude + 5);
                break;
            case "FOG":    
                longitude = Math.max(longitude, longitude + 1);
                break;
            case "SNOW":
                height = Math.max(0, height - 12);
                break;
        }
        if (height > 100)
            height = 100;
        System.out.println(getAid() + ": " + getWeatherMsg(weatherTower.getWeather(coordinates)));
        coordinates = new Coordinates(longitude, latitude, height);
        if (height <= 0)
            weatherTower.unregister(this);
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }

    public String getAid() {
        return ("Helicopter#" + name + "(" + id + ")");
    }

    public String getCoordinates() {
        return super.getStringCoordinates();
    }
}
