package project;
import javax.swing.*;


import java.awt.*;
public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame();//������ ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���������� �����ϱ� ���� �޼ҵ� ȣ��
		frame.setPreferredSize(new Dimension(500, 600));//������ ũ�� ����
		frame.setResizable(false);//������ ũ�� ����
		new FirstLayout(frame);//ù��° ���̾ƿ� ����, �������� ���ڷ� �־���(���� �����ӿ��� ������ �г��� ���� ����)
	}
}