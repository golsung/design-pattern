
// SimpleCalculator 클래스

class SimpleCalculator {

    // 두 정수의 합을 계산하고 결과를 로그로 출력
    public int calc(int a, int b) {
        int result = a + b;
        System.out.println("add executed <<" + result + ">>");
        return result;
    }
}

//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//class SimpleCalculator {
//    public int calc(int a, int b) {
//        int result = a + b;
//        try (PrintWriter out = new PrintWriter(new FileWriter("log.txt", true))) {
//            out.println("add executed <<" + result + ">>");  // 파일 로깅
//        } catch (IOException e) {
//            System.out.println("Error writing to log file: " + e.getMessage());
//        }
//        return result;
//    }
//}

// 메인 클래스
public class Main {
    public static void main(String[] args) {
        // Calculator 타입의 참조 변수로 SimpleCalculator 인스턴스 생성
        SimpleCalculator calculator = new SimpleCalculator();

        // add 메소드 호출 결과를 로깅
        calculator.calc(10, 20); // 이 함수 호출은 로깅을 포함하며 결과를 출력합니다.
    }
}