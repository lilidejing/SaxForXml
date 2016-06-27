package com.zte.sax;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.zte.entity.Userinfo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Activity01 extends Activity {
   
	EditText txtName;
	EditText txtNo;
	EditText txtSex;
	EditText txtEmail;
	EditText txtAge;
	Button btnStart;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        txtName=(EditText)this.findViewById(R.id.txtName);
        txtNo=(EditText)this.findViewById(R.id.txtNo);
        txtSex=(EditText)this.findViewById(R.id.txtSex);
        txtAge=(EditText)this.findViewById(R.id.txtAge);
        txtEmail=(EditText)this.findViewById(R.id.txtEmail);
        btnStart=(Button)this.findViewById(R.id.button1);
        btnStart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 SAXParserFactory spf=SAXParserFactory.newInstance();
			        try {
						SAXParser sp=spf.newSAXParser();
						XmlPaser xmlPar=new XmlPaser();
						InputStream is=this.getClass().getClassLoader().getResourceAsStream("user.xml");
						sp.parse(is, xmlPar);
						Userinfo user=xmlPar.getUser();
						
						txtName.setText(user.getUsername());
						txtSex.setText(user.getSex());
						txtAge.setText(String.valueOf(user.getAge()));
						txtEmail.setText(user.getEmail());
						txtNo.setText(user.getStuNo());
						System.out.println("id:  "+user.getUid());
						
						
						
						
						
					} catch (ParserConfigurationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SAXException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
       
    }
}