package chaplinskiy.servlet.web.userServlet;

import chaplinskiy.servlet.model.User;
import chaplinskiy.servlet.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteUserServlet extends HttpServlet {

    private final UserService userService;

    public DeleteUserServlet() {
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        System.out.println(id);

        userService.deleteById(Long.valueOf(id));

        resp.getWriter().print("User remove, where id = " + id);
    }
}
