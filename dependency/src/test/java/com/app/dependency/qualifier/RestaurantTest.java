package com.app.dependency.qualifier;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class RestaurantTest {
    @Autowired @Qualifier("vips")
    private Restaurant restaurant;

    @Test
    public void vipsRestaurant(){
        log.info("restaurant : {}", restaurant);
        log.info("restaurant.getSteakPrice() : {}", restaurant.getSteakPrice());
    }
}

//
//package com.app.dependency.qualifier;
//
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//@Slf4j
//public class ResturantTest {
//
//    @Autowired @Qualifier("vips")
//    private Resturant resturant;
//
//    @Test
//    public void resturantTest(){
//        log.info("ResturantTest");
//        log.info("resturant : {}", resturant);
//        log.info("resturant.isSaladBar() : {}", resturant.isSaladBar());
//    }
//
//
//}
