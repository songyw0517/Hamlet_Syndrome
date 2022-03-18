package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.*;
public class SecondLayout extends JPanel {
	/*instance data*/
	private JButton Back, More, btnHome;//뒤로가기, 한번 더, 홈으로 가기 기능을 하는 각각의 버튼
	private ButtonListener btnListener;//버튼 리스너
	private JPanel primary, prePanel, iconPanel, menuPanel, firstPanel;
	/*primary : 현재 띄울 패널
	 *prePanel : 이전 패널
	 *iconPanel : 메뉴 사진을 띄울 패널
	 *menuPanel : 뒤로가기 버튼과 홈 버튼을 넣을 패널
	 *firstPanel : 홈 버튼이 눌렸을 경우 이동할 패널(firstLayout의 패널)*/
	private Random rand;//랜덤 수를 받기 위한 객체
	private int k;//랜덤 수를 받을 변수
	private JFrame firstLayout;//받아온 프레임을 저장하기 위한 프레임
	private ImageIcon imgRestaurant;//메뉴 이미지를 갖고오기 위한 이미지아이콘
	private JLabel lblRestaurant;//이미지를 넣을 라벨
	private String[] restaurantName = {"images/menu/menu(1).png", "images/menu/menu(2).png", //불러올 이미지 파일의 이름을 배열로 선언
			"images/menu/menu(3).png", "images/menu/menu(4).png", "images/menu/menu(5).png",
			"images/menu/menu(6).png","images/menu/menu(7).png","images/menu/menu(8).png"};
	public SecondLayout(JFrame firstLayout, JPanel prePanel) {//생성자
		setLayout(null);//레이아웃 매니저 삭제
		this.firstLayout = firstLayout;//받아온 프레임으로 초기화
		btnListener = new ButtonListener();//버튼 리스너 생성
		rand = new Random();//랜덤객체 생성
		k = rand.nextInt(8);//8개의 메뉴 중 하나 선택
		System.out.println("rand = "+k);
		this.prePanel = prePanel;//이전 패널로 돌아갈 때 사용
		
		/*Back버튼 생성 및 배치 및 설정*/
		Back = new JButton(new ImageIcon("images/Back.png"));//뒤로가기 버튼, Back.png 이미지를 가져옴
		Back.setBounds(5, 5	, 120, 70);//뒤로가기 버튼의 위치
		Back.setBorderPainted(false);//버튼의 테두리 삭제
		Back.setContentAreaFilled(false);//버튼의 내용영역의 채우기 삭제
		Back.setFocusPainted(false);//버튼이 선택(focus)되었을 때 생기는 테두리 삭제
		Back.addActionListener(btnListener);//버튼에 리스너 추가
		
		/*한번더 버튼 생성 및 배치 및 설정*/
		More = new JButton(new ImageIcon("images/again(70by70).png"));//again(100by100).png 이미지를 받아옴
		More.setBounds(420, 490, 70, 70);//버튼의 위치 설정
		More.addActionListener(btnListener);//버튼에 리스너 추가
		More.setBorderPainted(false);//버튼의 테두리 삭제
		More.setContentAreaFilled(false);//버튼의 내용영역의 채우기 삭제
		More.setFocusPainted(false);//버튼이 선택(focus)되었을 때 생기는 테두리 삭제
		
		/*홈버튼 생성 및 배치 및 설정*/
		btnHome = new JButton(new ImageIcon("images/home.png"));//home.png 이미지를 받아옴
		btnHome.setBounds(380, 0, 120, 75);//버튼의 위치 설정
		btnHome.setBorderPainted(false);//버튼의 테두리 삭제
		btnHome.setContentAreaFilled(false);//버튼의 내용영역의 채우기 삭제
		btnHome.setFocusPainted(false);//버튼이 선택(focus)되었을 때 생기는 테두리 삭제
		btnHome.addActionListener(btnListener);//버튼에 리스너 추가
		
		/*메뉴 패널 생성 및 배치 및 설정*/
		menuPanel = new JPanel();//메뉴 패널 생성
		menuPanel.setLayout(null);//메뉴 패널의 레이아웃 매니저 삭제
		menuPanel.setBounds(0, 0, 500, 75);//패널의 위치 설정(맨 위)
		menuPanel.setBackground(new Color(252, 235,235));//메뉴의 배경색 설정
		menuPanel.add(Back);//메뉴 패널에 뒤로가기 버튼 추가
		menuPanel.add(btnHome);//메뉴 패널에 홈 버튼 추가
		
		/*메뉴 사진을 배치할 패널 생성 및 배치 및 설정*/
		iconPanel = new JPanel();//라벨 생성
		iconPanel.setBounds(22, 85, 400, 400);//라벨의 위치 설정
		iconPanel.setBackground(new Color(221,247,255));//이미지 패널의 배경색 설정
		
		/*불러온 이미지, 라벨 생성 및 배치 및 설정*/
		imgRestaurant = new ImageIcon(restaurantName[k]);//이미지 불러옴
		lblRestaurant = new JLabel(imgRestaurant);//받아온 이미지를 라벨에 추가하면서 라벨 생성
		lblRestaurant.setBounds(0, 0, 400, 400);//라벨의 위치 설정
		iconPanel.add(lblRestaurant);//패널에 라벨 추가
		
		/*전체 패널 생성 및 배치 및 설정*/
		primary = new JPanel();//전체 패널 생성
		primary.setLayout(null);//패널의 레이아웃 매니저 삭제
		primary.setBackground(new Color(221,247,255));//패널의 배경색 지정
		primary.add(More);//패널에 한번더 버튼 추가
		primary.add(iconPanel);//패널에 iconPanel 추가
		primary.add(menuPanel);//패널에 menuPanel 추가
		
		/*프레임에 추가*/
		firstLayout.add(primary);
		firstLayout.pack();
		firstLayout.setVisible(true);
	}
	
	private class ButtonListener implements ActionListener{//버튼 리스너 클레스
		@Override
		public void actionPerformed(ActionEvent e) {
			Object B = e.getSource();
			if(B==Back||B==btnHome)//뒤로가기버튼 또는 홈 버튼이 눌리면 첫번째 레이아웃으로 이동
			{
				primary.setVisible(false);//현재 패널을 안보이게 함
				prePanel.setVisible(true);//이전 패널(첫번째 패널)이 보이게 함
			}else if(B==More)
			{
				primary.setVisible(false);//현재 패널을 안보이게 함
				new SecondLayout(firstLayout, prePanel);//새로운 SecondLayout을 만들면서, 랜덤값 갱신, 이미지 갱신
			}
		}
	}
}
