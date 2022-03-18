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
	 * Back : 뒤로가기 버튼 Draw : 돈내는 사람의 이름을 띄우는 버튼(제비 뽑기 버튼) btnInc : 인원 수를 증가 시키는 버튼
	 * btnDec : 인원 수를 감소 시키는 버튼 btnCntCheck : 인원수를 고정(확정)하는 버튼\ btnNameCheck : 사람의
	 * 이름을 받는 버튼 btnHome : 홈 버튼
	 */
	private JPanel primary, prePanel, menuPanel;
	/*
	 * primary : 현재 띄울 패널 prePanel : 이전 패널 menuPanel : 뒤로가기 버튼과 홈 버튼을 넣을 패널
	 * namePanel :
	 */
	private TextField strName;// 이름을 입력하는 TextField
	private ButtonListener btnListener;// 버튼이 눌렸을 때 이벤트 처리할 리스너
	private int Num, cnt;// Num : 사용자가 입력한 인원수, cnt : 이름을 모두 받게 하기 위한 변수
	private ArrayList<String> nameList;// 사용자가 입력한 이름을 받는 ArrayList
	private Random rand;// 랜덤으로 사람의 이름을 뽑기 위한 랜덤 클래스
	private JLabel pickName, lblNum, lblName, lblCount, lblk;
	/**/
	private firePanel firePanel;
	private File clap;
	ImageIcon i = new ImageIcon("images/불꽃.gif");// 첫번째 레이아웃의 배경을 가져옴
	Image im = i.getImage();

	public FourthLayout(JFrame firstLayout, JPanel prePanel) {// 생성자
		setLayout(null);// 레이아웃 매니저 삭제
		Num = cnt = 0;// 인원수 및 반복문을 돌리기 위한 cnt 값을 0으로 초기화
		btnListener = new ButtonListener();// 버튼 리스너 생성
		rand = new Random();// 랜덤 객체 생성
		this.prePanel = prePanel;

		// 뒤로가기 버튼 생성 및 배치 및 설정
		Back = new JButton(new ImageIcon("images/Back.png"));// Back.png 이미지를 받아옴
		Back.setBounds(5, 5, 120, 70);// 뒤로가기 버튼의 위치 설정
		Back.setBorderPainted(false);// 버튼의 테두리 삭제
		Back.setContentAreaFilled(false);// 버튼의 내용영역의 채우기 삭제
		Back.setFocusPainted(false);// 버튼이 선택(focus)되었을 때 생기는 테두리 삭제
		Back.addActionListener(btnListener);// 버튼에 리스너 추가

		/* 인원수 설정하는 부분 */
		lblNum = new JLabel(new ImageIcon("images/인원수.png"));// "인원수"를 보여주는 라벨
		lblNum.setBounds(60, 140, 100, 40);

		btnInc = new JButton(new ImageIcon("images/up.png"));// 인원수를 증가시키는 버튼 생성
		btnInc.setBounds(250, 140, 30, 40);// 버튼 위치 설정
		btnInc.addActionListener(btnListener);// 버튼에 리스너 추가
		btnInc.setBorderPainted(false);// 버튼의 테두리 삭제
		btnInc.setContentAreaFilled(false);// 버튼의 내용영역의 채우기 삭제
		btnInc.setFocusPainted(false);// 버튼이 선택(focus)되었을 때 생기는 테두리 삭제

		lblCount = new JLabel("" + Num);// 현재 인원수를 보여주는 라벨생성
		lblCount.setBounds(220, 140, 50, 40);// 라벨의 위치 설정
		lblCount.setFont(new Font("Adobe 고딕 Std", Font.PLAIN, 30));// 라벨의 폰트 설정

		btnDec = new JButton(new ImageIcon("images/down.png"));// 인원수를 감소시키는 버튼 생성
		btnDec.setBounds(180, 140, 30, 40);// 버튼의 위치 설정
		btnDec.addActionListener(btnListener);// 버튼에 리스너 추가
		btnDec.setBorderPainted(false);// 버튼의 테두리 삭제
		btnDec.setContentAreaFilled(false);// 버튼의 내용영역의 채우기 삭제
		btnDec.setFocusPainted(false);// 버튼이 선택(focus)되었을 때 생기는 테두리 삭제

		lblk = new JLabel("명");// "명"을 표시하는 라벨
		lblk.setBounds(295, 140, 30, 40);// 라벨의 위치 설정
		lblk.setFont(new Font("Adobe 고딕 Std", Font.PLAIN, 30));// 라벨의 폰트 설정

		/* 인원수를 확정하는 버튼 생성 및 배치 및 설정 */
		btnCntCheck = new JButton(new ImageIcon("images/확인.png"));// 인원수를 고정(확정)하는 버튼 생성
		btnCntCheck.setBounds(350, 135, 70, 50);// 버튼의 위치 설정
		btnCntCheck.addActionListener(btnListener);// 버튼에 리스너 추가
		btnCntCheck.setBorderPainted(false);// 버튼의 테두리 삭제
		btnCntCheck.setContentAreaFilled(false);// 버튼의 내용영역의 채우기 삭제
		btnCntCheck.setFocusPainted(false);// 버튼이 선택(focus)되었을 때 생기는 테두리 삭제

		/* 이름을 입력하는 부분 */
		lblName = new JLabel(new ImageIcon("images/이름.png"));// 이름.png 이미지를 받아옴
		lblName.setBounds(60, 200, 100, 40);// 라벨의 위치 설정

		strName = new TextField();// 이름을 입력하는 공간 설정
		strName.setBounds(180, 200, 150, 40);// textField의 위치 설정
		strName.setFont(new Font("Verdana", Font.BOLD, 30));// 폰트 설정
		strName.addActionListener(btnListener);// 리스너 추가
		strName.setEnabled(false);// 사용 불가능하게 만듬

		btnNameCheck = new JButton(new ImageIcon("images/확인.png"));// 이름을 확인하는 버튼 생성
		btnNameCheck.setBounds(350, 195, 70, 50);// 버튼의 위치 설정
		btnNameCheck.addActionListener(btnListener);// 버튼에 리스너 추가
		btnNameCheck.setEnabled(false);// 버튼 사용불가능하게 만듬
		btnNameCheck.setBorderPainted(false);// 버튼의 테두리 삭제
		btnNameCheck.setContentAreaFilled(false);// 버튼의 내용영역의 채우기 삭제
		btnNameCheck.setFocusPainted(false);// 버튼이 선택(focus)되었을 때 생기는 테두리 삭제

		/* 사용자가 입력한 이름 중 하나를 뽑는 버튼 */
		Draw = new JButton(new ImageIcon("images/뽑기.png"));// 뽑기.png 이미지를 받아옴
		Draw.setBounds(205, 270, 100, 100);// 버튼의 위치설정
		Draw.addActionListener(btnListener);// 버튼에 리스너 추가
		Draw.setBorderPainted(false);// 버튼의 테두리 삭제
		Draw.setContentAreaFilled(false);// 버튼의 내용영역의 채우기 삭제
		Draw.setFocusPainted(false);// 버튼이 선택(focus)되었을 때 생기는 테두리 삭제
		Draw.setEnabled(false);// 버튼 사용불가능하게 만듬

		nameList = new ArrayList<String>();// 이름을 저장하는 ArrayList

		/* 당첨된 사람의 이름을 띄우는 부분 */
		pickName = new JLabel();// 당첨된 사람의 이름을 보여주는 라벨 생성
		pickName.setBounds(0, 10, 500, 150);// 라벨의 위치설정
		pickName.setForeground(Color.white);// 라벨의 색깔 설정
		pickName.setHorizontalAlignment(SwingConstants.CENTER);// 정렬
		pickName.setFont(new Font("Verdana", Font.BOLD, 50));// 라벨의 폰트 설정

		firePanel = new firePanel();// 불꽃 gif를 보여주는 패널
		firePanel.setLayout(null);// 레이아웃 매니저 삭제
		firePanel.setBounds(0, 375, 500, 225);// 패널의 위치 설정
		firePanel.add(pickName);// 그 위에 당첨된 사람의 이름을 보여주기 위해 라벨 추가
		firePanel.setVisible(false);// 패널이 안보이게 설정

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

		/* 전체 패널 생성 및 배치 및 설정 */
		primary = new JPanel();//전체 패널 생성
		primary.setLayout(null);//전체 패널의 레이아웃 매니저 삭제
		primary.setBackground(new Color(221, 247, 255));//전체 패널의 배경색 설정
		//전체 패널에 버튼 및 패널들 추가
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

		/* 프레임에 추가 */
		firstLayout.add(primary);
		firstLayout.pack();
		firstLayout.setVisible(true);
	}

	private class firePanel extends JPanel {// 불꽃 패널에서 gif를 넣기 위한 클레스
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(im, 0, 0, getWidth(), getHeight(), this);// 가져온 그림을 그리는 부분
		}
	}

	private class ButtonListener implements ActionListener {// 버튼 액션 클레스
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object B = e.getSource();
			if (B == Back || B == btnHome)// 뒤로가기 또는 홈버튼이 눌렸을 경우
			{
				primary.setVisible(false);// 현재 패널을 안보이게함
				prePanel.setVisible(true);// 이전 패널을 보이게함
			} else if (B == btnInc)// 인원수를 늘리는 버튼
			{
				Num++;
				lblCount.setText("" + Num);//라벨텍스트 변경하여 사용자가 현재 설정한 인원수를 보이게함
			} else if (B == btnDec)// 인원수를 줄이는 버튼
			{
				if (Num > 0) {
					Num--;
					lblCount.setText("" + Num);//라벨텍스트 변경하여 사용자가 현재 설정한 인원수를 보이게함
				} else// 음수가 들어가지 않도록 하기위한 다이얼로그 메시지 띄우기
					JOptionPane.showMessageDialog(primary, "최소인원은 1명입니다.", "ERROR", JOptionPane.WARNING_MESSAGE);
			} else if (B == btnCntCheck)// 인원수 확인 버튼
			{
				if (Num <= 0)// 0이 들어오지 않도록 하기위한 다이얼로그 메시지 띄우는 부분
					JOptionPane.showMessageDialog(primary, "최소인원은 1명입니다.", "ERROR", JOptionPane.WARNING_MESSAGE);
				else {// 다음 버튼들을 사용가능하게 만들고, 현재 버튼들을 사용불가능하게 만듬
					btnCntCheck.setEnabled(false);
					btnInc.setEnabled(false);
					btnDec.setEnabled(false);
					firePanel.setVisible(false);
					strName.setEnabled(true);
					btnNameCheck.setEnabled(true);
				}
			} else if (B == strName || B == btnNameCheck) {// 이름을 입력받음
				if (cnt < Num) {
					nameList.add(new String(strName.getText()));//ArrayList에 추가
					cnt++;
					if (cnt >= Num) {//인원수가 맞으면 제비뽑기 기능을 할 버튼 활성화 및 나머지 버튼들 사용불가능하게 만듬
						strName.setEnabled(false);
						btnNameCheck.setEnabled(false);
						Draw.setEnabled(true);
					}
				}
				strName.setText("");// 사용자가 입력한 텍스트 삭제
			} else if (B == Draw) {// 뽑기 버틑에 대한 리스너
				if (cnt < Num)
					JOptionPane.showMessageDialog(primary, "모든 사람의 이름을 입력해주세요", "ERROR", JOptionPane.WARNING_MESSAGE);
				else// 랜덤값 받고 이름띄우기
				{
					pickName.setText(nameList.get(rand.nextInt(Num)));// 받은 이름중 랜덤으로 이름라벨에 텍스트 설정
					firePanel.setVisible(true);// 당첨된 패널 보이게함
					//초기화부분
					Draw.setEnabled(false);
					btnInc.setEnabled(true);
					btnDec.setEnabled(true);
					btnCntCheck.setEnabled(true);
					nameList.removeAll(nameList);//이전에 입력한 값들을 모두 삭제
					cnt = 0;
					Num = 0;
					lblCount.setText("" + Num);
				}
			}
		}
	}
}
