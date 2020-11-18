package PackageOfCity;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Hashtable;

public class CityHashtable extends Hashtable<Long, City> {
    public LocalDateTime authDateTime;

    public void setAuthDateTime(ZonedDateTime authDateTime) {
        this.authDateTime = authDateTime;
    }

    public LocalDateTime getAuthDateTime(){
        return this.authDateTime;
    }
}
