package chaplinskiy.servlet.web.postServlet;

import chaplinskiy.servlet.model.Post;
import chaplinskiy.servlet.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeletePostServlet extends HttpServlet {

    private final PostService postService;

    public DeletePostServlet() {
        this.postService = new PostService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        postService.deletePostById(Long.valueOf(id));

        resp.getWriter().print("Post delete, where id is " + id);
    }
}
