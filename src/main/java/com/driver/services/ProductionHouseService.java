package com.driver.services;


import com.driver.EntryDto.ProductionHouseEntryDto;
import com.driver.model.ProductionHouse;
import com.driver.model.WebSeries;
import com.driver.repository.ProductionHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductionHouseService {

    @Autowired
    ProductionHouseRepository productionHouseRepository;

    public Integer addProductionHouseToDb(ProductionHouseEntryDto productionHouseEntryDto){

        //return  null;

        ProductionHouse productionHouse = new ProductionHouse();

        //Set the name by getting it from EntryDto
        productionHouse.setName(productionHouseEntryDto.getName());

        //Default ratings of the ProductionHouse should be 0
        productionHouse.setRatings(0.0);

        //Set the web-series list
        List<WebSeries> webSeriesList = new ArrayList<>(); //At the time of addition the list should be empty
        productionHouse.setWebSeriesList(webSeriesList);

        ProductionHouse savedProductionHouse= productionHouseRepository.save(productionHouse);
        return savedProductionHouse.getId();

    }



}
