/*
* Author: Andrew Hewitson
* Date:January 1, 2019
* Time: 4:24:00 PM
    
package data;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import util.ApplicationException;

public class Plasticoil {

    public static final String IN_PLASTICOIL_FILENAME = "plasticoil.csv";
    public static final Logger LOG_READER = LogManager.getLogger(Plasticoil.class);

    private double bindingEdge;
    private int quantity;
    private int bindingSize;
    private double[][] priceList = { { .85, .80, .75 }, { .35, .65, .85 } };

    public Plasticoil() {
    }

    /**
     * @param bindingEdge
     * @param quantity
     * @param bindingSize
     * @param priceList
     */
    public Plasticoil(double bindingEdge, int quantity, int bindingSize, double[][] priceList) {
        super();
        this.bindingEdge = bindingEdge;
        this.quantity = quantity;
        this.bindingSize = bindingSize;
        this.priceList = priceList;
    }

    /**
     * @return the bindingEdge
     */
    public double getBindingEdge() {
        return bindingEdge;
    }

    /**
     * @param bindingEdge
     *            the bindingEdge to set
     */
    public void setBindingEdge(double bindingEdge) {
        this.bindingEdge = bindingEdge;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity
     *            the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the bindingSize
     */
    public int getBindingSize() {
        return bindingSize;
    }

    /**
     * @param bindingSize
     *            the bindingSize to set
     */
    public void setBindingSize(int bindingSize) {
        this.bindingSize = bindingSize;
    }

    /**
     * @return the priceList
     */
    public double[][] getPriceList() {
        return priceList;
    }

    /**
     * @param priceList
     *            the priceList to set
     */
    public void setPriceList(double[][] priceList) {
        this.priceList = priceList;
    }

    /**
     * Read the input data.
     * 
     * @return
     *         A Price List of for plasticoil binding as a 2D ArrayList.
     * 
     * @throws ApplicationException
     *             if input data is incorrect throws ApplicationException
     */
    public static Map<Integer, Paper> readPaper() throws ApplicationException {

        File file = new File(IN_PLASTICOIL_FILENAME);
        FileReader in;
        Iterable<CSVRecord> records;
        try {
            in = new FileReader(file);
            records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
        } catch (IOException e) {
            throw new ApplicationException(e);
        }

        paper = new HashMap<>();

        LOG_READER.debug("Reading" + file.getAbsolutePath());
        for (CSVRecord record : records) {
            int SKU = Integer.parseInt(record.get("SKU"));
            String description = record.get("description");
            double pointThickness = Double.parseDouble(record.get("pointThickness"));
            int GSM = Integer.parseInt(record.get("GSM"));

            paper.put(SKU, new Paper(SKU, description, pointThickness, GSM));
        }
        return paper;
    }

    /**
     * @return price
     * @param bindingSize,
     */
    public double getBindingPrice(double bindingSize, int quantity) {
        double price = 0.0;
        if (quantity < 100) {
            price = 85.00;
        }
        if (quantity >= 100 && quantity <= 200) {
            price = priceList[0][0] * quantity;
        } else if (quantity > 200 && quantity <= 300) {
            price = priceList[0][1] * quantity;
        } else if (quantity > 200) {
            price = priceList[0][2] * quantity;
        }
        return price;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Plasticoil [bindingEdge=" + bindingEdge + ", quantity=" + quantity + ", bindingSize=" + bindingSize + "]";
    }

}
