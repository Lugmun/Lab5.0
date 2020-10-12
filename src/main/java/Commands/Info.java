package Commands;


import PackageOfCity.CityHashtable;


public class Info implements Command {

    @Override
    public void execute(CityHashtable hashtable) {
        if(hashtable.isEmpty()){
            System.out.println("Collection is empty");
        }else {
            System.out.println("Amount of cities in storage: " + hashtable.size() + "\n" +
                    "Date of initialization: " + hashtable.getAuthDateTime() + "\n" +
                    "Collection type: " + hashtable.getClass().getSimpleName());
        }
    }
}
