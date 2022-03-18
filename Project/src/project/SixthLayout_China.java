package project;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class SixthLayout_China extends JPanel {
	// instance data
	private ButtonListener btnListener;// ��ư�� ������ �� �̺�Ʈ ó���� ������
	private JButton Back, btnHome;// �ڷΰ���, Ȩ ��ư
	private JPanel primary, prePanel, restaurantPanel, menuPanel, detailPanel, firstPanel;
	/*
	 * primary : ���� ��� �г� prePanel : ���� �г� restaurantPanel : ������ �̹����� ��� �г�
	 * menuPanel : �ڷΰ��� ��ư�� Ȩ ��ư�� ���� �г� detailPanel : �������� ���� ������ ���� �г� firstPanel :
	 * Ȩ ��ư�� ������ ��� �̵��� �г�(firstLayout�� �г�)
	 */
	private ImageIcon imgRestaurant, imgDetails;// ������ �̹����� ���� imgRestaurant, �������� ���� �����̹����� ���� imgDetails
	private JLabel lblRestaurant, lblDetails;// ������ �̹��� �������� ���� ��
	private Random rand;// �������� �������� ���� ���� ���� ��ü
	private int k;// ���� ���� �ޱ����� ����
	private String[] restaurantName = { "images/China_Rice1.png", "images/China_Rice2.png", "images/China_Rice3.png",
			"images/China_Noodle1.png", "images/China_Noodle2.png", "images/China_Noodle3.png", "images/China_Etc1.png",
			"images/China_Etc2.png", "images/China_Etc3.png" };// ������ ������ �̹��� ���� ��� �� �̸��� �迭�� ����
	private String[] detailsName = { "images/China_Rice1_details.png", "images/China_Rice2_details.png",
			"images/China_Rice3_details.png", "images/China_Noodle1_details.png", "images/China_Noodle2_details.png",
			"images/China_Noodle3_details.png", "images/China_Etc1_details.png", "images/China_Etc2_details.png",
			"images/China_Etc3_details.png" };//�������� ���� ���� ������ �̹��� ���� ��� �� �̸��� �迭�� ����

	public SixthLayout_China(JFrame fifthLayout, JPanel prePanel, int kind, JPanel firstPanel) {
		btnListener = new ButtonListener();// ��ư������ ����
		this.firstPanel = firstPanel;// Ȩ ��ư�� ������ �� ���ư� �г�
		this.prePanel = prePanel;// ���� �гη� ���ư� �� ���
		rand = new Random();// ���� ��ü ����
		k = rand.nextInt(3);// 3���� ������ �� �Ѱ����� ��
		if (kind == 1)// ���̸� 0~2�� ���� ����
			k += 0;
		else if (kind == 2)// ���̸� 3~5�� ���� ����
			k += 3;
		else if (kind == 3)// ��Ÿ�̸� 6~8�� ���� ����
			k += 6;
		/* �޴��г� �Ʒ�, ������ ���� �г� */
		restaurantPanel = new JPanel();// �г� ����
		restaurantPanel.setBounds(0, 75, 500, 254);// �г��� ��ġ ����
		restaurantPanel.setBackground(new Color(221, 247, 255));// �г��� ���� ����

		imgRestaurant = new ImageIcon(restaurantName[k]);// ������ ������ �������� �ҷ���
		lblRestaurant = new JLabel(imgRestaurant);// �̹��� �������� ���ڷ� ���� �� ����
		lblRestaurant.setBounds(0, 0, 500, 254);// ���� ��ġ ����
		restaurantPanel.add(lblRestaurant);// �гο� �� �߰�

		/* �� �Ʒ�, ���� �г� */
		detailPanel = new JPanel();// �г� ����
		detailPanel.setBounds(0, 329, 500, 220);// �г��� ��ġ ����
		detailPanel.setBackground(Color.white);// �г��� ���� ����

		imgDetails = new ImageIcon(detailsName[k]);// ������ ������ �´� ���� ������ �ҷ���
		lblDetails = new JLabel(imgDetails);// �̹��� �������� ���ڷ� ���� �� ����
		lblDetails.setBounds(0, 0, 500, 220);// ���� ��ġ ����
		detailPanel.add(lblDetails);// �гο� �� �߰�

		// �ڷΰ��� ��ư ���� �� ��ġ �� ����
		Back = new JButton(new ImageIcon("images/Back.png"));// Back.png �̹����� �޾ƿ�
		Back.setBounds(5, 5, 120, 70);// �ڷΰ��� ��ư�� ��ġ ����
		Back.setBorderPainted(false);// ��ư�� �׵θ� ����
		Back.setContentAreaFilled(false);// ��ư�� ���뿵���� ä��� ����
		Back.setFocusPainted(false);// ��ư�� ����(focus)�Ǿ��� �� ����� �׵θ� ����
		Back.addActionListener(btnListener);// ��ư�� ������ �߰�

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

		// ��ü �г� ���� �� ��ġ �� ����
		primary = new JPanel();//��ü �г� ����
		primary.setBackground(new Color(221, 247, 255));//��ü �г��� ���� ����
		primary.setLayout(null);//��ü �г��� ���̾ƿ� �Ŵ��� ����
		//��ü �гο� ��ư �� �гε� �߰�
		primary.add(Back);
		primary.add(detailPanel);
		primary.add(restaurantPanel);
		primary.add(menuPanel);

		// �����ӿ� �߰�
		fifthLayout.add(primary);
		fifthLayout.pack();
		fifthLayout.setVisible(true);
	}

	private class ButtonListener implements ActionListener {// ��ư ������ Ŭ����

		public void actionPerformed(ActionEvent e) {
			Object B = e.getSource();
			if (B == Back) {// �ڷΰ��� ��ư�� ������ ���
				primary.setVisible(false);//���� �г��� �Ⱥ��̰� ��
				prePanel.setVisible(true);//���� �г��� ���̰���
			} else if (B == btnHome) {// Ȩ ��ư�� ������ ���
				primary.setVisible(false);//���� �г��� �Ⱥ��̰���
				firstPanel.setVisible(true);//ù��° �г��� ���̰� ��
			}
		}

	}

}
