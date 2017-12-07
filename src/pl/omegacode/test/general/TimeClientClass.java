package pl.omegacode.test.general;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * @author kma
 * 24 paź 2017
 */
public class TimeClientClass  implements TimeClient, Time {


    /* (non-Javadoc)
     * @see pl.omegacode.cpb.bribit.model.transfer.TimeClient#setTime(int, int, int)
     */
    @Override
    public void setTime(int hour, int minute, int second) {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see pl.omegacode.cpb.bribit.model.transfer.TimeClient#getLocalDateTime()
     */
    @Override
    public LocalDateTime getLocalDateTime() {
        // TODO Auto-generated method stub
        return LocalDateTime.now();
    }
    
    
    
    
    /* (non-Javadoc)
     * @see pl.omegacode.cpb.bribit.model.transfer.TimeClient#getZonedDateTime(java.lang.String)
     */
    @Override
    public ZonedDateTime getZonedDateTime(String zoneString) {
        return TimeClient.super.getZonedDateTime(zoneString);
    }

    public static void main(String[] args) {
        TimeClient c = new TimeClientClass();
        System.out.println(c.getZonedDateTime("UTC"));
        System.out.println(c.getZonedDateTime2("UTC"));
    }

}
