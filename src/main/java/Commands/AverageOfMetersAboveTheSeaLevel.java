package Commands;

import Checkers.FieldOfCityChecker;
import PackageOfCity.CityHashtable;

import java.util.Set;

public class AverageOfMetersAboveTheSeaLevel implements Command {


    @Override
    public void execute(CityHashtable hashtable) {

        double value = 0;

        if (!hashtable.isEmpty()) {
            Set<Long> keys = hashtable.keySet();
            double sumValue = 0; int i = 0;

            for(long key : keys) {
                if (hashtable.get(key).getMetersAboveSeaLevel()!=null) {
                    double somevalue = hashtable.get(key).getMetersAboveSeaLevel();
                    sumValue = sumValue + value;
                    i = i+1;
                }

            }
            value = sumValue/i;

        } else {
            System.out.println("Коллекция пуста");
        }
        System.out.println("Среднее значение: "+value);
    }
}
