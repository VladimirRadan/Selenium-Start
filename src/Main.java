import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Main {

    static void ispis() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Cao");
    }


    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        Thread.sleep(3000);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement usernameField =  driver.findElement(By.cssSelector("input[name='username']"));
        usernameField.sendKeys("tomsmith");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        //WebElement passwordField1 = driver.findElement(By.cssSelector("#password"));

        WebElement loginButton = driver.findElement(By.cssSelector(".fa"));
        loginButton.click();

        WebElement loggedInText = driver.findElement(By.id("flash"));

        String actualColor = loggedInText.getCssValue("background-color");

//        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        jsExecutor.executeScript("arguments[0].style.background='red'", loggedInText);


        String expectedColor = "rgba(93, 164, 35, 1)";

        Assert.assertEquals(actualColor, expectedColor);//hard assert

        String actualText = loggedInText.getText();
        //System.out.println("Actual text: " + actualText); //You logged into a secure area! //regex
        String expectedText = "You logged into a secure area!";

        String actualText2 = loggedInText.getText().substring(0, actualText.length()-1);

        //System.out.println("Actual2 text: " + actualText2);

        //String actualText3[] = loggedInText.getText().split("\n");

        String actualText3[] = loggedInText.getText().split("(?<=!)");

        //System.out.println("actual 3: " + actualText3[0]);

        Assert.assertEquals(actualText3[0],expectedText);

         driver.quit();
        //WebElement loginButton1 = driver.findElement(By.className("fa fa-2x fa-sign-in"));

    }



}