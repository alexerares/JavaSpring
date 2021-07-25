package com.db.school.demo.products;

public interface ProductServiceContract {
    public Product createProduct(Product product);
    public Product getProduct(String cod);
    public Product getAllProduct();

    public Boolean insertProduct(Product product);
    public Boolean updateProduct(Product product);

    public Boolean deleteProduct(String cod);
}
