package Checkers;

import PackageOfCity.City;
import PackageOfCity.Coordinates;

public class NullPointerChecker implements Checker2 {

    @Override
    public void checkEverything(City city) {

        if (city.getName() == null) {
            System.out.println("Looks like some of the fields contain null-values. They will be replaced automatically");
            city.setName("ID" + city.getId());
        }

        if (city.getCoordinates() == null) {
            System.out.println("Looks like some of the fields contain null-values. They will be replaced automatically");
            city.setCoordinates(new Coordinates(100f,100));
        }
        if (city.getCoordinates().getX() == null) {
            System.out.println("Looks like some of the fields contain null-values. They will be replaced automatically");
            city.getCoordinates().setX(100d);
        }

        if (city.getCoordinates().getY() == null){
            System.out.println("Looks like some of the fields contain null-values. They will be replaced automatically");
            city.getCoordinates().setY(100);
        }

        if (city.getArea() == null){
            System.out.println("Looks like some of the fields contain null-values. They will be replaced automatically");
            city.setArea(51L);
        }

        if (Double.valueOf(city.getMetersAboveSeaLevel()) == null){
            System.out.println("Looks like some of the fields contain null-values. They will be replaced automatically");
            city.setMetersAboveSeaLevel(1337d);
        }





        /*
        if (city.getEstablishmentDate() == null){

            System.out.println("Looks like some of the fields contain null-values. They will be replaced automatically");



            city.setEstablishmentDate(LocalDate.now());

        }



        if (Long.valueOf(city.getCarCode()) == null){

            System.out.println("Looks like some of the fields contain null-values. They will be replaced automatically");



            city.setCarCode(1488L);

        }


         */


        /*

        if (city.getStandardOfLiving() == null){

            city.setStandardOfLiving(StandardOfLiving.MEDIUM);

        }



        if (city.getGovernor() == null){

            city.setGovernor(new Human(Date.valueOf("2020-10-10")));

        }*/

    }
}
