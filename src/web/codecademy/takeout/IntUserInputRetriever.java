package web.codecademy.takeout;

public interface IntUserInputRetriever<T> {
    T produceOutputOnIntUserInput(int selection) throws IllegalArgumentException;
}

