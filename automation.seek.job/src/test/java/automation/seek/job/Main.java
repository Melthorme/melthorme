package automation.seek.job;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class Main {

    public static void main (String[] args) {

        Result result = JUnitCore.runClasses(JobSeekSuite.class);

        System.out.println(result.getRunTime());
        System.out.println(result.wasSuccessful());
        System.out.println(result.getFailureCount());
        System.out.println(result.getFailures());
    }
}
