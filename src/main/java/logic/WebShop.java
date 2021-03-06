package logic;


import interfaces.ISellable;
import interfaces.Observer;
import models.Animal;
import models.Product;

import java.util.ArrayList;
import java.util.List;

public class WebShop implements Observer {

    private List<ISellable> objects = new ArrayList<>();

    //ProductDAO productDAO= new ProductDAO();

    public void addNewProduct(int id, String name, double price){
        Product product = new Product(id, name, price);
        addSaleableToList(product);
        //productDAO.saveObject(product);
    }

    public List<ISellable> getObjects(){
        return this.objects;
    }

    private void addSaleableToList(ISellable saleable){
        objects.add(saleable);
    }

    @Override
    public void updateObject(Object obj) {
        addSaleableToList((Animal)obj);
    }

    public void boughtitem(ISellable obj){
        objects.remove(obj);
    }

}
