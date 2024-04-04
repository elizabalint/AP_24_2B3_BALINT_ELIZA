package org.example;
import java.io.IOException;
import freemarker.template.TemplateException;

public interface Command<T1, T2> {
    // metoda ce trebuie implementata in toate metodele ce implementeaza interfata
    default void handleCommand(T1 t1, T2 t2) throws IOException, TemplateException {

    }
}
