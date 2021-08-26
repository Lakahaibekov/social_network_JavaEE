package Servlets;

import DB.DBManager;
import DB.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/updateurl")
public class UpdateURLServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirect = "/login";
        User user = (User) request.getSession().getAttribute("CURRENT_USER");

        if(user!=null){
            String PictureURL = request.getParameter("picture_url");
            user.setPicture_url(PictureURL);

            if(DBManager.updateURL(user)){
                request.getSession().setAttribute("CURRENT_USER", user);
                redirect = "/profile?success";
            }
        }

        response.sendRedirect(redirect);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
