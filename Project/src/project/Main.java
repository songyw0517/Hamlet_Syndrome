package project;
import javax.swing.*;


import java.awt.*;
public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame();//프레임 생성
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//안정적으로 종료하기 위한 메소드 호출
		frame.setPreferredSize(new Dimension(500, 600));//프레임 크기 설정
		frame.setResizable(false);//프레임 크기 고정
		new FirstLayout(frame);//첫번째 레이아웃 생성, 프레임을 인자로 넣어줌(같은 프레임에서 각각의 패널을 띄우기 위함)
	}
}