package Commands;

import PackageOfCity.CityHashtable;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class Save implements Command {

    @Override
    public void execute(CityHashtable hashtable) {

        try(FileOutputStream fos = new FileOutputStream("notes3.csv");
            BufferedOutputStream bos = new BufferedOutputStream(fos)) {

            Set<Long> keys = hashtable.keySet();
            for(Long key: keys){
                //cities.get(key).setId();
                byte[] buffer = hashtable.get(key).toString().getBytes();
                bos.write(buffer, 0, buffer.length);
                //System.out.println();
            }
            //bos.flush();
            //bos.close();
            System.out.println("Коллекция была записана в файл");

        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }


    }
}
