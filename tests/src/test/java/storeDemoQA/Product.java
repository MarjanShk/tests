package storeDemoQA;

import org.openqa.selenium.WebElement;

/**
 * Created by Admin on 07.05.2016.
 */
public class Product {

    String name;
    double price;
    WebElement submit;

    public String getName() {
        return name;
    }

    public Product withName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Product withPrice(double price) {
        this.price = price;
        return this;
    }

    public WebElement getSubmit() {
        return submit;
    }

    public Product withSubmit(WebElement submit) {
        this.submit = submit;
        return this;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
