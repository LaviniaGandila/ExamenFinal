package SharedData;

import LoggerUtility.LoggerUtility;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Hooks extends SharedData {
    private String testName;

    @BeforeMethod
    public void prepareEnvironment () {
        testName = this.getClass().getSimpleName();
        LoggerUtility.startTestCase(testName);
        prepareDriver();
        LoggerUtility.infoTestCase("The driver is opened with succes");
    }

//   @AfterMethod
//    public void clearEnvironment(ITestResult result) {
//        if(!result.isSuccess())
//        {
//            LoggerUtility.errorTestCase(result.getThrowable().getMessage());
//        }
//        clearDriver();
//        LoggerUtility.infoTestCase("The driver is close with success");
//        LoggerUtility.finishTestCase(testName);
//    }
}
