package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FifthLayout_China extends JPanel {
	//instance data
	private JButton Rice, Noodle, Etc;//���θ޴�(��, ��, ��Ÿ)�� ���ϴ� ��ư
	private JButton back, btnHome;//�ڷΰ��� ��ư, Ȩ ��ư
	private JPanel primary, prePanel, menuPanel, SpacePanel, firstPanel;
	/*primary : ���� ��� �г�
	 *prePanel : ���� �г�
	 *menuPanel : �ڷΰ��� ��ư�� Ȩ ��ư�� ���� �г�
	 *propessorPanel : ������ ������ ���� �г�
	 *firstPanel : Ȩ ��ư�� ������ ��� �̵��� �г�(firstLayout�� �г�)*/
	private JLabel lblSpace;//������ �����ִ� �̹����� �޴� ��
	private JLabel propessor;//������ ������ �޾ƿ��� ��
	private ImageIcon imgIcon;//������ ������ �޴� �̹��� ������
	private ButtonListener btnListener;//��ư�� ������ �� �̺�Ʈ ó���� ������
	private JFrame fifthLayout;//�޾ƿ� �������� �����ϱ� ���� ������
	public FifthLayout_China(JFrame thirdLayout, JPanel prePanel, JPanel firstPanel) {//������
		this.firstPanel = firstPanel;//Ȩ ��ư�� ������ �� ���ư� �г�
		fifthLayout = thirdLayout;//�޾ƿ� ���������� �ʱ�ȭ
		this.prePanel = prePanel;//���� �гη� ���ư� �� ���
		btnListener = new ButtonListener();//��ư������ ����
		/*��, ��, ��Ÿ ��ư ��ġ ��  ����*/
		Rice = new JButton(new ImageIcon("images/��.png"));//��.png �̹����� �޾ƿ�
		Rice.setBounds(17, 240, 133, 187);//��ư�� ��ġ ����
		Rice.addActionListener(btnListener);//��ư�� ������ �߰�
		Rice.setBorderPainted(false);//��ư�� �׵θ� ����
		Rice.setContentAreaFilled(false);//��ư�� ���뿵���� ä��� ����
		Rice.setFocusPainted(false);//��ư�� ����(focus)�Ǿ��� �� ����� �׵θ� ����
		
		Noodle = new JButton(new ImageIcon("images/��.png"));//��.png �̹����� �޾ƿ�
		Noodle.setBounds(195, 240, 133, 187);//��ư�� ��ġ ����
		Noodle.addActionListener(btnListener);//��ư�� ������ �߰�
		Noodle.setBorderPainted(false);//��ư�� �׵θ� ����
		Noodle.setContentAreaFilled(false);//��ư�� ���뿵���� ä��� ����
		Noodle.setFocusPainted(false);//��ư�� ����(focus)�Ǿ��� �� ����� �׵θ� ����
		
		Etc = new JButton(new ImageIcon("images/��Ÿ.png"));//��Ÿ.png �̹����� �޾ƿ�
		Etc.setBounds(360, 240, 133, 187);//��ư�� ��ġ ����
		Etc.addActionListener(btnListener);//��ư�� ������ �߰�
		Etc.setBorderPainted(false);//��ư�� �׵θ� ����
		Etc.setContentAreaFilled(false);//��ư�� ���뿵���� ä��� ����
		Etc.setFocusPainted(false);//��ư�� ����(focus)�Ǿ��� �� ����� �׵θ� ����
		
		//�ڷΰ��� ��ư ���� �� ��ġ �� ����
		back = new JButton(new ImageIcon("images/Back.png"));//Back.png �̹����� �޾ƿ�
		back.setBounds(5, 5	, 120, 70);//�ڷΰ��� ��ư�� ��ġ ����
		back.setBorderPainted(false);//��ư�� �׵θ� ����
		back.setContentAreaFilled(false);//��ư�� ���뿵���� ä��� ����
		back.setFocusPainted(false);//��ư�� ����(focus)�Ǿ��� �� ����� �׵θ� ����
		back.addActionListener(btnListener);//��ư�� ������ �߰�
		
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
		menuPanel.add(back);//�޴� �гο� �ڷΰ��� ��ư �߰�
		menuPanel.add(btnHome);//�޴� �гο� Ȩ ��ư �߰�
		
		//������ ������ �����ִ� ��
		propessor = new JLabel(new ImageIcon("images/������.png"));//������.png �̹����� �޾ƿ�, �� ����
		propessor.setBounds(0, 82, 500, 130);//���� ��ġ ����
		
		//������ �����ִ� �̹��� ����
		imgIcon = new ImageIcon("images/iconPanel.png");//iconPanel.png �̹����� �޾ƿ�, �̹��� ������ ����
		lblSpace = new JLabel(imgIcon);//imgIcon�� ���ڷ� ���� �� ����
		lblSpace.setBounds(0, 0, 500, 240);//���� ��ġ ����
		
		//������ �����ִ� �̹����� �޾ƿ��� �г�
		SpacePanel = new JPanel();//�г� ����
		SpacePanel.setLayout(null);//���̾ƿ� �Ŵ��� ����
		SpacePanel.setBounds(0, 220, 499, 240);//�г��� ��ġ ����
		SpacePanel.add(lblSpace);//lblSpace �� �߰�
		
		//��ü �гο� ����
		primary = new JPanel();//��ü �г� ����
		primary.setLayout(null);//��ü �г��� ���̾ƿ� �Ŵ��� ����
		primary.setBackground(new Color(221,247,255));//��ü �г��� ���� ����
		//������ �г� �� ��ư �߰�
		primary.add(propessor);
		primary.add(Rice);
		primary.add(Noodle);
		primary.add(Etc);
		primary.add(menuPanel);
		primary.add(SpacePanel);
		
		//�����ӿ� ����
		thirdLayout.add(primary);
		thirdLayout.pack();
		thirdLayout.setVisible(true);
	}
	
	
	private class ButtonListener implements ActionListener{//��ư ������ Ŭ����
		public void actionPerformed(ActionEvent e) {
			Object B = e.getSource();
			if(B==Rice) {//���� ������ ���
				primary.setVisible(false);
				new SixthLayout_China(fifthLayout, primary, 1, firstPanel);
			}else if(B==Noodle) {//���� ������ ���
				primary.setVisible(false);
				new SixthLayout_China(fifthLayout, primary, 2, firstPanel);
			}else if(B==Etc) {//��Ÿ�� ������ ���
				primary.setVisible(false);
				new SixthLayout_China(fifthLayout, primary, 3, firstPanel);
			}else if(B==back) {//�ڷΰ��� ��ư�� ������ ���
				primary.setVisible(false);
				prePanel.setVisible(true);
			}else if(B==btnHome) {//Ȩ��ư�� ������ ���
				primary.setVisible(false);
				firstPanel.setVisible(true);
			}
		}
	}
	
}
