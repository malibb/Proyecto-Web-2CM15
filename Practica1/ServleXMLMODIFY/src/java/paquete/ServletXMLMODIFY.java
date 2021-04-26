package paquete;

import java.io.File;
import java.io.FileWriter;
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
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;


public class ServletXMLMODIFY extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
          String ruta=request.getRealPath("/");                
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletREADXML</title>");            
            out.println("</head>");
            out.println("<body>");             

            try {
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(ruta+"alumnos.xml");

		Document doc = (Document) builder.build(xmlFile);
		Element rootNode = doc.getRootElement();

		Element alumno = rootNode.getChild("alumno");
		alumno.getAttribute("id").setValue("0");

		Element boleta = new Element("boleta").setText("20201709");
		alumno.addContent(boleta);

		Element grupo = rootNode.getChild("grupo");                
		grupo.setText("MATEMATICAS");

		alumno.removeChild("nombre");

		XMLOutputter xmlOutput = new XMLOutputter();

		xmlOutput.setFormat(Format.getPrettyFormat());
                FileWriter writer = new FileWriter(ruta+"alumnos.xml");                
		xmlOutput.output(doc, writer);
                writer.flush();
                writer.close();                

                out.println("ARCHIVO ACTUALIZADO");
                out.println("</body>");
                out.println("</html>");  
                } 
                catch (IOException e) 
                {
		e.printStackTrace();
                } 
                catch (JDOMException e) 
                {
		e.printStackTrace();
                }

    }
}
