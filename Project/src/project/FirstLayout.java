package project;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FirstLayout extends JPanel{
	//instanceData
	private JButton btnRandomMenu;//랜덤메뉴 레이아웃으로 이동하는 버튼
	private JButton btnChooseMenu;//선택메뉴 레이아웃으로 이동하는 버튼
	private JButton btnRandomCal;//돈내기 레이아웃으로 이동하는 버튼
	private primary primary;//첫번째 레이아웃의 전체 패널
	private JFrame firstLayout;//각각의 패널에 넘길 프레임을 받기 위함
	private ButtonListener ButtonListener_1;//버튼이 눌렸을 때 이벤트 처리할 리스너
	ImageIcon i = new ImageIcon("images/FirstLayout.png");//첫번째 레이아웃의 배경을 가져옴
	Image im = i.getImage();//클레스에서 사용할 Image변수
	public FirstLayout(JFrame frame)//프레임 생성자
	{
		firstLayout= frame;//넘길 프레임을 받음
		ButtonListener_1 = new ButtonListener();//버튼리스너 생성
		/*랜덤버튼 생성 및 배치 및 설정*/
		btnRandomMenu = new JButton(new ImageIcon("images/룰렛.png"));//룰렛.png 이미지를 받아옴
		btnRandomMenu.setBounds(70, 85, 96, 122);//버튼의 위치 설정
		btnRandomMenu.addActionListener(ButtonListener_1);//버튼에 리스너 추가
		btnRandomMenu.setBorderPainted(false);//버튼의 테두리 삭제
		btnRandomMenu.setContentAreaFilled(false);//버튼의 내용영역의 채우기 삭제
		btnRandomMenu.setFocusPainted(false);//버튼이 선택(focus)되었을 때 생기는 테두리 삭제
		
		/*선택버튼 생성 및 배치 및 설정*/
		btnChooseMenu = new JButton(new ImageIcon("images/선택.png"));//선택.png 이미지를 받아옴
		btnChooseMenu.setBounds(300, 260, 96, 122);//버튼의 위치 설정
		btnChooseMenu.addActionListener(ButtonListener_1);//버튼에 리스너 추가
		btnChooseMenu.setBorderPainted(false);//버튼의 테두리 삭제
		btnChooseMenu.setContentAreaFilled(false);//버튼의 내용영역의 채우기 삭제
		btnChooseMenu.setFocusPainted(false);//버튼이 선택(focus)되었을 때 생기는 테두리 삭제
		
		/*돈내기 버튼 생성 및 배치 및 설정*/
		btnRandomCal = new JButton(new ImageIcon("images/내기.png"));//내기.png 이미지를 받아옴
		btnRandomCal.setBounds(70, 430, 96, 122);//버튼의 위치 설정
		btnRandomCal.addActionListener(ButtonListener_1);//버튼에 리스너 추가
		btnRandomCal.setBorderPainted(false);//버튼의 테두리 삭제
		btnRandomCal.setContentAreaFilled(false);//버튼의 내용영역의 채우기 삭제
		btnRandomCal.setFocusPainted(false);//버튼이 선택(focus)되었을 때 생기는 테두리 삭제
		
		/*전체 패널 생성 및 설정(추가)*/
		primary = new primary();//전체 패널 생성
		primary.setLayout(null);//레이아웃 매니저 삭제
		primary.add(btnRandomMenu);//랜덤버튼 추가
		primary.add(btnChooseMenu);//선택버튼 추가
		primary.add(btnRandomCal);//돈내기 버튼 추가
		
		/*프레임에 추가*/
		frame.getContentPane().add(primary);
		frame.pack();
		frame.setVisible(true);
	}
	private class primary extends JPanel{//첫번째 레이아웃의 배경을 담당하는 클래스
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(im, 0, 0, getWidth(),getHeight(), this);//가져온 그림을 그리는 부분
		}
	}
	private class ButtonListener implements ActionListener{//버튼 리스너 클레스
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			Object B = e.getSource();
			if(B==btnRandomMenu) {//랜덤 레이아웃으로 넘어감
				primary.setVisible(false);//현재 패널을 안보이게  함
				new SecondLayout(firstLayout, primary);//랜덤 레이아웃으로 이동(프레임을 인자로 주어 이동) 및 보여주기
			}
			else if(B==btnChooseMenu) {//선택 레이아웃으로 넘어감
				primary.setVisible(false);//현재 패널을 안보이게함
				new ThirdLayout(firstLayout, primary, primary);//선택 레이아웃으로 이동 및 보여주기
			}else if(B==btnRandomCal) {//돈내기 레이아웃으로 넘어감
				primary.setVisible(false);//현재 패널을 안보이게 함
				new FourthLayout(firstLayout, primary);//돈내기 레이아웃으로 이동 및 보여주기
			}
		}	
	}
	
}
