package be.helb.smakani.service;

import be.helb.smakani.destination.DataAcessDestinationClient;
import be.helb.smakani.dto.DestinationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class DataDestinationService {

    private final DataAcessDestinationClient dataAcessDestinationClient;

    @Autowired
    public DataDestinationService(DataAcessDestinationClient dataAcessDestinationClient) {
        this.dataAcessDestinationClient = dataAcessDestinationClient;
    }

    public List<DestinationDto> getDestinations(){
        return dataAcessDestinationClient.getDestinations();
    }

    public DestinationDto createDestination(DestinationDto destinationDto){
        return dataAcessDestinationClient.createDestination(destinationDto);
    }

    public DestinationDto deleteDestination(@PathVariable("id") Long id){
        return dataAcessDestinationClient.deleteDestination(id);
    }
}
