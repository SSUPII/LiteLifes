package ssupii.concept.litelifes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout historyView;
    ScrollView historyScroll;

    GameData gameData = new GameData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){e.printStackTrace();}

        historyView = (LinearLayout) findViewById(R.id.historyView);
        historyScroll = (ScrollView) findViewById(R.id.history);

        historyView.addView(createTitleText("Year "+gameData.getGameYear()));
        historyView.addView(createEventMainText("You are "+gameData.getName()+", born in "+gameData.getCountryName()+"."));
        historyView.addView(createEventDescriptionText("This is short."));
        historyView.addView(createEventDescriptionText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
    }

    public void onAgeButtonPressed(View view){
        gameData.nextYear();

        historyView.addView(createTitleText("Year "+gameData.getGameYear()+" - You are "+gameData.getAge()));
        historyView.addView(createPlaceholderEventMainText());
        historyScroll.post(new Runnable() {
            @Override
            public void run() {
                historyScroll.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
    }

    private TextView createTitleText(String text){
        TextView newEvent = createEventMainText(text);
        newEvent.setTypeface(Typeface.DEFAULT_BOLD);
        return newEvent;
    }

    private TextView createEventMainText(String text){
        TextView newEvent = new TextView(this);

        //Finalize TextView
        newEvent.setText(text);
        LinearLayout.LayoutParams params = createTextMarginParams(10);
        if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) params.setMarginStart(10);
        newEvent.setLayoutParams(params);
        return newEvent;
    }

    private TextView createEventDescriptionText(String text){
        TextView newEvent = new TextView(this);

        //Finalize TextView
        newEvent.setText(text);
        LinearLayout.LayoutParams params = createTextMarginParams(10,0,0,10);
        if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) params.setMarginStart(10);
        newEvent.setLayoutParams(params);
        return newEvent;
    }

    private TextView createPlaceholderTitleText(){
        return createTitleText(getResources().getString(R.string.placeholder));
    }

    private TextView createPlaceholderEventMainText(){
        return createEventMainText(getResources().getString(R.string.placeholder));
    }

    private LinearLayout.LayoutParams createTextMarginParams(int size){
        return createTextMarginParams(size,size,size,size);
    }

    private LinearLayout.LayoutParams createTextMarginParams(int left, int top, int right, int bottom){
        //Set content wrapping
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        //Set margin of Text in dp
        final float scale = getBaseContext().getResources().getDisplayMetrics().density;
        final int marginSizeLeft = (int) (left * scale + 0.5f);
        final int marginSizeTop = (int) (top * scale + 0.5f);
        final int marginSizeRight = (int) (right * scale + 0.5f);
        final int marginSizeBottom = (int) (bottom * scale + 0.5f);
        params.setMargins(marginSizeLeft,marginSizeTop,marginSizeRight,marginSizeBottom);
        //DEBUG
        Toast.makeText(this,marginSizeLeft+" "+marginSizeTop+" "+marginSizeRight+" "+marginSizeBottom,Toast.LENGTH_SHORT).show();
        return params;
    }
}