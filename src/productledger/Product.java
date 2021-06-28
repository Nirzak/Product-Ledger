/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productledger;

/**
 *
 * @author NirZak
 */
public class Product {
    private String name;
    private int buyPrice;
    private int sellPrice;
    private int availableQuantity;
    private int profit;
    
    Product(String name, int buyPrice, int sellPrice, int availableQuantity, int profit){
        this.name = name;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.availableQuantity = availableQuantity;
        this.profit = profit;
    }
    
    public String getName(){
        return this.name;
    }

    public int getBuyPrice() {
        return this.buyPrice;
    }

    public int getSellPrice() {
        return this.sellPrice;
    }

    public int getAvailableQuantity() {
        return this.availableQuantity;
    }
    
    public int getProfit(){
        return this.profit;
    }
    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }
    public void setProfit(int profit) {
        this.profit = profit;
    }
    
    /*public void setName(String name){
        this.name = name;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }
    */
    
    
}
