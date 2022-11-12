package juara.coding.drivers.strategies;

import juara.coding.drivers.utils.Constans;

public class DriveStrategyImplementer {

    public static DriveStrategy chooseStrategy(String strategy) {
        switch (strategy) {
            case Constans.CHROME:
                return new Chrome();

          //  case Constans.FIREFOX:
            //    return new Firefox();

            default:
                return null;
        }
    }
}
