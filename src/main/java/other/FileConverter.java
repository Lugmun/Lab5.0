package other;//для конвертации файлов в коллекцию объектов класса City

import Checkers.FieldOfCityChecker;
import PackageOfCity.*;
import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;


//import org.supercsv.*;

public class FileConverter {

    //public static long previousID = 0;
    public CityHashtable hashtable = new CityHashtable();

    /*
    public FileConverter(Hashtable<Long, City> hashtable){
        this.hashtable = hashtable;
    }

     */

    /*public static long generateId() {
        long id = System.currentTimeMillis() % 10000000000L;
        if (id <= previousID) {
            id = previousID + 1;
        }
        previousID = id;
        return id;
    }

     */

    /*public static Climate setClimate(String str){
        Climate cl = null;
        while (cl == null) {
            switch (str) {
                case "TROPICAL_SAVANNA":
                    cl = Climate.TROPICAL_SAVANNA;
                    break;
                case "SUBARCTIC":
                    cl = Climate.SUBARCTIC;
                    break;
                case "STEPPE":
                    cl = Climate.STEPPE;
                    break;
                case "POLAR_ICECAP":
                    cl = Climate.POLAR_ICECAP;
                    break;
                default:
                    //throw new IllegalStateException("Unexpected value: " + str);
                    //System.out.println("Wrong value");
            }
        }
        return cl;
    }

    public static Government setGovernment(String str){
        Government go = null;
        while (go == null) {
            switch (str) {
                case "PLUTOCRACY":
                    go = Government.PLUTOCRACY;
                    break;
                case "NOOCRACY":
                    go = Government.NOOCRACY;
                    break;
                case "ETHNOCRACY":
                    go = Government.ETHNOCRACY;
                    break;
                case "CORPORATOCRACY":
                    go = Government.CORPORATOCRACY;
                    break;
                case "ANARCHY":
                    go = Government.ANARCHY;
                    break;
                default:
                    //throw new IllegalStateException("Unexpected value: " + str);
                    //System.out.println("Wrong value");
            }
        }
        return go;
    }

    public static StandardOfLiving setStandartOfLiving(String str){
        StandardOfLiving sol = null;
        while (sol == null) {
            switch (str) {
                case "ULTRA_LOW":
                    sol = StandardOfLiving.ULTRA_LOW;
                    break;
                case "ULTRA_HIGH":
                    sol = StandardOfLiving.ULTRA_HIGH;
                    break;
                case "NIGHTMARE":
                    sol = StandardOfLiving.NIGHTMARE;
                    break;
                case "MEDIUM":
                    sol = StandardOfLiving.MEDIUM;
                    break;
                case "HIGH":
                    sol = StandardOfLiving.HIGH;
                    break;
                default:
                    //throw new IllegalStateException("Unexpected value: " + str);
                    //System.out.println("Wrong value");
            }
        }
        return sol;
    }

     */

    //public City objectofcollection = new City();

    public void fileReaderLineByLine(String csvPath){

        File csvFile = new File(csvPath);

        if(!csvFile.exists()){
            System.out.println("File does not exist");
            System.exit(0);
        }
        if(!csvFile.isFile()){
            System.out.println("This is not a file");
            System.exit(0);
        }
        if(!csvFile.canRead()){
            System.out.println("File is unreachable");
            System.exit(0);
        }
        if(!csvPath.endsWith(".csv")){
            System.out.println("This is not a csv-file");
            System.exit(0);
        }

        try(FileReader fr = new FileReader(csvPath)){
            CSVReader csvReader = new CSVReader(fr, ';');



            int counter = 0;
            String[] nextRecord;

            while ((nextRecord = csvReader.readNext())!= null){

                counter = counter + 1;

                FieldOfCityChecker fieldOfCityChecker = new FieldOfCityChecker();
                City cityToPut = fieldOfCityChecker.checkEverything(nextRecord, counter);
                cityToPut.setId(City.generateId());
                hashtable.put(cityToPut.getId(), cityToPut);
                hashtable.setAuthDateTime(ZonedDateTime.now());

                /*
                String name = null; double x = 0; Integer y = 0; Long area = null;
                long population = 0; Double metersAboveTheSea = null; Climate climate = null;
                Government government = null; StandardOfLiving standardOfLiving = null;
                Human governor = null;

                counter = counter + 1;

                if (nextRecord.length == 10) {
                    //long id = generateId();

                    if (nextRecord[0] != null){
                        name = nextRecord[0];
                    } else {
                        System.out.println("Field <<Name>> is null. Please, correct the field in "+counter+"city");
                        System.exit(0);
                    }
                    try{
                        x = Double.parseDouble(nextRecord[1]);
                    } catch (NumberFormatException e) {
                        System.out.println("NumberFormatException. Please, correct second field in "+counter+"city");
                        System.exit(0);
                    }
                    try{
                        y = Integer.valueOf(nextRecord[2]);
                    } catch (NumberFormatException e) {
                        System.out.println("NumberFormatException. Please, correct third field in "+counter+"city");
                        System.exit(0);
                    }
                    Coordinates coordinates = new Coordinates(x, y);
                    ZonedDateTime creationDate = ZonedDateTime.now();
                    try{
                        area = Long.valueOf(nextRecord[3]);
                    } catch (NumberFormatException e) {
                        System.out.println("NumberFormatException. Please, correct forth field in "+counter+"city");
                        System.exit(0);
                    }
                    try{
                        population = Long.parseLong(nextRecord[4]);
                    } catch (NumberFormatException e) {
                        System.out.println("NumberFormatException. Please, correct fifth field in "+counter+"city");
                        System.exit(0);
                    }
                    try{
                        if (nextRecord[5] != null) {
                            metersAboveTheSea = Double.valueOf(nextRecord[5]);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("NumberFormatException. Please, correct sixth field in "+counter+"city");
                        System.exit(0);
                    }
                    if ((Climate.POLAR_ICECAP.toString().equals(nextRecord[6])) || (Climate.STEPPE.toString().equals(nextRecord[6])) ||
                            (Climate.SUBARCTIC.toString().equals(nextRecord[6])) || (Climate.TROPICAL_SAVANNA.toString().equals(nextRecord[6]))) {
                        climate = setClimate(nextRecord[6]);
                    } else {
                        System.out.println("Поле Climate в "+counter+" городе будет null");
                    }
                    if ((Government.ANARCHY.toString().equals(nextRecord[7])) || (Government.CORPORATOCRACY.toString().equals(nextRecord[7])) ||
                            (Government.ETHNOCRACY.toString().equals(nextRecord[7])) || (Government.NOOCRACY.toString().equals(nextRecord[7])) || (Government.PLUTOCRACY.toString().equals(nextRecord[7]))) {
                        government = setGovernment(nextRecord[7]);
                    } else {
                        System.out.println("Поле Government в "+counter+" городе будет null");
                    }
                    if ((StandardOfLiving.HIGH.toString().equals(nextRecord[8])) || (StandardOfLiving.MEDIUM.toString().equals(nextRecord[8])) ||
                            (StandardOfLiving.NIGHTMARE.toString().equals(nextRecord[8])) || (StandardOfLiving.ULTRA_HIGH.toString().equals(nextRecord[8])) || (StandardOfLiving.ULTRA_LOW.toString().equals(nextRecord[8]))) {
                        standardOfLiving = setStandartOfLiving(nextRecord[8]);
                    } else {
                        System.out.println("Поле StandardOfLiving в "+counter+" городе будет  null");
                    }
                    if (nextRecord[9] != null){
                        governor = new Human(nextRecord[9]);
                    } else {
                        System.out.println("Поле Governor в "+counter+" городе будет null");
                    }

                    //CityHashtable newCity = new CityHashtable();

                    hashtable.put(id, new City(id, name, coordinates, creationDate, area, population, metersAboveTheSea, climate, government, standardOfLiving, governor));
                    hashtable.setAuthDateTime(LocalDateTime.now());

                    /*
                    Set<Long> keys = newCity.keySet();
                    for(Long key: keys){

                    }

                } else {
                    System.out.println("Not enough fields in that line"+"\n"+"Please, correct your file with the necessary amount of fields: 10");
                    System.exit(0);
                }
                 */
            }


            /*
            for (City c : newCity) {

                if (!collection.contains(c)) {

                    np.checkEverything(c);

                    wf.checkEverything(c);

                    collection.add(c);

                }

            }

             */

        }

        catch (Exception e){
            e.printStackTrace();
        }


    }
}
