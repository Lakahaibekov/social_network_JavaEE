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
import java.util.ArrayList;

@WebServlet(value = "/myposts")
public class MyPostsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User currentUser = (User)request.getSession().getAttribute("CURRENT_USER");
        if(currentUser!=null){
            ArrayList<Posts> posts = new ArrayList<>();
            posts = DBManager.getAllPosts(currentUser.getId());
            request.setAttribute("posts", posts);
            request.getRequestDispatcher("/myPosts.jsp").forward(request, response);
        }else{
            response.sendRedirect("/login");
        }
    }
}
