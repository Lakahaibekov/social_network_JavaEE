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
import java.security.Timestamp;

@WebServlet(value = "/addpost")
public class AddPostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String redirect = "/login?emailerror";

        User currentUser = (User)request.getSession().getAttribute("CURRENT_USER");
        if(currentUser!=null) {

            request.setCharacterEncoding("utf8");

            redirect = "/myposts?error";

            String title = request.getParameter("title");
            String shortContent = request.getParameter("short_content");
            String content = request.getParameter("content");


            Posts post = new Posts();
            post.setId(null);
            post.setAuthod_id(currentUser);
            post.setTitle(title);
            post.setShort_content(shortContent);
            post.setContent(content);

            if(DBManager.addPost(post)){
                redirect = "/myposts?success";
            }
        }
        response.sendRedirect(redirect);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
