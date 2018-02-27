package src.com.baizhi.manager.controller;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.enterprise.inject.spi.Producer;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/validateCode")

public class KaptchaController {

	//����kaptcha��������ӿڱ��
	@Autowired
	private Producer producer;
	
	@RequestMapping("/code")
	public void getKaptcha(HttpSession session,HttpServletResponse response) throws IOException{
		
		
		//ͨ��kaptcha��������һ��ͼƬ
			//1.��Ҫ��һ��Kaptcha����������Ա������ͨ���Զ�װ����ɸ�ֵ
			//2.ͨ��kaptcha����ķ��������Եõ�����ַ���
			//3.�����ɵ��ַ���������session�������� ==>session.setAttribute("kaptcha","���ɵ��ַ���")
			//4.ͨ��kaptcha����ķ��������԰��ַ�������һ��ͼƬ
		
		//����һ������ַ���
		String kaptcha = producer.createText();
		
		//�����ɵ��ַ���������session��������
		session.setAttribute("code", kaptcha);
		
		//�����ɵ��ַ������뵽ͼƬ�У�ʹ�����ɵ��ַ�������һ��ͼƬ
		BufferedImage image = producer.createImage(kaptcha);
		
		
		//��һ��ͼƬ��Ӧ���ͻ��ˣ�jsp��
			//1.��Ҫһ����Ӧ�����ڷ����β�������HttpServletResponse
			//2.��response����Ӧһ��ͼƬ���ͻ���
		
		//��image���ͼƬ����jpg�ĸ�ʽд�뵽��Ӧ�����===����image���ͼƬ����jpg�ĸ�ʽ���ͻ�����Ӧ
		ImageIO.write(image, "jpg", response.getOutputStream());
		
	}
}
