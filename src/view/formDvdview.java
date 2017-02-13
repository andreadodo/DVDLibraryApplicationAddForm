package view;

import model.DVDCollection;
import model.DVDItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by andrea on 09/02/17.
 */
public class formDvdview extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            //Retrieve from parameters.
            String idStr = request.getParameter("id");

            int id = -1;
            try {
                id = Integer.parseInt(idStr);
            } catch (NumberFormatException nfe) {
            }

            DVDCollection dvdLibrary = DVDCollection.getDvdCollection();
            DVDItem dvd = dvdLibrary.getDvd(id);

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Add DVD</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action='addDvd.do' method='POST'>");

            if(idStr != null)
                out.println("<input type='hidden' name='id' value='"+ dvd.getDvdId() +"'>");

            out.println("Title:<br>");
            if(idStr == null)
                out.println("<input type='text' name='title' value='insert Title'>");
            else
                out.println("<input type='text' name='title' value='"+ dvd.getDvdTitle() +"'>");
            out.println("<br><br>");
            out.println("Year:<br>");
            if(idStr == null)
                out.println("<input type='text' name='year' value='insert Year'>");
            else
                out.println("<input type='text' name='year' value='"+ dvd.getDvdYear() +"'>");
            out.println("<br><br>");
            out.println("Genre:<br>");
            if(idStr == null) {
                out.println("<select name='genre'>");
                out.println("<option value ='UNKNOW'>select...</option>");
                out.println("<option value ='Sci-Fi'>Sci-Fi</option>");
                out.println("<option value ='Cartoon'>Cartoon</option>");
                out.println("<option value ='Dramatics'>Dramatics</option>");
                out.println("</select>");
            }
            else {
                out.println("<select name='genre'>");
                out.println("<option value ='Sci-Fi' ");
                if(dvd.getDvdGenre().equals("Sci-Fi"))
                    out.println("selected");
                out.println(">Sci-Fi</option>");
                out.println("<option value ='Cartoon' ");
                if(dvd.getDvdGenre().equals("Cartoon"))
                    out.println("selected");
                out.println(">Cartoon</option>");
                out.println("<option value ='Drammatics' ");
                if(dvd.getDvdGenre().equals("Dramatics"))
                    out.println("selected");
                out.println(">Dramatics</option>");
                out.println("</select>");
            }

            out.println("<br><br>");
            out.println("<input type='submit' value='Add to Library'>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
