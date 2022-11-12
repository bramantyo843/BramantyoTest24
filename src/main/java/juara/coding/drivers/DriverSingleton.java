package juara.coding.drivers;

import juara.coding.drivers.strategies.DriveStrategyImplementer;
import juara.coding.drivers.strategies.DriveStrategy;

import juara.coding.drivers.utils.Constans;


import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    private static DriverSingleton instance = null;
    private static WebDriver driver;

    private DriverSingleton(String driver) {
        instantiate(driver);
    }

    public WebDriver instantiate(String strategy) {
        DriveStrategy driverStrategy = DriveStrategyImplementer.chooseStrategy(strategy);
        driver = driverStrategy.setStrategy();
        driver.manage().timeouts().implicitlyWait(Constans.TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

    public static DriverSingleton getInstance(String driver) {
        if(instance == null) {
            instance = new DriverSingleton(driver);
        }

        return instance;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void closeObjectInstance() {
        instance = null;
        driver.quit();
    }
}
