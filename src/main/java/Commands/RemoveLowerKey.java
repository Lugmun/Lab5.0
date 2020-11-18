package Commands;

import PackageOfCity.CityHashtable;

import java.util.Arrays;
import java.util.Set;

public class RemoveLowerKey implements BigCommand{
    @Override
    public void execute(CityHashtable hashtable, String str) {
        if (!hashtable.isEmpty()){
            try{
                long presentId = Long.parseLong(str);
                int prevSize = hashtable.size();
                Set<Long> keys = hashtable.keySet();
                Long[] array = keys.toArray(new Long[0]);
                for(long key : array) {
                    if (presentId > key){
                        hashtable.remove(key);
                    }
                }
                System.out.println(prevSize - hashtable.size() + " элементов было удалено");
            }catch (Exception e){
                if (e instanceof NumberFormatException) {System.out.println("ID должен быть типа long от 0 до "+Long.MAX_VALUE);}
                e.printStackTrace();
            }
        }else {
            System.out.println("Коллекция пуста");
        }
    }
}
