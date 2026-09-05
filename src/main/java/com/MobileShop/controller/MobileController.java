package com.MobileShop.controller;

import com.MobileShop.Model.MobileModel;
import com.MobileShop.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/mobileapi")
public class MobileController {

    @Autowired
    private MobileService mobileService;

    // 1. Get All Mobiles
    @GetMapping("/allMobile")
    public List<MobileModel> getAllMobiles() {

        return mobileService.getAllMobiles();
    }

    // Get Mobile By ID
    @GetMapping("/id/{id}")
    public Optional<MobileModel> getMobileById(@PathVariable int id) {

        return Optional.ofNullable(mobileService.getMobileById(id));
    }

    // Get By Brand
    @GetMapping("/brand/{brand}")
    public List<MobileModel> getByBrand(@PathVariable String brand) {

        return mobileService.getMobileByBrand(brand);
    }

    //Get By Price Range
    @GetMapping("/price")
    public List<MobileModel> getByPriceBetween(
            @RequestParam double minPrice,
            @RequestParam double maxPrice) {

        return mobileService.getMobileByPriceBetween(minPrice, maxPrice);
    }

    //add Mobile
    @PostMapping("/addMobile")
    public MobileModel addMobile(@RequestBody MobileModel mobileModel){
        return mobileService.saveMobile(mobileModel);
    }

    //update Mobile
    @PutMapping("/updateMobile/{id}")
    public MobileModel updateMobile(
            @PathVariable int id,
            @RequestBody MobileModel mobileModel) {

        return mobileService.updateMobile(id, mobileModel);
    }

    // 6. delete Mobile
    @DeleteMapping("/deleteMobile/{id}")
    public String deleteMobile(@PathVariable int id) {

        return mobileService.deleteMobile(id);
    }
}
