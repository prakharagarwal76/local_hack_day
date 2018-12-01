package com.example.prekshasingla.localhackday;

public class EventItem {
    String title;
    String image;
    double date;
    String month;
    double year;
    String location;
    String description;

    public String getOrganiser_requirement() {
        return organiser_requirement;
    }

    public void setOrganiser_requirement(String organiser_requirement) {
        this.organiser_requirement = organiser_requirement;
    }

    public String getSponsor_requirement() {
        return sponsor_requirement;
    }

    public void setSponsor_requirement(String sponsor_requirement) {
        this.sponsor_requirement = sponsor_requirement;
    }

    public String getVenue_requirement() {
        return venue_requirement;
    }

    public void setVenue_requirement(String venue_requirement) {
        this.venue_requirement = venue_requirement;
    }

    String organiser_requirement;
    String sponsor_requirement;
    String venue_requirement;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getYear() {
        return year;
    }

    public void setYear(double year) {
        this.year = year;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getDate() {
        return date;
    }

    public void setDate(double date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




}
