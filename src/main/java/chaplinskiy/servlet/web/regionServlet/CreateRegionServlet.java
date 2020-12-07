package chaplinskiy.servlet.web.regionServlet;

import chaplinskiy.servlet.model.Region;
import chaplinskiy.servlet.service.RegionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateRegionServlet extends HttpServlet {

    private final RegionService regionService;

    public CreateRegionServlet() {
        this.regionService = new RegionService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");

        regionService.createRegion(name);

        resp.getWriter().print("region is create, where name is " + name);
    }
}