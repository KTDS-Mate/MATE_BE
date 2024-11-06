package com.mate;

import com.mate.bbs.dao.CountriesAndCitiesDao;
import com.mate.common.vo.TopDestinationVO;
import com.mate.common.vo.TopDestinationsListVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TopDestinationsTest {

    @Autowired
    private CountriesAndCitiesDao countriesAndCitiesDao;

    @Test
    public void testTopDestinationsVO() {
        TopDestinationVO vo = new TopDestinationVO();
        vo.setCityName("Test");
        vo.setNumberOfTours(10);
        vo.setNumberOfRequests(5);

        // Now get values
        assertEquals("Test", vo.getCityName());
        assertEquals(10, vo.getNumberOfTours());
        assertEquals(5, vo.getNumberOfRequests());
    }

    @Test
    public void testSelectTopDestinations() {
        TopDestinationsListVO result = countriesAndCitiesDao.selectTopDestinations();

        // A simple null check and size check can be done here
        assertNotNull(result, "Result should not be null");
    }
}