package Commands;

import PackageOfCity.CityHashtable;

import java.util.Set;

public class RemoveLowerKey implements BigCommand{
    @Override
    public void execute(CityHashtable hashtable, String str) {
        if (!hashtable.isEmpty()){
            try{
                long presentId = Long.valueOf(str);
                int prevSize = hashtable.size();
                Set<Long> keys = hashtable.keySet();
                for(long key : keys) {
                    if (presentId > key){
                        hashtable.remove(key);
                    }
                }
                System.out.println(prevSize - hashtable.size() + " елементов было удалено");
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            System.out.println("Collection is empty");
        }
    }
}
