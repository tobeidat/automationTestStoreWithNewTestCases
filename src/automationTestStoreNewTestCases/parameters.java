package automationTestStoreNewTestCases;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class parameters {
	WebDriver driver = new ChromeDriver();

	String[] firstNames = { "ahmad", "ayman", "amjad", "sewar" };
	String[] lastNames = { "omar", "ameer", "mahmoud", "yazan" };

	Random rand = new Random();

	int randomIndex = rand.nextInt(firstNames.length);
	int randomIndex2 = rand.nextInt(lastNames.length);
	int randomNum = rand.nextInt(10999);
	String emails = firstNames[randomIndex] + lastNames[randomIndex2] + rand.nextInt(9999) + "@gmail.com";

}
