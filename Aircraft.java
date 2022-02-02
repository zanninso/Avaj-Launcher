public class Aircraft {
    protected Long id;
    protected String name;
    protected Coordinates coordinates;
    private static Long idCounter = 0L;

    protected Aircraft(String name, Coordinates coordinates) {
        this.id = nextId();
        this.name = name;
        this.coordinates = coordinates;
    }

    private static Long nextId()
    {
        return(idCounter++);
    }
}
