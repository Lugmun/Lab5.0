package Commands;

import Checkers.FieldOfCityChecker;
import PackageOfCity.City;
import PackageOfCity.CityHashtable;

import java.util.Set;

public class RemoveKey implements BigCommand {
    @Override
    public void execute(CityHashtable hashtable, String str) {
        try {
            long idToRemove = Long.parseLong(str);
            int prevSize = hashtable.size();

            if (!hashtable.isEmpty()) {

                if (hashtable.containsKey(idToRemove)) {
                    hashtable.remove(idToRemove);
                } else System.out.println("Города c таким id нет");

            } else System.out.println("Коллекция пуста");

            if (prevSize - hashtable.size() > 0) System.out.println("Город был успешно удалён");

        }catch (NumberFormatException e){
            System.out.println("ID должен быть типа long от 0 до "+Long.MAX_VALUE);
        }
    }
}
