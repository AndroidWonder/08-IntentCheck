//Using onStart() allows multiple attempts. If we only relied on onCreate(),
//the app couldn't restart when only stopped. Do you see why?

package com.course.example.intentcheck;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import android.content.Intent;

public class IntentCheckActivity extends Activity {

	//set a request code number to identify a particular request
	public static final int requestCode_235 = 235;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    @Override
    public void onStart(){
    	super.onStart();
    	Intent intent = new Intent(this, UIDemo.class);
        startActivityForResult(intent, requestCode_235);
    }

    	//listen for event of requested activity finishing
        @Override
    	protected void onActivityResult(int requestCode, 
    			                    int resultCode,  Intent data) {
    		super.onActivityResult(requestCode, resultCode, data);
   		
    			switch (requestCode){
    			case (requestCode_235): {
    							
    				if (resultCode == Activity.RESULT_OK) 
   					  		Toast.makeText(this, "Result OK", Toast.LENGTH_LONG).show();   					
    					else 
    						Toast.makeText(this, "Result NOT OK", Toast.LENGTH_LONG).show();				
    				break;
    			}
    			
    			default : Toast.makeText(this, "Not my problem", Toast.LENGTH_LONG).show();
    			}//switch
    		
    	}// onActivityResult
        
}