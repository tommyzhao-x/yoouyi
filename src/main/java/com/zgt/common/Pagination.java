package com.zgt.common;

import java.io.Serializable;
import java.util.List;

public class Pagination<T extends Serializable> {

    private static Pagination pagination;

    private int size;
    private int totalPages;
    private List<T> items;

    private Pagination() {

    }

    public static Pagination getInstance() {

        if (pagination == null) {
            pagination = new Pagination();
        }

        return pagination;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.totalPages = (int) Math.ceil(size/Constants.PAGE_SIZE);
        this.size = size;
    }
    
}
