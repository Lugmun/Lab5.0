package Commands;

import Checkers.FieldOfCityChecker;
import PackageOfCity.City;
import PackageOfCity.CityHashtable;

import java.util.Set;

public class ReplaceIfGreater implements BigCommand{
    @Override
    public void execute(CityHashtable hashtable, String str) {
        if (!hashtable.isEmpty()){

            try{
                String[] mstr = str.split(" ", 2);
                mstr[1] = mstr[1].replaceAll("[{}]", "");
                String[] nextRecord = mstr[1].split(";", 10);
                long presentId = Long.valueOf(str);
                Set<Long> keys = hashtable.keySet();
                for(long key : keys) {
                    if (presentId == key) {
                        if (hashtable.get(presentId).compareTo(hashtable.get(key)) > 0) {
                            FieldOfCityChecker fieldOfCityChecker = new FieldOfCityChecker();
                            City cityToPut = fieldOfCityChecker.checkEverything(nextRecord);
                            hashtable.put(cityToPut.getId(), cityToPut);
                            hashtable.replace(presentId, cityToPut);
                            System.out.println("Город " + presentId + " был успешно изменет");
                        } else {
                            System.out.println("Значения полей меньше имеющихся");
                        }
                    }
                    System.out.println("Город " + presentId + " был успешно изменет");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            System.out.println("Коллекция пуста");
        }
    }
}
