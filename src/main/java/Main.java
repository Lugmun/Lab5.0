

import com.opencsv.CSVWriter;
import java.io.*;
import java.time.ZonedDateTime;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        //System.out.println("Hello, World! Now you can try to work)");

        // write your code here
        FileConverter fc = new FileConverter();

        /*
        try {
            System.out.println("введите путь к файлу");
            Scanner scanner = new Scanner(System.in);
            fc.fileReaderLineByLine(scanner.nextLine());

        } catch (OutOfMemoryError e) {
            System.out.println("File is too weight");
        }

         */


        // CityHashtable cities = new CityHashtable();
        /*
        City c1 = new City("AAAA", new Coordinates(1d, 15), ZonedDateTime.now(), 5L, 44, 364d, Climate.POLAR_ICECAP, Government.NOOCRACY, StandardOfLiving.MEDIUM, new Human("nick"));
        City c2 = new City("BBBB", new Coordinates(2d, -9), ZonedDateTime.now(), 77L, 1111111, 36d, Climate.STEPPE, Government.ANARCHY, StandardOfLiving.MEDIUM, new Human("nick2"));
        City c3 = new City("CCCC", new Coordinates(-3d, 44), ZonedDateTime.now(), 15L, 1, 34d, Climate.TROPICAL_SAVANNA, Government.ETHNOCRACY, StandardOfLiving.HIGH, new Human("nick3"));
        City c4 = new City("hhhh", new Coordinates(4d, 100), ZonedDateTime.now(), 50L, 34958, 345d, Climate.SUBARCTIC, Government.PLUTOCRACY, StandardOfLiving.ULTRA_LOW, new Human("nick4"));

        //Set<Long> keys = cities.keySet();
        //for(Long key: keys) {
           // cities.get(key).setId();
           // cities.put(cities.get(key).getId(), cities.get(key));
           // System.out.println(cities.get(key));
        c1.setId(); c2.setId(); c3.setId(); c4.setId();

        cities.put(c1.getId(), c1);
        cities.put(c2.getId(), c2);
        cities.put(c3.getId(), c3);
        cities.put(c4.getId(), c4);
        System.out.println(c3 == cities.put(c4.getId(), c4));
        */

        /*
        try {
            System.out.println("Please, enter the path of the file");
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            if (str != null) {
                while (str != null) {

                    File file = new File(str);

                    if (file.exists()) {
                        if (file.canRead()) {
                            Terminal t = new Terminal(fc.hashtable);
                            t.start();
                        } else {
                            System.out.println("File cannot be read");
                        }
                    } else {
                        System.out.println("File is not exist");
                    }
                    continue;
                }

            } else {
                System.out.println("Path was not found");
                System.exit(0);
            }
        }catch (OutOfMemoryError e){

            System.out.println("Sorry");

            System.exit(0);

        }

         */


        try {
            //System.out.println("Enter your file");
            //Scanner scanner = new Scanner(System.in);
            //String filename = args[0].trim();
            //File f = new File(filename);
            if (!args[0].trim().isEmpty()) {
                fc.fileReaderLineByLine(args[0].trim());
                Terminal t = new Terminal(fc.hashtable);
                t.start();
            } else {
                System.out.println("Path was not found");
            }
        } catch (Exception e) {
            if (e instanceof ArrayIndexOutOfBoundsException) {
                System.out.println("Не был передан файл в качестве: аргумент командной строки");
            } else {
                System.out.println("Файл слишком большой по объёму");
            }
        }


        /*
        //запись в файл с помощью java.io.BufferedOutputStream
        try(FileOutputStream fos = new FileOutputStream("notes2.csv");
            BufferedOutputStream bos = new BufferedOutputStream(fos)) {

               Set<Long> keys = fc.hashtable.keySet();
            for(Long key: keys){
                //cities.get(key).setId();
                byte[] buffer = fc.hashtable.get(key).toString().getBytes();
                bos.write(buffer, 0, buffer.length);
            }
            bos.flush();
            //bos.close();

        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }


        //Terminal t = new Terminal();

         */

    }
}
