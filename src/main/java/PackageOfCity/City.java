package PackageOfCity;

import java.time.ZonedDateTime;


public class City implements Comparable<City>{
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long area; //Значение поля должно быть больше 0, Поле не может быть null
    private long population; //Значение поля должно быть больше 0
    private Double metersAboveSeaLevel;
    private Climate climate; //Поле может быть null
    private Government government; //Поле может быть null
    private StandardOfLiving standardOfLiving; //Поле может быть null
    private Human governor; //Поле может быть null

    public City(long id, String name, Coordinates coordinates, ZonedDateTime creationDate, Long area,
                long population, Double metersAboveSeaLevel, Climate climate, Government government,
                StandardOfLiving standardOfLiving, Human governor) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.area = area;
        this.population = population;
        this.metersAboveSeaLevel = metersAboveSeaLevel;
        this.climate = climate;
        this.government = government;
        this.standardOfLiving = standardOfLiving;
        this.governor = governor;
    }

    public City(String name, Coordinates coordinates, ZonedDateTime creationDate, Long area, long population,
                Double metersAboveSeaLevel, Climate climate, Government government,
                StandardOfLiving standardOfLiving, Human governor) {
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.area = area;
        this.population = population;
        this.metersAboveSeaLevel = metersAboveSeaLevel;
        this.climate = climate;
        this.government = government;
        this.standardOfLiving = standardOfLiving;
        this.governor = governor;
    }

    public City(){
    }

    public long getId() {
        return id;
    }

    /*public static long previousID = 0;

    public void setId() {
        this.id = System.currentTimeMillis() % 10000000000L;
        if (id <= previousID) {
            id = previousID + 1;
        }
        previousID = id;
        this.id = id;
    }
    */

    //getters and setters
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCoordinates(Coordinates coordinates){
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates(){
        return coordinates;
    }

    public static ZonedDateTime setCreationDate(){
        ZonedDateTime creationDate = ZonedDateTime.now();
        return creationDate;
    }

    public void setArea(Long area){
        this.area = area;
    }

    public Long getArea(){
        return area;
    }

    public void setPopulation(long population){
        this.population = population;
    }

    public long getPopulation(){
        return population;
    }

    public void setMetersAboveSeaLevel(Double metersAboveSeaLevel){
        this.metersAboveSeaLevel = metersAboveSeaLevel;
    }

    public Double getMetersAboveSeaLevel(){
        return metersAboveSeaLevel;
    }

   public void setGovernor(Human governor){
        this.governor = governor;
   }

   public Human getGovernor(){
        return governor;
   }


    @Override
    public int compareTo(City city) {
        int diff = 0;

        if(this.id - city.getId() > 0){
            diff++;
        }else if (this.id - city.getId() < 0){
            diff--;
        }
        return diff;
    }

    @Override
    public String toString() {
        return  getId()+";"+getName()+";"+getCoordinates()+";"
                +getArea()+";"+getPopulation()+";"+getMetersAboveSeaLevel() +";"
                +climate.toString()+";"+government.toString()+";"
                +standardOfLiving.toString()+";"+getGovernor()+"\n";
    }

    public String customToString() {
        return "City ID: "+getId()+"\n"+
                "Name: "+getName()+"\n"+
                "Coordinates: "+getCoordinates().getX()+"; "+getCoordinates().getY()+"\n"+
                "Area: " +getArea()+"\n"+
                "Population: "+getPopulation()+"\n"+
                "Meters above the sea: "+getMetersAboveSeaLevel()+"\n"+
                "Climate: " +climate.toString()+"\n"+
                "Government: "+government.toString()+"\n"+
                "Standard of living: "+standardOfLiving.toString()+"\n"+
                "Governor: "+getGovernor();
    }
}



