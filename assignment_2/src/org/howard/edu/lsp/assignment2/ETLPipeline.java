package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.util.*;

public class ETLPipeline {

    public static void main(String[] args) {

        String inputFile = "data/products.csv"; // path to input file
        String outputFile = "data/transformed_products.csv";  // path to output file

        // Read data from CSV file
        List<String[]> data = extract(inputFile);
        if (data == null || data.isEmpty()) return;

        // Process data/transform by performing discount
        List<String[]> transformedData = transform(data);

        // Write new transformed data to new CSV file
        load(transformedData, outputFile);
    }

    private static List<String[]> extract(String filePath) {
        List<String[]> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip the header row
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file not found");
            return null;
        } catch (IOException e) {
            System.out.println("Error reading input file");
            return null;
        }
        return data;
    }

    private static List<String[]> transform(List<String[]> data) {
        List<String[]> transformedData = new ArrayList<>();
        transformedData.add(new String[] {"ProductID", "Name", "Price", "Category", "PriceRange"}); // Adding header row for new file

        for (String[] row : data) {

            try {
                if (row.length < 4) {
                    System.out.println("Skipping invalid row: " + Arrays.toString(row));
                    continue;
                }

                String name = row[1].trim().toUpperCase();
                double price = Double.parseDouble(row[2].trim());
                String category = row[3].trim();

                if (category.equals("Electronics")) {
                    price = Math.round(price * 0.9 * 100.0) / 100.0; // Apply 10% discount, rounded to 2 decimal places
                }
                if (category.equals("Electronics") && price > 500) {
                    category = "Premium Electronics";
                }

                // Determine range based off price
                String priceRange = getPriceRange(price);

                transformedData.add(new String[] {row[0], name, String.format("%.2f", price), category, priceRange});
            } catch (NumberFormatException e) {
                System.out.println("Error processing row: " + Arrays.toString(row));
            }
        }
        return transformedData;
    }

    private static String getPriceRange(double price) {
        if (price <= 10) return "Low";
        else if (price <= 100) return "Medium";
        else if (price <= 500) return "High";
        else return "Premium";
    }

    private static void load(List<String[]> data, String filePath) {
        System.out.println("Attempting to write to: " + new File(filePath).getAbsolutePath());

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] row : data) {
                bw.write(String.join(",", row)); // Write each row
                bw.newLine(); // Move to next line
            }

            File file = new File(filePath);
            System.out.println("Output file exists after writing: " + file.exists());

            System.out.println("Transformation complete. Output " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing to output file");
        }
    }
}

