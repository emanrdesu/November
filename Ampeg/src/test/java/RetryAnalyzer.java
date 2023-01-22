
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int counter = 1;
    private int retryLimit = 10;

    @Override
    public boolean retry(ITestResult result) {
        System.out.println("Retry #" + counter);
        return counter++ <= retryLimit;
    }
}