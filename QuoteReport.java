/**
 * Quoting Software QuoteReport Class. Takes object from Quote class that user has created and
 * saves it to file as a formatted quote.
 *
 * @author Andrew Hewitson
 *
 *         Date:Jan 13, 2019
 *         Time: 10:01 am
 */
package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import data.Quote;
import util.ApplicationException;

public class QuoteReport {

    public static final String LINE = new String(new char[475]).replace("\0", "-");
    public static final String PAPER_REPORT_HEADER_FORMAT = "%-13s %-25s %-25s %-25s %-25s %-10s %-25s %-25s %-25s %-25s %-25s %-25s %-25s %-25s %-25s %-25s %-25s %-25s %-25s";
    public static final String PAPER_REPORT_FORMAT = "%-13s %-25s %-25s %-25s %-25s %-10d %-25s %-25.2f %-25.2f %-25d %-25s %-25.2f %-25d %-25s %-25.2f %-25d %-25s %-25.2f %-25.2f";

    private static final String OUT_PAPERREPORT = ".txt";

    public static final Logger LOG_REPORT = LogManager.getLogger(QuoteReport.class);

    // default constructor
    public QuoteReport() {
    }

    /**
     * Takes Quote object and writes formatted report to file
     *
     * @param books
     *            A HashMap of Books
     * @throws ApplicationException
     *             If input is incorrect throws ApplicationException
     */
    public static void writeQuoteToFile(Quote quote) throws ApplicationException {

        PrintStream out = null;
        final File filename = new File(quote.getCompanyName() + "_" + quote.getQuoteNumber() + OUT_PAPERREPORT);
        FileOutputStream fileOut;
        try {
            fileOut = new FileOutputStream(filename);
            out = new PrintStream(fileOut);
            // out.println(MainClass.STARTTIME);
            out.println("Paper Report");
            out.println(LINE);
            out.println(String.format(PAPER_REPORT_HEADER_FORMAT, "Quote Number", "Company Name", "Estimator's Name", "Date", "P.O. Number", "Quantity", "Binding Type", "Non-Binding Edge", "Binding Edge", "Cover Quantity", "Cover Stock", "Cover Thickness", "Text Quantity", "Text Stock", "Text Thickness", "Insert Quantity", "Insert Stock", "Insert Thickness", "Price"));
            out.println(LINE);

            out.println(String.format(PAPER_REPORT_FORMAT, quote.getQuoteNumber(), quote.getCompanyName(), quote.getEstimatorName(), quote.getDate(), quote.getReferenceNumber(), quote.getBookQty(), quote.getBindingType(), quote.getNonBindingEdge(), quote.getBindingEdge(), quote.getCoverQty(), quote.getCoverStock(), quote.getCoverThickness(), quote.getTextQty(), quote.getTextStock(),
                    quote.getTextThickness(), quote.getInsertQty(), quote.getInsertStock(), quote.getInsertThickness(), quote.getUnitPrice()));
        } catch (final FileNotFoundException e) {
            LOG_REPORT.error(e.getMessage());
        } finally {
            // out.println(MainClass.calculateEndTimeAndDuration());
            out.close();
        }
    }

    /**
     * If input String is greater than designated maxWidth then String is subStringed into a shorter
     * String with an ellipsis (...)
     *
     * @param input
     *            String to truncate
     * @param maxWidth
     *            Maximum width of String
     * @return
     *         Truncated string as a String
     */
    public static String truncate(final String input, final int maxWidth) {
        String string = null;
        if (input.length() > maxWidth) {
            string = input.substring(0, maxWidth - 3) + "...";
        } else {
            string = input;
        }
        return string;
    }
}
