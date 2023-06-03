import Utils.BrowserUtils;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Case_1 {

    @Test
    public void case1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeoptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        boolean validation = false;

        Assert.assertEquals(driver.getTitle(), "Web Orders Login");
        if(driver.getTitle().equals("Web Orders Login")){
            validation = true;
            System.out.println("Title is \"Web Orders Login\": " + validation);
        }
        WebElement username = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginBtn = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginBtn.click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(), "Web Orders");
        if(driver.getTitle().equals("Web Orders")){
            validation = true;
            System.out.println("Title is \"Web Orders\": " + validation);
        }
        WebElement header = driver.findElement(By.tagName("h2"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "List of All Orders";
        Assert.assertEquals(actualHeader, expectedHeader);
        if(actualHeader.equals(expectedHeader)){
            validation = true;
            System.out.println("Header is \"List of All Orders\": " + validation);
        }
    }

    @Test
    public void case2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeoptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        boolean validation = false;

        WebElement username = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginBtn = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginBtn.click();
        Thread.sleep(2000);
        WebElement allProductsBtn = driver.findElement(By.linkText("View all products"));
        allProductsBtn.click();
        Thread.sleep(2000);
        allProductsBtn = driver.findElement(By.xpath("//li[@class='selected']"));
        String actualAllProductsStatus = allProductsBtn.getAttribute("class");
        String expectedAllProductsStatus = "selected";
        Assert.assertEquals(actualAllProductsStatus, expectedAllProductsStatus);
        if(actualAllProductsStatus.equals(expectedAllProductsStatus)){
            validation = true;
            System.out.println("All products button is selected: " + validation);
        }
        WebElement header = driver.findElement(By.tagName("h2"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "List of Products";
        Assert.assertEquals(actualHeader, expectedHeader);
        if(actualHeader.equals(expectedHeader)){
            validation = true;
            System.out.println("Header is \"List of Products\": " + validation);
        }
        String actualURL = driver.getCurrentUrl();
        String expectedPartofURL = "Products";
        Assert.assertTrue(actualURL.contains(expectedPartofURL));
        if(actualURL.contains(expectedPartofURL)){
            validation = true;
            System.out.println("URL contains \"Products\": " + validation);
        }
    }

    @Test
    public void case3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeoptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        boolean validation = false;

        WebElement username = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginBtn = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginBtn.click();
        Thread.sleep(2000);

        List<WebElement> allLinks = driver.findElements(By.xpath("//li//a"));
        List<String> expectedLinks = Arrays.asList("Default.aspx", "Products.aspx", "Process.aspx");
        List<String> actualLinks = new ArrayList<>();
        for(int i = 0; i < allLinks.size(); i++){
            System.out.println(allLinks.get(i).getAttribute("href"));
            actualLinks.add(allLinks.get(i).getAttribute("href"));
            Assert.assertTrue(actualLinks.get(i).contains(expectedLinks.get(i)));
            if(actualLinks.get(i).contains(expectedLinks.get(i))){
                validation = true;
                System.out.println("href value equals to " + expectedLinks.get(i) + ": " + validation);
            }
        }
    }

    @Test
    public void case4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeoptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement username = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginBtn = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginBtn.click();
        Thread.sleep(2000);
        WebElement orderBtn = driver.findElement(By.linkText("Order"));
        orderBtn.click();
        Thread.sleep(2000);
        boolean validation = false;

        WebElement dropdown = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct"));
        Select choice = new Select(dropdown);
        BrowserUtils.selectBy(dropdown,"ScreenSaver", "text" );
        WebElement quantity = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity"));
        quantity.sendKeys("5");
        WebElement customerName = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));
        customerName.sendKeys("CodeFish IT School");
        WebElement street = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2"));
        street.sendKeys("2200 E devon");
        WebElement city = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3"));
        city.sendKeys("Des Plaines");
        WebElement state = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
        state.sendKeys("Illinois");
        WebElement zipcode = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
        zipcode.sendKeys("60018");
        WebElement creditCard = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_cardList_1"));
        creditCard.click();
        Thread.sleep(500);
        WebElement creditCardNumber = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
        creditCardNumber.sendKeys("444993876233");
        WebElement expirationCreditCard = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
        expirationCreditCard.sendKeys("03/24");
        WebElement processBtn = driver.findElement(By.linkText("Process"));
        processBtn.click();

        WebElement message = driver.findElement(By.tagName("strong"));
        Assert.assertTrue(message.isDisplayed());
        if(message.isDisplayed()){
            validation = true;
            System.out.println("Message \"New order has been successfully added.\" is displayed: " + validation);
        }
        WebElement allOrdersBtn = driver.findElement(By.linkText("View all orders"));
        allOrdersBtn.click();
        Thread.sleep(1000);

        WebElement order = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl02_OrderSelector"));
        Assert.assertTrue(order.isDisplayed());
        if(order.isDisplayed()){
            validation = true;
            System.out.println("Order is added: " + validation);
        }
        Thread.sleep(1000);

        List<WebElement> orderDetails = driver.findElements(By.xpath("//tbody/tr[2]/td"));
        List<String> actualInfo = new ArrayList<>();
        List<String> expectedInfo = Arrays.asList("CodeFish IT School", "ScreenSaver", "5", "06/03/2023", "2200 E devon","Des Plaines", "Illinois", "60018",
                "MasterCard", "444993876233", "03/24");

        for(int i = 1; i < orderDetails.size()-1; i++){
            actualInfo.add(BrowserUtils.getText(orderDetails.get(i)));
            Assert.assertEquals(actualInfo.get(i-1), expectedInfo.get(i-1));
            if(actualInfo.get(i-1).equals(expectedInfo.get(i-1))){
                validation = true;
            }
        }
        System.out.println("All inputs are matching with new order: " + validation);


    }
}

