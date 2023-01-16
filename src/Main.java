import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {


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

        String expectedColor = "rgba(93, 164, 35, 1)";

        if (actualColor.equals(expectedColor)){
            System.out.println("Test je prosao");
        }else {
            System.out.println("Test je pao!");
        }

        String actualText = loggedInText.getText();
        System.out.println("Actual text: " + actualText); //You logged into a secure area! //regex


        String expectedText = "You logged into a secure area!";

        if (actualText.equals(expectedText)){
            System.out.println("Test je prosao");
        }else {
            System.out.println("Test je pao!");
        }




        driver.quit();




        //WebElement loginButton1 = driver.findElement(By.className("fa fa-2x fa-sign-in"));












    }



}