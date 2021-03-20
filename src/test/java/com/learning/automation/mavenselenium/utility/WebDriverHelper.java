package com.learning.automation.mavenselenium.utility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class WebDriverHelper extends BaseTest {

	public static void captureScreenshot(String methodName) {
		File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("./screenshot/" + methodName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void switchToWindow() {
		String currentWindow = getDriver().getWindowHandle();
		Set<String> windows = getDriver().getWindowHandles();
		Iterator<String> ite = windows.iterator();
		while (ite.hasNext()) {
			String newWindow = ite.next();
			if (!currentWindow.equals(newWindow)) {
				getDriver().switchTo().window(newWindow);
			}
		}
	}

}
