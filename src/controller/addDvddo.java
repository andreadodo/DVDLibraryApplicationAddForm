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
 * Created by andrea on 09/02/17.
 */
public class addDvddo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Keep a set of strings to record from processing errors.
        List errorMsgs = new LinkedList();
        request.setAttribute("errorMsgs", errorMsgs);

        try {
            //Retrieve from parameters.
            String title = request.getParameter("title").trim();
            String yearStr = request.getParameter("year").trim();
            String genre = request.getParameter("genre").trim();

            int year = -1;
            try {
                year = Integer.parseInt(yearStr);
            } catch (NumberFormatException nfe) {
                errorMsgs.add("The 'year' field must be a number.");
            }

            //Verify form parametrs
            if (genre.equals("UNKNOW"))
                errorMsgs.add("Please select a genre.");
            if (title.length() == 0 || title.equals("insert Title"))
                errorMsgs.add("Please enter title of the Dvd.");

            if ((year != -1) && ((year < 1900) || (year > 2017))) {
                if (year > 2017)
                    errorMsgs.add("Wow ... a dvd from the future.");
                else
                    errorMsgs.add("The 'year' field must within 1900 to 2017");
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

            DVDItem dvd = new DVDItem(title,year,genre); //TODO inserimenento dvd

            dvdLibrary.addDvd(dvd);

            request.setAttribute("dvd", dvd);

            //Open succes view
            RequestDispatcher view = request.getRequestDispatcher("Success.view");
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