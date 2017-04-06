package com.juancat.CustomServletContainer.response;
import com.juancat.CustomServletContainer.request.Request;
import com.juancat.CustomServletContainer.streams.BasicServletOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Collection;
import java.util.Formatter;
import java.util.Locale;

public class Response implements HttpServletResponse{

    public String getCharacterEncoding() {
        return null;
    }

    public String getContentType() {
        return null;
    }

    private static final int BUFFER_SIZE = 1024;
    Request request;

    String contentType = "text/html";
    int contentLength = 0;

    OutputStream tmpOutputStream;
    OutputStream output;

    PrintWriter writer;

    public void commitResponse() throws IOException {
        Formatter formatter = new Formatter();
        String template = formatter.format("HTTP/1.1 200 OK \r\nContent-Type: %s\r\nContent-Length: %s\r\n\r\n%s",
                contentType, contentLength, tmpOutputStream.toString()).toString();
        output.write(template.getBytes());
        tmpOutputStream.flush();
        output.flush();
    }

    public Response(OutputStream output) {
        this.output = output;
        tmpOutputStream = new ByteArrayOutputStream();
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public ServletOutputStream getOutputStream() throws IOException {
        return new BasicServletOutputStream(tmpOutputStream);
    }

    public PrintWriter getWriter() throws IOException {
        writer = new PrintWriter(tmpOutputStream, true);
        return writer;
    }

    public void setCharacterEncoding(String s) {

    }

    public void setContentLength(int i) {
        this.contentLength = i;
    }

    public void setContentLengthLong(long l) {

    }

    public void setContentType(String s) {

    }

    public void setBufferSize(int i) {

    }

    public int getBufferSize() {
        return 0;
    }

    public void flushBuffer() throws IOException {

    }

    public void resetBuffer() {

    }

    public boolean isCommitted() {
        return false;
    }

    public void reset() {

    }

    public void setLocale(Locale locale) {

    }

    public Locale getLocale() {
        return null;
    }

    public void addCookie(Cookie cookie) {

    }

    public boolean containsHeader(String s) {
        return false;
    }

    public String encodeURL(String s) {
        return null;
    }

    public String encodeRedirectURL(String s) {
        return null;
    }

    public String encodeUrl(String s) {
        return null;
    }

    public String encodeRedirectUrl(String s) {
        return null;
    }

    public void sendError(int i, String s) throws IOException {

    }

    public void sendError(int i) throws IOException {

    }

    public void sendRedirect(String s) throws IOException {

    }

    public void setDateHeader(String s, long l) {

    }

    public void addDateHeader(String s, long l) {

    }

    public void setHeader(String s, String s1) {

    }

    public void addHeader(String s, String s1) {

    }

    public void setIntHeader(String s, int i) {

    }

    public void addIntHeader(String s, int i) {

    }

    public void setStatus(int i) {

    }

    public void setStatus(int i, String s) {

    }

    public int getStatus() {
        return 0;
    }

    public String getHeader(String s) {
        return null;
    }

    public Collection<String> getHeaders(String s) {
        return null;
    }

    public Collection<String> getHeaderNames() {
        return null;
    }
}
