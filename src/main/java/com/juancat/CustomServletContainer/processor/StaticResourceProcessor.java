package com.juancat.CustomServletContainer.processor;

import com.juancat.CustomServletContainer.request.Request;
import com.juancat.CustomServletContainer.response.Response;
import com.juancat.CustomServletContainer.utils.Constants;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.*;

public class StaticResourceProcessor {

    private static final int BUFFER_SIZE = 2048;

    public void process(Request request, Response response) throws IOException {
        byte[] bytes = new byte[BUFFER_SIZE];
        FileInputStream fis = null;
        ServletOutputStream tmpOutputStream = response.getOutputStream();

        try {
            int readedBytes = 0;

            File file = new File(Constants.WEB_ROOT, request.getRequestURI());
            fis = new FileInputStream(file);
            int ch = fis.read(bytes, 0, BUFFER_SIZE);
            while (ch!=-1) {
                readedBytes += ch;
                tmpOutputStream.write(bytes, 0, ch);
                ch = fis.read(bytes, 0, BUFFER_SIZE);
            }

            response.setContentLength(readedBytes);
        }

        catch (FileNotFoundException e) {
            tmpOutputStream.write("<h1>File Not Found</h1>".getBytes());
        }
        finally {
            if (fis!=null)
                fis.close();
        }

    }
}
