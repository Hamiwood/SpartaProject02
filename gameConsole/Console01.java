package gameConsole;

//Lv01

import GameUtil.Util01;
import java.util.Collections;
import java.util.Scanner;

public class Console01 {
    public static void main(String[] args) {
        Util01 util = new Util01();
        Scanner sc = new Scanner(System.in);

        //입력
        while(util.isExit()){
            int count = 0;
            Collections.shuffle(util.getRandom());// 셔플

            //값 3개 가져오기 메서드
            util.pickThree();

            while(util.getSuccess() != 3){

                System.out.println("중복되지 않는 일의 자리 양의 정수 3개를 입력해주십시오.");
                System.out.println("[예시 : 3 5 7]");
                System.out.println();

                util.inputNumber();

                util.playGame();

                count++;

                if(util.getSuccess() == 3){
                    System.out.println();
                    System.out.println(count+"번의 시도만에 정답을 맞췄습니다!");
                    System.out.println("게임을 다시 플레이하시려면 1, 아니라면 아무거나 입력해주세요");
                    String sel = sc.next();
                    if(sel.equals("1")){
                        util.setSuccess(util.getResult());
                        util.getChoice().clear();
                        util.setExit(true);
                        break;
                    }else{
                        System.out.println("게임을 종료합니다");
                        util.setExit(false);
                    }
                }
            }
        }
    }
}
