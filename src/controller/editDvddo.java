package controller;

import model.DVDCollection;
import model.DVDItem;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by andrea on 10/02/17.
 */
public class editDvddo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Keep a set of strings to record from processing errors.
        List errorMsgs = new LinkedList();
        request.setAttribute("errorMsgs", errorMsgs);

        try {
            //Retrieve from parameters.
            String idStr = request.getParameter("id");

            int id = -1;
            try {
                id = Integer.parseInt(idStr);
            } catch (NumberFormatException nfe) {
                errorMsgs.add("The 'id' must be a number.");
            }

            //open error view
            if (!errorMsgs.isEmpty()) {
                request.setAttribute("errors", errorMsgs);
                RequestDispatcher view = request.getRequestDispatcher("Error.view");
                view.forward(request, response);
                return;
            }

            //Perform business logic
            DVDCollection dvdLibrary = DVDCollection.getDvdCollection();
            DVDItem dvd = dvdLibrary.getDvd(id);

            //open succes view
            request.setAttribute("dvd", dvd);
            RequestDispatcher view = request.getRequestDispatcher("formDvd.view");
            view.forward(request, response);
            return;

            //Handle any unexpected exceptions
        } catch (RuntimeException re) {
            errorMsgs.add(re.getMessage());
            request.setAttribute("errors", errorMsgs);
            RequestDispatcher view = request.getRequestDispatcher("Error.view");
            view.forward(request, response);
        }
    }
}