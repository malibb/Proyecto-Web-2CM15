/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author AlexiSmuuk
 */
public class CrearPregunta extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>CrearPregunta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Crear nueva pregunta</h1>");
            out.println("<p>Nombre pregunta <input type='text' name='nombre Pregunta' size='40'></p>");
            out.println("<p>Pregunta <input type='text' name='Pregunta' size='40'></p>");
            out.println("<p>respuesta <input type='text' name='Respuesta' size='40'></p>");
            out.println("<p>Drag opcion 1 <input type=\"text\" name=\"\" size=\"40\"> <input type='file' /></p>");
                        out.println("<p>Drag opcion 2 <input type=\"text\" name=\"\" size=\"40\"> <input type='file' /></p>");
            out.println("<p>Drag opcion 3 <input type=\"text\" name=\"\" size=\"40\"> <input type='file' /></p>");
            out.println("<p>Drag opcion 4 <input type=\"text\" name=\"\" size=\"40\"> <input type='file' /></p>");
            out.println("<p>Target opcion 1 <input type=\"text\" name=\"\" size=\"40\"> <input type='file' /></p>");
            out.println("<p>Target opcion 2 <input type=\"text\" name=\"\" size=\"40\"> <input type='file' /></p>");
            out.println("<p>Target opcion 3 <input type=\"text\" name=\"\" size=\"40\"> <input type='file' /></p>");
            out.println("<p>Target opcion 4 <input type=\"text\" name=\"\" size=\"40\"> <input type='file' /></p>");
            out.println("<input type='submit' />");


            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
