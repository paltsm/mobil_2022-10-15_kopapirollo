package com.example.kopapirollo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
	private ImageView en_kep, gep_kep;
	private TextView TextEredmeny;
	private Button buttonKo, buttonPapir, buttonOllo;
	private int en, robot;//dontesek
	private int nyer,veszt,dontetlen;//eredmenyek
	private Toast uzenet;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		buttonKo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				en_kep.setImageResource(R.drawable.rock);
				en=0;
				jatek();
			}
		});
		buttonPapir.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				en_kep.setImageResource(R.drawable.paper);
				en=1;
				jatek();
			}
		});
		buttonOllo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				en_kep.setImageResource(R.drawable.scissors);
				en=2;
				jatek();
			}
		});
	}

	private void jatek(){
		robotKep();
		switch (en-robot){
			case -2:
				nyer++;
				Toast.makeText("nyertél");
				break;
			case -1:
				veszt++;
				break;
			case 0:
				dontetlen++;
				break;
			case 1:
				nyer++;
				break;
			case 2:
				veszt++;
				break;
		}
		TextEredmeny.setText("eredmeny: ember: " + nyer + " computer: "+veszt);

	}
	private void robotKep(){
		Random random=new Random();
		robot=random.nextInt(3);
		if(robot==0){
			gep_kep.setImageResource(R.drawable.rock);
		}else if(robot==1){
			gep_kep.setImageResource(R.drawable.paper);
		}else{
			gep_kep.setImageResource(R.drawable.scissors);
		}
	}
	private void init() {
		en_kep = findViewById(R.id.en_kep);
		gep_kep = findViewById(R.id.gep_kep);
		TextEredmeny = findViewById(R.id.TextEredmeny);
		buttonKo = findViewById(R.id.buttonKo);
		buttonPapir = findViewById(R.id.buttonPapir);
		buttonOllo = findViewById(R.id.buttonOllo);

	}
}