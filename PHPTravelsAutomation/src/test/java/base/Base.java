package base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import util.PropertiesUtil;




public class Base {
	
	protected WebDriver driver;
	protected PropertiesUtil testData = null;
	protected final String TEST_DATA_PROPERTIES = "test_data.properties";
	
	public Base() throws IOException, FileNotFoundException{
		this.testData = new PropertiesUtil(TEST_DATA_PROPERTIES);
	}


	@BeforeClass
	@Parameters({ "browser" })
	public void setUp(@Optional("chrome") String browser) throws Exception {
		
		
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\graha\\SeleniumTraning\\SimpleRegistration\\resources\\geckodriver.exe");
			this.driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\chromedriver.exe");
//			ChromeOptions options = new ChromeOptions();
//			options.setCapability("Site key","6LeIxAcTAAAAAJcZVRqyHh71UMIEGNQ_MXjiZKhI");
//			options.setCapability("Secret key","6LeIxAcTAAAAAGG-vFI1TnRWxMZNFuojJ4WifJWe");
//			this.driver = new ChromeDriver(options);
			this.driver = new ChromeDriver();

			 
			

//			driver.manage().deleteAllCookies();
//			driver.manage().addCookie(new Cookie("PHPSESSID","cd02504ce2359c14f4e20962572aa2b"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			

			
		
		

		}

	}

	@AfterClass
	public void cleanUp() {
	//	driver.quit();
	}

}

