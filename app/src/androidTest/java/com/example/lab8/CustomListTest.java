// CustomListTest.java
package com.example.lab8;

import static org.junit.Assert.*;
        import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import java.util.ArrayList;

@RunWith(AndroidJUnit4.class)
public class CustomListTest {
    private CustomList customList;
    private ArrayList<City> cityList;

    @Before
    public void setUp() {
        cityList = new ArrayList<>();
        customList = new CustomList(
                InstrumentationRegistry.getInstrumentation().getTargetContext(),
                cityList
        );
    }

    @Test
    public void testAddCity() {
        int initialSize = customList.getCount();
        City newCity = new City("Edmonton", "AB");
        customList.addCity(newCity);
        assertEquals(initialSize + 1, customList.getCount());
        assertTrue(customList.hasCity(newCity));
    }

    @Test
    public void testHasCity() {
        City testCity = new City("Edmonton", "AB");
        customList.addCity(testCity);
        assertTrue(customList.hasCity(testCity));
        assertFalse(customList.hasCity(new City("Calgary", "AB")));
    }

    @Test
    public void testDeleteCity() {
        City testCity = new City("Edmonton", "AB");
        customList.addCity(testCity);
        int initialSize = customList.getCount();
        customList.deleteCity(testCity);
        assertEquals(initialSize - 1, customList.getCount());
        assertFalse(customList.hasCity(testCity));
    }

    @Test
    public void testCountCities() {
        assertEquals(0, customList.getCount());
        customList.addCity(new City("Edmonton", "AB"));
        assertEquals(1, customList.getCount());
        customList.addCity(new City("Calgary", "AB"));
        assertEquals(2, customList.getCount());
    }
}