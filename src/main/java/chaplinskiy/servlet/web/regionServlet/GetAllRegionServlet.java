package chaplinskiy.servlet.web.regionServlet;

import chaplinskiy.servlet.model.Region;
import chaplinskiy.servlet.service.RegionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetAllRegionServlet extends HttpServlet {

    private final RegionService regionService;

    public GetAllRegionServlet() {
        this.regionService = new RegionService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Region> regions = regionService.getAll();
        String regionsResp = "";

        for(Region r : regions){
            String regionString = r.getId() + ", " + r.getName() + "\n";
            regionsResp += regionString;
        }

        regionsResp = regionsResp.trim();

        resp.getWriter().print(regionsResp);
    }
}
