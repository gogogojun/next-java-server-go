package com.next.app.api.user.controller;

import com.next.app.api.user.entity.Business;
import com.next.app.api.user.service.BusinessService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "모든 사업장 조회", description = "모든 사업장을 출력합니다.")
    public List<Business> getAllBusiness() {
        return businessService.getAllBusiness();
    }

    @GetMapping("/{id}")
    @Operation(summary = "사업장 조회", description = "ID로 특정 사업장을 조회합니다.")
    public Business getProductById(@PathVariable Long id) {
        return businessService.getBusinessById(id);
    }

    @PostMapping
    @Operation(summary = "사업장 생성", description = "새로운 사업장을 생성합니다.")
    public Business createBusiness(@RequestBody Business business) {
        return businessService.createBusiness(business);
    }

    @PutMapping("/{id}")
    @Operation(summary = "사업장 수정", description = "기존 사업장 정보를 수정합니다.")
    public Business updateBusiness(@PathVariable Long id, @RequestBody Business business) {
        return businessService.updateBusiness(id, business);
    }
    @Operation(summary = "사업장 제거", description = "사업장 정보를 제거합니다.")
    @DeleteMapping("/{id}")
    public void deleteBusiness(@PathVariable Long id) {
        businessService.deleteBusiness(id);
    }
}
