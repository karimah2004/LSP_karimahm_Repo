package org.howard.edu.lspfinal.question3;

/**
 * Driver class to demonstrate report generation using the Template Method pattern.
 */
public class Driver {
    public static void main(String[] args) {
    	
    	//create and generate the sales report
        ReportStructure salesReport = new SalesReport();
        salesReport.generateReport();

        System.out.println();

        //create and generate the inventory report
        ReportStructure inventoryReport = new InventoryReport();
        inventoryReport.generateReport();
    }
}

