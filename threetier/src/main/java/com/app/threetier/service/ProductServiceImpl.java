package com.app.threetier.service;

import com.app.threetier.domain.vo.ProductVO;
import com.app.threetier.repository.ProductDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

    @Override
    public void registerProduct(ProductVO productVO) {
        productDAO.saveProduct(productVO);
    }

    public List<ProductVO> getAllProducts() {
        return productDAO.findAll();
    }
}
