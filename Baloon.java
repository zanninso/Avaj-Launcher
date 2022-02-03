public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    
    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    private String getWeatherMsg(String weather) {
        switch (weather) {
            case "SUN":
                return "Let's enjoy the good weather and take some pics.";
            case "RAIN":
                return "Damn you rain! You messed up my baloon.";
            case "FOG":    
                return "Don’t be afraid to go into the Mist.";
            case "SNOW":
                return "It's snowing. We're gonna crash.";
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
                longitude = Math.max(longitude, longitude + 2);
                height = Math.min(100, height + 4);
                break;
            case "RAIN":
                height = Math.max(0, height - 5);
                break;
            case "FOG":    
                height = Math.max(0, height - 3);
                break;
            case "SNOW":
                height = Math.max(0, height - 15);
                break;
        }
        System.out.println(getAid() + ": " + getWeatherMsg(weatherTower.getWeather(coordinates)));
        coordinates = new Coordinates(longitude, latitude, height);
        if (height <= 0) 
            weatherTower.unregister(this);
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }

    public String getAid() {
        return ("Baloon#" + name + "(" + id + ")");
    }

    public String getCoordinates() {
        return super.getStringCoordinates();
    }
}
