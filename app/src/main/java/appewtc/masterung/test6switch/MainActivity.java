package appewtc.masterung.test6switch;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ToggleButton;

import ioio.lib.api.DigitalOutput;
import ioio.lib.api.exception.ConnectionLostException;
import ioio.lib.util.BaseIOIOLooper;
import ioio.lib.util.android.IOIOActivity;

public class MainActivity extends IOIOActivity {

    //Explicit
    private ToggleButton oneToggleButton, twoToggleButton, threeToggleButton,
            fourToggleButton, fiveToggleButton, sixToggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initial Widget
        initialWidget();

    }   // onCreate

    private void initialWidget() {
        oneToggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        twoToggleButton = (ToggleButton) findViewById(R.id.toggleButton2);
        threeToggleButton = (ToggleButton) findViewById(R.id.toggleButton3);
        fourToggleButton = (ToggleButton) findViewById(R.id.toggleButton4);
        fiveToggleButton = (ToggleButton) findViewById(R.id.toggleButton5);
        sixToggleButton = (ToggleButton) findViewById(R.id.toggleButton6);
    }   // initialWidget

    private class Looper extends BaseIOIOLooper {

        //Explicit
        private DigitalOutput oneDigitalOutput, twoDigitalOutput, threeDigitalOutput,
                fourDigitalOutput, fiveDigitalOutput, sixDigitalOutput;

        @Override
        protected void setup() throws ConnectionLostException, InterruptedException {
            super.setup();
        }   // setup

        @Override
        public void loop() throws ConnectionLostException, InterruptedException {
            super.loop();
        }   //loop
        
    }   // Looper Class

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}   // Main Class
