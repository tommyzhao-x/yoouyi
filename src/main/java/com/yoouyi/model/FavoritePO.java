package com.yoouyi.model;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.yoouyi.model.trip.TripInfoPO;

@Document(collection = "c_favorite")
public class FavoritePO {
    @Indexed
    private ObjectId userId;
    @DBRef
    private TripInfoPO trip;
    private Date createDate;

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public TripInfoPO getTrip() {
        return trip;
    }

    public void setTrip(TripInfoPO trip) {
        this.trip = trip;
    }

}
