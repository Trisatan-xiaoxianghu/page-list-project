package utils;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class JdbcUtils {

	public JdbcUtils() {
		// TODO Auto-generated constructor stub
	}
	private static  ComboPooledDataSource dataSource = new ComboPooledDataSource();

	public static  QueryRunner qr=new QueryRunner(dataSource);
	

//	
//	/**
//	 *  1. ��ʼ��C3P0���ӳ�
//	 */
//	private static  DataSource dataSource;
//	static {
//		dataSource = new ComboPooledDataSource();
//	}
//	
//	/**
//	 * 2. ����DbUtils���Ĺ��������
//	 */
//	public static QueryRunner getQueryRuner(){
//		// ����QueryRunner���󣬴������ӳض���
//		// �ڴ���QueryRunner�����ʱ���������������Դ����
//		// ��ô��ʹ��QueryRunner���󷽷���ʱ�򣬾Ͳ���Ҫ�������Ӷ���
//		// ���Զ�������Դ�л�ȡ����(���ùر�����)
//		return new QueryRunner(dataSource);
//	}
}








