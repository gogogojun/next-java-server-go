package com.next.app.api.user.controller;

import com.next.app.api.user.entity.Business;
import com.next.app.api.user.service.BusinessService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/business")
@Tag(name = "Business Controller", description = "사업 관리 API")
@CrossOrigin(origins = "http://localhost")
public class BusinessController {
    private final BusinessService businessService;
    @Autowired
    public BusinessController(BusinessService businessService) {
        this.businessService= businessService;
    }
    @GetMapping
    public List<Business> getAllBusiness() {
        return businessService.getAllBusiness();
    }
    @GetMapping("/{id}")
    public Business getProductById(@PathVariable Long id) {
        return businessService.getBusinessById(id);
    }
    @PostMapping
    public Business createBusiness(@RequestBody Business business) {
        return businessService.createBusiness(business);
    }
    @PutMapping("/{id}")
    public Business updateBusiness(@PathVariable Long id, @RequestBody Business business) {
        return businessService.updateBusiness(id, business);
    }
    @DeleteMapping("/{id}")
    public void deleteBusiness(@PathVariable Long id) {
        businessService.deleteBusiness(id);
    }
}
