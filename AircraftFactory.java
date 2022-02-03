
class InvalidTypeException extends Exception { 
    public InvalidTypeException(String errorMessage) {
        super(errorMessage);
    }
}

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws InvalidTypeException, OutOfRangeException, NegativeCoordinatesException
    {
        if (type.equals("Helicopter"))
            return (new Helicopter(name, new Coordinates(longitude, latitude, height)));
        else if(type.equals("JetPlane"))
            return (new JetPlane(name, new Coordinates(longitude, latitude, height)));
        else if(type.equals("Baloon"))
            return (new Baloon(name, new Coordinates(longitude, latitude, height)));
        throw new InvalidTypeException("invalid Aircraft type: " + type);
    } 
}
