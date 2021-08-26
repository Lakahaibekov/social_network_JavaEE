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

@WebServlet(value = "/editpost")
public class EditPostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirect="/login";

        User currentUser = (User)request.getSession().getAttribute("CURRENT_USER");
        if(currentUser!=null){

            Long id = Long.parseLong(request.getParameter("update_id"));
            String title = request.getParameter("update_title");
            String short_content = request.getParameter("update_short_content");
            String content = request.getParameter("update_content");
            Long user_id = currentUser.getId();

            Posts post = null;
            post = DBManager.getPost(id);
            if (post != null) {

                post.setId(id);
                post.setTitle(title);
                post.setShort_content(short_content);
                post.setContent(content);
                currentUser.setId(user_id);
                post.setAuthod_id(currentUser);

                DBManager.savePost(post);
                redirect = "/postdetails?post_id="+id;

            }

            response.sendRedirect(redirect);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
