/**
 * Project: a01029917Comp2613Assignment1
 *
 * File: Books.java
 * Date: May 21, 2018
 * Time: 10:45:00 AM
 */

package util;

/**
 * Application Exception Class
 *
 * @author Andrew Hewitson, A01029917
 *
 */

@SuppressWarnings("serial")
public class ApplicationException extends Exception {

    public ApplicationException() {
        super();
    }

    public ApplicationException(final String message) {
        super(message);
    }

    public ApplicationException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ApplicationException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writeableStackTrace) {
        super(message, cause, enableSuppression, writeableStackTrace);
    }

    public ApplicationException(final Throwable cause) {
        super(cause);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return super.getMessage();
    }
}
