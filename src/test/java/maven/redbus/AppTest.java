package maven.redbus;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppTest {
	@Test
	public void testRedbusBooking() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");

		WebElement fromPlace = driver.findElement(By.id("srcinput"));
		fromPlace.sendKeys("Madiwala, Bangalore");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement fromSuggestion = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Madiwala, Bangalore']")));
		fromSuggestion.click();

		WebElement toPlace = driver.findElement(By.id("destinput"));
		toPlace.sendKeys("Guindy, Chennai");

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement toSuggestion = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Guindy, Chennai']")));
		toSuggestion.click();

		WebElement tomorrow = driver.findElement(By.xpath("//button[@aria-label='Search for Tomorrow']"));
		tomorrow.click();

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement priceTab = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Price']")));
		priceTab.click();

		wait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[contains(text(),'View seats')]")));

		List<WebElement> viewSeats = driver.findElements(By.xpath("//button[contains(text(),'View seats')]"));
		viewSeats.get(0).click();

		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement clickCross = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@data-autoid='bottom-sheet']//button[@aria-label='Close']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickCross);

		WebElement clickSeat = driver.findElement(By.id("U7"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickSeat);

		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement button = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[text()='Select boarding & dropping points']")));
		button.click();

		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement madiwala = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='bp-point-1']")));
		madiwala.click();

		WebElement guindy = driver
				.findElement(By.xpath("//div[@aria-label='05:40, 02 Mar Guindy, Opp to sangeetha Hotel']"));
		guindy.click();

		WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement phone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Phone *")));
		phone.sendKeys("9020123456");

		WebElement email = driver.findElement(By.xpath("//input[@type='text']"));
		email.sendKeys("richugm@gmail.com");

		WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement stateDropdown = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='State of Residence']")));
		stateDropdown.click();

		WebElement stateOption = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Karnataka']")));
		stateOption.click();

		WebElement passengerName = driver.findElement(By.xpath("//input[@aria-label='Name *']"));
		passengerName.sendKeys("Richu");

		WebElement passengerAge = driver.findElement(By.xpath("//input[@aria-label='Age *']"));
		passengerAge.sendKeys("25");

		WebElement male = driver.findElement(By.xpath("//div[@aria-label='Male']"));
		male.click();

		WebElement assurance = driver
				.findElement(By.xpath("//div[text()='Yes, protect my trip at ₹ 24 (1 passenger)']"));
		assurance.click();

		WebElement button1 = driver.findElement(By.xpath("//button[text()='Continue booking']"));
		button1.click();

		WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement qrCode = wait8
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Pay through QR code']")));
		qrCode.click();

	}
}
