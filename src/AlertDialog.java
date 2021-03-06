import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class AlertDialog extends JPanel {

	private ImageIcon img;
	private String meesage;
	
	public AlertDialog(String messge) {
		// 알림창 좌측에 들어갈 이미지 리사이징
		try {
			Image img = ImageIO.read(new File("res/exclamation.png"));
			BufferedImage bImg = (BufferedImage)img;
			Image newImage = bImg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(newImage);
			this.setImg(icon);
		} catch(Exception e) {
			e.printStackTrace();
		}		
		
		this.setMeesage(messge);
		render();
	}
	
	public AlertDialog(String imagePath, String message) {
		super();
		// 만약 새로운 imagePath가 들어오면 기존의 이미지는 사용하지 않고 새로들어온 이미지를 리사이징해서 사용함
		try {
			Image img = ImageIO.read(new File(imagePath));
			BufferedImage bImg = (BufferedImage)img;
			Image newImage = bImg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(newImage);
			this.setImg(icon);
		} catch(Exception e) {
			e.printStackTrace();
		}
		this.setMeesage(message);
		
		render();
	}

	public void render() {
		this.setPreferredSize(new Dimension(300, 90));
		this.setLayout(null);
		
		// 알림창 이미지 배치
		JLabel lblIcon = new JLabel();
		lblIcon.setIcon(this.img);
		lblIcon.setBounds(15, 15, 60, 60);
		lblIcon.setBackground(Color.GRAY);
		this.add(lblIcon);

		// 알림창 메세지 배치
		JLabel lblMessage = new JLabel();
		lblMessage.setText(this.meesage);
		lblMessage.setBounds(90, 10, 200, 70);
		lblMessage.setForeground(Color.WHITE);
		lblMessage.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMessage.setBackground(Color.red);
		
		// 만약 메세지가 10글자가 초과되면 폰트 조정
		if(this.meesage.length() > 10) {
			lblMessage.setFont(new Font("Dotum", Font.BOLD, 12));
		} else {
			lblMessage.setFont(new Font("Dotum", Font.BOLD, 15));
		}
		
		this.add(lblMessage);
	}
	
	public String getMeesage() {
		return meesage;
	}

	public void setMeesage(String meesage) {
		this.meesage = meesage;
	}

	public ImageIcon getImg() {
		return img;
	}

	public void setImg(ImageIcon img) {
		this.img = img;
	}
	public void setImg(String path) {
		try {
			Image img = ImageIO.read(new File(path));
			BufferedImage bImg = (BufferedImage)img;
			Image newImage = bImg.getScaledInstance(100,100, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(newImage);
			this.setImg(icon);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
