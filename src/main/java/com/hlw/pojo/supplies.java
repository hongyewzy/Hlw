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
    private String deng1;
    private String deng2;
    private String date;

    public supplies(String feng1, String feng2, String deng1,String deng2) {
        this.feng1=feng1;
        this.feng2=feng2;
        this.deng1=deng1;
        this.deng2=deng2;
    }
}
