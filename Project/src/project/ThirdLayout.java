package project;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class ThirdLayout extends JPanel {
	//instance data
	private JButton Korea_Menu, Japan_Menu, China_Menu, USA_Menu;//���� �޴�(��,��,��,��)�� ���ϴ� ��ư
	private JButton Back, btnHome;//�ڷΰ���, Ȩ ��ư
	private ButtonListener btnListener;//��ư�� ������ �� �̺�Ʈ ó���� ������
	private JPanel primary, prePanel, menuPanel, firstPanel;
	/*primary : ���� ��� �г�
	 *prePanel : ���� �г�
	 *menuPanel : �ڷΰ��� ��ư�� Ȩ ��ư�� ���� �г�
	 *firstPanel : Ȩ ��ư�� ������ ��� �̵��� �г�(firstLayout�� �г�)*/
	private JFrame thirdLayout;//�޾ƿ� �������� �����ϱ� ���� ������
	public ThirdLayout(JFrame firstLayout, JPanel prePanel, JPanel firstPanel) {
		this.prePanel = prePanel;//���� �гη� ���ư� �� ���
		this.thirdLayout = firstLayout;//�޾ƿ� ���������� �ʱ�ȭ
		this.firstPanel = firstPanel;//Ȩ ��ư�� ������ �� ���ư� �г�
		btnListener = new ButtonListener();//��ư������ ����
		
		/*�ѽ�, �Ͻ�, �߽�, ��� ��ư�� ��ġ �� ����*/
		Korea_Menu = new JButton(new ImageIcon("images/�ѽ�.png"));//�ѽ�.png �̹����� �޾ƿ�
		Korea_Menu.setBounds(25, 100, 215, 200);//��ư�� ��ġ ����
		Korea_Menu.addActionListener(btnListener);//��ư�� ������ �߰�
		Korea_Menu.setBorderPainted(false);//��ư�� �׵θ� ����
		Korea_Menu.setContentAreaFilled(false);//��ư�� ���뿵���� ä��� ����
		Korea_Menu.setFocusPainted(false);//��ư�� ����(focus)�Ǿ��� �� ����� �׵θ� ����
		
		Japan_Menu = new JButton(new ImageIcon("images/�Ͻ�.png"));//�Ͻ�.png �̹����� �޾ƿ�
		Japan_Menu.setBounds(260, 100, 215, 200);//��ư�� ��ġ ����
		Japan_Menu.addActionListener(btnListener);//��ư�� ������ �߰�
		Japan_Menu.setBorderPainted(false);//��ư�� �׵θ� ����
		Japan_Menu.setContentAreaFilled(false);//��ư�� ���뿵���� ä��� ����
		Japan_Menu.setFocusPainted(false);//��ư�� ����(focus)�Ǿ��� �� ����� �׵θ� ����
		
		China_Menu = new JButton(new ImageIcon("images/�߽�.png"));//�߽�.png �̹����� �޾ƿ�
		China_Menu.setBounds(25, 330, 215, 200);//��ư�� ��ġ ����
		China_Menu.addActionListener(btnListener);//��ư�� ������ �߰�
		China_Menu.setBorderPainted(false);//��ư�� �׵θ� ����
		China_Menu.setContentAreaFilled(false);//��ư�� ���뿵���� ä��� ����
		China_Menu.setFocusPainted(false);//��ư�� ����(focus)�Ǿ��� �� ����� �׵θ� ����
		
		USA_Menu = new JButton(new ImageIcon("images/���.png"));//���.png �̹����� �޾ƿ�
		USA_Menu.setBounds(260, 330, 215, 200);//��ư�� ��ġ ����
		USA_Menu.addActionListener(btnListener);//��ư�� ������ �߰�
		USA_Menu.setBorderPainted(false);//��ư�� �׵θ� ����
		USA_Menu.setContentAreaFilled(false);//��ư�� ���뿵���� ä��� ����
		USA_Menu.setFocusPainted(false);//��ư�� ����(focus)�Ǿ��� �� ����� �׵θ� ����
		
		//�ڷΰ��� ��ư ���� �� ��ġ �� ����
		Back = new JButton(new ImageIcon("images/Back.png"));//Back.png �̹����� �޾ƿ�
		Back.setBounds(5, 5	, 120, 70);//�ڷΰ��� ��ư�� ��ġ ����
		Back.setBorderPainted(false);//��ư�� �׵θ� ����
		Back.setContentAreaFilled(false);//��ư�� ���뿵���� ä��� ����
		Back.setFocusPainted(false);//��ư�� ����(focus)�Ǿ��� �� ����� �׵θ� ����
		Back.addActionListener(btnListener);//��ư�� ������ �߰�
		
		//Ȩ ��ư ���� �� ��ġ �� ����
		btnHome = new JButton(new ImageIcon("images/home.png"));//home.png �̹����� �޾ƿ�
		btnHome.setBounds(380, 0, 120, 75);//Ȩ ��ư�� ��ġ ����
		btnHome.setBorderPainted(false);//��ư�� �׵θ� ����
		btnHome.setContentAreaFilled(false);//��ư�� ���뿵���� ä��� ����
		btnHome.setFocusPainted(false);//��ư�� ����(focus)�Ǿ��� �� ����� �׵θ� ����
		btnHome.addActionListener(btnListener);//��ư�� ������ �߰�
		
		//�޴� �гλ��� �� ��ġ �� ����
		menuPanel = new JPanel();//�޴� �г� ����
		menuPanel.setLayout(null);//�޴� �г��� ���̾ƿ� �Ŵ��� ����
		menuPanel.setBounds(0, 0, 500, 75);//�޴� �г��� ��ġ ����
		menuPanel.setBackground(new Color(252, 235,235));//�޴� �г��� ���� ����
		menuPanel.add(Back);//�޴� �гο� �ڷΰ��� ��ư �߰�
		menuPanel.add(btnHome);//�޴� �гο� Ȩ ��ư �߰�

		/*��ü �г� ���� �� ��ġ �� ����*/
		primary = new JPanel();//��ü �г� ����
		primary.setBackground(new Color(221,247,255));//��ü �г��� ���� ����
		primary.setLayout(null);//��ü �г��� ���̾ƿ� �Ŵ��� ����
		primary.add(menuPanel);//��ü �гο� �޴� �г� �߰�
		/*��ü �гο� ������ ��ư�� �߰�*/
		primary.add(Korea_Menu);
		primary.add(Japan_Menu);
		primary.add(China_Menu);
		primary.add(USA_Menu);
		
		/*�����ӿ� �߰�*/
		firstLayout.add(primary);
		firstLayout.pack();
		firstLayout.setVisible(true);
		
	}
	private class ButtonListener implements ActionListener{//��ư ������ Ŭ����

		public void actionPerformed(ActionEvent e) {
			Object B = e.getSource();
			if(B==Korea_Menu)//�ѽ� ��ư�� ������ ��
			{
				primary.setVisible(false);//���� �г��� �Ⱥ��̰� ��
				new FifthLayout_Korea(thirdLayout, primary, firstPanel);//�ѽ� �г� ���� �� ���̰���
			}
			else if(B==Japan_Menu)//�Ͻ� ��ư�� ������ ��
			{
				primary.setVisible(false);//���� �г��� �Ⱥ��̰� ��
				new FifthLayout_Japan(thirdLayout, primary, firstPanel);//�Ͻ� �г� ���� �� ���̰���
			}
			else if(B==China_Menu) {//�߽� ��ư�� ������ ��
				primary.setVisible(false);//���� �г��� �Ⱥ��̰� ��
				new FifthLayout_China(thirdLayout, primary, firstPanel);//�߽� �г� ���� �� ���̰���
			}
			else if(B==USA_Menu) {//��� ��ư�� ������ ��
				primary.setVisible(false);//���� �г��� �Ⱥ��̰� ��
				new FifthLayout_USA(thirdLayout, primary, firstPanel);//��� �г� ���� �� ���̰���
			}
			else if(B==Back)//�ڷΰ��� ��ư�� ������ ��
			{
				primary.setVisible(false);//���� �г��� �Ⱥ��̰� ��
				prePanel.setVisible(true);//���� �г��� ���̰���
			}
			else if(B==btnHome) {
				primary.setVisible(false);//���� �г��� �Ⱥ��̰� ��
				firstPanel.setVisible(true);//ù��° �г��� ���̰���
			}
		}
	}
}
