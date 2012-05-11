package model;





public class Person {
    int id;
    String ln;
    String fn;

    public Person(int id, String ln, String fn) {
        this.id = id;
        this.ln = ln;
        this.fn = fn;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", ln=" + ln + ", fn=" + fn + '}';
    }
    static Person[] gerArr(){
         Person p0 = new Person(1,"JKLjkjk","Dfdfsf");
         Person p1 = new Person(2,"DFDSJKLjkjk","111Dfdfsf");
         Person p3 = new Person(3,"AAAAJKLjkjk","POoocodoDfdfsf");
         return new Person[]{p0,p1,p3};
    }
}
