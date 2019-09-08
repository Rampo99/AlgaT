package sample;
import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {

    private ArrayList<T> elementi;

    public Heap() {
        elementi = new ArrayList<T>();
    }
    public void insert(T item) {
        elementi.add(item);
        heapInsert();
    }

    private void heapInsert() {
        int k = elementi.size() - 1;
        while (k > 0) {
            int p = (k-1)/2;
            T item = elementi.get(k);
            T parent = elementi.get(p);
            if (item.compareTo(parent) > 0) {
                elementi.set(k, parent);
                elementi.set(p, item);
                k = p;
            }
        }
    }
    public T delete(){
        if (elementi.size() == 0) {
            System.out.println("Non ci sono elementi");
        }
        if (elementi.size() == 1) {
            return elementi.remove(0);
        }
        T hold = elementi.get(0);
        elementi.set(0, elementi.remove(elementi.size()-1));
        heapDelete();
        return hold;
    }

    private void heapDelete() {
        int k = 0;
        int l = 2*k+1;
        while (l < elementi.size()) {
            int max=l, r=l+1;
            if (r < elementi.size()) {
                if (elementi.get(r).compareTo(elementi.get(l)) > 0) {
                    max++;
                }
            }
            if (elementi.get(k).compareTo(elementi.get(max)) < 0) {
                T temp = elementi.get(k);
                elementi.set(k, elementi.get(max));
                elementi.set(max, temp);
                k = max;
                l = 2*k+1;
            }
        }
    }

    public int size() {
        return elementi.size();
    }

}