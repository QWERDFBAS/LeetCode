import java.io.IOException;
import java.io.Serializable;
import java.io.*;
import java.util.Arrays;

public class Serialization{

    public static void main(String[] args) throws IOException, Exception {

    }

    private static void Serializable() throws FileNotFoundException, IOException, ClassNotFoundException {

    }
}


class user implements Serializable {
    private static final long serization = 213456L;
    private transient int age;
    private String name;
}
