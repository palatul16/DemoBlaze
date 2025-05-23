package demoblaze.utils;

import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaUtility {
	public static String getNewUser()
	{
		String newUser = LocalDateTime.now().toString().replace(":", "").replace(" ", "");
		return newUser;
	}
	
	public String popup(WebDriver driver ) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.alertIsPresent());
		 Alert alert = driver.switchTo().alert();
         String alertMessage = alert.getText();
         alert.accept();
		return alertMessage;
	}
}
