package pl.omegacode.test.general;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * @author kma
 * 24 paź 2017
 */
public interface Time {
    default String getTime() {
        return "time";
    }
    
    default ZonedDateTime getZonedDateTime(String zoneString) {
        return ZonedDateTime.of(getLocalDateTime(), TimeClient.getZoneId(zoneString));
    }

    /**
     * @return
     */
    LocalDateTime getLocalDateTime();
}
