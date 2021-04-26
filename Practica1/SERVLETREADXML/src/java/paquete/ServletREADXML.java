package paquete;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class ServletREADXML extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
          String ruta=request.getRealPath("/");                
	  SAXBuilder builder = new SAXBuilder();
	  File xmlFile = new File(ruta+"alumnos.xml");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletREADXML</title>");            
            out.println("</head>");
            out.println("<body>");
	  try {
		Document document = (Document) builder.build(xmlFile);
		Element rootNode = document.getRootElement();
                String atributo=rootNode.getAttributeValue("atributo");
                out.println(atributo+"<br />");
		List list = rootNode.getChildren("alumno");             
		for (int i = 0; i < list.size(); i++) 
                {
		   Element node = (Element) list.get(i);
		   out.println("Nombre: " + node.getChildText("nombre")+"<br />");
		   out.println("Apellido : " + node.getChildText("apellido")+"<br />");                                   
		}
            out.println("</body>");
            out.println("</html>");                

	  } 
          catch (IOException io) 
          {
		System.out.println(io.getMessage());
	  } 
          catch (JDOMException jdomex) 
          {
		System.out.println(jdomex.getMessage());
	  }        


    }
}
