package com.imooc.io;

import java.io.UnsupportedEncodingException;

public class EncodeDmeo {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "慕课ABC";
		//将字符转换成字节，硬盘上的存储形式
		byte []bytes1= s.getBytes();//使用项目默认的编码UTF-8
		for(byte b:bytes1){
			//显示字节的数字-128-127
			System.out.print(b+" ");
		}
		System.out.println("");
		for(byte b:bytes1){
			//把字节转换成了int 以16进制的方式显示,扩大为32位，前24位都是零
			System.out.print(Integer.toHexString(b)+" ");
		}
		System.out.println("");
		for(byte b:bytes1){
			//把字节转换成了int 以16进制的方式显示，将前面的0去掉
			System.out.print(Integer.toHexString(b & 0xff)+" ");
		}
		
		System.out.println();
		//指定字节编码
		byte []bytes2 = s.getBytes("UTF-8");
		for(byte b:bytes2){
			//把字节转换成了int 以16进制的方式显示，将前面的0去掉
			System.out.print(Integer.toHexString(b & 0xff)+" ");
		}
		/**
		 * e6 85 95 e8 af be 41 42 43 
		 * 慕                        课                      A  B  C
		 * utf-8编码中文占用3个字节，英文占用1个字节
		 */
		
		
		
		System.out.println();
		//指定字节编码gbk
		byte []bytes3 = s.getBytes("gbk");
		for(byte b:bytes3){
			//把字节转换成了int 以16进制的方式显示，将前面的0去掉
			System.out.print(Integer.toHexString(b & 0xff)+" ");
		}
		
		/**
		 *c4 bd bf ce 41 42 43
		 * 慕         课            A  B  C
		 * GBK编码中文占用两个字节，英文占用一个字节
		 */
		
		/**
		 * java 是双字节编码 utf-16be,中文占2个字节，英文占2个字节。
		 * 61 55 8b fe 0 41 0 42 0 43
		 * 慕              课               A    B    C
		 */
		
		System.out.println();
		//指定字节编码gbk
		byte []bytes4 = s.getBytes("utf-16be");
		for(byte b:bytes4){
			//把字节转换成了int 以16进制的方式显示，将前面的0去掉
			System.out.print(Integer.toHexString(b & 0xff)+" ");
		}
		/**
		 * 当你的字节序列是某种编码时，这个时候将字节转换字符串的时候，字符串也需要用这种方式，否者会出现乱码
		 * 
		 */
		System.out.println();
		String str1 = new String(bytes4);//使用项目默认的编码UTF-8
		System.out.println(str1);//出现乱码
		String str2 = new String(bytes4,"utf-16be");
		System.out.println(str2);
		
		/*
		 * 文件文件，就是字节序列
		 * 可以是任意编码的字节序列
		 * 如果我们在中文机器上直接创建文本文件，那么文本文件默认以ansi编码来保存文字信息
		 */
	}

}
