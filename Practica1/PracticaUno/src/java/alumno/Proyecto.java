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

public class Proyecto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        /* TODO output your page here. You may use following sample code. */
     

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Datos</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>C R U D  preguntas</h1>");
        out.println("<a href='CrearPregunta'>Crear Pregunta</a>");
        out.println("<table>");
        out.println("<tr>"
                + "<td><b>Nombre Pregunta</b></td>"
                + "<td><b>Acciones</b></td>"
                + "</tr>");
        // Bloque de lectura 
         String ruta=request.getRealPath("/");                
	  SAXBuilder builder = new SAXBuilder();
	  File xmlFile = new File(ruta+"RELACION_DE_COLUMNAS.xml");
    
      
	  try {
		Document document = (Document) builder.build(xmlFile);
		Element rootNode = document.getRootElement();
		List list = rootNode.getChildren("PREGUNTA");             
		for (int i = 0; i < list.size(); i++) 
                {
                    out.println("<tr>");
		   Element node = (Element) list.get(i);
		   out.println("<td>" +node.getChildText("TITULO")+"<td />");
		   out.println("<td> LEER PREGUNTA | MODIFICAR PREGUNTA | ELIMINAR PREGUNTA<td />");    
                   out.println("</tr>");
		}              

	  } 
          catch (IOException io) 
          {
		System.out.println(io.getMessage());
	  } 
          catch (JDOMException jdomex) 
          {
		System.out.println(jdomex.getMessage());
	  }        
          // FIN DE BLOQUE DE LECTURA

        out.println("</table>");

        out.println("</body>");
        out.println("</html>");
    }

}
