package com.imooc.io;

import java.io.UnsupportedEncodingException;

public class EncodeDmeo {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "Ľ��ABC";
		//���ַ�ת�����ֽڣ�Ӳ���ϵĴ洢��ʽ
		byte []bytes1= s.getBytes();//ʹ����ĿĬ�ϵı���UTF-8
		for(byte b:bytes1){
			//��ʾ�ֽڵ�����-128-127
			System.out.print(b+" ");
		}
		System.out.println("");
		for(byte b:bytes1){
			//���ֽ�ת������int ��16���Ƶķ�ʽ��ʾ,����Ϊ32λ��ǰ24λ������
			System.out.print(Integer.toHexString(b)+" ");
		}
		System.out.println("");
		for(byte b:bytes1){
			//���ֽ�ת������int ��16���Ƶķ�ʽ��ʾ����ǰ���0ȥ��
			System.out.print(Integer.toHexString(b & 0xff)+" ");
		}
		
		System.out.println();
		//ָ���ֽڱ���
		byte []bytes2 = s.getBytes("UTF-8");
		for(byte b:bytes2){
			//���ֽ�ת������int ��16���Ƶķ�ʽ��ʾ����ǰ���0ȥ��
			System.out.print(Integer.toHexString(b & 0xff)+" ");
		}
		/**
		 * e6 85 95 e8 af be 41 42 43 
		 * Ľ                        ��                      A  B  C
		 * utf-8��������ռ��3���ֽڣ�Ӣ��ռ��1���ֽ�
		 */
		
		
		
		System.out.println();
		//ָ���ֽڱ���gbk
		byte []bytes3 = s.getBytes("gbk");
		for(byte b:bytes3){
			//���ֽ�ת������int ��16���Ƶķ�ʽ��ʾ����ǰ���0ȥ��
			System.out.print(Integer.toHexString(b & 0xff)+" ");
		}
		
		/**
		 *c4 bd bf ce 41 42 43
		 * Ľ         ��            A  B  C
		 * GBK��������ռ�������ֽڣ�Ӣ��ռ��һ���ֽ�
		 */
		
		/**
		 * java ��˫�ֽڱ��� utf-16be,����ռ2���ֽڣ�Ӣ��ռ2���ֽڡ�
		 * 61 55 8b fe 0 41 0 42 0 43
		 * Ľ              ��               A    B    C
		 */
		
		System.out.println();
		//ָ���ֽڱ���gbk
		byte []bytes4 = s.getBytes("utf-16be");
		for(byte b:bytes4){
			//���ֽ�ת������int ��16���Ƶķ�ʽ��ʾ����ǰ���0ȥ��
			System.out.print(Integer.toHexString(b & 0xff)+" ");
		}
		/**
		 * ������ֽ�������ĳ�ֱ���ʱ�����ʱ���ֽ�ת���ַ�����ʱ���ַ���Ҳ��Ҫ�����ַ�ʽ�����߻��������
		 * 
		 */
		System.out.println();
		String str1 = new String(bytes4);//ʹ����ĿĬ�ϵı���UTF-8
		System.out.println(str1);//��������
		String str2 = new String(bytes4,"utf-16be");
		System.out.println(str2);
		
		/*
		 * �ļ��ļ��������ֽ�����
		 * ���������������ֽ�����
		 * ������������Ļ�����ֱ�Ӵ����ı��ļ�����ô�ı��ļ�Ĭ����ansi����������������Ϣ
		 */
	}

}
