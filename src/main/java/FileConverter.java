//для конвертации файлов в коллекцию объектов класса City

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Scanner;

import static java.lang.System.*;
//import org.supercsv.*;

public class FileConverter {

    public City objectofcollection = new City();

    public static void fileReaderLineByLine(String csvPath){

        try(FileReader fr = new FileReader(csvPath)){
           // System.out.println("введите путь к файлу");
            //FileReader fr = new FileReader(csvPath);
            CSVReader csvReader = new CSVReader(fr);

            String[] nextRecord;

            while ((nextRecord = csvReader.readNext())!= null){
                for (String cell : nextRecord){
                    System.out.print(cell + "\t");
                }
                out.println();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    //public void fileReaderLineByLine(InputStream in) {
   // }
}
