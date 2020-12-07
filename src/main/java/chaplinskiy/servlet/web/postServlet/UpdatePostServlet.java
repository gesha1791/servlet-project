package chaplinskiy.servlet.web.postServlet;

import chaplinskiy.servlet.model.Post;
import chaplinskiy.servlet.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class UpdatePostServlet extends HttpServlet {

    private final PostService postService;

    public UpdatePostServlet() {
        this.postService = new PostService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String content = req.getParameter("content");
        String id = req.getParameter("id");

        Post post = new Post();

        post.setId(Long.valueOf(id));
        post.setUpdated(LocalDateTime.now());
        post.setContent(content);

        postService.updatePost(post);

        resp.getWriter().print("Post update, where id is: " + id);
    }
}
