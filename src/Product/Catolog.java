package Product;

import java.io.Serializable;

public class Catolog implements Serializable {
    public String name;
    public Catolog(String name) {
        this.name = name.toUpperCase();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  name ;
    }
}
