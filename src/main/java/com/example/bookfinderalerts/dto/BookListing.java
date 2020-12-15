package com.example.bookfinderalerts.dto;

import java.util.ArrayList;
import java.util.List;

public class BookListing {

    private String id;

    private List<PriceListing> priceListings = new ArrayList<>();

    public BookListing(String id) {
        this.id = id;
    }

    public BookListing(String id, List<PriceListing> priceListings) {
        this.id = id;
        this.priceListings = priceListings;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<PriceListing> getPriceListings() {
        return priceListings;
    }

    public void setPriceListings(List<PriceListing> priceListings) {
        this.priceListings = priceListings;
    }
}
