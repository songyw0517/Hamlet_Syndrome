package project;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FirstLayout extends JPanel{
	//instanceData
	private JButton btnRandomMenu;//�����޴� ���̾ƿ����� �̵��ϴ� ��ư
	private JButton btnChooseMenu;//���ø޴� ���̾ƿ����� �̵��ϴ� ��ư
	private JButton btnRandomCal;//������ ���̾ƿ����� �̵��ϴ� ��ư
	private primary primary;//ù��° ���̾ƿ��� ��ü �г�
	private JFrame firstLayout;//������ �гο� �ѱ� �������� �ޱ� ����
	private ButtonListener ButtonListener_1;//��ư�� ������ �� �̺�Ʈ ó���� ������
	ImageIcon i = new ImageIcon("images/FirstLayout.png");//ù��° ���̾ƿ��� ����� ������
	Image im = i.getImage();//Ŭ�������� ����� Image����
	public FirstLayout(JFrame frame)//������ ������
	{
		firstLayout= frame;//�ѱ� �������� ����
		ButtonListener_1 = new ButtonListener();//��ư������ ����
		/*������ư ���� �� ��ġ �� ����*/
		btnRandomMenu = new JButton(new ImageIcon("images/�귿.png"));//�귿.png �̹����� �޾ƿ�
		btnRandomMenu.setBounds(70, 85, 96, 122);//��ư�� ��ġ ����
		btnRandomMenu.addActionListener(ButtonListener_1);//��ư�� ������ �߰�
		btnRandomMenu.setBorderPainted(false);//��ư�� �׵θ� ����
		btnRandomMenu.setContentAreaFilled(false);//��ư�� ���뿵���� ä��� ����
		btnRandomMenu.setFocusPainted(false);//��ư�� ����(focus)�Ǿ��� �� ����� �׵θ� ����
		
		/*���ù�ư ���� �� ��ġ �� ����*/
		btnChooseMenu = new JButton(new ImageIcon("images/����.png"));//����.png �̹����� �޾ƿ�
		btnChooseMenu.setBounds(300, 260, 96, 122);//��ư�� ��ġ ����
		btnChooseMenu.addActionListener(ButtonListener_1);//��ư�� ������ �߰�
		btnChooseMenu.setBorderPainted(false);//��ư�� �׵θ� ����
		btnChooseMenu.setContentAreaFilled(false);//��ư�� ���뿵���� ä��� ����
		btnChooseMenu.setFocusPainted(false);//��ư�� ����(focus)�Ǿ��� �� ����� �׵θ� ����
		
		/*������ ��ư ���� �� ��ġ �� ����*/
		btnRandomCal = new JButton(new ImageIcon("images/����.png"));//����.png �̹����� �޾ƿ�
		btnRandomCal.setBounds(70, 430, 96, 122);//��ư�� ��ġ ����
		btnRandomCal.addActionListener(ButtonListener_1);//��ư�� ������ �߰�
		btnRandomCal.setBorderPainted(false);//��ư�� �׵θ� ����
		btnRandomCal.setContentAreaFilled(false);//��ư�� ���뿵���� ä��� ����
		btnRandomCal.setFocusPainted(false);//��ư�� ����(focus)�Ǿ��� �� ����� �׵θ� ����
		
		/*��ü �г� ���� �� ����(�߰�)*/
		primary = new primary();//��ü �г� ����
		primary.setLayout(null);//���̾ƿ� �Ŵ��� ����
		primary.add(btnRandomMenu);//������ư �߰�
		primary.add(btnChooseMenu);//���ù�ư �߰�
		primary.add(btnRandomCal);//������ ��ư �߰�
		
		/*�����ӿ� �߰�*/
		frame.getContentPane().add(primary);
		frame.pack();
		frame.setVisible(true);
	}
	private class primary extends JPanel{//ù��° ���̾ƿ��� ����� ����ϴ� Ŭ����
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(im, 0, 0, getWidth(),getHeight(), this);//������ �׸��� �׸��� �κ�
		}
	}
	private class ButtonListener implements ActionListener{//��ư ������ Ŭ����
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			Object B = e.getSource();
			if(B==btnRandomMenu) {//���� ���̾ƿ����� �Ѿ
				primary.setVisible(false);//���� �г��� �Ⱥ��̰�  ��
				new SecondLayout(firstLayout, primary);//���� ���̾ƿ����� �̵�(�������� ���ڷ� �־� �̵�) �� �����ֱ�
			}
			else if(B==btnChooseMenu) {//���� ���̾ƿ����� �Ѿ
				primary.setVisible(false);//���� �г��� �Ⱥ��̰���
				new ThirdLayout(firstLayout, primary, primary);//���� ���̾ƿ����� �̵� �� �����ֱ�
			}else if(B==btnRandomCal) {//������ ���̾ƿ����� �Ѿ
				primary.setVisible(false);//���� �г��� �Ⱥ��̰� ��
				new FourthLayout(firstLayout, primary);//������ ���̾ƿ����� �̵� �� �����ֱ�
			}
		}	
	}
	
}
