import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.FluentWait;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.NoSuchElementException;
import com.google.common.base.Function;

/**
 * This program allow the browser run automatically and find out the information
 * <p>
 * Name: Joey Zhen
 **/
public class Flipkart {
	// 1
	public WebDriver webDriver;

	@BeforeTest
	public void setup() {
		webDriver = new ChromeDriver();
		webDriver.get("https://www.flipkart.com/");
		webDriver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void check() {
		// 2
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		WebElement cross = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"_2KpZ6l _2doB4z\"]")));
		cross.click();
	}

	@Test(priority = 2)
	public void electronics() {
		// 3
		WebElement electronics_menuname = webDriver.findElement(By.xpath("//div[contains(text(),'Electronics')]"));
		Actions builder = new Actions(webDriver);
		builder.moveToElement(electronics_menuname).build().perform();
		WebElement mobile_menu_button = webDriver.findElement(By.xpath("//*[contains(text(),'MobileAccessory')]"));
		mobile_menu_button.click();
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 3)
	public void mi() {
		WebElement electronics_name = webDriver.findElement(By.xpath("//html/body/div/div/div[2]/div/div/span[1]"));
		Actions m = new Actions(webDriver);
		m.moveToElement(electronics_name).build().perform();
		WebElement m_menu = webDriver.findElement(By.xpath("//a[contains(text(),'Mi')]"));
		new WebDriverWait(webDriver, 2000).until(ExpectedConditions.elementToBeClickable(m_menu)).click();
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// 4
	@Test(priority = 4)
	public void mitext() {
		WebElement mi = webDriver.findElement(By.xpath("//p[contains(text(),'Latest from MI :')]"));
		String find = mi.getText();
		String t = "Latest from MI : Redmi Go";
		Assert.assertEquals(find, t);
	}

	@Test(priority = 5)
	public void down() throws InterruptedException {

		// webDriver.switchTo().frame(0); //need to switch to this frame before clicking
		// the slider
		WebElement minSlider = webDriver.findElement(By.xpath("(.//div[@class='_3FdLqY'])"));
		slider(minSlider);
		WebDriverWait w = new WebDriverWait(webDriver, 10);
		WebElement d = w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='_3uDYxP']//select[1]")));
		Select drpMaxDropDown = new Select(d);
		drpMaxDropDown.selectByIndex(5);
	}
	
	  @Test(priority= 6)
	  public void video() throws InterruptedException
	  {
		  WebDriverWait w = new WebDriverWait(webDriver, 10);
			WebElement se = w
					.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
			 se.clear();
			 se.sendKeys("redmi go (black, 8 gb)"); 
			 WebElement button = webDriver.findElement(By.xpath("//button[@class='L0Z3Pu']")); 
			 button.click();
			 WebElement in = webDriver.findElement(By.xpath("//div[@class='_1YokD2 _3Mn1Gg'][2]//div[@class='_1AtVbE col-12-12'][1]"));
			 in.click();
			 changeToNewWindow();
			 List<WebElement> thumbnail = webDriver.findElements(By.xpath("//div[@class='_1YokD2 _3Mn1Gg col-5-12 _78xt5Y']//*[@class='_3GnUWp']//li[@class='_20Gt85 _1Y_A6W']")); 
			 if (thumbnail.size() >= 1) { 
				 thumbnail.get(1).click(); // click on first found thumbnail }
			 }

			 WebDriverWait f = new WebDriverWait(webDriver, 10);
				WebElement fr = f
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_1BweB8']//iframe[@class='_1JqCrR']")));
//				webDriver.findElement(By.xpath("//div[@class='_1BweB8']//iframe[@class='_1JqCrR']"));
			 WebElement frame = fr; 
			 webDriver.switchTo().frame(frame); 
			 
				 int total = webDriver.findElements(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).size();
				 if (total >= 1) {
					 webDriver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();
					 webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
				 }
				 Thread.sleep(3000);
				 webDriver.switchTo().defaultContent(); 
			 } 

	@Test(priority = 7)
	public void sendkey() throws InterruptedException {
		
		WebElement electronics_name = webDriver.findElement(By.xpath("//html/body/div/div/div[2]/div/div/span[1]"));
		Actions m = new Actions(webDriver);
		m.moveToElement(electronics_name).build().perform();
		WebElement m_menu = webDriver.findElement(By.xpath("//a[contains(text(),'Mi')]"));
		new WebDriverWait(webDriver, 2000).until(ExpectedConditions.elementToBeClickable(m_menu)).click();
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebDriverWait w = new WebDriverWait(webDriver, 10);
		WebElement d = w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='_1YokD2 _3Mn1Gg'][2]//div[@class='_1AtVbE col-12-12'][1]")));
	  	d.click();
		
		changeToanotherWindow();
		WebDriverWait c= new WebDriverWait(webDriver, 10);
		WebElement cl = c
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='_30jeq3 _16Jk6d']")));
		String x = cl.getText();
		x = x.replaceAll("[^0-9]", "");
		if (Integer.parseInt(x) > 0) {
			Assert.assertTrue(true, "Price >0");
		} else {
			Assert.assertTrue(false, "Price < 0");
			}
		}

	 @Test(priority = 8)
	 public void VerifyDeliveryVisibility() throws InterruptedException {
	  
	  WebDriverWait wait = new WebDriverWait(webDriver, 10);
	  WebElement send = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='_36yFo0']")));
	  send.click();
	  send.sendKeys("560099");
	  webDriver.findElement(By.xpath("//form[@class='N79-rD']//input[@class='_36yFo0']")).sendKeys(Keys.ENTER); 
	  }
	 
	@Test(priority = 9)
	public void ClickOnViewDetailLink() {
		webDriver.findElement(By.className("_20cDxP")).click();
		WebDriverWait w = new WebDriverWait(webDriver, 10);
		WebElement c = w
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='_2KpZ6l _1KAjNd']")));
		c.click();
	}

	  @Test(priority= 10) 
	  public void clickOnAddAoCart() throws InterruptedException
	  {	
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webDriver.findElement(By.xpath(".//button[text()='ADD TO CART']")).click();

	  	
	  }
	  
	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		webDriver.quit();
	}

	@SuppressWarnings("deprecation")
	public WebElement waitForFindElement(final By locator) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(webDriver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver arg0) {
				return arg0.findElement(locator);
			}
		});
		return element;
	}

	public void slider(WebElement Slider) throws InterruptedException {
		
		Actions moveSlider = new Actions(webDriver);
		Action action = moveSlider.dragAndDropBy(Slider, 30, 0).build();
		action.perform();
	}

	public void changeToNewWindow() {
		String oldTab = webDriver.getWindowHandle();
		ArrayList<String> newTab = new ArrayList<String>(webDriver.getWindowHandles());
		newTab.remove(oldTab);// change focus to new tab
		webDriver.switchTo().window(newTab.get(0));
	}
	
	public void changeToanotherWindow() {
		String oldTab = webDriver.getWindowHandle();
		ArrayList<String> newTab = new ArrayList<String>(webDriver.getWindowHandles());
		newTab.remove(oldTab);// change focus to new tab
		webDriver.switchTo().window(newTab.get(1));
	}

	public void waitForElementVisibility(String str) {
		WebDriverWait wait = new WebDriverWait(webDriver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(str)));
	}

	public void hoverAndClickOnElement(WebElement ele) {
		Actions actions = new Actions(webDriver);
		actions.moveToElement(ele).perform();
		actions.moveToElement(ele).click().build().perform();
	}

}
