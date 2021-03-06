package person.calculator;

import android.os.Bundle; // for saving state information
import android.support.v7.app.AppCompatActivity; // base class
import android.text.Editable; // for EditText event handling
import android.text.TextWatcher; // EditText listener
import android.widget.EditText; // for bill amount input
import android.widget.SeekBar; // for changing the tip percentage
import android.widget.SeekBar.OnSeekBarChangeListener; // SeekBar listener
import android.widget.TextView; // for displaying text
import java.text.NumberFormat; // for currency formatting

public class MainActivity extends AppCompatActivity {

    private static final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percentFormat = NumberFormat.getPercentInstance();
    private TextView percentTextView; // shows tip percentage
    private TextView tipTextView; // shows calculated tip amount
    private TextView totalTextView; // shows calculated total bill amount
    private SeekBar percentSeekBar;
    EditText amountEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get references to programmatically manipulated TextViews

        percentTextView = (TextView) findViewById(R.id.percentTextView);
        tipTextView = (TextView) findViewById(R.id.tipTextView);
        totalTextView = (TextView) findViewById(R.id.totalTextView);
        tipTextView.setText(currencyFormat.format(0)); // set text to 0
        totalTextView.setText(currencyFormat.format(0)); // set text to 0

        // set amountEditText's TextWatcher
        amountEditText = (EditText) findViewById(R.id.amountEditText);
        amountEditText.addTextChangedListener(amountEditTextWatcher);

        // set percentSeekBar's OnSeekBarChangeListener
        percentSeekBar = (SeekBar) findViewById(R.id.percentSeekBar);
        percentSeekBar.setOnSeekBarChangeListener(seekBarListener);
    }

    // calculate and display tip
    private void calcTip() {

        double amount = Double.parseDouble(amountEditText.getText().toString());
        double percent = percentSeekBar.getProgress();
        double tip = amount * (percent / 100.0);

        percentTextView.setText(String.valueOf(percent)+"%");
        tipTextView.setText(String.valueOf(tip));

//        // calculate the tip and total
//        double tip = billAmount * percent;
//        double total = billAmount + tip;
//
//        // display tip and total formatted as currency
//        tipTextView.setText(currencyFormat.format(tip));
//        totalTextView.setText(currencyFormat.format(total));
    }

    // calculate and display tip and total amounts
    private void calcTotal() {

        double amount = Double.parseDouble(amountEditText.getText().toString());
        double percent = percentSeekBar.getProgress();
        double tip = amount * (percent / 100.0);
        double total = amount + tip;
        totalTextView.setText(String.valueOf(total));

        // calculate the tip and total
        //double tip = billAmount * percent;
        //double total = billAmount + tip;

        // display tip and total formatted as currency
        //tipTextView.setText(currencyFormat.format(tip));
        //totalTextView.setText(currencyFormat.format(total));
    }

    // listener object for the SeekBar's progress changed events
    private final OnSeekBarChangeListener seekBarListener = new OnSeekBarChangeListener() {
        // update percent, then call calculate
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            calcTip();
            calcTotal();

            //percent = progress / 100.0; // set percent based on progress

            //calculate(); // calculate and display tip and total
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    };

    // listener object for the EditText's text-changed events
    private final TextWatcher amountEditTextWatcher = new TextWatcher() {
        // called when the user modifies the bill amount
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                calcTip();
                calcTotal();
//                // get bill amount and display currency formatted value
//                billAmount = Double.parseDouble(s.toString()) / 100.0;
//                amountTextView.setText(currencyFormat.format(billAmount));
            } catch (Exception e) {
//                // if s is empty or non-numeric
//                amountTextView.setText("");
//                billAmount = 0.0;
            }

            //calculate(); // update the tip and total TextViews
        }

        @Override
        public void afterTextChanged(Editable s) {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
    };
}
