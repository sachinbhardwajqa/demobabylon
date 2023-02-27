package interfaces;

import java.time.*;
 
public interface TimeClient {
    void setTime(int hour, int minute, int second);
    void setDate(int day, int month, int year);
    void setDateAndTime(int day, int month, int year,
                               int hour, int minute, int second);
    LocalDateTime getLocalDateTime();

    /*To add below additional method
    *
    *
    public interface TimeClient {
        void setTime(int hour, int minute, int second);
        void setDate(int day, int month, int year);
        void setDateAndTime(int day, int month, int year,
        int hour, int minute, int second);
        LocalDateTime getLocalDateTime();
        ZonedDateTime getZonedDateTime(String zoneString);
    }
    * */
    static ZoneId getZoneId (String zoneString) {
        try {
            return ZoneId.of(zoneString);
        } catch (DateTimeException e) {
            System.err.println("Invalid time zone: " + zoneString +
                    "; using default time zone instead.");
            return ZoneId.systemDefault();
        }
    }

    default ZonedDateTime getZonedDateTime(String zoneString) {
        return ZonedDateTime.of(getLocalDateTime(), getZoneId(zoneString));
    }

    /*
    * When we extend an interface that contains a default method, we can do the following:
    *
    * Not mention the default method at all, which lets our extended interface inherit the default method.
    * Redeclare the default method, which makes it abstract.
    * Redefine the default method, which overrides it.
    * */


    /*
    *
    *
    public interface TimeClient {
    // ...
        static public ZoneId getZoneId (String zoneString) {
            try {
                return ZoneId.of(zoneString);
            } catch (DateTimeException e) {
                System.err.println("Invalid time zone: " + zoneString +"; using default time zone instead.");
                return ZoneId.systemDefault();
            }
        }

        default public ZonedDateTime getZonedDateTime(String zoneString) {
            return ZonedDateTime.of(getLocalDateTime(), getZoneId(zoneString));
        }
    }
    * */

    /*
    //We have time server, which periodically notifies its clients of the current date and time
    //Interface that the server could use to enforce a particular protocol on its clients
    import java.time.*;
    public interface TimeClient {
        void setTime(int hour, int minute, int second);
        void setDate(int day, int month, int year);
        void setDateAndTime(int day, int month, int year,
                               int hour, int minute, int second);
        LocalDateTime getLocalDateTime();
    }
     */
}