package GameUtil;

//Lv02

import java.util.*;
import java.util.regex.Pattern;

public class Util02 {
    Scanner sc = new Scanner(System.in);

    public String[] nums = {"1","2","3","4","5","6","7","8","9"};
    private List<String> random = Arrays.asList(nums);//셔플이 가능하도록 List로 변경
    private List<String> choice = new ArrayList<>();//셔플한 리스트 중 3개의 값을 받아옴

    private Set<String> inputNum = new LinkedHashSet<>();//입력 값 >> 중복되지 않도록

    private final String NUMBER_REG = "^[1-9]$";//정규표현식(1-9)

    private List<String> result = new ArrayList<>();//결과
    private int success = 0; // 스트라이크가 몇 개인지 확인

    private boolean exit =  true; // 반복문

    //getter setter
    public List<String> getRandom() {
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
    public List<String> getChoice() {
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

            if(inputNum.contains(num)){
                System.out.println("경고!) 이미 입력된 숫자입니다");
                System.out.println();
            }else if(num.equals("0")){
                System.out.println("경고!) 0은 입력할 수 없습니다");
                System.out.println();
            }else if(num.length() > 1){
                System.out.println("경고!) 일의 자리의 정수만 입력하실 수 있습니다");
                System.out.println();
            }else if(!Pattern.matches(NUMBER_REG, num)){
                System.out.println("경고!) 문자는 입력하실 수 없습니다");
                System.out.println();
            }else{
                inputNum.add(num);
            }


        }
    }

    //게임을 진행하는 메서드
    public void playGame(){
        Iterator<String> iter = inputNum.iterator();
        for(int i = 0; i < choice.size(); i++){
            String s = iter.next();
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
