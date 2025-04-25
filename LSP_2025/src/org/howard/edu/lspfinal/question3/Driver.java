package org.howard.edu.lspfinal.question3;

/**
 * Driver class to demonstrate report generation using the Template Method pattern.
 */
public class Driver {
    public static void main(String[] args) {
        ReportStructure salesReport = new SalesReport();
        salesReport.generateReport();

        System.out.println();

        ReportStructure inventoryReport = new InventoryReport();
        inventoryReport.generateReport();
    }
}

