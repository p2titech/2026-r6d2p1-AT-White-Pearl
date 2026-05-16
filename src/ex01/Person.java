package ex01;

// 人の情報
public class Person {
    String name;
    int birthyear; // A.D.
    ILineage lineage = null;
    public Person(String name, int birthyear) {
        this.name = name;
        this.birthyear = birthyear;
    }

    // thisとthatがいとこ関係にあるか判定する
    public boolean isCousinOf(Person that) {
        return (that.lineage.getFather().getP() != null && 
                that.lineage.getFather().getP().isUncleOrAuntOf(this)) || 
                (that.lineage.getMother().getP() != null && 
                that.lineage.getMother().getP().isUncleOrAuntOf(this));
    }

    // thisがthatのおじかおばであるか判定する(補助メソッド)
    public boolean isUncleOrAuntOf(Person that) {
        if(this.equals(that.lineage.getFather().getP()) || 
           this.equals(that.lineage.getMother().getP())) {
            return false;
        } else {
            return this.lineage.getFather().getChildren()
                   .contain(that.lineage.getFather()) || 
                   this.lineage.getFather().getChildren()
                   .contain(that.lineage.getMother()) || 
                   this.lineage.getMother().getChildren()
                   .contain(that.lineage.getFather()) || 
                   this.lineage.getMother().getChildren()
                   .contain(that.lineage.getMother());
        }
    }
}
