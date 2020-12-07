package chaplinskiy.servlet.web.postServlet;

import chaplinskiy.servlet.model.Post;
import chaplinskiy.servlet.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreatePostServlet extends HttpServlet {

    private final PostService postService;

    public CreatePostServlet() {
        this.postService = new PostService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String content = req.getParameter("content");

        postService.createPost(content);

        resp.getWriter().print("Post create, where content is: " + content);
    }
}
