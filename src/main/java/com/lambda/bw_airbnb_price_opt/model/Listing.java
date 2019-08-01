package com.lambda.bw_airbnb_price_opt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "listings")
public class Listing extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long listing_id;

    private String name;

    private Double latitude;

    private Double longitude;

    private Integer minimum_nights;

    private Integer maximum_nights;

    private Integer accommodates;

    private Integer bathrooms;

    private Integer bedrooms;

    private Double price;

    private Double security_deposit;

    private Double cleaning_fee;

    private Integer guests_included;

    private Double extra_people;

    private Boolean has_availability;

    private int number_of_reviews;

    private int review_scores_cleanliness;

    private int review_scores_rating;

    private int review_scores_communication;

    private int review_scores_location;

    private Double reviews_per_month;

    private int amenities_num;

    private int calculated_host_listings_count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bed_type_id",
            nullable = false)
    @JsonIgnoreProperties({"listings", "hibernateLazyInitializer"})
    private BedType bedType;

//    calculated_host_listings_count
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "neighbourhood_id",
            nullable = false)
    @JsonIgnoreProperties({"listings", "hibernateLazyInitializer"})
    private NeighbourHood neighbourHood;

//    optimal_price key on listings
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_type_id",
            nullable = false)
    @JsonIgnoreProperties({"listings", "hibernateLazyInitializer"})
    private PropertyType propertyType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_type_id",
            nullable = false)
    @JsonIgnoreProperties({"listings", "hibernateLazyInitializer"})
    private RoomType roomType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cancellation_policy_id",
            nullable = false)
    @JsonIgnoreProperties({"listings", "hibernateLazyInitializer"})
    private CancellationPolicy cancellationPolicy;

    public Listing() {
    }

    public Listing(
            String name,
            Double latitude,
            Double longitude,
            Integer minimum_nights,
            Integer maximum_nights,
            Integer accommodates,
            Integer bathrooms,
            Integer bedrooms,
            Double security_deposit,
            Double cleaning_fee,
            Integer guests_included,
            Double extra_people,
            Boolean has_availability,
            NeighbourHood neighbourHood,
            PropertyType propertyType,
            RoomType roomType,
            CancellationPolicy cancellationPolicy,
            BedType bedType,
            int amenities_num
    ) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.minimum_nights = minimum_nights;
        this.maximum_nights = maximum_nights;
        this.accommodates = accommodates;
        this.bathrooms = bathrooms;
        this.bedrooms = bedrooms;
//        this.price = price;
        this.security_deposit = security_deposit;
        this.cleaning_fee = cleaning_fee;
        this.guests_included = guests_included;
        this.extra_people = extra_people;
        this.has_availability = has_availability;
        this.neighbourHood = neighbourHood;
        this.propertyType = propertyType;
        this.roomType = roomType;
        this.cancellationPolicy = cancellationPolicy;
        this.bedType = bedType;
        this.amenities_num = amenities_num;

        setNumber_of_reviews((int)(Math.random() * ((400 - 1) + 1)) + 1);

        setReview_scores_cleanliness((int)(Math.random() * ((10 - 0) + 1)));

        setReview_scores_rating((int)(Math.random() * ((100 - 20) + 1)) + 20);

        setReview_scores_communication((int)(Math.random() * ((10 - 1) + 1)) + 1);

        setReview_scores_location((int)(Math.random() * ((10 - 1) + 1)) + 1);

        setReviews_per_month((Math.random() * ((10 - 1) + 1)) + 1);

        setCalculated_host_listings_count((int)(Math.random() * ((200 - 1) + 1)) + 1);
    }

    public int getNumber_of_reviews() {
        return number_of_reviews;
    }

    public int getAmenities() {
        return amenities_num;
    }

    public void setAmenities(int amenities_num) {
        this.amenities_num = amenities_num;
    }

    public void setNumber_of_reviews(int number_of_reviews) {
        this.number_of_reviews = number_of_reviews;
    }

    public int getReview_scores_cleanliness() {
        return review_scores_cleanliness;
    }

    public void setReview_scores_cleanliness(int review_scores_cleanliness) {
        this.review_scores_cleanliness = review_scores_cleanliness;
    }

    public int getReview_scores_rating() {
        return review_scores_rating;
    }

    public void setReview_scores_rating(int review_scores_rating) {
        this.review_scores_rating = review_scores_rating;
    }

    public int getCalculated_host_listings_count() {
        return calculated_host_listings_count;
    }

    public int getAmenities_num() {
        return amenities_num;
    }

    public void setAmenities_num(int amenities_num) {
        this.amenities_num = amenities_num;
    }

    public void setCalculated_host_listings_count(int calculated_host_listings_count) {
        this.calculated_host_listings_count = calculated_host_listings_count;
    }

    public int getReview_scores_communication() {
        return review_scores_communication;
    }

    public void setReview_scores_communication(int review_scores_communication) {
        this.review_scores_communication = review_scores_communication;
    }

    public int getReview_scores_location() {
        return review_scores_location;
    }

    public void setReview_scores_location(int review_scores_location) {
        this.review_scores_location = review_scores_location;
    }

    public Double getReviews_per_month() {
        return reviews_per_month;
    }

    public void setReviews_per_month(Double reviews_per_month) {
        this.reviews_per_month = reviews_per_month;
    }

    public BedType getBedType() {
        return bedType;
    }

    public void setBedType(BedType bedType) {
        this.bedType = bedType;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public long getListing_id() {
        return listing_id;
    }

    public void setListing_id(long listing_id) {
        this.listing_id = listing_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getMinimum_nights() {
        return minimum_nights;
    }

    public void setMinimum_nights(Integer minimum_nights) {
        this.minimum_nights = minimum_nights;
    }

    public NeighbourHood getNeighbourHood() {
        return neighbourHood;
    }

    public void setNeighbourHood(NeighbourHood neighbourHood) {
        this.neighbourHood = neighbourHood;
    }

    public Integer getMaximum_nights() {
        return maximum_nights;
    }

    public void setMaximum_nights(Integer maximum_nights) {
        this.maximum_nights = maximum_nights;
    }

    public Integer getAccommodates() {
        return accommodates;
    }

    public void setAccommodates(Integer accommodates) {
        this.accommodates = accommodates;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    public Integer getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSecurity_deposit() {
        return security_deposit;
    }

    public void setSecurity_deposit(Double security_deposit) {
        this.security_deposit = security_deposit;
    }

    public Double getCleaning_fee() {
        return cleaning_fee;
    }

    public void setCleaning_fee(Double cleaning_fee) {
        this.cleaning_fee = cleaning_fee;
    }

    public Integer getGuests_included() {
        return guests_included;
    }

    public void setGuests_included(Integer guests_included) {
        this.guests_included = guests_included;
    }

    public Double getExtra_people() {
        return extra_people;
    }

    public void setExtra_people(Double extra_people) {
        this.extra_people = extra_people;
    }

    public Boolean getHas_availability() {
        return has_availability;
    }

    public void setHas_availability(Boolean has_availability) {
        this.has_availability = has_availability;
    }

    public CancellationPolicy getCancellationPolicy() {
        return cancellationPolicy;
    }

    public void setCancellationPolicy(CancellationPolicy cancellationPolicy) {
        this.cancellationPolicy = cancellationPolicy;
    }
}
