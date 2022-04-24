package com.lpy.demo.service;

import java.io.UnsupportedEncodingException;

public interface AdventureService {
    Object searchAdventure(String server,String zoom,String name) throws UnsupportedEncodingException;
    public String urlAssembleTest(String server, String zoom, String name) throws UnsupportedEncodingException;
    public String urlASS(String server, String zoom, String name) throws UnsupportedEncodingException;
}
