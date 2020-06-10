package tareas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SongsBySinatraParent {
    public static WebDriver driver;

    public static void navegarSitio(String url)
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(url);

    }

    public static void validarHomePage(String welcomeMessage)
    {
        WebElement welcomeText = driver.findElement(By.xpath("//*[text()='Welcome to this website all about the songs of the great Frank Sinatra']"));
        WebElement imgSinatra = driver.findElement(By.cssSelector("[src='images/sinatra.jpg']"));
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
    }

    public static void validarMensajeBienvendia(String mensajeBienvenida)
    {
    }

    public static void cerrarBrowser()
    {
        driver.quit();
    }
}
