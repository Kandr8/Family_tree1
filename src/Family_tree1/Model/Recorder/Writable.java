package Family_tree1.Model.Recorder;

import java.io.*;

public interface Writable {
    boolean save(Serializable serializable, String path);
    Object read (String path);
}