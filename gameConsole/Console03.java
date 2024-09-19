package gameConsole;

//Lv03

import GameUtil.Util03;

import java.util.Collections;
import java.util.Scanner;

public class Console03 {
    public static void main(String[] args) {
        Util03 util = new Util03();
        Scanner sc = new Scanner(System.in);

        while(util.isExit()){
            util.getChoice().clear();
            util.setSuccess(util.getResult());
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
                        util.setSaveLog(Integer.toString(count));
                        System.out.println("게임 재시작 : 1 | 게임 기록 확인 : 2 | 게임 종료 : 3");
                        sel = sc.next();
                        if(sel.equals("1")){
                            util.setExit(true);
                            break;
                        }else if(sel.equals("2")){
                            util.bringLog();
                            util.setExit(true);
                            System.out.println();
                            break;
                        }else if(sel.equals("3")){
                            System.out.println("게임을 종료합니다");
                            util.setExit(false);
                        }else {
                            System.out.println("잘못된 입력값입니다");
                            System.out.println();
                            util.setSuccess(util.getResult());
                            break;
                        }
                    }
                }
            }else if (sel.equals("2")){
                util.bringLog();
                System.out.println();
            }else if (sel.equals("3")){
                System.out.println("게임을 종료합니다");
                util.setExit(false);
            }else {
                System.out.println("잘못된 입력값입니다");
                System.out.println();
            }
        }
    }
}
