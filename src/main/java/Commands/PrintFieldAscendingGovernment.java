package Commands;

import PackageOfCity.CityHashtable;

import java.util.Set;

public class PrintFieldAscendingGovernment implements Command {
    @Override
    public void execute(CityHashtable hashtable) {
        double value = 0;

        if (!hashtable.isEmpty()) {
            Set<Long> keys = hashtable.keySet();
            double previousKey = 0; double presentKey = 0;

            for(long key : keys) {
                if (hashtable.get(key).getGovernor()!=null) {

                }

            }


        } else {
            System.out.println("Коллекция пуста");
        }
        System.out.println("Среднее значение: "+value);
    }
}
