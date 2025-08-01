package com.next.app.api.user.service;

import com.next.app.api.user.entity.Business;
import com.next.app.api.user.repository.BusinessRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class BusinessService {

    @Autowired
    private BusinessRepository businessRepository;

    public List<Business> getAllBusiness() {
        return businessRepository.findAll();
    }
    // 상품 단건 조회
    public Business getBusinessById(Long id) {
        return businessRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Business not found with id: " + id));
    }
    // 상품 생성
    public Business createBusiness(Business business) {
        return businessRepository.save(business);
    }
    // 상품 수정
    public Business updateBusiness(Long id, Business updatedBusiness) {
        Business business = businessRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Business not found with id: " + id));
        business.setbusinessNumber(updatedBusiness.getbusinessNumber());
        business.setcompanyName(updatedBusiness.getcompanyName());
        business.setrepresentativeName(updatedBusiness.getrepresentativeName());
        business.setcontactEmail(updatedBusiness.getcontactEmail());
        business.setcontactPhone(updatedBusiness.getcontactPhone());
        business.setaddress(updatedBusiness.getaddress());
        return businessRepository.save(business);
    }
    // 상품 삭제
    public void deleteBusiness(Long id) {
        businessRepository.deleteById(id);
    }
}
