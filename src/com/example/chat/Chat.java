package com.example.chat;


import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;
import android.content.Intent;

public class Chat extends ActionBarActivity {

	public final static String EXTRA_MESSAGE = "com.example.chat.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat);
messageButton(null);
		
	}
	
		private void messageButton(View v) {
			// TODO Auto-generated method stub
			Button messageButton = (Button) findViewById(R.id.button1);
			messageButton.setOnClickListener(new View.OnClickListener(){

				public void onClick(View v) {
					Toast.makeText(Chat.this, "Logged in!", Toast.LENGTH_LONG).show();
					
					
				
				Intent intent = new Intent(Chat.this, login.class);
				EditText editText = (EditText) findViewById(R.id.editText3);
				String message = editText.getText().toString();
				intent.putExtra(EXTRA_MESSAGE, message);
				startActivity(intent);
				}
				
			});
		}
		
	
	public void buttonClick(View v)
	{
		String temp;
		EditText input1 = (EditText)findViewById(R.id.editText1);
		temp = input1.getText().toString();
		TextView output = (TextView)findViewById(R.id.textView1);
		output.setText(temp);
		(new GetAnimalSoundTask()).execute(temp);
		
	//Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_SHORT).show();
	}

	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.chat, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	@SuppressWarnings("unchecked")
	private class GetAnimalSoundTask extends AsyncTask {

	        /**
	         * Let's make the http request and return the result as a String.
	         */
	        protected String doInBackground(Object... args) {
	                if(args != null && args[0] instanceof String) {
	                        String animal = (String) args[0];
	                        return ServerInterface.getAnimalSound(animal);
	                } else {
	                        return null;
	                }
	        }

	        /**
	         * Display the result as a Toast.
	         */
	        protected void onPostExecute(Object objResult) {
	                // check to make sure we're dealing with a string
	                if(objResult != null && objResult instanceof String) {                          
	                        String result = (String) objResult;
	                        TextView output = (TextView)findViewById(R.id.textView1);
	                		output.setText(result);
	                        
	                        
	                        //Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
	                }
	        }

	}

}
