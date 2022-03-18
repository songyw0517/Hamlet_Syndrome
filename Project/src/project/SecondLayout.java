package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.*;
public class SecondLayout extends JPanel {
	/*instance data*/
	private JButton Back, More, btnHome;//�ڷΰ���, �ѹ� ��, Ȩ���� ���� ����� �ϴ� ������ ��ư
	private ButtonListener btnListener;//��ư ������
	private JPanel primary, prePanel, iconPanel, menuPanel, firstPanel;
	/*primary : ���� ��� �г�
	 *prePanel : ���� �г�
	 *iconPanel : �޴� ������ ��� �г�
	 *menuPanel : �ڷΰ��� ��ư�� Ȩ ��ư�� ���� �г�
	 *firstPanel : Ȩ ��ư�� ������ ��� �̵��� �г�(firstLayout�� �г�)*/
	private Random rand;//���� ���� �ޱ� ���� ��ü
	private int k;//���� ���� ���� ����
	private JFrame firstLayout;//�޾ƿ� �������� �����ϱ� ���� ������
	private ImageIcon imgRestaurant;//�޴� �̹����� ������� ���� �̹���������
	private JLabel lblRestaurant;//�̹����� ���� ��
	private String[] restaurantName = {"images/menu/menu(1).png", "images/menu/menu(2).png", //�ҷ��� �̹��� ������ �̸��� �迭�� ����
			"images/menu/menu(3).png", "images/menu/menu(4).png", "images/menu/menu(5).png",
			"images/menu/menu(6).png","images/menu/menu(7).png","images/menu/menu(8).png"};
	public SecondLayout(JFrame firstLayout, JPanel prePanel) {//������
		setLayout(null);//���̾ƿ� �Ŵ��� ����
		this.firstLayout = firstLayout;//�޾ƿ� ���������� �ʱ�ȭ
		btnListener = new ButtonListener();//��ư ������ ����
		rand = new Random();//������ü ����
		k = rand.nextInt(8);//8���� �޴� �� �ϳ� ����
		System.out.println("rand = "+k);
		this.prePanel = prePanel;//���� �гη� ���ư� �� ���
		
		/*Back��ư ���� �� ��ġ �� ����*/
		Back = new JButton(new ImageIcon("images/Back.png"));//�ڷΰ��� ��ư, Back.png �̹����� ������
		Back.setBounds(5, 5	, 120, 70);//�ڷΰ��� ��ư�� ��ġ
		Back.setBorderPainted(false);//��ư�� �׵θ� ����
		Back.setContentAreaFilled(false);//��ư�� ���뿵���� ä��� ����
		Back.setFocusPainted(false);//��ư�� ����(focus)�Ǿ��� �� ����� �׵θ� ����
		Back.addActionListener(btnListener);//��ư�� ������ �߰�
		
		/*�ѹ��� ��ư ���� �� ��ġ �� ����*/
		More = new JButton(new ImageIcon("images/again(70by70).png"));//again(100by100).png �̹����� �޾ƿ�
		More.setBounds(420, 490, 70, 70);//��ư�� ��ġ ����
		More.addActionListener(btnListener);//��ư�� ������ �߰�
		More.setBorderPainted(false);//��ư�� �׵θ� ����
		More.setContentAreaFilled(false);//��ư�� ���뿵���� ä��� ����
		More.setFocusPainted(false);//��ư�� ����(focus)�Ǿ��� �� ����� �׵θ� ����
		
		/*Ȩ��ư ���� �� ��ġ �� ����*/
		btnHome = new JButton(new ImageIcon("images/home.png"));//home.png �̹����� �޾ƿ�
		btnHome.setBounds(380, 0, 120, 75);//��ư�� ��ġ ����
		btnHome.setBorderPainted(false);//��ư�� �׵θ� ����
		btnHome.setContentAreaFilled(false);//��ư�� ���뿵���� ä��� ����
		btnHome.setFocusPainted(false);//��ư�� ����(focus)�Ǿ��� �� ����� �׵θ� ����
		btnHome.addActionListener(btnListener);//��ư�� ������ �߰�
		
		/*�޴� �г� ���� �� ��ġ �� ����*/
		menuPanel = new JPanel();//�޴� �г� ����
		menuPanel.setLayout(null);//�޴� �г��� ���̾ƿ� �Ŵ��� ����
		menuPanel.setBounds(0, 0, 500, 75);//�г��� ��ġ ����(�� ��)
		menuPanel.setBackground(new Color(252, 235,235));//�޴��� ���� ����
		menuPanel.add(Back);//�޴� �гο� �ڷΰ��� ��ư �߰�
		menuPanel.add(btnHome);//�޴� �гο� Ȩ ��ư �߰�
		
		/*�޴� ������ ��ġ�� �г� ���� �� ��ġ �� ����*/
		iconPanel = new JPanel();//�� ����
		iconPanel.setBounds(22, 85, 400, 400);//���� ��ġ ����
		iconPanel.setBackground(new Color(221,247,255));//�̹��� �г��� ���� ����
		
		/*�ҷ��� �̹���, �� ���� �� ��ġ �� ����*/
		imgRestaurant = new ImageIcon(restaurantName[k]);//�̹��� �ҷ���
		lblRestaurant = new JLabel(imgRestaurant);//�޾ƿ� �̹����� �󺧿� �߰��ϸ鼭 �� ����
		lblRestaurant.setBounds(0, 0, 400, 400);//���� ��ġ ����
		iconPanel.add(lblRestaurant);//�гο� �� �߰�
		
		/*��ü �г� ���� �� ��ġ �� ����*/
		primary = new JPanel();//��ü �г� ����
		primary.setLayout(null);//�г��� ���̾ƿ� �Ŵ��� ����
		primary.setBackground(new Color(221,247,255));//�г��� ���� ����
		primary.add(More);//�гο� �ѹ��� ��ư �߰�
		primary.add(iconPanel);//�гο� iconPanel �߰�
		primary.add(menuPanel);//�гο� menuPanel �߰�
		
		/*�����ӿ� �߰�*/
		firstLayout.add(primary);
		firstLayout.pack();
		firstLayout.setVisible(true);
	}
	
	private class ButtonListener implements ActionListener{//��ư ������ Ŭ����
		@Override
		public void actionPerformed(ActionEvent e) {
			Object B = e.getSource();
			if(B==Back||B==btnHome)//�ڷΰ����ư �Ǵ� Ȩ ��ư�� ������ ù��° ���̾ƿ����� �̵�
			{
				primary.setVisible(false);//���� �г��� �Ⱥ��̰� ��
				prePanel.setVisible(true);//���� �г�(ù��° �г�)�� ���̰� ��
			}else if(B==More)
			{
				primary.setVisible(false);//���� �г��� �Ⱥ��̰� ��
				new SecondLayout(firstLayout, prePanel);//���ο� SecondLayout�� ����鼭, ������ ����, �̹��� ����
			}
		}
	}
}
