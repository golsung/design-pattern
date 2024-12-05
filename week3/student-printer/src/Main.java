public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("insang chung");
        s1.setMidScore(90.0);
        s1.setFinalScore(100.0);
        s1.setHwScore(95.0);
        System.out.println("******  Print in XML  *******");
        s1.print("xml");
        
        System.out.println("******  Print in Json  *******");
        s1.print("json");
    }
}
