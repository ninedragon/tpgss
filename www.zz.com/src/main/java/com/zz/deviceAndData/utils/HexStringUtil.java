package com.zz.deviceAndData.utils;

public class HexStringUtil {
	
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
     }
    
    /*
     * 16进制字符串转字节数组
     */
    public static byte[] hexString2Bytes(String hex) {
            
            if ((hex == null) || (hex.equals(""))){
                return null;
            }
            else if (hex.length()%2 != 0){
                return null;
            }
            else{                
                hex = hex.toUpperCase();
                int len = hex.length()/2;
                byte[] b = new byte[len];
                char[] hc = hex.toCharArray();
                for (int i=0; i<len; i++){
                    int p=2*i;
                    b[i] = (byte) ((charToByte(hc[p]) << 4 | charToByte(hc[p+1])) & 0xff);
                }
              return b;
            }           
            
    }
    
    /**
     * @param hex
     * @return  16进制字符串转int数组
     */
    public static int[] hexString2ints(String hex) {
        
        if ((hex == null) || (hex.equals(""))){
            return null;
        }
        else if (hex.length()%2 != 0){
            return null;
        }
        else{                
            hex = hex.toUpperCase();
            int len = hex.length()/2;
            int[] b=new int[len];
            char[] hc = hex.toCharArray();
            for (int i=0; i<len; i++){
                int p=2*i;
                b[i] = (int)((charToByte(hc[p]) << 4 | charToByte(hc[p+1])) & 0xff);
            }
          return b;
        }           
        
}
    public static void main(String[] args) {
//    	String hex="00681d001d00688412041e00010100170107047982943f10013f968b3e05ff0060a7dd448616";
//    	byte[] bytes = hexString2Bytes(hex);
//    	System.out.println(bytes[7]&0xff);
//    	System.out.println(bytes);
    	String hex="00681d001d00688412041e00010100170107047982943f10013f968b3e05ff0060a7dd448616";
    	int[] bytes = hexString2ints(hex);
    	System.out.println();
    	System.out.println(bytes);
	}
}

