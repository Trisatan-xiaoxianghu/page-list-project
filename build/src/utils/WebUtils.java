package utils;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtils {

	public WebUtils() {
		// TODO Auto-generated constructor stub
	}
	public static <T> T copyToBean(HttpServletRequest request, Class<T> clazz) {
		try {
			// ��������
						T t = clazz.newInstance();
						
						// ��ȡ���еı�Ԫ�ص�����
						Enumeration<String> enums = request.getParameterNames();
						// ����
						while (enums.hasMoreElements()) {
							String name = enums.nextElement();  // pwd
							String value = request.getParameter(name);
							BeanUtils.copyProperty(t, name, value);
					
						}
						
						return t;
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				}
}



