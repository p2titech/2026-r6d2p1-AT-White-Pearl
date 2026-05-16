package ex01;

// 追加の子供
public class ConsChild implements IChildren {
    ILineage first;
    IChildren rest;
    public ConsChild(ILineage first, IChildren rest) {
        this.first = first;
        this.rest = rest;
    }

    public boolean contain(ILineage that) {
        return this.first.equals(that) || this.rest.contain(that);
    }
}
