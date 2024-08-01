package ageria;

import java.util.Random;

public class Costumer {

    Random random = new Random();
    private long id;
    private String name;
    private int tier;

    public Costumer(String name, int tier) {
        this.id = random.nextInt(100000, 500000);
        this.name = name;
        this.tier = tier;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTier() {
        return tier;
    }

    @Override
    public String toString() {
        return "Costumer: " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tier=" + tier;
    }
}
