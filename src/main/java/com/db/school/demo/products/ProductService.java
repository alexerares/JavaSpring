package com.db.school.demo.products;

import com.db.school.demo.customer.Customer;
import com.db.school.demo.customer.CustomerMapper;
import com.db.school.demo.customer.CustomerServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ProductServiceContract {

    @Autowired
    private JdbcTemplate template;

    public Product createProduct(Product product){
        System.out.println(product);
        return product;
    }

    public Product getProduct(String cod){
        List<Product> products = template.query("SELECT * FROM `db-school`.products WHERE cod =" + cod, new ProductMapper());
        System.out.println(products);
        return new Product(cod,"hartie","frumos",3,5.5);
    }

    public Product getAllProduct(){
        List<Product> products = template.query("SELECT * FROM `db-school`.products", new ProductMapper());
        System.out.println(products);
        return new Product("1234","hartie","frumos",3,5.5);
    }

    public Boolean insertProduct(Product product){
        System.out.println(product);
        String sqlQuery = "INSERT INTO `db-school`.`products`\n" +
                "(`cod`,\n" +
                "`nume`,\n" +
                "`descriere`,\n" +
                "`stock`,\n" +
                "`price`)\n" +
                "VALUES\n" +
                "(?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?\n" +
                ");";

        int n =template.update(sqlQuery,product.getCod(),product.getNume(),product.getDescriere(),
                product.getStock(),product.getPrice());

        if (n >0) {
            return true;
        } else {
            return false;
        }

    }

    public Boolean updateProduct(Product product){
        System.out.println(product);
        String sqlQuery = "Update `db-school`.`products`\n" +
                "SET`nume` = ?,\n" +
                "`descriere` = ?,\n" +
                "`stock` = ?,\n" +
                "`price` = ?\n" +
                "WHERE `cod` = ?;";

        int n =template.update(sqlQuery,product.getNume(),product.getDescriere(),
                product.getStock(),product.getPrice(),product.getCod());

        if (n >0) {
            return true;
        } else {
            return false;
        }

    }
    public Boolean deleteProduct(String cod){
        String sqlQuery = "Delete from `db-school`.`products` WHERE `cod` = ?;";
        System.out.println(sqlQuery);
        System.out.println(cod);
        int n =template.update(sqlQuery, cod);
        System.out.println(n);
        if (n >0) {
            return true;
        } else {
            return false;
        }
    }
}