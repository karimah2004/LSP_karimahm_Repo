package org.howard.edu.lspfinal.question3;

/**
 * Abstract base class for generating reports using the Template Method pattern.
 */
public abstract class ReportStructure {
    /**
     * Template method that outlines the report generation process.
     */
    public final void generateReport() {
        loadData();
        formatData();
        printReport();
    }

    protected abstract void loadData();
    protected abstract void formatData();
    protected abstract void printReport();
}

/**
 * Concrete implementation of a sales report.
 */
class SalesReport extends ReportStructure {
	
	//loads sales data
    protected void loadData() {
        System.out.println("Loading sales data...");
    }

    //formats sales data
    protected void formatData() {
        System.out.println("Formatting sales data...");
    }

    //prints formatted sales report
    protected void printReport() {
        System.out.println("Printing sales report.");
    }
}

/**
 * Concrete implementation of an inventory report.
 */
class InventoryReport extends ReportStructure {
	//loads inventory specific data
    protected void loadData() {
        System.out.println("Loading inventory data...");
    }

    //formats the inventory data
    protected void formatData() {
        System.out.println("Formatting inventory data...");
    }

    //prints the formatted inventory report
    protected void printReport() {
        System.out.println("Printing inventory report.");
    }
}
