package com.codepath.example.tipcalculator;

import java.util.Locale;
import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	public EditText etTotal;
	public TextView tvTip;
	private double _currentPercentage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		etTotal = (EditText) findViewById(R.id.etTotal);
		tvTip = (TextView) findViewById(R.id.tvTip);
		
		etTotal.addTextChangedListener(new TextWatcher() {
			@Override
		    public void onTextChanged(CharSequence s, int start, int before, int count) {
		        // Fires right as the text is being changed (even supplies the range of text)
		    }

		    @Override
		    public void beforeTextChanged(CharSequence s, int start, int count,
		            int after) {
		        // Fires right before text is changing
		    }

		    @Override
		    public void afterTextChanged(Editable s) {
		        // Fires right after the text has changed
		    	if (_currentPercentage != 0.0)
		    	{
		    		calculateValue(_currentPercentage);
		    	}
		    }
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calc, menu);
		return true;
	}
	
	public void calculateValue(double percentage)
	{
		_currentPercentage = percentage;
		String fieldValue = etTotal.getText().toString();
		if (!fieldValue.isEmpty())
		{
			double total = Double.parseDouble(fieldValue);
			total *= percentage;
			// convert total to currency format
			String formattedTip = String.format(Locale.getDefault(), "$%.2f", total);
			tvTip.setText(formattedTip);
		}
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
