package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
	
	public static final Random RANDOM = new Random();
	private Button rollDices1, rollDices2;
	private ImageView imageView1, imageView2;
	private TextView message;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		rollDices1 = (Button) findViewById(R.id.rollDices1);
		rollDices2 = (Button) findViewById(R.id.rollDices2);
		imageView1 = (ImageView) findViewById(R.id.imageView1);
		imageView2 = (ImageView) findViewById(R.id.imageView2);
		message = (TextView) findViewById(R.id.message);
		
		rollDices1.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view) {
				int value1 = randomDiceValue();
				int value2 = randomDiceValue();

				int res1 = getResources().getIdentifier("dice_" + value1, "drawable", "com.example.myapplication");
				int res2 = getResources().getIdentifier("dice_" + value2, "drawable", "com.example.myapplication");
				
				switch(view.getId()) {
				case R.id.rollDices1:
					if(value1 > value2) {
						message.setText("User wins");
						break;
					}
					else if (value2 > value1) {
						message.setText("Computer Wins");
						break;
					}
					else
						message.setText("Its a Tie ");

				}
		
				imageView1.setImageResource(res1);
				imageView2.setImageResource(res2);
				
			}
			
	
		});
		
		rollDices2.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view) {
				int value1 = randomDiceValue();
				int value2 = randomDiceValue();
				
				int res1 = getResources().getIdentifier("dice_" + value1, "drawable", "com.example.myapplication");
				int res2 = getResources().getIdentifier("dice_" + value2, "drawable", "com.example.myapplication");
				
				switch(view.getId()) {
	
					case R.id.rollDices2:
						if(value2 > value1) {
							message.setText("User wins");
							break;
						}
						else if (value1 > value2) {
							message.setText("Computer Wins");
							break;
						}
						else
							message.setText("Its a Tie ");
				}
				
				imageView1.setImageResource(res1);
				imageView2.setImageResource(res2);
				
			}
			
	
		});
		

	}
	
	public static int randomDiceValue() {
		return RANDOM.nextInt(6) + 1;
	}

	
}

