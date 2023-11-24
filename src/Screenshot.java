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
		// driver.manage().window().maximize();
		// Date currentDate = new Date();

		// TakesScreenshot src = ((TakesScreenshot) driver);

		// File SrcFile = src.getScreenshotAs((OutputType.FILE));

		// File Dest = new File("./Screenshots/image" + currentDate + ".png");
		// FileUtils.copyFile(SrcFile, Dest);

		List<WebElement> theStudentsName = driver.findElements(By.tagName("option"));

		System.out.println(" ********* Names of the removed students ********");
		for (int i = 0; i < theStudentsName.size(); i++) {

			if (i % 2 != 0) {

				theStudentsName.get(i).click();
				System.out.println(theStudentsName.get(i).getText());
				driver.findElement(By.xpath("//*[@id=\"remove\"]")).click();

			}

		}

		System.out.println(" ********* Names of the non-removed students ********");

		List<WebElement> studentsNamesAfterRemove = driver.findElements(By.tagName("option"));

		for (int j = 0; j < studentsNamesAfterRemove.size(); j++) {

			System.out.println(studentsNamesAfterRemove.get(j).getText());

		}

		int actualNumber =studentsNamesAfterRemove.size();
		System.out.println(actualNumber + " actual number");

		int expectedNumber = theStudentsName.size() - studentsNamesAfterRemove.size();

		System.out.println(expectedNumber + " expected number");

		Assert.assertEquals(actualNumber, expectedNumber);
		;
	}
}
