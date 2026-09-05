package com.MobileShop.repository;

import com.MobileShop.Model.MobileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MobileRepository extends JpaRepository<MobileModel, Integer> {

    List<MobileModel> findByBrand(String brand);

    List<MobileModel> findByPriceBetween(double minPrice, double maxPrice);
}
