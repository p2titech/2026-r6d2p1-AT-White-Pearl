package ex01;

// 追加の先祖
public class HaveLineage implements ILineage {
    ILineage father;
    ILineage mother;
    Person p;
    IChildren children = new MTChild();
    public HaveLineage(ILineage father, ILineage mother, Person p) {
        this.father = father;
        this.mother = mother;
        this.p = p;

        this.p.lineage = this;
        this.father.addChild(this);
        this.mother.addChild(this);
    }

    public void addChild(ILineage child) {
        this.children = new ConsChild(child, this.children);
        return;
    }

    public ILineage getFather() {
        return this.father;
    }
    public ILineage getMother() {
        return this.mother;
    }
    public Person getP() {
        return this.p;
    }
    public IChildren getChildren() {
        return this.children;
    }

    public String oldestName() {
        if(this.father.oldestYear() == -1 && this.mother.oldestYear() == -1) {
            return this.p.name;
        } else {
            if(this.father.oldestYear() == -1) {
                return this.mother.oldestName();
            } else {
                if(this.mother.oldestYear() == -1) {
                    return this.father.oldestName();
                } else {
                    if(this.father.oldestYear() < this.mother.oldestYear()) {
                        return this.father.oldestName();
                    } else {
                        return this.mother.oldestName();
                    }
                }
            }
        }
    }

    public int oldestYear() {
        if(this.father.oldestYear() == -1 && this.mother.oldestYear() == -1) {
            return this.p.birthyear;
        } else {
            if(this.father.oldestYear() == -1) {
                return this.mother.oldestYear();
            } else {
                if(this.mother.oldestYear() == -1) {
                    return this.father.oldestYear();
                } else {
                    if(this.father.oldestYear() < this.mother.oldestYear()) {
                        return this.father.oldestYear();
                    } else {
                        return this.mother.oldestYear();
                    }
                }
            }
        }
    }
}
