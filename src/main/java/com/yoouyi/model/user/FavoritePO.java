package com.yoouyi.model.user;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.yoouyi.model.trip.TripPO;

@Document(collection = "c_favorite")
public class FavoritePO {
    @Indexed
    private String userId;
    @DBRef
    private TripPO trip;
    private Date createDate;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public TripPO getTrip() {
        return trip;
    }

    public void setTrip(TripPO trip) {
        this.trip = trip;
    }

}
