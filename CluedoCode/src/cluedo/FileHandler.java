package cluedo;

import java.io.*;
import java.util.*;

public class FileHandler {
	BufferedWriter fileWriter;
	BufferedReader fileReader;
	PrintWriter clear;
	ArrayList<String> data = new ArrayList<String>();
	
	
	public void createNewFile(String fileName, boolean appendable) {
		try {
			fileWriter = new BufferedWriter(new FileWriter(fileName + "saveGame.txt", appendable));
			fileReader = new BufferedReader(new FileReader(fileName + "saveGame.txt"));
		}catch(Exception e) {
			System.out.println("Could not create file");
			e.printStackTrace();
		}
	}
	
	public void clear(String fileName) {
		try {
			clear = new PrintWriter(fileName + "saveGame.txt");
			clear.write("");
			
			clear.close();
		}catch(Exception e) {
			System.out.println("Could not clear file");
			e.printStackTrace();
		}
	}
	
	public void write(String data) {
		try {			
			fileWriter.write(data + "\n");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void append(String data) {
		try {
			fileWriter.append(data + "\n");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void writerClose() {
		try {
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void readerClose() {
		try {
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void read() {
		
		try {
			String currentLine;
			while((currentLine = fileReader.readLine()) != null){
				data.add(currentLine);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public int getLength() {
		int count = 0;
		try {
			String currentLine;
			while((currentLine = fileReader.readLine()) != null){
				data.add(currentLine);
				count++;
			}
			return count;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	

	public ArrayList<String> getData() {
		return data;
	}
}
