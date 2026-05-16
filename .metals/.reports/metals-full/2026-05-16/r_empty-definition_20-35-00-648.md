error id: file://<WORKSPACE>/src/ex01/Person.java:
file://<WORKSPACE>/src/ex01/Person.java
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 276
uri: file://<WORKSPACE>/src/ex01/Person.java
text:
```scala
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
    public@@ boolean isCousinOf(Person that) {
        return that.lineage.getFather().getP().isUncleOrAuntOf(this) || 
               that.lineage.getMother().getP().isUncleOrAuntOf(this);
    }

    // thisがthatの叔父か叔母であるか判定する
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

```


#### Short summary: 

empty definition using pc, found symbol in pc: 