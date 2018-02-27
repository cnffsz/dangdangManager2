package src.com.baizhi.manager.util.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FIleTrasfer {
	
	@SuppressWarnings("deprecation")
	public static String fileTrtans(HttpServletRequest req,MultipartFile file){
		System.out.println(file);
		
		if(file!=null){
		//�õ���ǰ�����Э��
		String scheme = req.getScheme();
		//�õ���ǰ����ķ�����ip
		String serverName = req.getServerName();
		//�õ���ǰ����Ķ˿ں�
		int serverPort = req.getServerPort();
		//�ļ���ԭʼ�ļ���
		String filename = file.getOriginalFilename();
		//�õ���Ŀ·��
		String realPath = req.getRealPath("");
		//����һ���ļ�����
		File path = new File(realPath);
		//�õ�webapps���ϼ�Ŀ¼
		String imgPath = path.getParent();
		//����������Դ���ļ���
		File imgs = new File (imgPath+"/images");
		//��ֻ֤����һ��Ŀ¼�������ж�
		if(!imgs.exists()){
			
			imgs.mkdirs();
		}
		//��ԭʼ�ļ������д����ֹ��������
		filename=UUID.randomUUID().toString().replace("-", "")
		+new Date().getTime()+filename.substring(filename.lastIndexOf("."));
		//ƴ����Ҫ�������ݿ���ļ�����ʵ����·��
		String lastName=scheme+"://"+serverName+":"+serverPort+"/images/"+filename;
		//���ļ��ϴ���ָ��Ŀ¼
		try {
			file.transferTo(new File(imgPath+"/images/"+filename));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lastName;
		
		}
		return "";
	}
		
}
