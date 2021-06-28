/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productledger;
import java.util.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.io.IOException;

/**
 *
 * @author NirZak
 */
public class Ledger {

    /**
     * @param args the command line arguments
     */
    public List<Product> productList = new ArrayList<>();
    private int balance = 0;
    public void Menu(){
        while(true){
            System.out.println("Welcome to Product Inventory");
            System.out.println("1. Add a Product ");
            System.out.println("2. Delete a Product");
            System.out.println("3. Buy a Product");
            System.out.println("4. Sell a Product");
            System.out.println("5. See the list of products");
            System.out.println("6. See available balance");
            System.out.println("7. Quit from System");
            System.out.print("Please select an option: ");
     try{
                BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
                String s= br.readLine();
                if(s.equals("1")){
                    addProduct();
                }
                else if(s.equals("2")){
                    deleteProduct();
                }
                else if(s.equals("3")){
                    buyProduct();
                }
                else if(s.equals("4")){
                    sellProduct();
                }
                else if(s.equals("5")){
                    showProducts();
                }
                else if(s.equals("6")){
                    System.out.println("Available Balance: "+balance);
                }
                else if(s.equals("7")){
                    break;
                }
                else{
                    System.out.println("Invalid option. Please select a number from 1-7");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
         }
        }
    private void addProduct(){
        try{
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the Name of the Product: ");
            String name = br.readLine();
            System.out.print("Enter buying price of the Product: ");
            int buyPrice = Integer.parseInt(br.readLine());
            System.out.println("Enter selling price of the product");
            int sellPrice = Integer.parseInt(br.readLine());
            System.out.println("Enter Quantity of the Product");
            int availableQuantity = Integer.parseInt(br.readLine());
            System.out.println("Enter Profit from the Product");
            int profit = Integer.parseInt(br.readLine());
            Product product = new Product(name, buyPrice, sellPrice, availableQuantity, profit);
            productList.add(product);
            System.out.println("Product Added!");
            System.out.println("\n");

        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private void deleteProduct(){
        System.out.print("Enter the index of the product to delete: ");
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        try{
        int index=Integer.parseInt(br.readLine());
        productList.remove(index);
        System.out.println("Product has been Deleted!");
        System.out.println("\n");
        }
        catch (Exception e){
            System.out.println("Product is not in the list");
            System.out.println("\n");
        }
    }
    private void buyProduct(){
       System.out.println("Enter the index of the product to select");
       Product pd = null;
       int quantity, buyPrice, availableQuantity, index = 0;
       BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
       try{
        index = Integer.parseInt(br.readLine());
        pd = productList.get(index);   
       }
       catch (Exception e){
          System.out.println("Product is not in the list");
       }
       buyPrice = pd.getBuyPrice();
       availableQuantity = pd.getAvailableQuantity();
       System.out.println("Enter Number of product you want to buy");
       try{
         quantity = Integer.parseInt(br.readLine());
         int totalPrice = quantity*buyPrice;
         if(totalPrice<balance){
         balance = balance - totalPrice;
         availableQuantity =  availableQuantity + quantity;
         pd.setAvailableQuantity(availableQuantity);
         productList.set(index, pd);
         }
         else{
             System.out.println("You don't have sufficient balance");
             System.out.println("\n");
             return;
         }
         
       }
       catch (Exception e){
         e.printStackTrace(); 
       }       
    }
    
    private void sellProduct(){
       System.out.println("Enter the index of the product to select");
       Product pd = null;
       int quantity, buyPrice, sellPrice, availableQuantity, profit, totalsellPrice,index = 0;
       BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
       try{
        index = Integer.parseInt(br.readLine());
        pd = productList.get(index);   
       }
       catch (Exception e){
          System.out.println("Product is not in the list");
       }
       sellPrice = pd.getSellPrice();
       buyPrice = pd.getBuyPrice();
       availableQuantity = pd.getAvailableQuantity();
       profit = pd.getProfit();
       System.out.println("Enter Number of product you want to sell");
       try{
         quantity = Integer.parseInt(br.readLine());
         if(quantity<availableQuantity){
         totalsellPrice = quantity*sellPrice;
         balance = balance + totalsellPrice;
         availableQuantity =  availableQuantity - quantity;
         profit = profit + ((sellPrice-buyPrice)*quantity);
         pd.setAvailableQuantity(availableQuantity);
         pd.setProfit(profit);
         productList.set(index, pd);
         }
         else{
             System.out.println("You don't have sufficient amount of Products");
             System.out.println("\n");
             return;
         }
         
       }
       catch (Exception e){
         e.printStackTrace(); 
       } 
    }
    private void showProducts(){
    // Print the list objects in tabular format.
    int index = 0;
    System.out.println("---------------------------------------------------------------------------------");
    System.out.printf("%10s %30s %18s %20s","Index", "Name", "Available Quantity", "Profit");
    System.out.println();
    System.out.println("---------------------------------------------------------------------------------");
    for(Product product: productList){
        System.out.format("%10d %30s %18d %20d",
                index, product.getName(), product.getAvailableQuantity(), product.getProfit());
        System.out.println();
        index++;
    }
    System.out.println("-----------------------------------------------------------------------------");
    }
    
    }
