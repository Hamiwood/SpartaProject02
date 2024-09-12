import java.util.*;

public class start {
    public static void main(String[] args) {
        Integer[] nums = {1,2,3,4,5,6,7,8,9};
        List<Integer> random = Arrays.asList(nums);
        Set<Integer> inputNum = new LinkedHashSet<>();//입력값
        List<String> result = new ArrayList<>();//결과
        boolean exit =  true;

        //입력
        while(exit){
            int success = 0;
            int count = 0;
            Collections.shuffle(random);// 셔플

            //값 3개 가져오기 메서드
            List<Integer> choice = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                choice.add(random.get(i));
            }

            while(success != 3){

                System.out.println("중복되지 않는 일의 자리 양의 정수 3개를 입력해주십시오.");
                System.out.println("[예시 : 3 5 7]");
                System.out.println();
                Scanner sc = new Scanner(System.in);

                while(inputNum.size() != 3){
                    System.out.println((inputNum.size()+1)+"번째 번호를 입력하십시오");
                    String num = sc.next();
                    inputNum.add(Integer.parseInt(num));
                }

                //메서드화
                Iterator<Integer> iter = inputNum.iterator();
                for(int i = 0; i < choice.size(); i++){
                    int s = iter.next();
                    if(Objects.equals(s, choice.get(i))){
                        result.add("스트라이크");
                    }
                    else if(choice.contains(s)){
                        result.add("볼");
                    }else{
                        result.add("아웃");
                    }
                }

                success = Collections.frequency(result, "스트라이크");
                System.out.println(Collections.frequency(result, "스트라이크")+"스트라이크 "+Collections.frequency(result, "볼")+"볼 "+Collections.frequency(result, "아웃")+"아웃");
                inputNum.clear();
                result.clear();
                count++;

                if(success == 3){
                    System.out.println();
                    System.out.println(count+"번의 시도만에 정답을 맞췄습니다!");
                    System.out.println("게임을 다시 플레이하시려면 1, 아니라면 아무거나 입력해주세요");
                    String sel = sc.next();
                    if(sel.equals("1")){
                        exit = true;
                    }else{
                        System.out.println("게임을 종료합니다");
                        exit = false;
                    }
                }
            }
        }
    }
}

//문제 해결
//while문을 반복하니 값이 쌓이는 문제 1,2,3> 1,2,3,4,5,6 >> .clear()

//while문이 멈추지 않는 문제
//Collections.frequency(result, "스트라이크")!=3 을 넣었더니 당연히 인식하지 않음

//while문이 무한으로 도는 문제
//다른 whlie문으로 못들어가고 무한 반복함
//시작시 success를 0으로 설정

//input문제 >> list 에서 linkedHashSet으로 바꾸고 반복문 코드 재설정

//set 사용 이슈
//if문이 적용이 안됨 NoSuchElementException 발생
//iter.next()를 바로 사용하지 않고 int 값에 넣어서 반복

//고급문제
//숫자 수 늘리기
//맞추는 횟수 지정하기

//추가사항
//예외처리