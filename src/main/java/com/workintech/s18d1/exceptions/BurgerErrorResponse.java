package com.workintech.s18d1.exceptions;



import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BurgerErrorResponse {

    private int status;
    private String message;
    private  long timeStamp;

    public BurgerErrorResponse(String message) {
        this.status = 400;
        this.message = message;
        this.timeStamp = System.currentTimeMillis();
    }

}
