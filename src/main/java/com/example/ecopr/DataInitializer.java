package com.example.ecopr;
import com.example.ecopr.model.*;
import com.example.ecopr.repository.*;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
public class DataInitializer {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private ClothRepository clothRepository;

    @Autowired
    private RelationsRepository relationsRepository;

    @PostConstruct
    @Transactional
    public void initData() {
        System.out.println("INITIALIZING DATA.......");
        if (categoriesRepository.count() == 0) {
            loadCategoriesFromCSV("src/main/resources/inventory_db/categories.csv");
            loadClothsFromCSV("src/main/resources/inventory_db/cloth.csv");
            loadProductsFromCSV("src/main/resources/inventory_db/products.csv");
            loadRelationsFromCSV("src/main/resources/inventory_db/relations.csv");
        }
    }

    // Load data from CSV files using objects of entities

    private void loadCategoriesFromCSV(String filename) {
        try (CSVReader reader = new CSVReader(new FileReader(filename))) {
            List<String[]> rows = reader.readAll();
            rows.remove(0); // Skip header row

            for (String[] row : rows) {
                String categoryName = row[0];
                Integer categoryId = Integer.parseInt(row[1]);
                Categories category = new Categories(categoryName);
                category.setCategory_id(categoryId);
                categoriesRepository.save(category); //save into persistence database
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    private void loadClothsFromCSV(String filename) {
        try (CSVReader reader = new CSVReader(new FileReader(filename))) {
            List<String[]> rows = reader.readAll();
            rows.remove(0); // Skip header row

            for (String[] row : rows) {
                String clothName = row[0];
                Integer clothId = Integer.parseInt(row[1]);
                Cloth cloth = new Cloth(clothName);
                cloth.setCloth_id(clothId);
                clothRepository.save(cloth);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    private void loadProductsFromCSV(String filename) {
        try (CSVReader reader = new CSVReader(new FileReader(filename))) {
            List<String[]> rows = reader.readAll();
            rows.remove(0); // Skip header row

            for (String[] row : rows) {
                int productId = Integer.parseInt(row[0]);
                String productName = row[1];
                Integer productCost = Integer.parseInt(row[2]); // Changed to Integer
                String productURL = row[3];

                Products product = new Products(productName, productCost, productURL);
                product.setProduct_id(productId);
                productsRepository.save(product);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    private void loadRelationsFromCSV(String filename) {
        try (CSVReader reader = new CSVReader(new FileReader(filename))) {
            List<String[]> rows = reader.readAll();
            rows.remove(0); // Skip header row
    
            for (String[] row : rows) {
                Integer relationId = Integer.parseInt(row[0]);
                Integer productId = Integer.parseInt(row[1]); // Changed to Integer
                Integer categoryId = Integer.parseInt(row[2]); // Changed to Integer
                Integer clothId = Integer.parseInt(row[3]); // Changed to Integer
    
                Optional<Products> productOpt = productsRepository.findById(productId);
                Optional<Categories> categoryOpt = categoriesRepository.findById(categoryId);
                Optional<Cloth> clothOpt = clothRepository.findById(clothId);
    
                if (productOpt.isPresent() && categoryOpt.isPresent() && clothOpt.isPresent()) {
                    Products product = productOpt.get();
                    Categories category = categoryOpt.get();
                    Cloth cloth = clothOpt.get();
    
                    Relations relation = new Relations(relationId, product, category, cloth);
                    relationsRepository.save(relation);
                }
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}

