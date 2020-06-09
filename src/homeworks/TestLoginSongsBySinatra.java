package homeworks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class TestLoginSongsBySinatra {
    static WebDriver driver;

    public static void main(String[] args) {
        navegarSitio("http://evening-bastion-49392.herokuapp.com/");
        verificarLandingPage();
        darClickLogin();
        verificarPaginaLogIn();
        hacerLogin();


    }

    private static void navegarSitio(String url) {
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    private static void verificarLandingPage() {
        WebElement welcomeText = driver.findElement(By.linkText("Welcome to this website all about the songs of the great Frank Sinatra"));
        WebElement logInButton = driver.findElement(By.cssSelector("[href=\"/login\"]"));

        if (welcomeText.isDisplayed() && logInButton.isDisplayed()) {
            System.out.println("Pagina principal de Songs By Sinatra carga perfecto");
        } else {
            System.out.println("no carga la pagina");
            System.exit(-1); //sale del programa y regrea un -1 para marcar un error.
        }
    }

    private static void darClickLogin() {
        WebElement logInButton = driver.findElement(By.cssSelector("[href=\"/login\"]"));
        logInButton.click();
    }

    private static void verificarPaginaLogIn() {
        WebElement userName = driver.findElement(By.cssSelector("[id='username']"));
        WebElement password = driver.findElement(By.cssSelector("[id='password']"));
        WebElement logInButton = driver.findElement(By.cssSelector("[type='submit']"));

        if (userName.isDisplayed() && password.isDisplayed() && logInButton.isDisplayed()) {
            System.out.println("Pagina principal de login carga perfecto");
        } else {
            System.out.println("no carga la pagina");
            System.exit(-1); //sale del programa y regrea un -1 para marcar un error.
        }
    }

    private static void hacerLogin() {
        driver.close();
    }


}
