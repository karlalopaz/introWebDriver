package tareas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class LikeSongParent extends SongsBySinatraParent
{
    public static void seleccionarCancion(int numeroCancion)
    {
        List<WebElement> listaCanciones = driver.findElements(By.cssSelector("#songs li a"));
        System.out.println("la lista de caciones es de " +listaCanciones.size() + " canciones");
        WebElement cancion = listaCanciones.get(numeroCancion - 1);
        cancion.click();
    }

    public static void darLike()
    {
        WebElement like = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("like")));
        WebElement nombreCancion = driver.findElement(By.cssSelector("section h1"));
        String nombre = nombreCancion.getText();
        if (like.isDisplayed())
        {
            WebElement darLike = driver.findElement(By.cssSelector("[value='Like']"));
            darLike.click();
            System.out.println("Se le ha dado like a la cancion "+ nombre + " ;) ");
        }
        else
        {
            System.out.println("No hay boton para darle like a la cancion");
        }
    }

    public static void logOut()
    {
        WebElement logout = driver.findElement(By.cssSelector("[href='/logout']"));
        logout.click();
    }

    public static void validarLogout(String mensajeLogout)
    {
        WebElement logoutMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        if (logoutMessage.isDisplayed())
        {
            System.out.println("Logout exitoso");
        }
        else
        {
            System.out.println("no se hizo el logout");
            System.exit(-1); //sale del programa y regrea un -1 para marcar un error.
        }
    }
}