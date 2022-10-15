package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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
	private int nyer, veszt, dontetlen;//eredmenyek
	private String uzenet;
	private AlertDialog.Builder vege_alert;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		buttonKo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				en_kep.setImageResource(R.drawable.rock);
				en = 0;
				Jatek();
			}
		});
		buttonPapir.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				en_kep.setImageResource(R.drawable.paper);
				en = 1;
				Jatek();
			}
		});
		buttonOllo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				en_kep.setImageResource(R.drawable.scissors);
				en = 2;
				Jatek();
			}
		});
	}

	private void Jatek() {
		robotKep();
		if (en - robot == -2 || en - robot == 1) {
			nyer++;
			uzenet = "te nyertél";
		} else if (en - robot == 0) {
			dontetlen++;
			uzenet = "döntetlen";
		} else {
			veszt++;
			uzenet = "gép nyert";
		}
		Toast.makeText(MainActivity.this, uzenet, Toast.LENGTH_SHORT).show();
		TextEredmeny.setText("eredmény: ember: " + nyer + " computer: " + veszt);
		if(nyer>2||veszt>2){
			if ((nyer > veszt)) {
				vege_alert.setTitle("győzelem");
				vege_alert.show();
			} else {
				vege_alert.setTitle("vereség");
				vege_alert.show();
			}
		}
	}


	private void robotKep() {
		Random random = new Random();
		robot = random.nextInt(3);
		if (robot == 0) {
			gep_kep.setImageResource(R.drawable.rock);
		} else if (robot == 1) {
			gep_kep.setImageResource(R.drawable.paper);
		} else {
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
		vege_alert = new AlertDialog.Builder(MainActivity.this);

		vege_alert.setCancelable(false).setTitle("neyert").setMessage("szeretne új játékot játszani?").setNegativeButton("nem", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialogInterface, int i) {
				finish();
			}
		}).setPositiveButton("igen", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialogInterface, int i) {
				ujJatek();
			}
		}).create();
	}
	private void ujJatek(){
		nyer=0;
		veszt=0;
		dontetlen=0;
		TextEredmeny.setText("eredmény: ember: " + nyer + " computer: " + veszt);
	}
}