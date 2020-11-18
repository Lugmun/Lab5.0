package Commands;


import PackageOfCity.CityHashtable;


public class Info implements Command {

    @Override
    public void execute(CityHashtable hashtable) {
        if(hashtable.isEmpty()){
            System.out.println("Коллекция пуста");
        }else {
            System.out.println("Количество городов в хранилище: " + hashtable.size() + "\n" +
                    "Дата инициализации: " + hashtable.getAuthDateTime() + "\n" +
                    "Тип коллекции: " + hashtable.getClass().getSimpleName());
        }
    }
}
