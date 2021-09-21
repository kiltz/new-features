package de.kiltz.neu.in7;

import java.io.Closeable;
import java.io.IOException;
import java.sql.SQLException;

public class EineRessource implements Closeable {
    public void tuWas() throws SQLException {
        System.out.println("Tue etwas...");
    }
    @Override
    public void close() throws IOException {
        System.out.println("Schließe die Ressource");
    }
}
