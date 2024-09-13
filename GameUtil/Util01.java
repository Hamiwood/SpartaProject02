package GameUtil;

//Lv01

import java.util.*;
import java.util.regex.Pattern;

public class Util01 {
    Scanner sc = new Scanner(System.in);

    public Integer[] nums = {1,2,3,4,5,6,7,8,9};
    private List<Integer> random = Arrays.asList(nums);//셔플이 가능하도록 List로 변경
    private List<Integer> choice = new ArrayList<>();//셔플한 리스트 중 3개의 값을 받아옴

    private Set<Integer> inputNum = new LinkedHashSet<>();//입력 값 >> 중복되지 않도록

    private final String NUMBER_REG = "^[1-9]$";//정규표현식(1-9)

    private List<String> result = new ArrayList<>();//결과
    private int success = 0; // 스트라이크가 몇 개인지 확인

    private boolean exit =  true; // 반복문

    //getter setter
    public List<Integer> getRandom() {
        return random;
    }
    public List<String> getResult() {
        return result;
    }
    public void setExit(boolean exit) {
        this.exit = exit;
    }
    public boolean isExit() {
        return exit;
    }
    public List<Integer> getChoice() {
        return choice;
    }
    public int getSuccess() {
        return success;
    }
    public void setSuccess(List<String> result) {
        this.success = Collections.frequency(result, "스트라이크");
    }

    //랜덤한 3개를 골라오는 메서드
    public void pickThree(){
        for (int i = 0; i < 3; i++) {
            choice.add(random.get(i));
        }
    }

    //입력값 3개를 저장하는 메서드
    public void inputNumber(){
        while(inputNum.size() != 3){

            System.out.println((inputNum.size()+1)+"번째 번호를 입력하십시오");
            String num = sc.next();
            if(Pattern.matches(NUMBER_REG, num)){
                inputNum.add(Integer.parseInt(num));
            }else{
                System.out.println("경고!) 잘못된 입력값 입니다");
                System.out.println("0을 제외한 일의 자리, 양의 정수만 입력하실 수 있습니다.");
                System.out.println();
            }

        }
    }

    //게임을 진행하는 메서드
    public void playGame(){
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
        setSuccess(result);
        System.out.println(Collections.frequency(result, "스트라이크")+"스트라이크 "+Collections.frequency(result, "볼")+"볼 "+Collections.frequency(result, "아웃")+"아웃");
        System.out.println();

        inputNum.clear();
        result.clear();
    }

}


//메서드화 시키는 과정에서 clear가 안되는 경우
//정확히는 choice의 클리어가 되지 않았던 것임
//1번을 누르면 choice가 clear되도록

//success가 갱신되지 않는 경우
// private int success = Collections.frequency(result, "스트라이크");
// private int success = 0;
// setSuccess를 바꿈

//두번째 시도부터 result가 비어버리는 경우
//첫번째 while문으로 돌아가지 않아 choice에 값이 담기지 않았다.
//break로 두번째 while문을 벗어나게 함