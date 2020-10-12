package Commands;

import PackageOfCity.City;
import PackageOfCity.CityHashtable;
import com.opencsv.CSVReader;

public class UpdateId implements BigCommand  {
    @Override
    public void execute(CityHashtable hashtable, String str) {

        if (!hashtable.isEmpty()) {
            String[] mstr = str.split(" ", 2);
            if (mstr.length == 2)
                try {
                    mstr[1] = mstr[1].replaceAll("[{}]", "");
                    String[] fields = mstr[1].split(";", 10);
                    for (String field: fields) {

                    }
                    //System.out.println(mstr[1]);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            //System.out.println(str);
        }
    }
}
