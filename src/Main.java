import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("내장함수 버전 result = " + array());
        System.out.println("내장함수 아닌 버전 result = " + array2());

    }
    //내장함수 버전
    static public int array() {
        //배열 선언해서 값을 넣어준다.
        int[] a = {1000, 1, -3000, 9, 0, -10, -1, 2, 4, 10000, -12345};
        //반복문으로 i를 1에서부터 1억까지 돌린다.
        for(int i=1; i<=100000000; i++) {
            final int finalI = i;
            //배열이 i값을 포함하는지 확인한다.
            boolean isExist = Arrays.stream(a).anyMatch(n -> n == finalI); //구글 +1 도움
            //문제 -> 1. anyMatch("i"::equals)는 String일 때 먹히는 거였음.
            //해결 -> anyMatch에 숫자를 쓰려면 final로 써야함 =>> final은 변하지 않는 상수 =>> 왜 anyMatch에 쓰려면 final을 써야하는지?

            //만약 배열에 i값을 포함하지 않으면 i를 리턴한다.
            if(!isExist) {
                return finalI;
            }
        }
        return 0;
    }
    //내장함수 없는 버전(제연님 +1 도움)
    static public int array2() {
        //배열 선언해서 값을 넣어준다.
        int[] b = {1000, 1, -3000, 9, 0, -10, -1, 2, 4, 10000, -12345};
        //result를 선언하고 false로 초기화 해준다.
        boolean result = false;
        //num을 선언하고 0으로 초기화 해준다.
        int num = 0;
        //반복문으로 i를 1에서부터 1억까지 돌린다.
        for(int i=1; i<=100000000; i++) {
            //---배열 안에 i값을 포함하는지 확인하는 과정---
            //반복문으로 배열의 값을 하나씩 빼서 비교해준다.
            for(int j=0; j<b.length; j++) {
                //i값이 배열의 요소와 같으면 result에 true를 저장하고 for문을 종료한다.
                if(i == b[j]) {
                    result = true;
                    break; //*break 와 continue 차이 -> break는 for문 종료, continue는 지금꺼는 스킵하고 다음 반복을 하겠다.

                //i값이 배열의 요소와 같지 않으면 result에 false를 저장한다.
                } else {
                    result = false;
                }
            }
            //만약 result가 true이면 i 반복문을 스킵하고 다음 반복을 하겠다.
            if(result == true) {
                continue;
            }
            //위의 if문에 걸리지 않으면(배열 요소와 i가 같지 않으면) num에 i값을 저장하고 for문을 종료한다.
            num=i;
            break;
            //---배열 안에 i값을 포함하는지 확인하는 과정 끝 ---

        }
        //num을 리턴한다.
        return num;
    }
}