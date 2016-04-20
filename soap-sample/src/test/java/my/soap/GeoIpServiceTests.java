package my.soap;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Tirex on 20.04.2016.
 */
public class GeoIpServiceTests {
    @Test
    public void testMyIp(){
        GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("217.23.150.14");
        assertEquals(geoIP.getCountryCode(),"RUS");

    }
    @Test
    public void testInvalidIp(){
        GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("217.23.150.xxx");
        assertEquals(geoIP.getCountryCode(),"RUS");

    }
}
