package tareas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SongsBySinatraParent {
    public static WebDriver driver;
    static WebDriverWait wait;

    public static void navegarSitio(String url)
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        driver.navigate().to(url);

    }

    public static void validarHomePage(String welcomeMessage)
    {
        WebElement welcomeText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Welcome to this website all about the songs of the great Frank Sinatra']")));
        WebElement imgSinatra = driver.findElement(By.cssSelector("[src='/images/sinatra.jpg']"));
        WebElement linkLogin = driver.findElement(By.cssSelector("[href='/login']"));

        if (welcomeText.isDisplayed() && imgSinatra.isDisplayed() && linkLogin.isDisplayed())
        {
            System.out.println("Pagina principal de Songs By Sinatra carga perfecto");
        }
        else
        {
            System.out.println("no carga la pagina");
            System.exit(-1); //sale del programa y regrea un -1 para marcar un error.
        }
    }

    public static void hacerLogin(String user, String password)
    {
        WebElement linkLogin = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href='/login']")));
        linkLogin.click();
        WebElement usernameBox = driver.findElement(By.id("username"));
        WebElement passwordBox = driver.findElement(By.id("password"));
        usernameBox.sendKeys(user);
        passwordBox.sendKeys(password);
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
        loginButton.click();
    }

    public static void validarMensajeLogin(String mensajeBienvenida)
    {
        WebElement loginMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        if (loginMessage.isDisplayed())
        {
            System.out.println("Login exitoso");
        }
        else
        {
            System.out.println("no se hizo el login");
            System.exit(-1); //sale del programa y regrea un -1 para marcar un error.
        }
    }

    public static void validarSongsPage ()
    {
        WebElement songsTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section h1")));
        String currentUrl = driver.getCurrentUrl();
        WebElement songsLink = driver.findElement(By.cssSelector("[href='/songs']"));
        String currentClass = songsLink.getAttribute("class");
        List<WebElement> listaCanciones = driver.findElements(By.cssSelector("#songs li"));

        if(songsTitle.isDisplayed()  &&
                currentUrl.endsWith("songs") &&
                currentClass.equals("current") &&
                listaCanciones.size() > 0) {
            System.out.println("Si estoy en la pagina de songs");
        }
        else {
            System.out.println("No estoy en la pagina de songs.");
            cerrarBrowser();

            System.exit(-1);
        }
    }

    public static void cerrarBrowser()
    {
        driver.quit();
    }
}
