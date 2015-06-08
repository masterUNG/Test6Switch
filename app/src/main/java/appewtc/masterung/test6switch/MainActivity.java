package appewtc.masterung.test6switch;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.ToggleButton;

import ioio.lib.api.DigitalOutput;
import ioio.lib.api.exception.ConnectionLostException;
import ioio.lib.util.BaseIOIOLooper;
import ioio.lib.util.IOIOLooper;
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
            //super.setup();
            oneDigitalOutput = ioio_.openDigitalOutput(1, false);
            twoDigitalOutput = ioio_.openDigitalOutput(2, false);
            threeDigitalOutput = ioio_.openDigitalOutput(3, false);
            fourDigitalOutput = ioio_.openDigitalOutput(4,false);
            fiveDigitalOutput = ioio_.openDigitalOutput(5, false);
            sixDigitalOutput = ioio_.openDigitalOutput(6, false);

            //Check Connected
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MainActivity.this, "Connected IOIO Board OK", Toast.LENGTH_SHORT).show();
                }   //event
            });

        }   // setup

        @Override
        public void loop() throws ConnectionLostException, InterruptedException {
            //super.loop();
            oneDigitalOutput.write(oneToggleButton.isChecked());
            twoDigitalOutput.write(twoToggleButton.isChecked());
            threeDigitalOutput.write(threeToggleButton.isChecked());
            fourDigitalOutput.write(fourToggleButton.isChecked());
            fiveDigitalOutput.write(fiveToggleButton.isChecked());
            sixDigitalOutput.write(sixToggleButton.isChecked());

            //Cannot Connected Board
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }   //loop

    }   // Looper Class

    protected IOIOLooper createIOIOLooper() {

        return new Looper();
    }   // createIOIOLooper

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
