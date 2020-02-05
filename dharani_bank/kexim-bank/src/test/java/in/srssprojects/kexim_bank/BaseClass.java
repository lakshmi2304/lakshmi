package in.srssprojects.kexim_bank;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import customexceptions.InvalidBrowserNameException;

public class BaseClass {
	WebDriver driver;
	static ExtentReports report;
	static ExtentTest test;
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public String getDate() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("dd_MMM_yy_hh-mm-ss_a");
		return df.format(date);
	}
	
	public String getScreenshot(String folderName, String fileName, WebDriver driver) {
		 File img = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 File desImg = new File(getFilePath(folderName, fileName)+getDate()+".png");
		 try {
			FileUtils.copyFile(img, desImg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 System.out.println(desImg.getAbsolutePath());
		 return desImg.getAbsolutePath();
	}
	
	public static String getFilePath(String folderName, String fileName) {
		return System.getProperty("user.dir")+File.separator+folderName+File.separator+fileName;
	}
	
	public void launchBrowser(String browserName, String url) throws InvalidBrowserNameException {
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", getFilePath("drivers", "chromedriver.exe"));
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", getFilePath("drivers", "geckodriver.exe"));
			driver = new FirefoxDriver();
		}else {
			throw new InvalidBrowserNameException();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	
	public void launchBrowser(String browserName, String url, boolean withListener) throws InvalidBrowserNameException {
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", getFilePath("drivers", "chromedriver.exe"));
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", getFilePath("drivers", "geckodriver.exe"));
			driver = new FirefoxDriver();
		}else {
			throw new InvalidBrowserNameException();
		}
		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		EventCapture listener = new EventCapture();
		edriver.register(listener);
		driver = edriver;
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void launchBrowser(String browserName, String url, boolean withListener, String nodeUrl) {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setPlatform(Platform.WINDOWS);
		if(browserName.equalsIgnoreCase("chrome")) {
			caps = DesiredCapabilities.chrome();
			caps.setBrowserName(BrowserType.CHROME);
		}else if(browserName.equalsIgnoreCase("firefox")) {
			caps = DesiredCapabilities.firefox();
			caps.setBrowserName(BrowserType.FIREFOX);
		}else {
			caps = DesiredCapabilities.internetExplorer();
		}
		try {
			driver = new RemoteWebDriver(new URL(nodeUrl), caps);
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		EventCapture listener = new EventCapture();
		edriver.register(listener);
		driver = edriver;
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void closeBrowser() {
		driver.close();
	}

}
