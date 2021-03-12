import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@WebServlet("/headers")
public class Servlet_Headers extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        if(name == null){
            name = "";
        }

        Locale locale = request.getLocale();
        String languageTag = locale.toLanguageTag().substring(0,2);

        String greeting;
        switch (languageTag){
            case "fr":
                greeting = "Bonjour";
                break;
            case "de":
                greeting = "Guten Tag";
                break;
            default:
                greeting = "Hello";
                languageTag = "en";
        }
        response.setHeader("Content-Language", languageTag);

        response.getWriter().println(greeting + " " + name);
    }
}
