package alumno;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import java.util.List;
import java.io.File;

public class LeerPregunta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        /* TODO output your page here. You may use following sample code. */
        String texto = request.getParameter("TEXTO");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Datos</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>"+texto+"</h1>");
         String opcion = "";
        for(int i = 0; i < 4; i++){
           opcion =  request.getParameter("opcion_"+i);
           out.println("<h1>"+opcion+"</h1>");
        }
        

        out.println("</body>");
        out.println("</html>");
    }

}
