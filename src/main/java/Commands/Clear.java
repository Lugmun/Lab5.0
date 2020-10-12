package Commands;

import PackageOfCity.CityHashtable;

public class Clear implements Command {

    @Override
    public void execute(CityHashtable hashtable) {
        if(!hashtable.isEmpty()){
            hashtable.clear();
            System.out.println("Collection was cleared successfully");
        }else{
            System.out.println("Collection is empty");
        }
    }
}
