package other;

import Commands.*;

import PackageOfCity.City;
import PackageOfCity.CityHashtable;

import java.util.Hashtable;
import java.util.Scanner;

public class Terminal {

    private CityHashtable hashtable;
    private Scanner scanner = new Scanner(System.in);
    private String newLine = new String();
    private Info info = new Info();
    private Show show = new Show();
    private Insert insert = new Insert();
    private UpdateId update_id = new UpdateId();
    private RemoveKey remove_key = new RemoveKey();
    private Clear clear = new Clear();
    private Save save = new Save();
    //private ExecuteScript executeScript = new ExecuteScript(this);
    private ReplaceIfGreater replace_if_greater = new ReplaceIfGreater();
    private ReplaceIfLower replace_if_lower = new ReplaceIfLower();
    private RemoveLowerKey remove_lower_key = new RemoveLowerKey();
    private AverageOfMetersAboveTheSeaLevel average_of_meters_above_the_sea_level = new AverageOfMetersAboveTheSeaLevel();
    private PrintFieldAscendingGovernment print_field_ascending_government = new PrintFieldAscendingGovernment();
    private PrintFieldDescendingGovernor print_field_descending_governor = new PrintFieldDescendingGovernor();


    public Terminal(CityHashtable hashtable){
        this.hashtable = hashtable;
    }



    /**

     *осуществляет запуск интерактивного режима

     */

    public void start(){
        System.out.println("Можете начать работать. Напечатайте 'help' для просмотра списка команд");
        while (true){
            newLine = scanner.nextLine().trim();
            String[] arr = newLine.split(" ", 2);
            if (arr.length == 1){
                commandManager(arr[0], null);
            }else{
                commandManager(arr[0],arr[1]);
            }
        }
    }

    /**

     * осуществляет запуск режима выполнения комманд с параметрами

     * @param arr1 первый параметр (название команды)

     * @param arr2 второй параметр (аргументы команды)

     */

    public void startWithParams(String arr1, String arr2){
        if (arr2 == null){
            commandManager(arr1, null);
        }else{
            commandManager(arr1,arr2);
        }
    }

    private void commandManager(String arr1, String arr2){
        if (arr2 == null){
            switch (arr1){
                case "exit":

                    System.out.println("До свидания");
                    System.exit(0);

                    break;

                case "help":

                    System.out.println("help : вывести справку по доступным командам");                                                                          //complete
                    System.out.println("info : вывести в стандартный поток вывода информацию о коллекции");                                                      //complete
                    System.out.println("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");                            //complete
                    System.out.println("insert null {element} : добавить новый элемент c заданным ключом");                                                      //complete
                    System.out.println("update id {element} : обновить значение элемента коллекции, id которого равен заданному");                               //complete
                    System.out.println("remove_key null : удалить элемент из коллекции по его ключу");                                                           //complete
                    System.out.println("clear : очистить коллекцию");                                                                                            //complete
                    System.out.println("save : сохранить коллекцию в файл");                                                                                     //complete
                    System.out.println("execute_script file_name : считать и исполнить скрипт из указанного файла");                                             //
                    System.out.println("exit : завершить программу (без сохранения в файл)");                                                                    //complete
                    System.out.println("replace_if_greater null {element} : заменить значение по ключу, если новое значение больше старого");                    //Complete
                    System.out.println("replace_if_lower null {element} : заменить значение по ключу, если новое значение меньше старого");                      //Complete
                    System.out.println("remove_lower_key null : удалить из коллекции все элементы, ключ которых меньше, чем заданный");                          //complete
                    System.out.println("average_of_meters_above_sea_level : вывести среднее значение поля metersAboveSeaLevel для всех элементов коллекции");    //complete
                    System.out.println("print_field_ascending_government : вывести значения поля government всех элементов в порядке возрастания");              //
                    System.out.println("print_field_descending_governor : вывести значения поля governor всех элементов в порядке убывания");                    //
                    break;

                case "info":
                    info.execute(hashtable);
                    break;

                case "show":
                    show.execute(hashtable);
                    break;

                case "clear":
                    clear.execute(hashtable);
                    break;
                case "save":
                    save.execute(hashtable);
                    break;

                case "insert":

                case "update":

                case "remove_key":

                case "replace_if_lower":

                case "replace_if_greater":

                    System.out.println("Null второй агрумент");
                    break;

                case "average_of_meters_above_sea_level":
                    average_of_meters_above_the_sea_level.execute(hashtable);
                    break;

                case "print_field_ascending_government":

                    print_field_ascending_government.execute(hashtable);
                    break;

                case "print_field_descending_governor":

                    print_field_descending_governor.execute(hashtable);
                    break;
                    /*
                case "execute_script":

                    System.out.println("Null script name value. Try another argument");

                    break;
                     */
                default:
                    System.out.println("Неизвестная команда, напечатайте 'help' для просмотра списка команд");
                    break;
            }

        } else{

            switch (arr1){

                case "insert":

                    insert.execute(hashtable, arr2.trim());

                    break;


                case  "update":

                    update_id.execute(hashtable, arr2.trim());

                    break;

                case "remove_key":

                    remove_key.execute(hashtable, arr2.trim());

                    break;


                case "replace_if_greater":

                    replace_if_greater.execute(hashtable, arr2.trim());

                    break;

                case "replace_if_lower":

                    replace_if_lower.execute(hashtable, arr2.trim());

                    break;


                case "remove_lower_key":

                    remove_lower_key.execute(hashtable, arr2.trim());

                    break;


                /*
                case "execute_script":

                    executeScript.execute(hashtable,arr2.trim());

                    break;

                 */

                default:

                    System.out.println("Неизвестная команда, напечатайте 'help' для просмотра списка команд");

                    break;

            }
        }
    }
}

