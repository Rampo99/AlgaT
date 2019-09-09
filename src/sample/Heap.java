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
            T a = elementi.get(k);
            T b = elementi.get(p);
            if (a.compareTo(b) > 0) {
                elementi.set(k, b);
                elementi.set(p, a);
                k=p;
            } else {
                break;
            }
        }
    }
    public T getElement(int k){
        return elementi.get(k);
    }
    public T getMax(){
        return elementi.get(0);
    }

    public T extractMax(){
        if (elementi.size() == 1) {
            return elementi.remove(0);
        }
        T a = elementi.get(0);
        elementi.set(0, elementi.remove(elementi.size()-1));
        heapDelete();
        return a;
    }

    private void heapDelete() {
        int a = 0;
        int b = 1;
        while (b < elementi.size()) {
            int max=b, r=b+1;
            if (r < elementi.size()) {
                if (elementi.get(r).compareTo(elementi.get(b)) > 0) {
                    max++;
                }
            }
            if (elementi.get(a).compareTo(elementi.get(max)) < 0) {
                T delete = elementi.get(a);
                elementi.set(a, elementi.get(max));
                elementi.set(max, delete);
                a = max;
                b = 2*a+1;
            } else {
                break;
            }
        }
    }

    public void insert2(T item){
        elementi.add(item);
    }
    public void sort1() {
        for (int i = elementi.size() / 2 - 1; i >= 0; i--)
            heapify(elementi.size(),i);

    }
    public void sort2(){
        for (int i=elementi.size()-1; i>=0; i--){
            T temp = elementi.get(0);
            elementi.set(0,elementi.get(i));
            elementi.set(i,temp);
            heapify(i,0);
        }
    }

    public void heapify(int n, int i){
        int max = i;
        int sx = 2*max + 1;
        int dx = 2*max + 2;
        //controllo se il figlio sx é piú grande dell'elemento a [0]
        if(sx < n && (elementi.get(sx).compareTo(elementi.get(max)) > 0)){
            max = sx;
        }
        //controllo se il figlio dx é piú grande del massimo
        if(dx < n && (elementi.get(dx).compareTo(elementi.get(max)) > 0)){
            max = dx;
        }
        //swap in caso del massimo non a [0]
        if(max != i){
            T swap = elementi.get(i);
            elementi.set(i,elementi.get(max));
            elementi.set(max,swap);
            //ricorsione sul sotto albero
            heapify(n,max);
        }
    }

    public int size() {
        return elementi.size();
    }
}