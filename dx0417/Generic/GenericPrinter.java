package dx0417.Generic;

public class GenericPrinter<T extends Material> {
    private T material;
            // Power meteral = new Power();
    public void setMaterial(T material) {
        this.material = material;
    }

    public T getMaterial() {
        return material;
    }

    public String toString() {
        return material.toString(); // new Power().toString();
    }

    public void printing() {
        material.doPrinting();
    }
}