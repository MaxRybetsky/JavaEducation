package examples.io;

import java.io.*;

/**
 * Class with clone method using serialization
 */
public class SerialCloneable implements Cloneable, Serializable {
    public Object clone() throws CloneNotSupportedException {
        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            try (ObjectOutputStream out = new ObjectOutputStream(bout)) {
                out.writeObject(this);
            }
            try (ByteArrayInputStream bin = new ByteArrayInputStream(
                    bout.toByteArray())) {
                ObjectInputStream in = new ObjectInputStream(bin);
                return in.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            CloneNotSupportedException e2 =
                    new CloneNotSupportedException();
            e2.initCause(e);
            throw e2;
        }
    }
}
