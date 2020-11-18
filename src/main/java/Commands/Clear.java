package Commands;

import PackageOfCity.CityHashtable;

public class Clear implements Command {

    @Override
    public void execute(CityHashtable hashtable) {
        if(!hashtable.isEmpty()){
            hashtable.clear();
            System.out.println("Коллекция была очищена");
        } else {System.out.println("Коллекция пуста");}
    }
}
