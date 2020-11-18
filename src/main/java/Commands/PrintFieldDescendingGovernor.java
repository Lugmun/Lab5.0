package Commands;

import PackageOfCity.City;
import PackageOfCity.CityHashtable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrintFieldDescendingGovernor implements Command{

    @Override
    public void execute(CityHashtable hashtable) {
        if (!hashtable.isEmpty()) {
            //Set<Long> keys = hashtable.keySet();
            //double previousKey = 0; double presentKey = 0;
            City[] array = new City[0];
            List<City> list = Arrays.asList(hashtable.values().toArray(array));
            Collections.sort(list);
            Collections.reverse(list);
            for (City c : list) {
                System.out.println(c.getGovernor().toString());
            }
        } else System.out.println("Коллекция пуста");
    }
}
