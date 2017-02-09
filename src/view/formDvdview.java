package view;

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Add DVD</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action='addDvd.do' method='POST'>");
            out.println("Title:<br>");
            out.println("<input type='text' name='title' value='insert Title'>");
            out.println("<br><br>");
            out.println("Year:<br>");
            out.println("<input type='text' name='year' value='insert Year'>");
            out.println("<br><br>");
            out.println("Genre:<br>");
            out.println("<select name='genre'>");
            out.println("<option value ='UNKNOW'>select...</option>");
            out.println("<option value ='Sci-Fi'>Sci-Fi</option>");
            out.println("<option value ='Cartoon'>Cartoon</option>");
            out.println("<option value ='Dramatics'>Dramatics</option>");
            out.println("</select>");
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
