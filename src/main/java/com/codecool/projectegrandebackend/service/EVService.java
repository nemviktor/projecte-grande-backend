package com.codecool.projectegrandebackend.service;

import com.codecool.projectegrandebackend.model.EV;
import com.codecool.projectegrandebackend.model.evgenerated.EVResponseItem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
public class EVService {

    @Value("${REACT_APP_OPENCHARGERMAP}")
    private String REACT_APP_OPENCHARGERMAP;
    private String url = "https://api.openchargemap.io/v3/poi/?output=json&latitude=47.497913&longitude=19.040236&distance=20";
//    https://api.openchargemap.io/v3/poi/?output=json&latitude=47.497913&longitude=19.040236&distance=10

    public Set<EV> getEVData(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>("body", headers);
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("X-API-Key",  REACT_APP_OPENCHARGERMAP);



       ResponseEntity<Set<EVResponseItem>> evResponseEntity = restTemplate.exchange(url,
               HttpMethod.GET,
               entity,
               new ParameterizedTypeReference<Set<EVResponseItem>>() {});
        Set<EVResponseItem> evResponse = evResponseEntity.getBody();
        Set<EV> evList = createEVList(evResponse);

        return  evList;
    }

    private Set<EV> createEVList(Set<EVResponseItem> evs) {
        Set<EV> evList = new HashSet<>();
        for(EVResponseItem evResponse: evs){
            EV actualEv = new EV(
                    evResponse.getAddressInfo().getID(),
                    evResponse.getAddressInfo().getAddressLine1(),
                    evResponse.getAddressInfo().getTown(),
                    evResponse.getAddressInfo().getLatitude(),
                    evResponse.getAddressInfo().getLongitude(),
                    evResponse.getAddressInfo().getTitle(),
                    false
            );
            evList.add(actualEv);
        }
        return evList;
    }


}