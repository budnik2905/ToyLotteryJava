
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class ToyLottery {

    private PriorityQueue<Toy> toys;
    private String[] ids;
    private String[] names;
    private int[] weights;

    public ToyLottery(String[] ids, String[] names, int[] weights) {
        this.ids = ids;
        this.names = names;
        this.weights = weights;
        toys = new PriorityQueue<>();
        for (int i = 0; i < ids.length; i++) {
            toys.add(new Toy(ids[i], names[i], weights[i]));
        }
    }

    public void addToy(String id, String name, int weight) {
        toys.add(new Toy(id, name, weight));
    }

    public Toy getToy() {
        return toys.poll();
    }

    public void getAndWriteToFile(int numToys, String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);
        for (int i = 0; i < numToys; i++) {
            Toy toy = getToy();
            writer.write(toy.getId() + ", " + toy.getName() + ", " + toy.getWeight() + "\n");
        }
        writer.close();
    }

    private class Toy implements Comparable<Toy> {

        private String id;
        private String name;
        private int weight;

        public Toy(String id, String name, int weight) {
            this.id = id;
            this.name = name;
            this.weight = weight;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Toy o) {
            return Integer.compare(o.weight, this.weight);
        }
    }

}


