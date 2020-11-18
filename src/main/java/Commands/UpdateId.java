package Commands;

import Checkers.FieldOfCityChecker;
import PackageOfCity.City;
import PackageOfCity.CityHashtable;
import com.opencsv.CSVReader;

import java.util.Set;

public class UpdateId implements BigCommand  {

    //String[] nextRecord;

    @Override
    public void execute(CityHashtable hashtable, String str) {

        int i = 0;

        if (!hashtable.isEmpty()) {
            String[] mstr = str.split(" ", 2);

            if (mstr.length == 2) {
                try {
                    mstr[1] = mstr[1].replaceAll("[{}]", "");
                    String[] nextRecord = mstr[1].split(";", 10);
                    long neededId = Long.parseLong(mstr[0]);     //Long.valueOf(mstr[0]);
                    Set<Long> keys = hashtable.keySet();
                    for(long key : keys){
                        if (neededId == key) {
                            i = i+1;
                            //System.out.println(hashtable.remove(neededId));
                            FieldOfCityChecker fieldOfCityChecker = new FieldOfCityChecker();
                            City cityToPut = fieldOfCityChecker.checkEverything(nextRecord, -1);
                            cityToPut.setId(neededId);
                            hashtable.put(cityToPut.getId(), cityToPut);
                            System.out.println("Город с id " + neededId + " был успешно обновлён");
                        }
                    }
                    if (i==0) {System.out.println("Город не был добавлен");}

                } catch (Exception e) {
                    e.printStackTrace();
                }

            //System.out.println(str);
            }
        } else {
            System.out.println("Невозможно обновить."+"\n"+
                               "Коллекция пуста");
        }
    }
}
