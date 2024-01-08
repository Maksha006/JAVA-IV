package be.helb.smakani.service;

import be.helb.smakani.dao.DestinationDao;
import be.helb.smakani.model.Destination;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService
{
    private final DestinationDao destinationDao;

    public DestinationService(DestinationDao destinationDao) {
        this.destinationDao = destinationDao;
    }

    public List<Destination> findAll() {
        return destinationDao.findAll();
    }

    public Destination findByCityName(String cityName){
        return destinationDao.findByCityName(cityName);
    }

    public void delete(Long id) {
        destinationDao.deleteById(id);
    }

    public Destination save(Destination destination) {
        return destinationDao.save(destination);
    }
}
