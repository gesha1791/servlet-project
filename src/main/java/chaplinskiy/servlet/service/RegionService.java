package chaplinskiy.servlet.service;

import chaplinskiy.servlet.model.Region;
import chaplinskiy.servlet.repository.RegionRepository;
import chaplinskiy.servlet.repository.hibernate.RegionRepositoryHibernate;

import java.util.List;

public class RegionService {
    private final RegionRepository regionRepository;

    public RegionService(){
        regionRepository = new RegionRepositoryHibernate() {
        };
    }

    public List<Region> getAll() {
        return regionRepository.getAll();
    }

    public void createRegion(String name) {
        Region region = new Region();
        region.setName(name);

        regionRepository.create(region);
    }

    public void deleteRegionById(Long id) {
        regionRepository.deleteById(id);
    }

    public Region getRegionById(Long id) {
        return regionRepository.getById(id);
    }

    public void updateRegion(Region nameUpdateRegion) {
        regionRepository.update(nameUpdateRegion);
    }
}
