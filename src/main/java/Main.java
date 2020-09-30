import com.opencsv.CSVWriter;

import java.io.*;
import java.time.ZonedDateTime;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        System.out.println("Hello, World!");



       /* FileConverter fc = new FileConverter();
        System.out.println("введите путь к файлу");
        fc.fileReaderLineByLine(scanner.nextLine());

        */
        City c1 = new City(1, "AAAA", new Coordinates(1d, 15), ZonedDateTime.now(), 5L, 44, 364d, Climate.POLAR_ICECAP, Government.NOOCRACY, StandardOfLiving.MEDIUM, new Human("nick"));
        City c2 = new City(2, "BBBB", new Coordinates(2d, -9), ZonedDateTime.now(), 77L, 1111111, 36d, Climate.STEPPE, Government.ANARCHY, StandardOfLiving.MEDIUM, new Human("nick2"));
        City c3 = new City("CCCC", new Coordinates(-3d, 44), ZonedDateTime.now(), 15L, 1, 34d, Climate.TROPICAL_SAVANNA, Government.ETHNOCRACY, StandardOfLiving.HIGH, new Human("nick3"));
        City c4 = new City("hhhh", new Coordinates(4d, 100), ZonedDateTime.now(), 50L, 34958, 345d, Climate.SUBARCTIC, Government.PLUTOCRACY, StandardOfLiving.ULTRA_LOW, new Human("nick4"));


        Hashtable<Long, City> cities = new Hashtable<>();
        cities.put(c1.getId(), c1);
        cities.put(c2.getId(), c2);
        cities.put(c3.getId(), c3);


        try(FileOutputStream fos = new FileOutputStream("notes.csv");
            BufferedOutputStream bos = new BufferedOutputStream(fos))
        {
            // перевод строки в байты


            //byte[] buffer = textForWrite.getBytes();
            //bos.write(buffer, 0, buffer.length);
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
