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
		   Element preguntaNode = (Element) list.get(i);
                   //Obteniendo el valor de las opciones
                   Element drags = preguntaNode.getChild("DRAGS");
                   List ops = drags.getChildren("OPCION");
                   String opcionesDRAGS = "";
                   for(int j = 0; j < ops.size() ; j++){
                       
                       Element nodeopcion = (Element) ops.get(j);
                       opcionesDRAGS += "opcion_"+j+"="+nodeopcion.getText()+"&";
                   }
                   //Obteniendo el valor de los targets
                   Element targets = preguntaNode.getChild("TARGETS");
                   List ops2 = targets.getChildren("OPCION");
                   String opcionesTARGETS = "";
                   for(int a = 0; a < ops2.size() ; a++){
                       
                       Element nodetarget = (Element) ops2.get(a);
                       opcionesTARGETS += "target_"+a+"="+nodetarget.getText()+"&";
                   }
                   
		   out.println("<td>" +preguntaNode.getChildText("TITULO")+"<td />");
		   out.println("<td> <a href='LeerPregunta?TEXTO="+preguntaNode.getAttributeValue("TEXTO")+"&"+opcionesDRAGS+"&"+opcionesTARGETS+"'>LEER PREGUNTA</a> | <a href='#'>MODIFICAR PREGUNTA</a> | <a href='#'>ELIMINAR PREGUNTA</a><td />");    
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
