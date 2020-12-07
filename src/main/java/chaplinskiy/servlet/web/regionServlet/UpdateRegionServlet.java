package chaplinskiy.servlet.web.regionServlet;

import chaplinskiy.servlet.model.Region;
import chaplinskiy.servlet.service.RegionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateRegionServlet extends HttpServlet {

    private final RegionService regionService;

    public UpdateRegionServlet() {
        this.regionService = new RegionService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");

        Region updateRegion = new Region(Long.valueOf(id), name);

        regionService.updateRegion(updateRegion);

        resp.getWriter().print("Updating region, where id is: " + id);
    }
}
