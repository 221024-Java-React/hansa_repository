package com.revature.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//I want this to be a general purpose file io class, and be able to write any type of data
public class FileIO<T> {
	
	private String filename;
	
	public FileIO(String filename) {
		this.filename = filename;
	}
	
	//Now lets read the object back from the file
	public T readObject(){
		T ret;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			ret = (T) ois.readObject();
			return ret;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("No one has written to the file yet");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	//Lets first allow ourselves to write to a file
	public void writeObject(T object) {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filename));
			oos.writeObject(object);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}