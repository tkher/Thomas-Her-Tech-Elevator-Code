package com.techelevator.locations.services;

import com.techelevator.locations.model.Location;
import com.techelevator.util.BasicLogger;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class LocationService {

    private static final String API_BASE_URL = "http://localhost:8080/locations/";
    private final RestTemplate restTemplate = new RestTemplate();

    private String authToken = null;

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public Location[] getAll() {
        Location[] locations = null;
        try {
            //step 1 - Create HTTP headers in order to pass the authentication code
                //Refactored into makeAuthEntity()
//            HttpHeaders httpHeaders = new HttpHeaders();
//            httpHeaders.setBearerAuth(authToken);

            //step 2 - We need to use an exchange() method in order for us to send the get request and recieve the response/response body
            //we do so by creating http entity
//            HttpEntity<Void> entity = new HttpEntity<>(httpHeaders); // httpEntity takes the headers as the parameter
            ResponseEntity<Location[]> response = restTemplate.exchange(API_BASE_URL, HttpMethod.GET, makeAuthEntity(), Location[].class);

            locations=response.getBody(); //reponse method replaces previous get methoed below.

            //locations = restTemplate.getForObject(API_BASE_URL, Location[].class); <-- old get method
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return locations;
    }

    public Location getOne(int id) {
        Location location = null;
        try {
            //Step two - get one
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setBearerAuth(authToken);

            HttpEntity<Void> entity = new HttpEntity<>(httpHeaders);
            ResponseEntity<Location> response = restTemplate.exchange(API_BASE_URL + id,HttpMethod.GET,makeAuthEntity(),Location.class);

            location = response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return location;
    }

    public Location add(Location newLocation) {
        HttpEntity<Location> entity = makeLocationEntity(newLocation);

        Location returnedLocation = null;
        try {
            returnedLocation = restTemplate.postForObject(API_BASE_URL, entity, Location.class);
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return returnedLocation;
    }

    public boolean update(Location updatedLocation) {
        HttpEntity<Location> entity = makeLocationEntity(updatedLocation);

        boolean success = false;
        try {
            restTemplate.put(API_BASE_URL + updatedLocation.getId(), entity);
            success = true;
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return success;
    }

    public boolean delete(int id) {
        boolean success = false;
        try {
            restTemplate.exchange(API_BASE_URL + id, HttpMethod.DELETE, makeAuthEntity(), Void.class);
            success = true;
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return success;
    }

    private HttpEntity<Location> makeLocationEntity(Location location) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(location, headers);
    }

    private HttpEntity<Void> makeAuthEntity() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(authToken);
        return new HttpEntity<>(httpHeaders);
    }

}
