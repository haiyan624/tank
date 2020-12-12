package wq.dp.stategy;

public class CatWeightComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat t1, Cat t2) {
        return t1.getWeight() - t2.getWeight();
    }
}
