package classExercise;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TelcelSeleccionarArticulo {
    static WebDriver driver;

    public static void main(String[] args) {
        navegarSitio("https://www.telcel.com");
        verificarLandingPage();
        listarTelefonos();
        seleccionarEstado("Jalisco");
        verificarPaginaResultados();
        Celular primerCelular = capturarDatosCelular(1);
        seleccionarCelular(1);
        validarDatosCelular(primerCelular);
        
    }




    private static void navegarSitio(String url) {
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    private static void verificarLandingPage() {
        // verificar que existan logoTelcel, tiendaEnLinea, campoBusqueda y asegurarnos que esta visible

        WebElement logoTelcel = driver.findElement(By.cssSelector("[src='/content/dam/htmls/img/icons/logo-telcel.svg']"));
        WebElement tiendaEnLinea =  driver.findElement(By.cssSelector("[data-nombreboton='Tienda en linea superior']"));
        WebElement campoBusqueda = driver.findElement(By.cssSelector("#buscador-menu-input"));

        if (logoTelcel.isDisplayed() && tiendaEnLinea.isDisplayed() && campoBusqueda.isDisplayed())
        {
            System.out.println("Pagina principal de telcel carga perfecto");
        }
        else {
            System.out.println("no carga la pagina");
            System.exit(-1); //sale del programa y regrea un -1 para marcar un error.
        }

    }

    private static void listarTelefonos() {

        //linkTelefonosCelulares: css= ".dropdown-menu [href='/personas/equipos/telefonos-y-smartphones']]"
        //
        //ModalSeleccionEstado: css=".modal-dialog.modal-lg"
        //seleccionaEstadoDropdown: css=".chosen-single span"
        //
        //campoBusquedaEstado: css=".chosen-search input"
        //
        //ligaEstado: css=".chosen-results.active-result"
        //
        //botonEntrar:css="#entrarPerfilador"
        WebElement tiendaEnLinea = driver.findElement(By.cssSelector("[data-nombreboton='Tienda en linea superior']"));
        tiendaEnLinea.click();
        WebElement linkTelefonosCelulares = driver.findElement(By.cssSelector(".shortcut-container [data-nombreboton='Telefonos y smartphones']"));
        linkTelefonosCelulares.click();
    }
    private static void seleccionarEstado(String nombreEstado) {
    }
    private static void verificarPaginaResultados() {
    }
    private static Celular capturarDatosCelular(int i) {
        return null;
    }
    private static void seleccionarCelular(int numeroCelular) {
    }
    private static void validarDatosCelular(Celular primerCelular) {
    }

}
