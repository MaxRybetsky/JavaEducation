package examples.io;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class DataIO {
    /**
     * Writes fixed number of string units
     * to binary format
     * @param s String to write
     * @param size max size of string could be written
     * @param out output stream
     * @throws IOException if process was interrupted due to
     *                     any IO error
     */
    public static void writeFixedString(String s, int size,
                                        DataOutput out) throws IOException {
        for (int i = 0; i < size; i++) {
            out.writeChar(i < s.length() ? s.charAt(i) : 0);
        }
    }

    /**
     * Reads string from binary format
     * @param size max size of string
     * @param in input stream
     * @return string was read
     * @throws IOException if process was interrupted due to
     *                     any IO error
     */
    public static String readFixedString(int size,
                                         DataInput in) throws IOException {
        StringBuilder b = new StringBuilder(size);
        int i = 0;
        boolean done = false;
        while (!done && i < size) {
            char ch = in.readChar();
            i++;
            if (ch == 0) {
                done = true;
            } else {
                b.append(ch);
            }
        }
        in.skipBytes(2 * (size - i));
        return b.toString();
    }
}
