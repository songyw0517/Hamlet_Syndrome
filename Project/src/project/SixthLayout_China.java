package project;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class SixthLayout_China extends JPanel {
	// instance data
	private ButtonListener btnListener;// 버튼이 눌렸을 때 이벤트 처리할 리스너
	private JButton Back, btnHome;// 뒤로가기, 홈 버튼
	private JPanel primary, prePanel, restaurantPanel, menuPanel, detailPanel, firstPanel;
	/*
	 * primary : 현재 띄울 패널 prePanel : 이전 패널 restaurantPanel : 음식점 이미지를 띄울 패널
	 * menuPanel : 뒤로가기 버튼과 홈 버튼을 넣을 패널 detailPanel : 음식점에 대한 설명을 넣을 패널 firstPanel :
	 * 홈 버튼이 눌렸을 경우 이동할 패널(firstLayout의 패널)
	 */
	private ImageIcon imgRestaurant, imgDetails;// 음식점 이미지를 받을 imgRestaurant, 음식점에 대한 설명이미지를 넣을 imgDetails
	private JLabel lblRestaurant, lblDetails;// 각각의 이미지 아이콘을 넣을 라벨
	private Random rand;// 음식점을 랜덤으로 띄우기 위한 랜덤 객체
	private int k;// 랜덤 값을 받기위한 변수
	private String[] restaurantName = { "images/China_Rice1.png", "images/China_Rice2.png", "images/China_Rice3.png",
			"images/China_Noodle1.png", "images/China_Noodle2.png", "images/China_Noodle3.png", "images/China_Etc1.png",
			"images/China_Etc2.png", "images/China_Etc3.png" };// 음식점 사진의 이미지 파일 경로 및 이름을 배열로 저장
	private String[] detailsName = { "images/China_Rice1_details.png", "images/China_Rice2_details.png",
			"images/China_Rice3_details.png", "images/China_Noodle1_details.png", "images/China_Noodle2_details.png",
			"images/China_Noodle3_details.png", "images/China_Etc1_details.png", "images/China_Etc2_details.png",
			"images/China_Etc3_details.png" };//음식점에 대한 설명 사진의 이미지 파일 경로 및 이름을 배열로 저장

	public SixthLayout_China(JFrame fifthLayout, JPanel prePanel, int kind, JPanel firstPanel) {
		btnListener = new ButtonListener();// 버튼리스너 생성
		this.firstPanel = firstPanel;// 홈 버튼이 눌렸을 때 돌아갈 패널
		this.prePanel = prePanel;// 이전 패널로 돌아갈 때 사용
		rand = new Random();// 랜덤 객체 생성
		k = rand.nextInt(3);// 3개의 음식점 중 한가지를 고름
		if (kind == 1)// 밥이면 0~2의 값을 가짐
			k += 0;
		else if (kind == 2)// 면이면 3~5의 값을 가짐
			k += 3;
		else if (kind == 3)// 기타이면 6~8의 값을 가짐
			k += 6;
		/* 메뉴패널 아래, 음식점 사진 패널 */
		restaurantPanel = new JPanel();// 패널 생성
		restaurantPanel.setBounds(0, 75, 500, 254);// 패널의 위치 설정
		restaurantPanel.setBackground(new Color(221, 247, 255));// 패널의 배경색 설정

		imgRestaurant = new ImageIcon(restaurantName[k]);// 음식점 사진을 랜덤으로 불러옴
		lblRestaurant = new JLabel(imgRestaurant);// 이미지 아이콘을 인자로 받은 라벨 생성
		lblRestaurant.setBounds(0, 0, 500, 254);// 라벨의 위치 설정
		restaurantPanel.add(lblRestaurant);// 패널에 라벨 추가

		/* 맨 아래, 설명 패널 */
		detailPanel = new JPanel();// 패널 생성
		detailPanel.setBounds(0, 329, 500, 220);// 패널의 위치 설정
		detailPanel.setBackground(Color.white);// 패널의 배경색 설정

		imgDetails = new ImageIcon(detailsName[k]);// 음식점 사진에 맞는 설명 사진을 불러옴
		lblDetails = new JLabel(imgDetails);// 이미지 아이콘을 인자로 받은 라벨 생성
		lblDetails.setBounds(0, 0, 500, 220);// 라벨의 위치 설정
		detailPanel.add(lblDetails);// 패널에 라벨 추가

		// 뒤로가기 버튼 생성 및 배치 및 설정
		Back = new JButton(new ImageIcon("images/Back.png"));// Back.png 이미지를 받아옴
		Back.setBounds(5, 5, 120, 70);// 뒤로가기 버튼의 위치 설정
		Back.setBorderPainted(false);// 버튼의 테두리 삭제
		Back.setContentAreaFilled(false);// 버튼의 내용영역의 채우기 삭제
		Back.setFocusPainted(false);// 버튼이 선택(focus)되었을 때 생기는 테두리 삭제
		Back.addActionListener(btnListener);// 버튼에 리스너 추가

		/// 홈 버튼 생성 및 배치 및 설정
		btnHome = new JButton(new ImageIcon("images/home.png"));// home.png 이미지를 받아옴
		btnHome.setBounds(380, 0, 120, 75);// 홈 버튼의 위치 설정
		btnHome.setBorderPainted(false);// 버튼의 테두리 삭제
		btnHome.setContentAreaFilled(false);// 버튼의 내용영역의 채우기 삭제
		btnHome.setFocusPainted(false);// 버튼이 선택(focus)되었을 때 생기는 테두리 삭제
		btnHome.addActionListener(btnListener);// 버튼에 리스너 추가

		// 메뉴 패널생성 및 배치 및 설정
		menuPanel = new JPanel();// 메뉴 패널 생성
		menuPanel.setLayout(null);// 메뉴 패널의 레이아웃 매니저 삭제
		menuPanel.setBounds(0, 0, 500, 75);// 메뉴 패널의 위치 설정
		menuPanel.setBackground(new Color(252, 235, 235));// 메뉴 패널의 배경색 설정
		menuPanel.add(Back);// 메뉴 패널에 뒤로가기 버튼 추가
		menuPanel.add(btnHome);// 메뉴 패널에 홈 버튼 추가

		// 전체 패널 생성 및 배치 및 설정
		primary = new JPanel();//전체 패널 생성
		primary.setBackground(new Color(221, 247, 255));//전체 패널의 배경색 설정
		primary.setLayout(null);//전체 패널의 레이아웃 매니저 삭제
		//전체 패널에 버튼 및 패널들 추가
		primary.add(Back);
		primary.add(detailPanel);
		primary.add(restaurantPanel);
		primary.add(menuPanel);

		// 프레임에 추가
		fifthLayout.add(primary);
		fifthLayout.pack();
		fifthLayout.setVisible(true);
	}

	private class ButtonListener implements ActionListener {// 버튼 리스너 클래스

		public void actionPerformed(ActionEvent e) {
			Object B = e.getSource();
			if (B == Back) {// 뒤로가기 버튼이 눌렸을 경우
				primary.setVisible(false);//현재 패널을 안보이게 함
				prePanel.setVisible(true);//이전 패널을 보이게함
			} else if (B == btnHome) {// 홈 버튼이 눌렸을 경우
				primary.setVisible(false);//현재 패널을 안보이게함
				firstPanel.setVisible(true);//첫번째 패널이 보이게 함
			}
		}

	}

}
