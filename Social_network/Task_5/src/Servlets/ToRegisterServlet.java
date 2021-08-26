package Servlets;

import DB.DBManager;
import DB.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/toregister")
public class ToRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("re_password");
        String fullName = request.getParameter("full_name");
        String birthdate = request.getParameter("birthdate");
        String picture_url = request.getParameter("picture_url");

        String redirect = "/register?passworderror";

        if(password.equals(rePassword)){
            redirect = "/register?emailerror";
            User user  = DBManager.getUser(email);
            System.out.println(user);

            if(user == null){

                User newUser = new User(null, email, password, fullName, birthdate, picture_url);

                if(DBManager.addUser(newUser)){
                    redirect = "/register?succes";
                }
            }
        }
        response.sendRedirect(redirect);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/register.jsp").forward(request,response);
    }
}
