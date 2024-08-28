package com.challenge.report;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * Reports class instance to log data from test executions to feed report
 *
 * @author Carlos Rodríguez
 */
public class ExtentReportsManager {
	private static ExtentReportsManager instance;
	private static ExtentReports report;
	private static ThreadLocal<ExtentTest> extentTestThreadLocal;

	private ExtentReportsManager() {
		report = new ExtentReports(System.getProperty("user.dir") +"/test-output/report/testReport.html");
		extentTestThreadLocal = new ThreadLocal<>();
	}

	public static ExtentReportsManager getInstance(){
		if (instance == null){
			synchronized (ExtentReportsManager.class){
				if (instance == null){
					instance = new ExtentReportsManager();
				}
			}
		}
		return instance;
	}

	public ExtentReports getReport(){
		return report;
	}

	public ExtentTest getExtentTest() {
		return extentTestThreadLocal.get();
	}

	public void setExtentTest(ExtentTest extentTest) {
		ExtentReportsManager.extentTestThreadLocal.set(extentTest);
	}
}
