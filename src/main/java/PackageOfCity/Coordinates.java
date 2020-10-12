package PackageOfCity;

public class Coordinates implements Comparable<Coordinates>{
    private double x;
    private Integer y; //Поле не может быть null

    public Coordinates(double x, Integer y) {
        this.x = x;
        this.y = y; }

    public void setX(double x){
        this.x = x;
    }
    public void setY(Integer y){
        this.y = y;
    }

    public String getX() {
        return "x = "+x;
    }

    public String getY() {
        return "y = "+y;
    }

    public void setCoordinates(String xstr, String ystr) {
        double x = Double.parseDouble(xstr);
        Integer y = Integer.valueOf(ystr);
        setX(x); setY(y);
    }

    public static Coordinates valueOf(Coordinates coo){
        if (coo == null){
            return new Coordinates(0,0);
        }else{
            return coo;
        }
    }

    @Override
    public int compareTo(Coordinates coo) {
        if (this.getX().equals(coo.getX()) && (this.getY().equals(coo.getY()))) {
            return 0;
        } else if (Double.parseDouble(this.getY()) - Double.parseDouble(coo.getY()) > 0) {
            return 1;
        } else {
            return -1;
        }
    }

    public String toString() {
        return x+";"+y;
    }
}

