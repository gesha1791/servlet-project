package chaplinskiy.servlet.web.userServlet;

import chaplinskiy.servlet.model.Region;
import chaplinskiy.servlet.model.Role;
import chaplinskiy.servlet.model.User;
import chaplinskiy.servlet.service.PostService;
import chaplinskiy.servlet.service.RegionService;
import chaplinskiy.servlet.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateUserServlet  extends HttpServlet {

    private final UserService userService;

    public CreateUserServlet() {
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String regionName = req.getParameter("region");

        Region region = new Region();
        region.setName(regionName);

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setRegion(region);
        user.setRole(Role.USER);


        userService.createUser(user);
        resp.getWriter().print("User create");
    }
}
