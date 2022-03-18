package project;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class ThirdLayout extends JPanel {
	//instance data
	private JButton Korea_Menu, Japan_Menu, China_Menu, USA_Menu;//세부 메뉴(한,중,일,양)을 정하는 버튼
	private JButton Back, btnHome;//뒤로가기, 홈 버튼
	private ButtonListener btnListener;//버튼이 눌렸을 때 이벤트 처리할 리스너
	private JPanel primary, prePanel, menuPanel, firstPanel;
	/*primary : 현재 띄울 패널
	 *prePanel : 이전 패널
	 *menuPanel : 뒤로가기 버튼과 홈 버튼을 넣을 패널
	 *firstPanel : 홈 버튼이 눌렸을 경우 이동할 패널(firstLayout의 패널)*/
	private JFrame thirdLayout;//받아온 프레임을 저장하기 위한 프레임
	public ThirdLayout(JFrame firstLayout, JPanel prePanel, JPanel firstPanel) {
		this.prePanel = prePanel;//이전 패널로 돌아갈 때 사용
		this.thirdLayout = firstLayout;//받아온 프레임으로 초기화
		this.firstPanel = firstPanel;//홈 버튼이 눌렸을 때 돌아갈 패널
		btnListener = new ButtonListener();//버튼리스너 생성
		
		/*한식, 일식, 중식, 양식 버튼들 배치 및 설정*/
		Korea_Menu = new JButton(new ImageIcon("images/한식.png"));//한식.png 이미지를 받아옴
		Korea_Menu.setBounds(25, 100, 215, 200);//버튼의 위치 설정
		Korea_Menu.addActionListener(btnListener);//버튼에 리스너 추가
		Korea_Menu.setBorderPainted(false);//버튼의 테두리 삭제
		Korea_Menu.setContentAreaFilled(false);//버튼의 내용영역의 채우기 삭제
		Korea_Menu.setFocusPainted(false);//버튼이 선택(focus)되었을 때 생기는 테두리 삭제
		
		Japan_Menu = new JButton(new ImageIcon("images/일식.png"));//일식.png 이미지를 받아옴
		Japan_Menu.setBounds(260, 100, 215, 200);//버튼의 위치 설정
		Japan_Menu.addActionListener(btnListener);//버튼에 리스너 추가
		Japan_Menu.setBorderPainted(false);//버튼의 테두리 삭제
		Japan_Menu.setContentAreaFilled(false);//버튼의 내용영역의 채우기 삭제
		Japan_Menu.setFocusPainted(false);//버튼이 선택(focus)되었을 때 생기는 테두리 삭제
		
		China_Menu = new JButton(new ImageIcon("images/중식.png"));//중식.png 이미지를 받아옴
		China_Menu.setBounds(25, 330, 215, 200);//버튼의 위치 설정
		China_Menu.addActionListener(btnListener);//버튼에 리스너 추가
		China_Menu.setBorderPainted(false);//버튼의 테두리 삭제
		China_Menu.setContentAreaFilled(false);//버튼의 내용영역의 채우기 삭제
		China_Menu.setFocusPainted(false);//버튼이 선택(focus)되었을 때 생기는 테두리 삭제
		
		USA_Menu = new JButton(new ImageIcon("images/양식.png"));//양식.png 이미지를 받아옴
		USA_Menu.setBounds(260, 330, 215, 200);//버튼의 위치 설정
		USA_Menu.addActionListener(btnListener);//버튼에 리스너 추가
		USA_Menu.setBorderPainted(false);//버튼의 테두리 삭제
		USA_Menu.setContentAreaFilled(false);//버튼의 내용영역의 채우기 삭제
		USA_Menu.setFocusPainted(false);//버튼이 선택(focus)되었을 때 생기는 테두리 삭제
		
		//뒤로가기 버튼 생성 및 배치 및 설정
		Back = new JButton(new ImageIcon("images/Back.png"));//Back.png 이미지를 받아옴
		Back.setBounds(5, 5	, 120, 70);//뒤로가기 버튼의 위치 설정
		Back.setBorderPainted(false);//버튼의 테두리 삭제
		Back.setContentAreaFilled(false);//버튼의 내용영역의 채우기 삭제
		Back.setFocusPainted(false);//버튼이 선택(focus)되었을 때 생기는 테두리 삭제
		Back.addActionListener(btnListener);//버튼에 리스너 추가
		
		//홈 버튼 생성 및 배치 및 설정
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
		menuPanel.add(Back);//메뉴 패널에 뒤로가기 버튼 추가
		menuPanel.add(btnHome);//메뉴 패널에 홈 버튼 추가

		/*전체 패널 생성 및 배치 및 설정*/
		primary = new JPanel();//전체 패널 생성
		primary.setBackground(new Color(221,247,255));//전체 패널의 배경색 설정
		primary.setLayout(null);//전체 패널의 레이아웃 매니저 삭제
		primary.add(menuPanel);//전체 패널에 메뉴 패널 추가
		/*전체 패널에 각각의 버튼들 추가*/
		primary.add(Korea_Menu);
		primary.add(Japan_Menu);
		primary.add(China_Menu);
		primary.add(USA_Menu);
		
		/*프레임에 추가*/
		firstLayout.add(primary);
		firstLayout.pack();
		firstLayout.setVisible(true);
		
	}
	private class ButtonListener implements ActionListener{//버튼 리스너 클레스

		public void actionPerformed(ActionEvent e) {
			Object B = e.getSource();
			if(B==Korea_Menu)//한식 버튼이 눌렸을 때
			{
				primary.setVisible(false);//현재 패널을 안보이게 함
				new FifthLayout_Korea(thirdLayout, primary, firstPanel);//한식 패널 생성 및 보이게함
			}
			else if(B==Japan_Menu)//일식 버튼이 눌렸을 때
			{
				primary.setVisible(false);//현재 패널을 안보이게 함
				new FifthLayout_Japan(thirdLayout, primary, firstPanel);//일식 패널 생성 및 보이게함
			}
			else if(B==China_Menu) {//중식 버튼이 눌렸을 때
				primary.setVisible(false);//현재 패널을 안보이게 함
				new FifthLayout_China(thirdLayout, primary, firstPanel);//중식 패널 생성 및 보이게함
			}
			else if(B==USA_Menu) {//양식 버튼이 눌렸을 때
				primary.setVisible(false);//현재 패널을 안보이게 함
				new FifthLayout_USA(thirdLayout, primary, firstPanel);//양식 패널 생성 및 보이게함
			}
			else if(B==Back)//뒤로가기 버튼이 눌렸을 때
			{
				primary.setVisible(false);//현재 패널을 안보이게 함
				prePanel.setVisible(true);//이전 패널을 보이게함
			}
			else if(B==btnHome) {
				primary.setVisible(false);//현재 패널을 안보이게 함
				firstPanel.setVisible(true);//첫번째 패널이 보이게함
			}
		}
	}
}
