package secret;

/**
 * URL传输等
 *
 */
public   class   Base64   
{   
	 /**
     * 对字符串进行 BASE64 编码
     *
     * @s  编码前的字符串
     * @return 编码后的字符串
     */
    static String base64Encode ( String s )
    {
        if ( s == null )
            return null ;
        
        return new String(( new org.apache.commons.codec.binary.Base64()).encode(s.getBytes()));
    }

    /**
     * 对字符串进行 BASE64 编码
     *
     * @bytes  编码前的字符
     * @return 编码后的字符串
     */
    static String base64Encode ( byte[] bytes )
    {

        return new String(( new org.apache.commons.codec.binary.Base64()).encode(bytes));
    }
    /**
     * 将 BASE64 编码的字符串进行解码
     *
     * @s BASE64 编码的字符串
     * @return 解码后的字符串
     */
    static String base64Decode (String s)
    {
        if ( s == null )
            return null ;
        try
        {
            byte [ ] b = org.apache.commons.codec.binary.Base64.decodeBase64(s);
            return new String ( b ) ;
        } catch ( Exception e )
        {
            return null ;
        }
    }
    /**
     * 将 BASE64 编码的字符串进行解码
     *
     * @s BASE64 编码的字符串
     * @return 解码后的字符串
     */
    static String base64Decode (byte[] bytes)
    {
        try
        {
            byte [ ] b = org.apache.commons.codec.binary.Base64.decodeBase64(bytes);
            return new String ( b ) ;
        } catch ( Exception e )
        {
            return null ;
        }
    }

    static byte[] base64DecodeBytes (byte[] bytes)
    {
        try
        {
            byte [ ] b = org.apache.commons.codec.binary.Base64.decodeBase64(bytes);
            return b ;
        } catch ( Exception e )
        {
            return null ;
        }
    }
}