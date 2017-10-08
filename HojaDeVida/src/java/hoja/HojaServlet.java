package hoja;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lógica.Formacion;
import lógica.Otros;
import lógica.Persona;

/**
 *
 * @author Juliana Alexandra
 */
@WebServlet(name = "HojaServlet", urlPatterns = {"/HojaServlet"})
public class HojaServlet extends HttpServlet {
    
    //Creacion de objetos
    Persona humano = new Persona();
    Formacion estudio = new Formacion();
    Otros extras = new Otros();
    
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
        
        //Obtencion los datos personales
        humano.setNombres(request.getParameter("nombres"));
        humano.setApellidos(request.getParameter("apellidos"));
        humano.setDocumento(Integer.parseInt(request.getParameter("documento")));
        humano.setEdad(Integer.parseInt(request.getParameter("edad")));
        humano.setTelefono(Integer.parseInt(request.getParameter("telefono")));
        humano.setDireccion(request.getParameter("direccion"));
        humano.setEmail(request.getParameter("email"));
        humano.setLugarNacimiento(request.getParameter("lugarNacimiento"));
        //Obtencion de los datos de estudio
        estudio.setNivel(request.getParameter("nivel"));
        estudio.setInstitucion(request.getParameter("institucion"));
        estudio.setFechafin(request.getParameter("fechaFin"));
        estudio.setIdiomas(request.getParameter("idiomas"));
        //Obtención de los datos extras
        extras.setViaje(request.getParameter("viaje"));
        extras.setVisa(request.getParameter("visa"));
        extras.setVehiculo(request.getParameter("vehiculo"));
        
        response.setContentType("text/html;charset=UTF-8");
        
      
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println(" <link rel =\"stylesheet\" type=\"text/css\" href=\"css/estilosHoja.css\" />");
            out.println("<title>Servlet HojaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1><font color = 346392><center>HOJA DE VIDA </color></h1></center>");
            out.println("DATOS PERSONALES<br>");
            out.println("NOMBRES: "+humano.getNombres()+"<br>");
            out.println("APELLIDOS: "+humano.getApellidos()+"<br>");
            out.println("DOCUMENTO: "+humano.getDocumento()+"<br>");
            out.println("EDAD: "+humano.getEdad()+"<br>");
            out.println("TELEFONO: "+humano.getTelefono()+"<br>");
            out.println("DIRECCION: "+humano.getDireccion()+"<br>");
            out.println("E-MAIL: "+humano.getEmail()+"<br>");
            out.println("LUGAR DE NACIMIENTO: "+humano.getLugarNacimiento()+"<br>");
            out.println("<br>");
            out.println("FORMACIÓN ACADÉMICA<br>");
            out.println("NIVEL DE ESTUDIOS: "+estudio.getNivel()+"<br>");
            out.println("INSTITUCIÓN: "+estudio.getInstitucion()+"<br>");
            out.println("FECHA DE FINALIZACIÓN: "+estudio.getFechafin()+"<br>");
            out.println("IDIOMAS: "+estudio.getIdiomas()+"<br>");
            out.println("<br>");
            out.println("OTROS<br>");
            out.println("DISPONIBILIDAD PARA VIAJAR: "+extras.getViaje()+"<br>");
            out.println("VISA: "+extras.getVisa()+"<br>");
            out.println("VEHÍCULO PROPIO: "+extras.getVehiculo()+"<br>");
            out.println("</body>");
            out.println("</html>");
        
        }
    }

   public boolean validar(HttpServletRequest request, HttpServletResponse response){
        
        if(humano.getNombres()==null || humano.getApellidos()==null){
            
            return false;
        }
        return true;
        
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
