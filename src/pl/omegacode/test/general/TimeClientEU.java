package pl.omegacode.test.general;

import java.time.ZonedDateTime;

/**
 * @author kma
 * 24 paź 2017
 */
public interface TimeClientEU extends TimeClient, Time {

    /* (non-Javadoc)
     * @see pl.omegacode.cpb.bribit.model.transfer.TimeClient#getZonedDateTime(java.lang.String)
     */
    @Override
    default ZonedDateTime getZonedDateTime(String zoneString) {
        // TODO Auto-generated method stub
        return TimeClient.super.getZonedDateTime(zoneString);
    }
    

}
