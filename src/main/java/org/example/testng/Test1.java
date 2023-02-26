package org.example.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test1 {

    @DataProvider (name = "dp")
    public static Object[][] dbData () {
        return new Object[][] {
                {"SQL", new Integer(1)},
                {"mySQL", new Integer(2)}
        };
    }

    @Test (retryAnalyzer = Retry.class)
    public void TestRetry () {
        System.out.println("Test Retry");
        Assert.fail();
    }

    @Parameters({"db"})
    @Test (groups = {"smokeTest", "regress"})
    public void test1 (String db) {
        System.out.println("test1" + db);
    }

    @Test (dependsOnMethods = {"test1"}, dependsOnGroups = "regress", alwaysRun = true)
    public void test11 () {
        System.out.println("test11");
    }

    @Parameters({"db"})
    @Test (dataProvider = "dp")
    public void test111 (String e1, int e2) {
        System.out.println("test111 " + e1 + " " + e2);
    }
}
