package com.hlw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class supplies {
    private String id;
    private String feng1;
    private String feng2;
    private String deng;
    private String date;

    public supplies(String feng1, String feng2, String deng) {
        this.feng1=feng1;
        this.feng2=feng2;
        this.deng=deng;
    }
}
