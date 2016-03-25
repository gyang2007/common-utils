package com.gyang.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class GZIPUtil {

    private static final Logger logger = LoggerFactory.getLogger(GZIPUtil.class);

    public static final int BUFFER = 1024;

    private GZIPUtil() {

    }

    public static byte[] compress(byte[] data) {

        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            compress(bais, baos);
            return baos.toByteArray();
        } catch (IOException e) {
            logger.error("", e);
        } finally {
            CloserUtil.close(bais, baos);
        }

        return null;
    }

    public static byte[] deCompress(byte[] data) {

        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            decompress(bais, baos);
            return baos.toByteArray();
        } catch (IOException e) {
            logger.error("", e);
        } finally {
            CloserUtil.close(bais, baos);
        }

        return null;
    }

    public static void compress(InputStream is, OutputStream os) throws IOException {

        GZIPOutputStream gos = null;

        try {
            gos = new GZIPOutputStream(os);

            int count;
            byte data[] = new byte[BUFFER];
            while ((count = is.read(data, 0, BUFFER)) != -1) {
                gos.write(data, 0, count);
            }

        } finally {
            CloserUtil.close(gos);
        }
    }

    public static void decompress(InputStream is, OutputStream os) throws IOException {

        GZIPInputStream gis = null;

        try {
            gis = new GZIPInputStream(is);

            int count;
            byte data[] = new byte[BUFFER];
            while ((count = gis.read(data, 0, BUFFER)) != -1) {
                os.write(data, 0, count);
            }
        } finally {
            CloserUtil.close(gis);
        }
    }
}
