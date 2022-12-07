package Lab6Tasks;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab6Tasks
{ 
	@Test
 public void fileupload() throws AWTException, Exception
 {   Logger logger = Logger.getLogger("UploadFilePage");
	 WebDriverManager.chromedriver().setup();
	 WebDriver driver= new ChromeDriver();
	 driver.get("https://www.dev2qa.com/demo/upload/uploadFileTest.html");
	 logger.info("Clicked the Upload Button");
	 driver.manage().window() .maximize();
	 Actions Action = new Actions(driver);
	 Thread.sleep(4000);
	 WebElement filepath1 = driver.findElement(By.xpath("//input[@name='uploadFileInputBox']"));
	Action.moveToElement(filepath1).click().perform();
	logger.info("FileUpload Path is find and clicked");
	 Robot Robot = new Robot();
	 StringSelection filepath= new StringSelection("C:\\Users\\4390\\Desktop\\ExcelDataBase.xlsx");
	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	clipboard.setContents(filepath,filepath);
	logger.info("FilePath is Identified");
	Thread.sleep(4000);
	 Robot.keyPress(KeyEvent.VK_CONTROL);
	 Robot.keyPress(KeyEvent.VK_V);
	 logger.info("Cotrol V is Preesed");
	 Robot.keyRelease(KeyEvent.VK_CONTROL);
	 Robot.keyRelease(KeyEvent.VK_V);
	 logger.info("Control V is Released");
	 Robot.keyPress(KeyEvent.VK_ENTER);
	 logger.info("Enter is Pressed");
	 Robot.keyRelease(KeyEvent.VK_ENTER);
	 Thread.sleep(3000);
	 logger.info("Enter is Released");
	 driver.quit();
	 }
}
