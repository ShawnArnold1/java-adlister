import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet
{
    public static final String USERNAME = "username";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Cookie myCookie = new Cookie(USERNAME, "Shawn");
        Cookie[] cookies = request.getCookies();


        for(Cookie cookie : cookies )
        {
            if (cookie.getName().equals(USERNAME))
            {
                myCookie = cookie;
            }
        }



        response.addCookie(myCookie);
        HttpSession session = request.getSession();
        String languagePreference = (String) session.getAttribute("language");
        if(languagePreference == null)
        {
            session.setAttribute("language", "en");
            languagePreference = "en";
        }

        if(request.getParameter("language") != null)
        {
            languagePreference = request.getParameter("language");
            session.setAttribute("language", request.getParameter("language"));
        }


        String greeting;
        switch(languagePreference)
        {
            case "en" :
                greeting = "Hello";
                break;
            case "fr" :
                greeting = "Bonjour";
                break;
            case "es" :
                greeting = "Hola";
                break;
            default:
                greeting = "Wassup boi";
        }



        request.setAttribute(USERNAME, myCookie.getValue());
        request.setAttribute("greeting", greeting);
        request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);

    }
}
