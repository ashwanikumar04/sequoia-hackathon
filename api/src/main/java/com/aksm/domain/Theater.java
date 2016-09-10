package com.aksm.domain;

import com.aksm.common.Constants;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

/**
 * Created by AshwaniK on 9/10/2016.
 */
@Document(indexName = Constants.INDEX_NAME, type = Constants.TYPE_THEATER, shards = 1, replicas = 0, refreshInterval = "-1")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Theater {
    @Id
    private String id;
    @JsonProperty("VenueCode")
    private String venueCode;
    @JsonProperty("VenueAddress")
    private String venueAddress;
    @JsonProperty("IsATMOSEnabled")
    private String isATMOSEnabled;
    @JsonProperty("VenueLegends")
    private String venueLegends;
    @JsonProperty("VenueName")
    private String venueName;
    @JsonProperty("VenueLongitude")
    private String venueLongitude;
    private GeoPoint location;
    @JsonProperty("VenueSubRegionCode")
    private String venueSubRegionCode;
    @JsonProperty("CinemaUnpaidFlag")
    private String cinemaUnpaidFlag;
    @JsonProperty("CompanyCode")
    private String companyCode;
    @JsonProperty("VenueLatitude")
    private String venueLatitude;
    @JsonProperty("VenueSubRegionName")
    private String venueSubRegionName;
}
