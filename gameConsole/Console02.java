package gameConsole;

//Lv02

import java.util.Collections;
import java.util.Scanner;
import GameUtil.Util02;

public class Console02 {
    public static void main(String[] args) {
        Util02 util = new Util02();
        Scanner sc = new Scanner(System.in);

        //입력
        while(util.isExit()){
            String sel = "";
            int count = 0;
            Collections.shuffle(util.getRandom());// 셔플
            util.pickThree();

            System.out.println("새로운 게임을 시작합니다!");
            System.out.println("게임 시작 : 1 | 게임 기록 확인 : 2 | 게임 종료 : 3");
            sel = sc.next();

            if(sel.equals("1")){
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
                        System.out.println("게임 재시작 : 1 | 게임 기록 확인 : 2 | 게임 종료 : 3");
                        sel = sc.next();
                        if(sel.equals("1")){
                            util.setSuccess(util.getResult());
                            util.getChoice().clear();
                            util.setExit(true);
                            break;
                        }else if(sel.equals("2")){
                            //게임 기록 확인
                            util.setSuccess(util.getResult());
                            util.getChoice().clear();
                            util.setExit(true);
                            System.out.println("현재의 과정에서는 사용할 수 없는 기능입니다");
                            System.out.println();
                            break;
                        }else if(sel.equals("3")){
                            System.out.println("게임을 종료합니다");
                            util.setExit(false);
                        }
                    }
                }
            }else if (sel.equals("2")){
                System.out.println("현재의 과정에서는 사용할 수 없는 기능입니다");
                util.getChoice().clear();
            }else if (sel.equals("3")){
                System.out.println("게임을 종료합니다");
                util.setExit(false);
            }
        }
    }
}
//게임에서 빠져나가지 못하는 문제 >> break후, sel값 초기화
//입력 조건 절에서 Integer.parseInt의 조건이 앞에 와 NumberFormatException이 뜨는 현상
//>>컬렉션과 배열을 모두 String으로 수정함
//sel2 에서 NosuchElementException발생
//>>choice 초기화를 안해서 값이 더해져 들어간 것이엇음