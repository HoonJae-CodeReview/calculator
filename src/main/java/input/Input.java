package input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public interface Input<T> {

    T input() throws  IOException;
}
