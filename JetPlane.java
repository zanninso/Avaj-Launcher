public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    
    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
        weatherTower = null;
    }

    private String getWeatherMsg(String weather) {
        switch (weather) {
            case "SUN":
                return "Ooooh finally we got the sun.";
            case "RAIN":
                return "It's raining. Better watch out for lightings.";
            case "FOG":    
                return "OMG! Winter is coming!";
            case "SNOW":
                return "Harry up it's snowing man";
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
                latitude += 10;
                height += 2;
                break;
            case "RAIN":
                latitude += 5;
                break;
            case "FOG":    
                latitude += 1;
                break;
            case "SNOW":
                height -= 7;
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
        return ("JetPlane#" + name + "(" + id + ")");
    }
}
