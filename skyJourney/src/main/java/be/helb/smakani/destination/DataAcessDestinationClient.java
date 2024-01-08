package be.helb.smakani.destination;


import be.helb.smakani.dto.DestinationDto;
import feign.RequestLine;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface DataAcessDestinationClient {

    @RequestLine("GET /allDestinations")
    List<DestinationDto> getDestinations();

    @RequestLine("POST /createDestination")
    public DestinationDto createDestination(DestinationDto destinationDto);

    @RequestLine("DELETE /destination/delete/{id}")
    public DestinationDto deleteDestination(@PathVariable("id") Long id);
}
