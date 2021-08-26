package Servlets;

import DB.DBManager;
import DB.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/updatepassword")
public class UpdatePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirect = "/login";
        User user = (User) request.getSession().getAttribute("CURRENT_USER");

        if(user!=null){
            String oldPass = request.getParameter("old_password");
            String newPass = request.getParameter("new_password");
            String reNewPass = request.getParameter("re_new_password");

            redirect = "/profile?newpasserror";

            if(newPass.equals(reNewPass)){
                redirect = "/profile?oldpasserror";
                if(user.getPassword().equals(oldPass)){
                    user.setPassword(newPass);
                    if(DBManager.updatePassword(user)){
                        request.getSession().setAttribute("CURRENT_USER", user);
                        redirect = "/profile?success";
                    }
                }
            }
        }

        response.sendRedirect(redirect);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
