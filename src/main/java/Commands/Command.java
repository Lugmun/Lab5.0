package Commands;

import PackageOfCity.City;
import PackageOfCity.CityHashtable;

public interface Command {
    public void execute(CityHashtable hashtable);
}
