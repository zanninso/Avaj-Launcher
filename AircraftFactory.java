
public class AircraftFactory {
    public Flyable newAircraft(String type, String name, Integer longitude, Integer latitude, Integer height)
    {
        if (type.equals("Helicopter"))
            return (new Helicopter(name, new Coordinates(longitude, latitude, height)));
        else if(type.equals("JetPlane"))
            return (new JetPlane(name, new Coordinates(longitude, latitude, height)));
        else if(type.equals("Baloon"))
            return (new Baloon(name, new Coordinates(longitude, latitude, height)));

        throw new RuntimeException("type not found");
    } 
}
