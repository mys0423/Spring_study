package com.app.threetier.service;

import com.app.threetier.domain.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class ProductServiceTests {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductVO productVO;

    @Test
    public void insertTest(){
        ProductVO productVO = new ProductVO();
        productVO.setProductName("test1");
        productVO.setProductPrice(2000L);
        productVO.setProductStock(3L);
        productVO.setProductBrand("test11");

        productService.registerProduct(productVO);

        log.info("등록 성공: {}", productVO);
    }

}
