package Servlets;

import DB.DBManager;
import DB.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/updateprofile")
public class UpdateProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String redirect = "/login";
        User user = (User) request.getSession().getAttribute("CURRENT_USER");

        if(user!=null){
            String fullName = request.getParameter("full_name");
            String birthDate = request.getParameter("birthdate");
            user.setFull_name(fullName);
            user.setBirth_date(birthDate);

            if(DBManager.updateUser(user)){
                request.getSession().setAttribute("CURRENT_USER", user);
                redirect = "/profile?success";
            }
        }

        response.sendRedirect(redirect);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
