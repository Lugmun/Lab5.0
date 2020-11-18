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
                long presentId = Long.parseLong(mstr[0]);
                Set<Long> keys = hashtable.keySet();
                for(long key : keys) {
                    if (presentId == key) {
                        if (hashtable.get(presentId).compareTo(hashtable.get(key)) > 0) {
                            FieldOfCityChecker fieldOfCityChecker = new FieldOfCityChecker();
                            City cityToPut = fieldOfCityChecker.checkEverything(nextRecord, -1);
                            //hashtable.put(cityToPut.getId(), cityToPut);
                            hashtable.replace(presentId, cityToPut);
                            System.out.println("Город " + presentId + " был успешно изменён");
                        } else {
                            System.out.println("Значения полей меньше имеющихся или они равны");
                        }
                    }
                }
            } catch (Exception e){
                if (e instanceof NumberFormatException) {System.out.println("ID должен быть типа long от 0 до "+Long.MAX_VALUE);}
                e.printStackTrace();
            }
        }else {
            System.out.println("Коллекция пуста");
        }
    }
}
