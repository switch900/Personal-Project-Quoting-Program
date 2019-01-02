package io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import data.Paper;
import util.ApplicationException;

/**
 * Reads input files
 * 
 * @author Andrew Hewitson, A01029917
 *
 */
public class PaperReader {

    public static final String IN_PAPERFILENAME = "paper.csv";
    public static final Logger LOG_READER = LogManager.getLogger(PaperReader.class);
    public static Map<Integer, Paper> paper;

    public PaperReader() {
    }

    /**
     * Read the input data.
     * 
     * @return
     *         A HashMap of paper.
     * 
     * @throws ApplicationException
     *             if input data is incorrect throws ApplicationException
     */
    public static Map<Integer, Paper> readPaper() throws ApplicationException {

        File file = new File(IN_PAPERFILENAME);
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
}
