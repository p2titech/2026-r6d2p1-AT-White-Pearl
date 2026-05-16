error id: file://<WORKSPACE>/src/ex01/LineageExamples.java:ex01/LineageExamples#mt.
file://<WORKSPACE>/src/ex01/LineageExamples.java
empty definition using pc, found symbol in pc: 
found definition using semanticdb; symbol ex01/LineageExamples#mt.
empty definition using fallback
non-local guesses:

offset: 888
uri: file://<WORKSPACE>/src/ex01/LineageExamples.java
text:
```scala
package ex01;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

// 家系の例
public class LineageExamples {
    Person p1 = new Person("SasakiTetsuya", 2001);
    Person p2 = new Person("KikuchiToshimasa", 2003);
    Person p3 = new Person("KikuchiKana", 2001);
    Person p4 = new Person("SuzukiKai", 1999);
    Person p5 = new Person("SasakiToshikazu", 1970);
    Person p6 = new Person("SasakiHana", 1973);
    Person p7 = new Person("Kikuchikazuya", 1975);
    Person p8 = new Person("KikuchiYuna", 1973);
    Person p9 = new Person("SuzukiAkiko", 1971);
    Person p10 = new Person("SuzukiKoji", 1975);
    Person p11 = new Person("SasakiFumio", 1947);
    Person p12 = new Person("SasakiTome", 1947);
    Person p13 = new Person("KikuchiSuzu", 1947);
    Person p14 = new Person("SuzukiMasa", 1947);
    Person p15 = new Person("SuzukiSakura", 1947);

    ILineage mt@@ = new MTLineage();

    ILineage l1_3 = new HaveLineage(mt, mt, p6);
    ILineage l1_2 = new HaveLineage(mt, mt, p5);
    ILineage l1_1 = new HaveLineage(l1_2, l1_3, p1);

    ILineage l2_6 = new HaveLineage(mt, mt, p11);
    ILineage l2_5 = new HaveLineage(mt, mt, p12);
    ILineage l2_4 = new HaveLineage(mt, mt, p13);
    ILineage l2_3 = new HaveLineage(mt, l2_6, p6);
    ILineage l2_2 = new HaveLineage(l2_4, l2_5, p5);
    ILineage l2_1 = new HaveLineage(l2_2, l2_3, p1);

    ILineage l3_15 = new HaveLineage(mt, mt, p15);
    ILineage l3_14 = new HaveLineage(mt, mt, p14);
    ILineage l3_13 = new HaveLineage(mt, mt, p13);
    ILineage l3_12 = new HaveLineage(mt, mt, p12);
    ILineage l3_11 = new HaveLineage(mt, mt, p11);
    ILineage l3_10 = new HaveLineage(l3_14, l3_15, p10);
    ILineage l3_9 = new HaveLineage(l3_14, l3_15, p9);
    ILineage l3_8 = new HaveLineage(l3_14, l3_15, p8);
    ILineage l3_7 = new HaveLineage(mt, l3_13, p7);
    ILineage l3_6 = new HaveLineage(mt, l3_13, p6);
    ILineage l3_5 = new HaveLineage(l3_11, l3_12, p5);
    ILineage l3_4 = new HaveLineage(l3_10, mt, p4);
    ILineage l3_3 = new HaveLineage(l3_7, l3_8, p3);
    ILineage l3_2 = new HaveLineage(l3_7, l3_8, p2);
    ILineage l3_1 = new HaveLineage(l3_5, l3_6, p1);

    IChildren c3_1 = 

    @Test
    public void testOldest() {
        assertEquals("SasakiToshikazu", l1_1.oldestName());
        assertEquals("SasakiHana", l1_3.oldestName());
        assertEquals("KikuchiSuzu", l2_1.oldestName());
        assertEquals("SasakiTome", l2_2.oldestName());
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: 