package com.hlw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class nydata {
    private String id;
    private String starttime;
    private String light;
    private String temperature;
    private String humidity;
    private String ph;
}
