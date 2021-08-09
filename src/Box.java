import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Box<E extends Fruit> implements Comparable<Box> {

    private List<E> box;

    public Box (){
        box = new ArrayList<>();
    }

    public void addToBox (E e){
        box.add(e);
    }
    public float getWeight(){
        if (box.size() > 0){
            return box.size() * box.get(0).getWeight();
        }
        return 0;
    };


    @Override
    public int compareTo(Box b) {
        return Float.compare(this.getWeight(), b.getWeight());
    }

    public boolean compare (Box b){
        return (compareTo(b) == 0);
    }

    public void transferFruits(Box<E> b){
        b.addSomeFruits(box);
        this.box = new ArrayList<>();
    }

    private void addSomeFruits(Collection<E> fruits){
        box.addAll(fruits);
    }
};


