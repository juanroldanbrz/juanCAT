package com.juancat.CustomServletContainer.streams;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Usuario on 06/04/2017.
 */
public class BasicServletOutputStream extends ServletOutputStream {
    OutputStream outputStream;

    public BasicServletOutputStream(OutputStream outputStream){
        this.outputStream = outputStream;
    }

    public boolean isReady() {
        return false;
    }

    public void setWriteListener(WriteListener writeListener) {

    }

    public void write(int b) throws IOException {
        outputStream.write(b);
    }
}
