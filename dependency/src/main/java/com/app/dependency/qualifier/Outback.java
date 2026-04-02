package com.app.dependency.qualifier;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Outback implements Restaurant {

    Boolean isSalad = true;
    int steakPrice = 20000;

    @Override
    public int getSteakPrice() {
        return steakPrice;
    }
}


//package com.app.dependency.qualifier;
//
//import lombok.Data;
//import org.springframework.stereotype.Component;
//
//@Component
//@Data
//public class Outback implements Resturant {
//    @Override
//    public boolean isSaladBar() {
//        return false;
//    }
//}