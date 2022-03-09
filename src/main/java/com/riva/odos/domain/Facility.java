package com.riva.odos.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "us_1a")
public class Facility {
    @DBRef
    @Field("10. FACILITY NAME")
    private String name;
    
    @DBRef
    @Field("11. FACILITY STREET")
    private String street;
    
    @DBRef
    @Field("12. FACILITY CITY")
    private String city;
    
    @DBRef
    @Field("13. FACILITY COUNTY")
    private String county;
    
    @DBRef
    @Field("14. FACILITY STATE")
    private String state;
    
    @DBRef
    @Field("15. FACILITY ZIP CODE")
    private int zipCode;
    
    @DBRef
    @Field("47. LATITUDE")
    private String latitude;
    
    @DBRef
    @Field("48. LONGITUDE")
    private String longitude;
}
