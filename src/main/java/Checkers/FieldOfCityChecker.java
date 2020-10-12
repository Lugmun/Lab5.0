package Checkers;

import PackageOfCity.*;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class FieldOfCityChecker implements Checker {

    public static long previousID = 0;

    public static long generateId() {
        Long id = previousID + 1;
        previousID = id;
        return id;
    }

    public static Climate setClimate(String str){
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


    @Override
    public City checkEverything(String[] str) {
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        //String[] nextRecord = str.split(";", 10);

        String name = null;
        double x = 0;
        Integer y = 0;
        Long area = null;
        long population = 0;
        Double metersAboveTheSea = null;
        Climate climate = null;
        Government government = null;
        StandardOfLiving standardOfLiving = null;
        Human governor = null;

        counter = counter + 1;

        City newCity = null;

        if (str.length == 10) {
            long id = generateId();

            if (str[0] != null) {
                name = str[0];
            } else {
                System.out.println("Field <<Name>> is null. Please, enter the field in " + counter + "city");
                scanner.nextLine();
            }
            try {
                x = Double.parseDouble(str[1]);
            } catch (NumberFormatException e) {
                while (Double.valueOf(x).equals(null)) {
                    System.out.println("NumberFormatException. Please, enter second field in " + counter + "city with type double");
                    x = Double.parseDouble(scanner.nextLine());
                }
            }
            try {
                y = Integer.valueOf(str[2]);
            } catch (NumberFormatException e) {
                System.out.println("NumberFormatException. Please, enter third field in " + counter + "city with type int");
                scanner.nextLine();
            }
            Coordinates coordinates = new Coordinates(x, y);
            ZonedDateTime creationDate = ZonedDateTime.now();
            try {
                area = Long.valueOf(str[3]);
            } catch (NumberFormatException e) {
                System.out.println("NumberFormatException. Please, enter forth field in " + counter + "city with type long");
                scanner.nextLine();
            }
            try {
                population = Long.parseLong(str[4]);
            } catch (NumberFormatException e) {
                System.out.println("NumberFormatException. Please, enter fifth field in " + counter + "city with type long");
                scanner.nextLine();
            }
            try {
                if (str[5] != null) {
                    metersAboveTheSea = Double.valueOf(str[5]);
                } else {
                    System.out.println("Поле metersAboveTheSea в " + counter + " городе будет null");
                }
            } catch (NumberFormatException e) {
                System.out.println("NumberFormatException. Please, enter sixth field in " + counter + "city with type double");
                scanner.nextLine();
            }
            if ((Climate.POLAR_ICECAP.toString().equals(str[6])) || (Climate.STEPPE.toString().equals(str[6])) ||
                    (Climate.SUBARCTIC.toString().equals(str[6])) || (Climate.TROPICAL_SAVANNA.toString().equals(str[6]))) {
                climate = setClimate(str[6]);
            } else {
                System.out.println("Поле Climate в " + counter + " городе будет null");
            }
            if ((Government.ANARCHY.toString().equals(str[7])) || (Government.CORPORATOCRACY.toString().equals(str[7])) ||
                    (Government.ETHNOCRACY.toString().equals(str[7])) || (Government.NOOCRACY.toString().equals(str[7])) ||
                    (Government.PLUTOCRACY.toString().equals(str[7]))) {
                government = setGovernment(str[7]);
            } else {
                System.out.println("Поле Government в " + counter + " городе будет null");
            }
            if ((StandardOfLiving.HIGH.toString().equals(str[8])) || (StandardOfLiving.MEDIUM.toString().equals(str[8])) ||
                    (StandardOfLiving.NIGHTMARE.toString().equals(str[8])) || (StandardOfLiving.ULTRA_HIGH.toString().equals(str[8])) ||
                    (StandardOfLiving.ULTRA_LOW.toString().equals(str[8]))) {
                standardOfLiving = setStandartOfLiving(str[8]);
            } else {
                System.out.println("Поле StandardOfLiving в " + counter + " городе будет  null");
            }
            if (str[9] != null) {
                governor = new Human(str[9]);
            } else {
                System.out.println("Поле Governor в " + counter + " городе будет null");
            }
            newCity = new City(id, name, coordinates, creationDate, area, population, metersAboveTheSea, climate, government, standardOfLiving, governor);
            //CityHashtable newCity = new CityHashtable();

            //hashtable.put(id, new City(id, name, coordinates, creationDate, area, population, metersAboveTheSea, climate, government, standardOfLiving, governor));
            //hashtable.setAuthDateTime(LocalDateTime.now());

                    /*
                    Set<Long> keys = newCity.keySet();
                    for(Long key: keys){

                    }*/

        } else {
            System.out.println("Not enough fields in that line" + "\n" + "Please, correct your file with the necessary amount of fields: 10");
            System.exit(0);
        }
        return newCity;
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



