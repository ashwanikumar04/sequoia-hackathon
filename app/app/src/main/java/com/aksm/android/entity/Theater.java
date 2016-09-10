package com.aksm.android.entity;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Builder;

/**
 * Created by AshwaniK on 9/10/2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(suppressConstructorProperties = true)
@Builder
public class Theater {
    private String id;
    @SerializedName("VenueCode")
    private String venueCode;
    @SerializedName("VenueAddress")
    private String venueAddress;
    @SerializedName("IsATMOSEnabled")
    private String isATMOSEnabled;
    @SerializedName("VenueLegends")
    private String venueLegends;
    @SerializedName("VenueName")
    private String venueName;
    @SerializedName("VenueLongitude")
    private String venueLongitude;
    private Location location;
    @SerializedName("VenueSubRegionCode")
    private String venueSubRegionCode;
    @SerializedName("CinemaUnpaidFlag")
    private String cinemaUnpaidFlag;
    @SerializedName("CompanyCode")
    private String companyCode;
    @SerializedName("VenueLatitude")
    private String venueLatitude;
    @SerializedName("VenueSubRegionName")
    private String venueSubRegionName;
}
