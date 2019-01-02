
/**
 * Paper Thickness Calculator Main Class
 *
 * @author Andrew Hewitson
 *
 *         Date:January 1, 2019
 *         Time: 4:24:00 PM
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import ui.MainFrame;

public class MainClass {

    public static final Instant STARTTIME = Instant.now();
    public static final String LOG4J_CONFIG_FILENAME = "log4j2.xml";

    static {
        configureLogging();
    }

    /**
     * new Log file
     */
    public static final Logger LOG = LogManager.getLogger(MainClass.class);

    // import java.util.HashMap;
    // import java.util.Map;
    // import java.util.Set;
    // import java.io.*;
    //
    // public static InputReader reader;
    // public static Book_Thickness testCode2;
    // public static Paper_Thicknesses testCode;
    // public static DropDownMenu dropDown;

    public static void main(String[] args) {
        LOG.info(STARTTIME);
        LOG.info("Starting BasicLogging.");
        // try {

        // PaperReport.writeToPaperReportToFile(PaperReader.readPaper());

        try {
            for (final LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    LOG.info(info.getName() + " LookAndFeel set.");
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            // DropDownMenu.menu();
            final MainFrame frame = new MainFrame();
            frame.setVisible(true);
            // } catch (Exception e) {
            // LOG.error(e.getMessage());
            // }
            // BookOptions.process(args);
            // new BookOptions().run();

        } catch (final Exception e) {
            LOG.error(e.getMessage());
        } finally {
            LOG.info(calculateEndTimeAndDuration());
        }

        //// testCode = new Paper_Thicknesses();
        // testCode2 = new Book_Thickness();
        // new Apak_Quoting();
    }

    public static void run() {

    }

    /**
     * Finds program end time in ms and calculates duration that program ran for in ms.
     *
     * @return
     *         calculateEndTimeAndDuration as a String
     */
    public static String calculateEndTimeAndDuration() {
        final Instant endTime = Instant.now();
        return String.format("%s%nDuration: %d ms", endTime, Duration.between(STARTTIME, endTime).toMillis());
    }

    /**
     * Configures LOG4J logging file
     */
    public static void configureLogging() {

        ConfigurationSource source;
        try {
            source = new ConfigurationSource(new FileInputStream(LOG4J_CONFIG_FILENAME));
            Configurator.initialize(null, source);
            Configurator.setRootLevel(Level.DEBUG);
        } catch (final IOException e) {
            LOG.error(String.format("Can't find the log4j logging configuration file %s.", LOG4J_CONFIG_FILENAME));
        }
    }

    // testCode = new Paper_Thicknesses();
    // // getThickness();
    //
    // // testCode2 = new Book_Thickness(100,4.6,10,5,193,10,2);
    // // testCode2.bookThickness();
    //
    // // System.out.print(
    // // "Enter description for paper(Enter as Brand/Description/Weight in lbs (i.e.
    // // Pacesetter Silk Text 100# : ");
    // // reader = new InputReader();
    // // String description = reader.getStringInput();
    // // System.out.print("Paper thickness in points: ");
    // // reader = new InputReader();
    // // Double pointThickness = reader.getDoubleInput();
    // // testCode.addPaper(description, new Double(pointThickness));
    // //
    // // System.out.println("Continue?");
    // // reader = new InputReader();
    // // String userInput = reader.getStringInput();
    // // if (userInput != null) {
    // // if (userInput.equals("y")) {
    // // run();
    // // }
    // // else {
    // Paper_Thicknesses.addPaperAuto();
    // // Paper_Thicknesses.displayAllPaper();
    // DropDownMenu.menu();
    // // System.out.println(DropDownMenu.data2);
    //// getThickness();
    //// testCode2.newBookQuote();
    //// testCode2.bookThickness();
    // // }
    // // }
    //
    // testCode2 = null;
    // try {
    // FileInputStream fileIn = new FileInputStream("c:/users/switc/eclipse-workspace/testSave.ser");
    // ObjectInputStream in = new ObjectInputStream(fileIn);
    // testCode2 = (Book_Thickness) in.readObject();
    // in.close();
    // fileIn.close();
    // }catch(IOException i) {
    // i.printStackTrace();
    //
    // }catch(ClassNotFoundException c){
    // System.out.println("Book_Thickness class not found");
    // c.printStackTrace();
    // return;
    // }
    //
    // System.out.println("count: " + testCode2.getBookCount());
    // System.out.println("Cover thickness: " + testCode2.getCoverThicknesses());
    // System.out.println("Text thickness: " + testCode2.getTextThicknesses());
    // System.out.println("Insert thickness: " + testCode2.getInsertThicknesses());
    // System.out.println("Binding Edge: " + testCode2.getBindingEdgeInInches());
    // System.out.println("Non-Binding Edge: " + testCode2.getNonBindingEdgeInInches());
    //
    //
    //
    // }

}
