package Commands;

import Checkers.FieldOfCityChecker;
import PackageOfCity.City;
import PackageOfCity.CityHashtable;

import java.util.Set;

public class Insert implements BigCommand {


    @Override
    public void execute(CityHashtable hashtable, String str) {

        if (!hashtable.isEmpty()) {
            String[] mstr = str.split(" ", 2);

            if (mstr.length == 2) {
                try {
                    mstr[1] = mstr[1].replaceAll("[{}]", "");
                    String[] nextRecord = mstr[1].split(";", 10);
                    long neededId = Long.valueOf(mstr[0]);
                    Set<Long> keys = hashtable.keySet();
                    for(long key : keys){
                        if (neededId != key) {
                            FieldOfCityChecker fieldOfCityChecker = new FieldOfCityChecker();
                            City cityToPut = fieldOfCityChecker.checkEverything(nextRecord);
                            cityToPut.setId(neededId);
                            hashtable.put(cityToPut.getId(), cityToPut);
                            System.out.println("Город с id " + neededId + " был успешно добавлен");
                        } else {System.out.println("Город c таким id существует");}
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                //System.out.println(str);
            }
        } else {
            String[] mstr = str.split(" ", 2);
            if (mstr.length == 2) {
                String[] nextRecord = mstr[1].split(";", 10);
                long neededId = Long.valueOf(mstr[0]);
                FieldOfCityChecker fieldOfCityChecker = new FieldOfCityChecker();
                City cityToPut = fieldOfCityChecker.checkEverything(nextRecord);
                cityToPut.setId(neededId);
                hashtable.put(cityToPut.getId(), cityToPut);
                System.out.println("Город с id " + neededId + " был успешно добавлен");
            }
        }

    }
}
