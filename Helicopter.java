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

    public void updateConditions()
    {
        if (weatherTower == null)
            throw new RuntimeException("weatherTower not registred");
        String weather = weatherTower.getWeather(coordinates);
        int longitude = coordinates.getLongitude();
        int latitude = coordinates.getLatitude();
        int height = coordinates.getHeight();
        switch (weather) {
            case "SUN":
                longitude += 10;
                height += 2;
                break;
            case "RAIN":
                longitude += 5;
                break;
            case "FOG":    
                longitude += 1;
                break;
            case "SNOW":
                height -= 12;
                break;
        }
        if (height > 100)
            height = 100;
        coordinates = new Coordinates(longitude, latitude, height);
        System.out.println(getWeatherMsg(weatherTower.getWeather(coordinates)));
        if (height <= 0)
            weatherTower.unregister(this);
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }

    public String getAid() {
        return ("Helicopter#" + name + "(" + id + ")");
    }
}
