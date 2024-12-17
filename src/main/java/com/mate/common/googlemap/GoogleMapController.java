package com.mate.common.googlemap;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/maps")
public class GoogleMapController {
  
  @Value("${google.maps.api-key}")
  private String apiKey;

  private final RestTemplate restTemplate;

  public GoogleMapController(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @GetMapping("/places")
  public ResponseEntity<String> searchPlaces(@RequestParam String query) {
      String url = String.format(
          "https://maps.googleapis.com/maps/api/place/textsearch/json?query=%s&key=%s",
          URLEncoder.encode(query, StandardCharsets.UTF_8),
          apiKey
      );

      String response = restTemplate.getForObject(url, String.class);
      return ResponseEntity.ok(response);
  }

  @GetMapping("/geocode")
  public ResponseEntity<String> getGeocoding(@RequestParam String latlng) {
      String url = String.format(
          "https://maps.googleapis.com/maps/api/geocode/json?latlng=%s&key=%s",
          latlng, apiKey
      );
      String response = restTemplate.getForObject(url, String.class);
      return ResponseEntity.ok(response);
  }


  
  @GetMapping("/reverse-geocode")
  public ResponseEntity<String> getReverseGeocoding(@RequestParam double lat, @RequestParam double lng) {
      String latlngParam = lat + "," + lng;
      String url = String.format(
          "https://maps.googleapis.com/maps/api/geocode/json?latlng=%s&key=%s",
          URLEncoder.encode(latlngParam, StandardCharsets.UTF_8),
          apiKey
      );
      String response = restTemplate.getForObject(url, String.class);
      System.out.println(response);
      return ResponseEntity.ok(response);
  }

}