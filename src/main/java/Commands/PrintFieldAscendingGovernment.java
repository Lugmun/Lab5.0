package Commands;

import PackageOfCity.City;
import PackageOfCity.CityHashtable;

import java.util.*;

public class PrintFieldAscendingGovernment implements Command {
    @Override
    public void execute(CityHashtable hashtable) {
        double value = 0;


        if (!hashtable.isEmpty()) {
            //Set<Long> keys = hashtable.keySet();
            //double previousKey = 0; double presentKey = 0;
            City[] array = new City[0];
            List<City> list = Arrays.asList(hashtable.values().toArray(array));
            Collections.sort(list);
            for (City c : list) {
                System.out.println(c.getGovernment().toString());
            }
        } else System.out.println("Коллекция пуста");
    }
}
