package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FifthLayout_China extends JPanel {
	//instance data
	private JButton Rice, Noodle, Etc;//세부메뉴(밥, 면, 기타)를 정하는 버튼
	private JButton back, btnHome;//뒤로가기 버튼, 홈 버튼
	private JPanel primary, prePanel, menuPanel, SpacePanel, firstPanel;
	/*primary : 현재 띄울 패널
	 *prePanel : 이전 패널
	 *menuPanel : 뒤로가기 버튼과 홈 버튼을 넣을 패널
	 *propessorPanel : 교수님 사진을 띄우는 패널
	 *firstPanel : 홈 버튼이 눌렸을 경우 이동할 패널(firstLayout의 패널)*/
	private JLabel lblSpace;//공간을 나눠주는 이미지를 받는 라벨
	private JLabel propessor;//교수님 사진을 받아오는 라벨
	private ImageIcon imgIcon;//교수님 사진을 받는 이미지 아이콘
	private ButtonListener btnListener;//버튼이 눌렸을 때 이벤트 처리할 리스너
	private JFrame fifthLayout;//받아온 프레임을 저장하기 위한 프레임
	public FifthLayout_China(JFrame thirdLayout, JPanel prePanel, JPanel firstPanel) {//생성자
		this.firstPanel = firstPanel;//홈 버튼이 눌렸을 때 돌아갈 패널
		fifthLayout = thirdLayout;//받아온 프레임으로 초기화
		this.prePanel = prePanel;//이전 패널로 돌아갈 때 사용
		btnListener = new ButtonListener();//버튼리스너 생성
		/*밥, 면, 기타 버튼 배치 및  설정*/
		Rice = new JButton(new ImageIcon("images/밥.png"));//밥.png 이미지를 받아옴
		Rice.setBounds(17, 240, 133, 187);//버튼의 위치 설정
		Rice.addActionListener(btnListener);//버튼에 리스너 추가
		Rice.setBorderPainted(false);//버튼의 테두리 삭제
		Rice.setContentAreaFilled(false);//버튼의 내용영역의 채우기 삭제
		Rice.setFocusPainted(false);//버튼이 선택(focus)되었을 때 생기는 테두리 삭제
		
		Noodle = new JButton(new ImageIcon("images/면.png"));//면.png 이미지를 받아옴
		Noodle.setBounds(195, 240, 133, 187);//버튼의 위치 설정
		Noodle.addActionListener(btnListener);//버튼에 리스너 추가
		Noodle.setBorderPainted(false);//버튼의 테두리 삭제
		Noodle.setContentAreaFilled(false);//버튼의 내용영역의 채우기 삭제
		Noodle.setFocusPainted(false);//버튼이 선택(focus)되었을 때 생기는 테두리 삭제
		
		Etc = new JButton(new ImageIcon("images/기타.png"));//기타.png 이미지를 받아옴
		Etc.setBounds(360, 240, 133, 187);//버튼의 위치 설정
		Etc.addActionListener(btnListener);//버튼에 리스너 추가
		Etc.setBorderPainted(false);//버튼의 테두리 삭제
		Etc.setContentAreaFilled(false);//버튼의 내용영역의 채우기 삭제
		Etc.setFocusPainted(false);//버튼이 선택(focus)되었을 때 생기는 테두리 삭제
		
		//뒤로가기 버튼 생성 및 배치 및 설정
		back = new JButton(new ImageIcon("images/Back.png"));//Back.png 이미지를 받아옴
		back.setBounds(5, 5	, 120, 70);//뒤로가기 버튼의 위치 설정
		back.setBorderPainted(false);//버튼의 테두리 삭제
		back.setContentAreaFilled(false);//버튼의 내용영역의 채우기 삭제
		back.setFocusPainted(false);//버튼이 선택(focus)되었을 때 생기는 테두리 삭제
		back.addActionListener(btnListener);//버튼에 리스너 추가
		
		btnHome = new JButton(new ImageIcon("images/home.png"));//home.png 이미지를 받아옴
		btnHome.setBounds(380, 0, 120, 75);//홈 버튼의 위치 설정
		btnHome.setBorderPainted(false);//버튼의 테두리 삭제
		btnHome.setContentAreaFilled(false);//버튼의 내용영역의 채우기 삭제
		btnHome.setFocusPainted(false);//버튼이 선택(focus)되었을 때 생기는 테두리 삭제
		btnHome.addActionListener(btnListener);//버튼에 리스너 추가
		
		//메뉴 패널생성 및 배치 및 설정
		menuPanel = new JPanel();//메뉴 패널 생성
		menuPanel.setLayout(null);//메뉴 패널의 레이아웃 매니저 삭제
		menuPanel.setBounds(0, 0, 500, 75);//메뉴 패널의 위치 설정
		menuPanel.setBackground(new Color(252, 235,235));//메뉴 패널의 배경색 설정
		menuPanel.add(back);//메뉴 패널에 뒤로가기 버튼 추가
		menuPanel.add(btnHome);//메뉴 패널에 홈 버튼 추가
		
		//교수님 사진을 보여주는 라벨
		propessor = new JLabel(new ImageIcon("images/교수님.png"));//교수님.png 이미지를 받아옴, 라벨 생성
		propessor.setBounds(0, 82, 500, 130);//라벨의 위치 설정
		
		//공간을 나눠주는 이미지 삽입
		imgIcon = new ImageIcon("images/iconPanel.png");//iconPanel.png 이미지를 받아옴, 이미지 아이콘 생성
		lblSpace = new JLabel(imgIcon);//imgIcon을 인자로 받은 라벨 생성
		lblSpace.setBounds(0, 0, 500, 240);//라벨의 위치 설정
		
		//공간을 나눠주는 이미지를 받아오는 패널
		SpacePanel = new JPanel();//패널 생성
		SpacePanel.setLayout(null);//레이아웃 매니저 삭제
		SpacePanel.setBounds(0, 220, 499, 240);//패널의 위치 설정
		SpacePanel.add(lblSpace);//lblSpace 라벨 추가
		
		//전체 패널에 삽입
		primary = new JPanel();//전체 패널 생성
		primary.setLayout(null);//전체 패널의 레이아웃 매니저 삭제
		primary.setBackground(new Color(221,247,255));//저체 패널의 배경색 설정
		//각각의 패널 및 버튼 추가
		primary.add(propessor);
		primary.add(Rice);
		primary.add(Noodle);
		primary.add(Etc);
		primary.add(menuPanel);
		primary.add(SpacePanel);
		
		//프레임에 삽입
		thirdLayout.add(primary);
		thirdLayout.pack();
		thirdLayout.setVisible(true);
	}
	
	
	private class ButtonListener implements ActionListener{//버튼 리스너 클레스
		public void actionPerformed(ActionEvent e) {
			Object B = e.getSource();
			if(B==Rice) {//밥이 눌렸을 경우
				primary.setVisible(false);
				new SixthLayout_China(fifthLayout, primary, 1, firstPanel);
			}else if(B==Noodle) {//면이 눌렸을 경우
				primary.setVisible(false);
				new SixthLayout_China(fifthLayout, primary, 2, firstPanel);
			}else if(B==Etc) {//기타가 눌렸을 경우
				primary.setVisible(false);
				new SixthLayout_China(fifthLayout, primary, 3, firstPanel);
			}else if(B==back) {//뒤로가기 버튼이 눌렸을 경우
				primary.setVisible(false);
				prePanel.setVisible(true);
			}else if(B==btnHome) {//홈버튼이 눌렸을 경우
				primary.setVisible(false);
				firstPanel.setVisible(true);
			}
		}
	}
	
}
