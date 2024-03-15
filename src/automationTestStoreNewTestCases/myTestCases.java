package automationTestStoreNewTestCases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestCases extends parameters {

	@BeforeTest
	public void setup() {
		driver.get("https://automationteststore.com/");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void signup() throws InterruptedException {
		WebElement registerButton = driver.findElement(By.id("customer_menu_top"));
		registerButton.click();

		WebElement continueButton = driver.findElement(By.cssSelector("button[title='Continue']"));
		continueButton.click();
		Thread.sleep(3000);

		WebElement firstName = driver.findElement(By.name("firstname"));
		firstName.sendKeys(firstNames[randomIndex]);
		WebElement lastName = driver.findElement(By.id("AccountFrm_lastname"));

		WebElement email = driver.findElement(By.name("email"));
		WebElement telephone = driver.findElement(By.name("telephone"));
		WebElement fax = driver.findElement(By.id("AccountFrm_fax"));

		lastName.sendKeys(lastNames[randomIndex2]);

		email.sendKeys(emails);
		telephone.sendKeys("0799998654");

		fax.sendKeys("01144(161)9998888");

		WebElement company = driver.findElement(By.cssSelector("#AccountFrm_company"));

		WebElement address1 = driver.findElement(By.cssSelector("#AccountFrm_address_1"));

		WebElement address2 = driver.findElement(By.cssSelector("#AccountFrm_address_2"));

		WebElement city = driver.findElement(By.name("city"));

		company.sendKeys("Amazon");
		address1.sendKeys("410 Terry Ave N, Seattle 98109, WA");
		address2.sendKeys("none");
		city.sendKeys("Bellevue, Washington");

		WebElement stateElement = driver.findElement(By.name("zone_id"));
		Select select = new Select(stateElement);
		select.selectByIndex(1);

		WebElement zipCode = driver.findElement(By.name("postcode"));
		zipCode.sendKeys("ab10 1aw");

		WebElement loginName = driver.findElement(By.id("AccountFrm_loginname"));
		WebElement password = driver.findElement(By.id("AccountFrm_password"));
		WebElement confirmPassword = driver.findElement(By.id("AccountFrm_confirm"));

		loginName.sendKeys(firstNames[randomIndex] + randomNum);
		password.sendKeys("absABS123");
		confirmPassword.sendKeys("absABS123");

		WebElement Subscribe = driver.findElement(By.name("newsletter"));
		Subscribe.click();

		WebElement privacyPolicy = driver.findElement(By.id("AccountFrm_agree"));
		privacyPolicy.click();

		WebElement continueButton1 = driver.findElement(By.className("btn-orange"));
		continueButton1.click();
		Thread.sleep(3000);

	}

	@Test(priority = 2)
	public void login() {
		driver.get("https://automationteststore.com/index.php?rt=account/logout");
		WebElement loginButton = driver.findElement(By.id("customer_menu_top"));
		loginButton.click();

		WebElement loginName = driver.findElement(By.id("loginFrm_loginname"));
		WebElement password = driver.findElement(By.id("loginFrm_password"));

		loginName.sendKeys(firstNames[randomIndex] + randomNum);
		password.sendKeys("absABS123");//

		WebElement loginButtonElement = driver.findElement(By.cssSelector("button[title='Login']"));
		loginButtonElement.click();
	}

	@Test(priority = 3)
	public void addFirstTwoItems() throws InterruptedException {
		driver.get("https://automationteststore.com/index.php?rt=product/category&path=52");

		WebElement conditionerElement = driver
				.findElement(By.cssSelector("ul[class='thumbnails row'] li:nth-child(1)"));
		conditionerElement.click();

		List<WebElement> addButton = driver.findElements(By.className("productcart"));
		for (int i = 0; i < 2; i++) {
			addButton.get(i).click();

			WebElement addToCartButton = driver.findElement(By.className("cart"));

			addToCartButton.click();

			driver.get("https://automationteststore.com/index.php?rt=product/category&path=52_54");

			addButton = driver.findElements(By.className("productcart"));

		}
		driver.get("https://automationteststore.com/index.php?rt=checkout/cart");

		WebElement checkoutButton = driver.findElement(By.id("cart_checkout2"));
		checkoutButton.click();

		WebElement totalPrice = driver.findElement(By.cssSelector("span[class='bold totalamout']"));
		System.out.println(totalPrice.getText());

		WebElement confirmOrderButton = driver.findElement(By.id("checkout_btn"));
		confirmOrderButton.click();
	}

	@AfterTest
	public void postTest() {
	}

}
