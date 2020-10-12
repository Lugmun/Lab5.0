package Commands;

import PackageOfCity.City;
import PackageOfCity.CityHashtable;

public interface BigCommand {
    public void execute(CityHashtable city, String str);
}
