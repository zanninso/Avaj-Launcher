
class NegativeCoordinatesException extends Exception { 
    public NegativeCoordinatesException(String errorMessage) {
        super(errorMessage);
    }
}

class OutOfRangeException extends Exception { 
    public OutOfRangeException(String errorMessage) {
        super(errorMessage);
    }
}

public class Coordinates
{
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude ,int latitude ,int height) throws NegativeCoordinatesException, OutOfRangeException
    {
        if (longitude < 0 || latitude < 0)
            throw new NegativeCoordinatesException("negative coordinates: " + longitude + ", " + latitude );
        if (height < 0 || height > 100)
            throw new OutOfRangeException("height shoudl be in (0 - 100): " + height);
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
    
    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "longtitude: " + longitude + ", latitude: " + latitude + ", heigth:" + height;
    }
}