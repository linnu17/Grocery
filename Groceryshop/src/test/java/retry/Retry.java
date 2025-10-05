package retry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {//retry method is there inside this
		//IRetryAnalyzer implement an interface.helps to implenets to retry
		
		private static final Logger LOG = (Logger) LogManager.getLogger("Retry.class");
		private static final int maxTry = 2;
		private int count = 0;

		@Override
		public boolean retry(final ITestResult iTestResult) {//if the count is lesser again execute
			//if success at first time 
			if (!iTestResult.isSuccess()) {
				if (this.count < maxTry) { //if<2 
					LOG.info("Retrying test " + iTestResult.getName() + " with status "
							+ getResultStatusName(iTestResult.getStatus()) + " for the " + (this.count + 1) + " time(s).");
					this.count++;
					return true;
				}
			}
			return false;
		}

		public String getResultStatusName(final int status) {
			String resultName = null;
			if (status == 1) {
				resultName = "SUCCESS";
			}
			if (status == 2) {
				resultName = "FAILURE";
			}
			if (status == 3) {
				resultName = "SKIP";
			}
			return resultName;
		}
	}


	


