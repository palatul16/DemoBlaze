package hooks;

import java.io.IOException;

import demoblaze.utils.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Base {

    @Before
    public void setUp() throws IOException {
        System.out.println("Starting browser session...");
        initializeDriver();  
        driver.get("https://www.demoblaze.com/");
    }

    @After
    public void tearDown() {
        System.out.println("Closing browser session...");
        if (driver != null) {
            driver.quit();
        }
    }
}
