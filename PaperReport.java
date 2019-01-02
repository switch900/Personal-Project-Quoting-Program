package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import data.Paper;
import util.ApplicationException;

public class PaperReport {

    public static final String LINE = new String(new char[196]).replace("\0", "-");
    // public static final String CUSTOMER_FORMAT = "%4d. %-6d %-12s %-12s %-40s %-25s %-12s %-15s %-40s %-12s %7d";
    // public static final String HEADER_FORMAT = "%4s. %-6s %-12s %-12s %-40s %-25s %-12s %-15s %-40s %-12s %7s";
    public static final String PAPER_REPORT_HEADER_FORMAT = "%8s %-40s %-10s %6s";
    public static final String PAPER_REPORT_FORMAT = "%8d %-40s %10.1f %6d";
    // public static final String PURCHASEREPORT_HEADER_FORMAT = "%-24s %-80s %2s";
    // public static final String PURCHASEREPORT_FORMAT = "%-24s %-80s $%.f";

    private static final String OUT_PAPERREPORT = "paper_report.txt";

    public static final Logger LOG_REPORT = LogManager.getLogger(PaperReport.class);

    public PaperReport() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Takes HashMap of Books and writes formatted report to file
     * 
     * @param books
     *            A HashMap of Books
     * @throws ApplicationException
     *             If input is incorrect throws ApplicationException
     */
    public static void writeToPaperReportToFile(Map<Integer, Paper> paper) throws ApplicationException {

        PrintStream out = null;
        File filename = new File(OUT_PAPERREPORT);
        FileOutputStream fileOut;
        try {
            fileOut = new FileOutputStream(filename);
            out = new PrintStream(fileOut);
            // out.println(MainClass.STARTTIME);
            out.println("Paper Report");
            out.println(LINE);
            out.println(String.format(PAPER_REPORT_HEADER_FORMAT, "SKU", "Description", "Thickness", "GSM"));
            out.println(LINE);

            for (Map.Entry<Integer, Paper> paper1 : paper.entrySet()) {

                out.println(String.format(PAPER_REPORT_FORMAT, //
                        paper1.getValue().getSKU(), //
                        truncate(paper1.getValue().getDescription(), 35), //
                        paper1.getValue().getPointThickness(), //
                        paper1.getValue().getGsm()));
            }
        } catch (FileNotFoundException e) {
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
    public static String truncate(String input, int maxWidth) {
        String string = null;
        if (input.length() > maxWidth) {
            string = input.substring(0, (maxWidth - 3)) + "...";
        } else {
            string = input;
        }
        return string;
    }
}
