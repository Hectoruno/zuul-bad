
/**
 * Write a description of class Item here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item {
    // Variable nombre
    String name;
    // Variable peso
    int weigh;
    // Variable identificador
    int id;

    /**
     * Constructor de objetos Item
     * 
     * @param nombre nombre de objeto 
     * @param peso peso de objeto
     */
    public Item(String nombre, int peso) {
        this.name = nombre;
        this.weigh = peso;
    }

    /**
     * Nombre del item.
     * @return Devuelve el nombre del item.
     */
    public String getNombre() {
        return name;
    }

    /**
     * Devuelve el nombre del item.
     * @return Devuelve el nombre del item.
     */
    public void setNombre(String nuevoNombre) {
        name = nuevoNombre;
    }

    /**  Peso del item.
     * @return Devuelve el peso del item.
     */
    public void setWeigh(int nuevoWeigh) {
        weigh = nuevoWeigh;
    }

    /**
     * Devuelve el peso del item.
     * @return Devuelve el peso del item.
     */

    public int getItem() {
        return weigh;
    }
}