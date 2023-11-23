import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Screenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"/Users/daniaalmilly/Downloads/chromedriver-mac-x64/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("http://127.0.0.1:5501/index.html");
		driver.manage().window().maximize();
		Date currentDate = new Date();

		 TakesScreenshot src = ((TakesScreenshot) driver);

		File SrcFile = src.getScreenshotAs((OutputType.FILE));

		 File Dest = new File("./Screenshots/image" + currentDate + ".png");
		 FileUtils.copyFile(SrcFile, Dest);

		List<WebElement> theStudentsName = driver.findElements(By.tagName("option"));

		int theTotalNumberOfStudents = theStudentsName.size();

		int howManyItems = 10;

		for (int i = 0; i < howManyItems; i++) {

			driver.findElement(By.xpath("//*[@id=\"remove\"]")).click();

		}

		List<WebElement> numbersAfterRemove = driver.findElements(By.tagName("option"));

		int actualNumber = numbersAfterRemove.size();
		System.out.println(actualNumber);
		
		int expectedNumber = theTotalNumberOfStudents - howManyItems;

		

		Assert.assertEquals(actualNumber, expectedNumber);
		 System.out.println(theTotalNumberOfStudents);
	}
}
