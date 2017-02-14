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
 * Created by andrea on 07/02/17.
 */
public class list_libraryview extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        DVDCollection dvdLibrary = DVDCollection.getDvdCollection();

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>LibraryServelet</title>");
            out.println("<style>");
            out.println("table {");
            out.println("border-collapse: collapse;");
            out.println("width: 100%;");
            out.println("}");
            out.println("td, th {");
            out.println("border: 1px solid #dddddd;");
            out.println("text-align: left;");
            out.println("padding: 8px;");
            out.println("}");
            out.println("tr:nth-child(even) {");
            out.println("background-color: #dddddd;");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>You have " + dvdLibrary.getLibrary().size() + " DVD in your collection.</p>");
            out.println("<table>");

            if (! dvdLibrary.getLibrary().isEmpty()) {
                out.println("<tr><td>id<td>TITLE</td><td>YEAR</td><td>GENRE</td><td>EDIT</td><td>DELETE</td></tr>");
                for (DVDItem dvd : dvdLibrary.getLibrary()) {
                    out.println("<tr>");
                    out.println("<td>" + dvd.getDvdId() + "</td>"); //test id
                    out.println("<td>" + dvd.getDvdTitle() + "</td>");
                    out.println("<td>" + dvd.getDvdYear() + "</td>");
                    out.println("<td>" + dvd.getDvdGenre() + "</td>");

                    out.println("<td><form action=formDvd.view method='POST'>"
                              + "<input name='id' value='" + dvd.getDvdId() + "' type='hidden'>"
                              + "<input type='submit' value='edit'> </form></td>");

                    out.println("<td><form action=delDvd.do method='POST'>"
                              + "<input name='id' value='" + dvd.getDvdId() + "' type='hidden'>"
                              + "<input type='submit' value='delete'> </form></td>");
                    out.println("</tr>");
                }
            }
            out.println("</table>");
            out.println("<br>");
            out.println("<form action=homepage.view method='POST'>"
                    + "<input type='submit' value='back Home'></form>");

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