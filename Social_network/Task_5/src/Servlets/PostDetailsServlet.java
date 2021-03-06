package Servlets;

import DB.DBManager;
import DB.Posts;
import DB.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(value = "/postdetails")
public class PostDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User currentUser = (User)request.getSession().getAttribute("CURRENT_USER");
        if(currentUser!=null){
            Long post_id = Long.parseLong(request.getParameter("post_id"));

            Posts posts = null;
            try {
                posts = DBManager.getPost(post_id);
            } catch (Exception e) {
                e.printStackTrace();
            }

            request.setAttribute("posts", posts);
            request.getRequestDispatcher("/postDetails.jsp").forward(request, response);
        }else{
            response.sendRedirect("/login");
        }
    }
}
