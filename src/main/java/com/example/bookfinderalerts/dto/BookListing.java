package com.example.bookfinderalerts.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BookListing implements Serializable {

    private String bookId;

    private List<PriceListing> priceListings = new ArrayList<>();

    public BookListing(String bookId) {
        this.bookId = bookId;
    }

    public BookListing(String bookId, List<PriceListing> priceListings) {
        this.bookId = bookId;
        this.priceListings = priceListings;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public List<PriceListing> getPriceListings() {
        return priceListings;
    }

    public void setPriceListings(List<PriceListing> priceListings) {
        this.priceListings = priceListings;
    }
}
