package Commands;


import PackageOfCity.City;
import PackageOfCity.CityHashtable;

public class Show implements Command {

    @Override
    public void execute(CityHashtable hashtable) {

        if (hashtable.isEmpty()){

            System.out.println("Collection is empty");

        }else{

            for (City c: hashtable.values()){
                System.out.println(c.customToString());
                System.out.println("--------------------------");

            }

           // hashtable.entrySet().toString();

        }

    }
}
