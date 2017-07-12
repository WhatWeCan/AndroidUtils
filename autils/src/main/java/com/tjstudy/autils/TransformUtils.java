package com.tjstudy.autils;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * 数据安全转换类
 *
 * @author tjstudy
 */
public class TransformUtils {

    //---------------------int 和 byte[]的相互转换------------------
    private TransformUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * int to byte[4]
     *
     * @param i
     * @return byte[]
     */
    private static byte[] int2Byte(int i) {
        byte[] result = new byte[4];
        result[0] = (byte) (i & 0xFF);
        result[1] = (byte) ((i >> 8) & 0xFF);
        result[2] = (byte) ((i >> 16) & 0xFF);
        result[3] = (byte) ((i >> 24) & 0xFF);
        return result;
    }

    /**
     * byte[2]转int
     *
     * @param res byte[]
     * @return Integer
     */
    private static Integer byte2Int(byte[] res) {
        if (res.length != 4) {
            return null;
        }
        byte[] temp = new byte[4];
        System.arraycopy(res, 0, temp, 0, res.length);
        return (temp[0] & 0xff) | ((temp[1] << 8) & 0xff00)
                | ((temp[2] << 16) & 0xff0000) | ((temp[3] << 24) & 0xff000000); // 表示安位或
    }

    /**
     * res[start],res[start+1],res[start+2],res[start+3]转int
     *
     * @param res
     * @param start
     * @return
     */
    private static Integer byte2Int(byte[] res, int start) {
        if ((res.length - start) != 4) {
            return null;
        }
        byte[] temp = new byte[4];
        System.arraycopy(res, 0, temp, 0, res.length);
        return (temp[0] & 0xff) | ((temp[1] << 8) & 0xff00)
                | ((temp[2] << 16) & 0xff0000) | ((temp[3] << 24) & 0xff000000); // 表示安位或
    }

    //---------------------String 和 byte[]的相互转换------------------

    /**
     * byte数组转字符串
     *
     * @param src     byte[]
     * @param charset 字符编码
     * @return
     */
    private static String byte2String(byte[] src, String charset) throws UnsupportedEncodingException {
        return new String(src, charset);
    }

    /**
     * char数组转byte数组
     *
     * @param chars
     * @param charset
     * @return
     */
    public static byte[] getBytes(char[] chars, String charset) {
        Charset cs = Charset.forName(charset);
        CharBuffer cb = CharBuffer.allocate(chars.length);
        cb.put(chars);
        cb.flip();
        ByteBuffer bb = cs.encode(cb);

        return bb.array();
    }

    /**
     * byte数组转char数组
     *
     * @param bytes
     * @param charset
     * @return
     */
    public static char[] getChars(byte[] bytes, String charset) {
        Charset cs = Charset.forName(charset);
        ByteBuffer bb = ByteBuffer.allocate(bytes.length);
        bb.put(bytes);
        bb.flip();
        CharBuffer cb = cs.decode(bb);

        return cb.array();
    }
    //---------------------short 和 byte[]的相互转换------------------

    /**
     * short 转byte[2]
     *
     * @param s short
     * @return byte[]
     */
    private static byte[] short2Byte(short s) {
        byte[] shortBuf = new byte[2];
        for (int i = 0; i < 2; i++) {
            int offset = (shortBuf.length - 1 - i) * 8;
            shortBuf[1 - i] = (byte) ((s >>> offset) & 0xff);
        }
        return shortBuf;
    }

    /**
     * byte[2] 转short
     *
     * @param res byte[]
     * @return Short
     */
    private static Short byte2Short(byte[] res) {
        if (res.length != 2) {
            return null;
        }
        return (short) ((res[0] & 0xff) | ((res[1] << 8) & 0xff00)); // | 表示安位或
    }

    /**
     * res[start],res[start+1] 转short
     *
     * @param res byte[]
     * @return Short
     */
    public static Short byte2Short(byte[] res, int start) {
        if ((res.length - start) < 2) {
            return null;
        }
        return (short) ((res[start] & 0xff) | ((res[start + 1] << 8) & 0xff00));
    }
}
