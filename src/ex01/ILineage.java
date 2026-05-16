package ex01;

// 家系
public interface ILineage {
    // 家系(祖先の記録)で最も昔に生まれた人物の名前を求める
    public String oldestName();
    // 家系(祖先の記録)で最も昔に生まれた人物の生まれた年を求める
    public int oldestYear();
    // 子供の家系を追加する
    public void addChild(ILineage child);
    // 父親/母親の家系,人の情報,その子供たちを取得する
    public ILineage getFather();
    public ILineage getMother();
    public Person getP();
    public IChildren getChildren();
}
