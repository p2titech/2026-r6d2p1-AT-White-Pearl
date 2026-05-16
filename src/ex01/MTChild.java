package ex01;

// 空の子供
public class MTChild implements IChildren {
    public MTChild() {}

    public boolean contain(ILineage that) {
        return false;
    }
}
