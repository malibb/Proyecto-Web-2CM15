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
import java.io.FileWriter;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class EliminarPregunta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        /* TODO output your page here. You may use following sample code. */

        String ruta = request.getRealPath("/");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Datos</title>");
        out.println("</head>");
        out.println("<body>");
        String texto = request.getParameter("TEXTO");
        try {
            SAXBuilder builder = new SAXBuilder();
            File xmlFile = new File(ruta + "RELACION_DE_COLUMNAS.xml");
            Document doc = builder.build(xmlFile);
            Element root = doc.getRootElement();
            List list = root.getChildren("PREGUNTA");
            for (int i = 0; i < list.size(); i++) {
                Element preguntaNode = (Element) list.get(i);
                if (preguntaNode.getAttributeValue("TEXTO").equals(texto)) {
                    preguntaNode.removeChild("DRAGS");
                    preguntaNode.removeChild("TARGETS");
                    preguntaNode.removeChild("TITULO");
                    XMLOutputter xmlOutput = new XMLOutputter();
                    xmlOutput.setFormat(Format.getPrettyFormat());
                    FileWriter writer = new FileWriter(ruta + "RELACION_DE_COLUMNAS.xml");
                    xmlOutput.output(doc, writer);
                    writer.flush();
                    writer.close();
                }
            }
            out.println("ELEMENTO BORRADO: recuerda que los cambios no se ven al instante en netbeans, <br/> puedes visualizar en buscando el xml directamente y abriendolo. <3");
            out.println("</body>");
            out.println("</html>");
        } catch (IOException | JDOMException e) {
            e.printStackTrace();
        }

        out.println("</body>");
        out.println("</html>");
    }

}
