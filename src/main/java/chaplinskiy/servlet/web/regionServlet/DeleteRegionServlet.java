package chaplinskiy.servlet.web.regionServlet;

import chaplinskiy.servlet.model.Region;
import chaplinskiy.servlet.service.RegionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteRegionServlet extends HttpServlet {

    private final RegionService regionService;

    public DeleteRegionServlet() {
        this.regionService = new RegionService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        System.out.println(id);

        regionService.deleteRegionById(Long.valueOf(id));

        resp.getWriter().print("Remove region where id is " + id);
    }
}