package com.pragmatest.nolt.customer_orders.services.models;

public class OrderItem {

    private String menuItemId;
    private int quantity;
    private String notes;

    // Although models might be similar today, keep them separate across layers!
    // Don't sacrifice less classes and code for readability and maintainability


    public String getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(String menuItemId) {
        this.menuItemId = menuItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}

