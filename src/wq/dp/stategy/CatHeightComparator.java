package wq.dp.stategy;

public class CatHeightComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat t1, Cat t2) {
        return t1.getHeight() - t2.getHeight();
    }
}
