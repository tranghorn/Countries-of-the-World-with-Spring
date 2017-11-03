package com.teamtreehouse.countries.data;

import com.teamtreehouse.countries.model.Country;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Trang on 11/02/2017.
 */
@Component
public class CountryRepository {
    private static final List<Country> ALL_COUNTRIES = Arrays.asList(
            new Country("Ecuador", 16703384 , "Quito", Arrays.asList(
                    "Spanish"
            )),
            new Country("France", 65064883, "Paris", Arrays.asList(
                    "French"
            )),
            new Country("India", 1344204669, "New Delhi", Arrays.asList(
                    "Hindi", "English"
            )),
            new Country("Italy", 59336469, "Rome", Arrays.asList(
                    "Italian"
            )),
            new Country("Kenya", 50112848, "Nairobi", Arrays.asList(
                    "English", "Kiswahili"
            ))
    );

    public List<Country> getAllCountries() {
        return ALL_COUNTRIES;
    }

    public Country getCountryByName(String name){
        return ALL_COUNTRIES.stream()
                .filter(country -> country.getName().toLowerCase().equals(name.toLowerCase()))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    public List<Country> getCountriesSortedByPopulation() {
        return ALL_COUNTRIES.stream().sorted((country1, country2) ->
                Integer.compare(country2.getPopulation(), country1.getPopulation()))
                .collect(Collectors.toList());
    }

    public List<Country> getCountriesSortedByName() {
        return ALL_COUNTRIES.stream().sorted((country1, country2) ->
                country1.getName().compareTo(country2.getName()))
                .collect(Collectors.toList());
    }

}