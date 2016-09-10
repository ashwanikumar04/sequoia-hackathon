package com.aksm.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by AshwaniK on 9/10/2016.
 */
@Document(indexName = "moviedb", type = "theatre", shards = 1, replicas = 0, refreshInterval = "-1")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Theater {
    @Id
    public String id;
    @JsonProperty("VenueCode")
    public String venueCode;
    @JsonProperty("VenueAddress")
    public String venueAddress;
    @JsonProperty("IsATMOSEnabled")
    public String isATMOSEnabled;
    @JsonProperty("VenueLegends")
    public String venueLegends;
    @JsonProperty("VenueName")
    public String venueName;
    @JsonProperty("VenueLongitude")
    public String venueLongitude;
    public Location location;
    @JsonProperty("VenueSubRegionCode")
    public String venueSubRegionCode;
    @JsonProperty("CinemaUnpaidFlag")
    public String cinemaUnpaidFlag;
    @JsonProperty("CompanyCode")
    public String companyCode;
    @JsonProperty("VenueLatitude")
    public String venueLatitude;
    @JsonProperty("VenueSubRegionName")
    public String venueSubRegionName;
}
