# Personal-Project-Quoting-Program
This is a personal project built on spec for a book bindery to automate their quoting process. As I make substantial changes to it I will update the files.  Please note that although this represents working software with functionality it is by no means the final product.

Eventually the goal is to use a SQL database which would contain all of the price guides for all aspects of the business,  list of all the types of paper that can be used in a quote.  Currently the bulk of the functionality is in the MainClass, Paper class, PaperReader class, and MainFrame class.  When the MainFrame class opens the user has the option to enter information into JTextFields and select things like binding types and paper types.  This information is currently passed into the program as a CSV file from Excel. For the immediate future this will likely be the case until the program is more complete.  Goals are for the user to be able to make changes to the Excel files from inside the program without needing access to the individual files.  (ie they will be able to add a new paper type with all of it's specs into the Excel file from inside the program.  All these papertypes (including any new ones added) would be accessible to the user as choices from a set of JComboBox's in the MainFrame.

At this point the program is only printing back on to the MainFrame a summary of the information the user has entered.  This information will be sent to a new dialog box which will be exportable as a PDF to the server so sales people can email this to the customer.  The quotes will also be saved as Hashmaps and exported to a CSV file for saving on the server with the quote number being the Key. (eventually to a SQL server) This information will be searchable by company name, estimator's name, binding type, or date.  It will also be searchable by quote number so anyone that needs to can bring a quote back up for immediate viewing.   

![alt text](https://github.com/switch900/Personal-Project-Quoting-Program/blob/master/Capture190101.JPG)


