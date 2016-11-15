package edu.bsuir.cinema.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static edu.bsuir.cinema.utils.pageConstants.*;

/**
 * Created by Alesha on 01.10.2016.
 */
public class ErrorController extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    protected void doAction(HttpServletRequest request,
                            HttpServletResponse response) throws IOException, ServletException {
        getServletContext().getRequestDispatcher(INDEX_PAGE).forward(request, response);
    }
}
