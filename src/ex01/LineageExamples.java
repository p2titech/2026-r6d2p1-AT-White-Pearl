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

    ILineage mtl = new MTLineage();

    ILineage l1_3 = new HaveLineage(mtl, mtl, p6);
    ILineage l1_2 = new HaveLineage(mtl, mtl, p5);
    ILineage l1_1 = new HaveLineage(l1_2, l1_3, p1);

    ILineage l2_6 = new HaveLineage(mtl, mtl, p13);
    ILineage l2_5 = new HaveLineage(mtl, mtl, p12);
    ILineage l2_4 = new HaveLineage(mtl, mtl, p11);
    ILineage l2_3 = new HaveLineage(mtl, l2_6, p6);
    ILineage l2_2 = new HaveLineage(l2_4, l2_5, p5);
    ILineage l2_1 = new HaveLineage(l2_2, l2_3, p1);

    ILineage l3_15 = new HaveLineage(mtl, mtl, p15);
    ILineage l3_14 = new HaveLineage(mtl, mtl, p14);
    ILineage l3_13 = new HaveLineage(mtl, mtl, p13);
    ILineage l3_12 = new HaveLineage(mtl, mtl, p12);
    ILineage l3_11 = new HaveLineage(mtl, mtl, p11);
    ILineage l3_10 = new HaveLineage(l3_14, l3_15, p10);
    ILineage l3_9 = new HaveLineage(l3_14, l3_15, p9);
    ILineage l3_8 = new HaveLineage(l3_14, l3_15, p8);
    ILineage l3_7 = new HaveLineage(mtl, l3_13, p7);
    ILineage l3_6 = new HaveLineage(mtl, l3_13, p6);
    ILineage l3_5 = new HaveLineage(l3_11, l3_12, p5);
    ILineage l3_4 = new HaveLineage(l3_10, mtl, p4);
    ILineage l3_3 = new HaveLineage(l3_7, l3_8, p3);
    ILineage l3_2 = new HaveLineage(l3_7, l3_8, p2);
    ILineage l3_1 = new HaveLineage(l3_5, l3_6, p1);

    IChildren mtc = new MTChild();

    IChildren c1_3 = new ConsChild(l1_1, mtc);
    IChildren c1_2 = new ConsChild(l1_1, mtc);
    IChildren c1_1 = mtc;

    IChildren c2_6 = new ConsChild(l2_3, mtc);
    IChildren c2_5 = new ConsChild(l2_2, mtc);
    IChildren c2_4 = new ConsChild(l2_2, mtc);
    IChildren c2_3 = new ConsChild(l2_1, mtc);
    IChildren c2_2 = new ConsChild(l2_1, mtc);
    IChildren c2_1 = mtc;

    IChildren c3_15 = new ConsChild(l3_8, new ConsChild(l3_9, new ConsChild(l3_10, mtc)));
    IChildren c3_14 = new ConsChild(l3_8, new ConsChild(l3_9, new ConsChild(l3_10, mtc)));
    IChildren c3_13 = new ConsChild(l3_6, new ConsChild(l3_7, mtc));
    IChildren c3_12 = new ConsChild(l3_5, mtc);
    IChildren c3_11 = new ConsChild(l3_5, mtc);
    IChildren c3_10 = new ConsChild(l3_4, mtc);
    IChildren c3_9 = mtc;
    IChildren c3_8 = new ConsChild(l3_2, new ConsChild(l1_3, mtc));
    IChildren c3_7 = new ConsChild(l3_2, new ConsChild(l1_3, mtc));
    IChildren c3_6 = new ConsChild(l3_1, mtc);
    IChildren c3_5 = new ConsChild(l3_1, mtc);
    IChildren c3_4 = mtc;
    IChildren c3_3 = mtc;
    IChildren c3_2 = mtc;
    IChildren c3_1 = mtc;

    @Test
    public void testOldest() {
        assertEquals("SasakiToshikazu", l1_1.oldestName());
        assertEquals("SasakiHana", l1_3.oldestName());
        assertEquals("KikuchiSuzu", l2_1.oldestName());
        assertEquals("SasakiTome", l2_2.oldestName());
    }

    @Test
    public void testIsUncleOrAuntOf() {
        assertEquals(true, p7.isUncleOrAuntOf(p1));
        assertEquals(false, p1.isUncleOrAuntOf(p7));
        assertEquals(false, p8.isUncleOrAuntOf(p1));
        assertEquals(false, p14.isUncleOrAuntOf(p8));
    }

    @Test
    public void testIsCousinOf() {
        assertEquals(true, p1.isCousinOf(p2));
        assertEquals(true, p2.isCousinOf(p1));
        assertEquals(false, p1.isCousinOf(p1));
        assertEquals(false, p2.isCousinOf(p3));
        assertEquals(true, p2.isCousinOf(p4));
        assertEquals(false, p1.isCousinOf(p4));
        assertEquals(false, p6.isCousinOf(p8));
        assertEquals(false, p11.isCousinOf(p13));
    }
}
