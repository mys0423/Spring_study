package com.app.dependency.qualifier;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Vips implements Restaurant {
    Boolean isSalad = false;
    int steakPrice = 30000;

    @Override
    public int getSteakPrice() {
        return steakPrice;
    }
}

//package com.app.dependency.qualifier;
//
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;
//
//@Component
//@Data
//public class Vips implements Resturant {
//
//    private int stakePrice = Resturant.stakePrice + 30000;
//
//    @Override
//    public boolean isSaladBar() {
//        return true;
//    }
//}