package com.codepath.example.tipcalculator;

import java.util.Locale;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	public EditText etTotal;
	public TextView tvTip;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		etTotal = (EditText) findViewById(R.id.etTotal);
		tvTip = (TextView) findViewById(R.id.tvTip);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calc, menu);
		return true;
	}
	
	public void calculateValue(double percentage)
	{
		String fieldValue = etTotal.getText().toString();
		double total = Double.parseDouble(fieldValue);
		total *= percentage;
		// convert total to currency format
		String formattedTip = String.format(Locale.getDefault(), "$%.2f", total);
		tvTip.setText(formattedTip);
	}
	
	public void onSubmit10(View v)
	{
		double percentage = 0.1d;
		calculateValue(percentage);
	}
	
	public void onSubmit15(View v)
	{
		double percentage = 0.15d;
		calculateValue(percentage);
	}
	
	public void onSubmit20(View v)
	{
		double percentage = 0.2d;
		calculateValue(percentage);
	}

}
