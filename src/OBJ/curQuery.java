package OBJ;

public class curQuery {
    public String name;
    public String job;
    public String sal;
    public String comm;
    public String hiredateStr;
    public String mgr;
    public String dept;

    @Override
    public String toString() {
        return "curQuery{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", sal='" + sal + '\'' +
                ", comm='" + comm + '\'' +
                ", hiredateStr='" + hiredateStr + '\'' +
                ", mgr='" + mgr + '\'' +
                ", dept='" + dept + '\'' +
                '}';
    }

    public curQuery(String name, String job, String sal, String comm, String hiredateStr, String mgr, String dept) {
        this.name = name;
        this.job = job;
        this.sal = sal;
        this.comm = comm;
        this.hiredateStr = hiredateStr;
        this.mgr = mgr;
        this.dept = dept;
    }
}
