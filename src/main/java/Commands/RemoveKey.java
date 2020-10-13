package Commands;

import Checkers.FieldOfCityChecker;
import PackageOfCity.City;
import PackageOfCity.CityHashtable;

import java.util.Set;

public class RemoveKey implements BigCommand {
    @Override
    public void execute(CityHashtable hashtable, String str) {
        try {
            long idToRemove = Long.valueOf(str);
            int prevSize = hashtable.size();

            if (!hashtable.isEmpty()) {

                Set<Long> keys = hashtable.keySet();
                for(long key : keys){
                    if (idToRemove == key) {
                        hashtable.remove(key);
                        System.out.println("Город с id " + key + " был успешно удалён");
                    } else {System.out.println("Города c таким id нет");}
                }

                /*
                if (hashtable.size() != prevSize) {
                    System.out.println("Город " + str + " был успешно удалён");
                } else {
                    System.out.println("Такого города нет");
                }

                 */
            } else {
                System.out.println("Коллекцимя пуста");
            }
        }catch (NumberFormatException e){
            System.out.println("ID должен быть от 0 до "+Long.MAX_VALUE);
        }
    }
}
