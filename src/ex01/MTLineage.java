package ex01;

// 不明の先祖
public class MTLineage implements ILineage {
    public MTLineage() {}

    // これが呼び出されることはないため"Err"を返す
    public String oldestName() {
        return "Err";
    }

    // 人物が存在しない(不明)のため-1を返す
    public int oldestYear() {
        return -1;
    }

    // 人物が存在しないため即時リターン
    public void addChild(ILineage child) {
        return;
    }

    // 人物が存在しないためthisを返す
    public ILineage getFather() {
        return this;
    }
    public ILineage getMother() {
        return this;
    }

    // 人物が存在しないためnullを返す
    public Person getP() {
        return null;
    }

    // 人物が存在しないためMTChildを返す
    public IChildren getChildren() {
        return new MTChild();
    }
}
