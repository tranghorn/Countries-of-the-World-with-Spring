package com.teamtreehouse.countries.controller;

import com.teamtreehouse.countries.data.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by Trang on 11/02/2017.
 */
@Controller
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @RequestMapping("/")
    public String listCountries(ModelMap modelMap){
        modelMap.put("countries", countryRepository.getAllCountries());
        return "index";
    }

    @RequestMapping("/country/{name}")
    public String country(@PathVariable String name, ModelMap modelMap){
        modelMap.put("country", countryRepository.getCountryByName(name));
        return "country";
    }

    @RequestMapping("/sort/by-population")
    public String listCountriesByPopulation(ModelMap modelMap){
        modelMap.put("countries", countryRepository.getCountriesSortedByPopulation());
        return "index";
    }

    @RequestMapping("/sort/by-name")
    public String listCountriesByName(ModelMap modelMap){
        modelMap.put("countries", countryRepository.getCountriesSortedByName());
        return "index";
    }
}