package com.newlecture;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.newlecture.ui.ExamConsole;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException
    {
    	//GridExamConsole console = new GridExamConsole();
    	Properties properties = new Properties();
    	FileInputStream fis = new FileInputStream("app.properties");
    	properties.load(fis);
    	ExamConsole console = (ExamConsole)Class.forName(properties.getProperty("console")).newInstance();
        console.input();
        console.print();
    }
}
