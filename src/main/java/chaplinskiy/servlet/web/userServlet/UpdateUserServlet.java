package chaplinskiy.servlet.web.userServlet;

import chaplinskiy.servlet.model.Region;
import chaplinskiy.servlet.model.Role;
import chaplinskiy.servlet.model.User;
import chaplinskiy.servlet.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUserServlet extends HttpServlet {

    private final UserService userService;

    public UpdateUserServlet() {
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        User userBuId = userService.getUserBuId(Long.valueOf(id));

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String regionName = req.getParameter("region");

        Region region = new Region();
        region.setName(regionName);


        userBuId.setFirstName(firstName);
        userBuId.setLastName(lastName);
        userBuId.setRegion(region);
        userBuId.setRole(Role.USER);


        userService.updateUser(userBuId);
        resp.getWriter().print("User update");
    }
}
