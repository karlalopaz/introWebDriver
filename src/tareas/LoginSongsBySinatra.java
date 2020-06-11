package tareas;

import org.openqa.selenium.WebDriver;

public class LoginSongsBySinatra  extends SongsBySinatraParent
{
    static WebDriver driver;

    public static void main(String[] args)
    {
        navegarSitio("http://evening-bastion-49392.herokuapp.com/");
        validarHomePage("Welcome to to this website all about the songs of the great Frank Sinatra");
        hacerLogin("frank", "sinatra");
        validarMensajeLogin("You are now logged in as frank");
        validarSongsPage ();
        cerrarBrowser();
    }
}
