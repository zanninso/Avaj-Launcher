import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

class ParseException extends Exception { 
    public ParseException(String errorMessage) {
        super(errorMessage);
    }
}

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("should give one argument.");
            System.exit(0);
        }
        try {
            List<List<Object>> tokens = parseFile(args[0]);
            PrintStream fileOut = new PrintStream("simulation.txt");
            System.setOut(fileOut);
            WeatherTower weatherTower = new WeatherTower();
            int simulation_number = (int)(tokens.get(0).get(0));
            tokens.remove(0);
            for (List<Object> list : tokens) {
                Flyable obj = AircraftFactory.newAircraft((String)list.get(0), (String)list.get(1), (int)list.get(2), (int)list.get(3), (int)list.get(4));
                obj.registerTower(weatherTower);
                weatherTower.register(obj);
            }
            for(int  i = 0 ; i < simulation_number && weatherTower.getObserversCount() > 0 ; i++) {
                weatherTower.changeWeather();
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(2);
        }
    }

    public static List<List<Object>> parseFile(String filename) throws ParseException, FileNotFoundException, IOException {
        List<List<Object>> tokens = new ArrayList<List<Object>>();
        BufferedReader reader;
        int line_idx = 0;
        reader = new BufferedReader(new FileReader(filename));
		try {
			String line = reader.readLine();
            if (line == null)
                throw new ParseException("empty file");
            tokens.add(Arrays.asList(Integer.parseInt(line)));
			line = reader.readLine();
			while (line != null) {
                line_idx++;
                String[] pieces = line.split("\\s");
                if (pieces.length != 5)
                    throw new ParseException("invalide number of arguments at line: " + line_idx);
                tokens.add(Arrays.asList(pieces[0], pieces[1], Integer.parseInt(pieces[2]), Integer.parseInt(pieces[3]), Integer.parseInt(pieces[4])));
                line = reader.readLine();
			}
		} catch (Exception e) {
            throw e;
		} finally {
            reader.close();
        }
        return(tokens);
    }
}
