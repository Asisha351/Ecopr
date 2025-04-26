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

                Categories category = new Categories(categoryId, categoryName);
                categoriesRepository.save(category);
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

                Cloth cloth = new Cloth(clothId, clothName);
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
                Integer productId = Integer.parseInt(row[0]);
                String productName = row[1];
                Integer productCost = Integer.parseInt(row[2]);
                String productURL = row[3];

                Products product = new Products(productId, productName, productCost, productURL);
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
                Integer productId = Integer.parseInt(row[1]);
                Integer categoryId = Integer.parseInt(row[2]);
                Integer clothId = Integer.parseInt(row[3]);

                Optional<Products> productOpt = productsRepository.findById(productId);
                Optional<Categories> categoryOpt = categoriesRepository.findById(categoryId);
                Optional<Cloth> clothOpt = clothRepository.findById(clothId);

                if (productOpt.isPresent() && categoryOpt.isPresent() && clothOpt.isPresent()) {
                    Products product = productOpt.get();
                    Categories category = categoryOpt.get();
                    Cloth cloth = clothOpt.get();

                    Relations relation = new Relations(relationId, product, category, cloth);
                    relationsRepository.save(relation);
                } else {
                    System.err.println("Could not find related entities for relation: " +
                                       "Product ID: " + productId + ", Category ID: " + categoryId + ", Cloth ID: " + clothId);
                }
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

}

