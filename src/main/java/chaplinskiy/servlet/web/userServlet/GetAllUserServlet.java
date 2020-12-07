package chaplinskiy.servlet.web.userServlet;

import chaplinskiy.servlet.model.User;
import chaplinskiy.servlet.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetAllUserServlet extends HttpServlet {

    private final UserService userService;

    public GetAllUserServlet() {
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userService.getAllUser();

        resp.getWriter().print(users.toString());

    }
}
