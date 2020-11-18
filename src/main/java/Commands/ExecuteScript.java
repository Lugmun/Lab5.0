package Commands;

import PackageOfCity.CityHashtable;
import other.Terminal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ExecuteScript implements BigCommand{

    private Terminal fileTerminal;

    public ExecuteScript (Terminal t) {
        this.fileTerminal = t;
    }



    @Override
    public void execute(CityHashtable city, String str) {

        File script = new File(str);

        try (FileReader fr = new FileReader(script)) {

            Scanner scanner = new Scanner(script);
            while (scanner.hasNext()) {
                String nextLine = scanner.nextLine().trim();
                String[] nextRecord = nextLine.split(" ", 2);
                if (nextRecord.length == 1) {
                    fileTerminal.startWithParams(nextRecord[0], null);
                } else {
                    fileTerminal.startWithParams(nextRecord[0], nextRecord[1]);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
