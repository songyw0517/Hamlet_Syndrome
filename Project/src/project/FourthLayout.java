package project;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FourthLayout extends JPanel {
	// instance data
	private JButton Back, Draw, btnInc, btnDec, btnCntCheck, btnNameCheck, btnHome;
	/*
	 * Back : �ڷΰ��� ��ư Draw : ������ ����� �̸��� ���� ��ư(���� �̱� ��ư) btnInc : �ο� ���� ���� ��Ű�� ��ư
	 * btnDec : �ο� ���� ���� ��Ű�� ��ư btnCntCheck : �ο����� ����(Ȯ��)�ϴ� ��ư\ btnNameCheck : �����
	 * �̸��� �޴� ��ư btnHome : Ȩ ��ư
	 */
	private JPanel primary, prePanel, menuPanel;
	/*
	 * primary : ���� ��� �г� prePanel : ���� �г� menuPanel : �ڷΰ��� ��ư�� Ȩ ��ư�� ���� �г�
	 * namePanel :
	 */
	private TextField strName;// �̸��� �Է��ϴ� TextField
	private ButtonListener btnListener;// ��ư�� ������ �� �̺�Ʈ ó���� ������
	private int Num, cnt;// Num : ����ڰ� �Է��� �ο���, cnt : �̸��� ��� �ް� �ϱ� ���� ����
	private ArrayList<String> nameList;// ����ڰ� �Է��� �̸��� �޴� ArrayList
	private Random rand;// �������� ����� �̸��� �̱� ���� ���� Ŭ����
	private JLabel pickName, lblNum, lblName, lblCount, lblk;
	/**/
	private firePanel firePanel;
	private File clap;
	ImageIcon i = new ImageIcon("images/�Ҳ�.gif");// ù��° ���̾ƿ��� ����� ������
	Image im = i.getImage();

	public FourthLayout(JFrame firstLayout, JPanel prePanel) {// ������
		setLayout(null);// ���̾ƿ� �Ŵ��� ����
		Num = cnt = 0;// �ο��� �� �ݺ����� ������ ���� cnt ���� 0���� �ʱ�ȭ
		btnListener = new ButtonListener();// ��ư ������ ����
		rand = new Random();// ���� ��ü ����
		this.prePanel = prePanel;

		// �ڷΰ��� ��ư ���� �� ��ġ �� ����
		Back = new JButton(new ImageIcon("images/Back.png"));// Back.png �̹����� �޾ƿ�
		Back.setBounds(5, 5, 120, 70);// �ڷΰ��� ��ư�� ��ġ ����
		Back.setBorderPainted(false);// ��ư�� �׵θ� ����
		Back.setContentAreaFilled(false);// ��ư�� ���뿵���� ä��� ����
		Back.setFocusPainted(false);// ��ư�� ����(focus)�Ǿ��� �� ����� �׵θ� ����
		Back.addActionListener(btnListener);// ��ư�� ������ �߰�

		/* �ο��� �����ϴ� �κ� */
		lblNum = new JLabel(new ImageIcon("images/�ο���.png"));// "�ο���"�� �����ִ� ��
		lblNum.setBounds(60, 140, 100, 40);

		btnInc = new JButton(new ImageIcon("images/up.png"));// �ο����� ������Ű�� ��ư ����
		btnInc.setBounds(250, 140, 30, 40);// ��ư ��ġ ����
		btnInc.addActionListener(btnListener);// ��ư�� ������ �߰�
		btnInc.setBorderPainted(false);// ��ư�� �׵θ� ����
		btnInc.setContentAreaFilled(false);// ��ư�� ���뿵���� ä��� ����
		btnInc.setFocusPainted(false);// ��ư�� ����(focus)�Ǿ��� �� ����� �׵θ� ����

		lblCount = new JLabel("" + Num);// ���� �ο����� �����ִ� �󺧻���
		lblCount.setBounds(220, 140, 50, 40);// ���� ��ġ ����
		lblCount.setFont(new Font("Adobe ��� Std", Font.PLAIN, 30));// ���� ��Ʈ ����

		btnDec = new JButton(new ImageIcon("images/down.png"));// �ο����� ���ҽ�Ű�� ��ư ����
		btnDec.setBounds(180, 140, 30, 40);// ��ư�� ��ġ ����
		btnDec.addActionListener(btnListener);// ��ư�� ������ �߰�
		btnDec.setBorderPainted(false);// ��ư�� �׵θ� ����
		btnDec.setContentAreaFilled(false);// ��ư�� ���뿵���� ä��� ����
		btnDec.setFocusPainted(false);// ��ư�� ����(focus)�Ǿ��� �� ����� �׵θ� ����

		lblk = new JLabel("��");// "��"�� ǥ���ϴ� ��
		lblk.setBounds(295, 140, 30, 40);// ���� ��ġ ����
		lblk.setFont(new Font("Adobe ��� Std", Font.PLAIN, 30));// ���� ��Ʈ ����

		/* �ο����� Ȯ���ϴ� ��ư ���� �� ��ġ �� ���� */
		btnCntCheck = new JButton(new ImageIcon("images/Ȯ��.png"));// �ο����� ����(Ȯ��)�ϴ� ��ư ����
		btnCntCheck.setBounds(350, 135, 70, 50);// ��ư�� ��ġ ����
		btnCntCheck.addActionListener(btnListener);// ��ư�� ������ �߰�
		btnCntCheck.setBorderPainted(false);// ��ư�� �׵θ� ����
		btnCntCheck.setContentAreaFilled(false);// ��ư�� ���뿵���� ä��� ����
		btnCntCheck.setFocusPainted(false);// ��ư�� ����(focus)�Ǿ��� �� ����� �׵θ� ����

		/* �̸��� �Է��ϴ� �κ� */
		lblName = new JLabel(new ImageIcon("images/�̸�.png"));// �̸�.png �̹����� �޾ƿ�
		lblName.setBounds(60, 200, 100, 40);// ���� ��ġ ����

		strName = new TextField();// �̸��� �Է��ϴ� ���� ����
		strName.setBounds(180, 200, 150, 40);// textField�� ��ġ ����
		strName.setFont(new Font("Verdana", Font.BOLD, 30));// ��Ʈ ����
		strName.addActionListener(btnListener);// ������ �߰�
		strName.setEnabled(false);// ��� �Ұ����ϰ� ����

		btnNameCheck = new JButton(new ImageIcon("images/Ȯ��.png"));// �̸��� Ȯ���ϴ� ��ư ����
		btnNameCheck.setBounds(350, 195, 70, 50);// ��ư�� ��ġ ����
		btnNameCheck.addActionListener(btnListener);// ��ư�� ������ �߰�
		btnNameCheck.setEnabled(false);// ��ư ���Ұ����ϰ� ����
		btnNameCheck.setBorderPainted(false);// ��ư�� �׵θ� ����
		btnNameCheck.setContentAreaFilled(false);// ��ư�� ���뿵���� ä��� ����
		btnNameCheck.setFocusPainted(false);// ��ư�� ����(focus)�Ǿ��� �� ����� �׵θ� ����

		/* ����ڰ� �Է��� �̸� �� �ϳ��� �̴� ��ư */
		Draw = new JButton(new ImageIcon("images/�̱�.png"));// �̱�.png �̹����� �޾ƿ�
		Draw.setBounds(205, 270, 100, 100);// ��ư�� ��ġ����
		Draw.addActionListener(btnListener);// ��ư�� ������ �߰�
		Draw.setBorderPainted(false);// ��ư�� �׵θ� ����
		Draw.setContentAreaFilled(false);// ��ư�� ���뿵���� ä��� ����
		Draw.setFocusPainted(false);// ��ư�� ����(focus)�Ǿ��� �� ����� �׵θ� ����
		Draw.setEnabled(false);// ��ư ���Ұ����ϰ� ����

		nameList = new ArrayList<String>();// �̸��� �����ϴ� ArrayList

		/* ��÷�� ����� �̸��� ���� �κ� */
		pickName = new JLabel();// ��÷�� ����� �̸��� �����ִ� �� ����
		pickName.setBounds(0, 10, 500, 150);// ���� ��ġ����
		pickName.setForeground(Color.white);// ���� ���� ����
		pickName.setHorizontalAlignment(SwingConstants.CENTER);// ����
		pickName.setFont(new Font("Verdana", Font.BOLD, 50));// ���� ��Ʈ ����

		firePanel = new firePanel();// �Ҳ� gif�� �����ִ� �г�
		firePanel.setLayout(null);// ���̾ƿ� �Ŵ��� ����
		firePanel.setBounds(0, 375, 500, 225);// �г��� ��ġ ����
		firePanel.add(pickName);// �� ���� ��÷�� ����� �̸��� �����ֱ� ���� �� �߰�
		firePanel.setVisible(false);// �г��� �Ⱥ��̰� ����

		/// Ȩ ��ư ���� �� ��ġ �� ����
		btnHome = new JButton(new ImageIcon("images/home.png"));// home.png �̹����� �޾ƿ�
		btnHome.setBounds(380, 0, 120, 75);// Ȩ ��ư�� ��ġ ����
		btnHome.setBorderPainted(false);// ��ư�� �׵θ� ����
		btnHome.setContentAreaFilled(false);// ��ư�� ���뿵���� ä��� ����
		btnHome.setFocusPainted(false);// ��ư�� ����(focus)�Ǿ��� �� ����� �׵θ� ����
		btnHome.addActionListener(btnListener);// ��ư�� ������ �߰�

		// �޴� �гλ��� �� ��ġ �� ����
		menuPanel = new JPanel();// �޴� �г� ����
		menuPanel.setLayout(null);// �޴� �г��� ���̾ƿ� �Ŵ��� ����
		menuPanel.setBounds(0, 0, 500, 75);// �޴� �г��� ��ġ ����
		menuPanel.setBackground(new Color(252, 235, 235));// �޴� �г��� ���� ����
		menuPanel.add(Back);// �޴� �гο� �ڷΰ��� ��ư �߰�
		menuPanel.add(btnHome);// �޴� �гο� Ȩ ��ư �߰�

		/* ��ü �г� ���� �� ��ġ �� ���� */
		primary = new JPanel();//��ü �г� ����
		primary.setLayout(null);//��ü �г��� ���̾ƿ� �Ŵ��� ����
		primary.setBackground(new Color(221, 247, 255));//��ü �г��� ���� ����
		//��ü �гο� ��ư �� �гε� �߰�
		primary.add(btnInc);
		primary.add(lblCount);
		primary.add(menuPanel);
		primary.add(firePanel);
		primary.add(btnNameCheck);
		primary.add(strName);
		primary.add(lblNum);
		primary.add(Draw);
		primary.add(btnCntCheck);
		primary.add(lblk);
		primary.add(btnDec);

		/* �����ӿ� �߰� */
		firstLayout.add(primary);
		firstLayout.pack();
		firstLayout.setVisible(true);
	}

	private class firePanel extends JPanel {// �Ҳ� �гο��� gif�� �ֱ� ���� Ŭ����
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(im, 0, 0, getWidth(), getHeight(), this);// ������ �׸��� �׸��� �κ�
		}
	}

	private class ButtonListener implements ActionListener {// ��ư �׼� Ŭ����
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object B = e.getSource();
			if (B == Back || B == btnHome)// �ڷΰ��� �Ǵ� Ȩ��ư�� ������ ���
			{
				primary.setVisible(false);// ���� �г��� �Ⱥ��̰���
				prePanel.setVisible(true);// ���� �г��� ���̰���
			} else if (B == btnInc)// �ο����� �ø��� ��ư
			{
				Num++;
				lblCount.setText("" + Num);//���ؽ�Ʈ �����Ͽ� ����ڰ� ���� ������ �ο����� ���̰���
			} else if (B == btnDec)// �ο����� ���̴� ��ư
			{
				if (Num > 0) {
					Num--;
					lblCount.setText("" + Num);//���ؽ�Ʈ �����Ͽ� ����ڰ� ���� ������ �ο����� ���̰���
				} else// ������ ���� �ʵ��� �ϱ����� ���̾�α� �޽��� ����
					JOptionPane.showMessageDialog(primary, "�ּ��ο��� 1���Դϴ�.", "ERROR", JOptionPane.WARNING_MESSAGE);
			} else if (B == btnCntCheck)// �ο��� Ȯ�� ��ư
			{
				if (Num <= 0)// 0�� ������ �ʵ��� �ϱ����� ���̾�α� �޽��� ���� �κ�
					JOptionPane.showMessageDialog(primary, "�ּ��ο��� 1���Դϴ�.", "ERROR", JOptionPane.WARNING_MESSAGE);
				else {// ���� ��ư���� ��밡���ϰ� �����, ���� ��ư���� ���Ұ����ϰ� ����
					btnCntCheck.setEnabled(false);
					btnInc.setEnabled(false);
					btnDec.setEnabled(false);
					firePanel.setVisible(false);
					strName.setEnabled(true);
					btnNameCheck.setEnabled(true);
				}
			} else if (B == strName || B == btnNameCheck) {// �̸��� �Է¹���
				if (cnt < Num) {
					nameList.add(new String(strName.getText()));//ArrayList�� �߰�
					cnt++;
					if (cnt >= Num) {//�ο����� ������ ����̱� ����� �� ��ư Ȱ��ȭ �� ������ ��ư�� ���Ұ����ϰ� ����
						strName.setEnabled(false);
						btnNameCheck.setEnabled(false);
						Draw.setEnabled(true);
					}
				}
				strName.setText("");// ����ڰ� �Է��� �ؽ�Ʈ ����
			} else if (B == Draw) {// �̱� ���z�� ���� ������
				if (cnt < Num)
					JOptionPane.showMessageDialog(primary, "��� ����� �̸��� �Է����ּ���", "ERROR", JOptionPane.WARNING_MESSAGE);
				else// ������ �ް� �̸�����
				{
					pickName.setText(nameList.get(rand.nextInt(Num)));// ���� �̸��� �������� �̸��󺧿� �ؽ�Ʈ ����
					firePanel.setVisible(true);// ��÷�� �г� ���̰���
					//�ʱ�ȭ�κ�
					Draw.setEnabled(false);
					btnInc.setEnabled(true);
					btnDec.setEnabled(true);
					btnCntCheck.setEnabled(true);
					nameList.removeAll(nameList);//������ �Է��� ������ ��� ����
					cnt = 0;
					Num = 0;
					lblCount.setText("" + Num);
				}
			}
		}
	}
}
