package chaplinskiy.servlet.web.postServlet;

import chaplinskiy.servlet.model.Post;
import chaplinskiy.servlet.model.Region;
import chaplinskiy.servlet.service.PostService;
import chaplinskiy.servlet.service.RegionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetAllPostsServlet extends HttpServlet {

    private final PostService postService;

    public GetAllPostsServlet() {
        this.postService = new PostService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Post> posts = postService.getAllPosts();
        String postResp = "";

        for(Post p : posts){
            String postString = p.toString() + "\n";
            postResp += postString;
        }

        postResp = postResp.trim();

        resp.getWriter().print(postResp);
    }
}
