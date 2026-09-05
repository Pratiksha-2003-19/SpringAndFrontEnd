package com.MobileShop.service;


import com.MobileShop.Model.MobileModel;
import com.MobileShop.repository.MobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MobileService {

    @Autowired
    MobileRepository mobileRepository;

    //GetAllMobiles
    public List<MobileModel> getAllMobiles(){
        return mobileRepository.findAll();
    }
    //GetMobileById
    public MobileModel getMobileById(int id){
        Optional<MobileModel> mobile =
                mobileRepository.findById(id);

        if (mobile.isPresent()) {
            return mobile.get();
        }

        return null;
    }

    //GetMobileByBrand
    public List<MobileModel> getMobileByBrand(String brand){
        return mobileRepository.findByBrand(brand);
    }

    //find By Price Range
    public List<MobileModel> getMobileByPriceRange(double minPrice, double maxPrice){
        return mobileRepository.findByPriceBetween(minPrice, maxPrice);
    }

    //Add Mobile
    public MobileModel addMobile(MobileModel mobileModel){
        return mobileRepository.save(mobileModel);
    }

    //Update Mobile
    public MobileModel updateMobile(int id, MobileModel mobileModel){
        Optional<MobileModel> oldMobile = mobileRepository.findById(id);

        if (oldMobile.isPresent()) {

            MobileModel existingMobile = oldMobile.get();

            existingMobile.setBrand(mobileModel.getBrand());
            existingMobile.setModel(mobileModel.getModel());
            existingMobile.setPrice(mobileModel.getPrice());
            existingMobile.setColor(mobileModel.getColor());
            existingMobile.setStock(mobileModel.getStock());

            return mobileRepository.save(existingMobile);
        }

        return null;
    }

    //Delete Mobile
    public String deleteMobile(int id) {

        if (mobileRepository.existsById(id)) {

            mobileRepository.deleteById(id);

            return "Mobile deleted successfully";
        }

        return "Mobile not found";
    }


    public List<MobileModel> getMobileByPriceBetween(double minPrice, double maxPrice) {
        return mobileRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public MobileModel saveMobile(MobileModel mobileModel) {
        return mobileRepository.save(mobileModel);
    }
}
