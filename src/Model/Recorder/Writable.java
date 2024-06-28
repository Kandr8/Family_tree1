package Model.Recorder;

import java.io.*;

public interface Writable {
    boolean save(Serializable serializable, String path);
    Object read (String path);
}