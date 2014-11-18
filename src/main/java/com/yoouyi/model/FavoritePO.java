package com.yoouyi.model;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "c_favorite")
public class FavoritePO {
    @Indexed
    private ObjectId userId;
    private ObjectId tripId;
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

    public ObjectId getTripId() {
        return tripId;
    }

    public void setTripId(ObjectId tripId) {
        this.tripId = tripId;
    }

}
