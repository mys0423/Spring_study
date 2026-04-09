package com.app.threetier.controller;

import com.app.threetier.domain.vo.ProductVO;
import com.app.threetier.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/products/*")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("register")
    public void goToRegister(ProductVO productVO) {;}

    @PostMapping("register")
    public RedirectView registerProduct(ProductVO productVO) {
        productService.registerProduct(productVO);
        return new RedirectView("/products/register");
    }

    @GetMapping("list")
    public void goToList(ProductVO productVO, Model model) {
        model.addAttribute("products", productService.getAllProducts());
    }
}
