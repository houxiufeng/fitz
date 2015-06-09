package com.xiaoma.fitz.dto;

public class PageDto {

    private Integer currentPage = 1;
    private Integer itemsPerPage = 10;
    public Integer getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
    public Integer getItemsPerPage() {
        return itemsPerPage;
    }
    public void setItemsPerPage(Integer itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }
    
    
}
