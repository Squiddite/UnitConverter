package net.squiddite.unitconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.Console;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinnerFromUnit = (Spinner) findViewById( R.id.spinnerFromUnit );
        Spinner spinnerToUnit = (Spinner) findViewById( R.id.spinnerToUnit );
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource( this, R.array.units_array, android.R.layout.simple_spinner_dropdown_item );
        spinnerFromUnit.setAdapter( adapter );
        spinnerToUnit.setAdapter( adapter );

        doListenerSetup();
        ArrayList<String> a = new ArrayList<String>();
        a.add( UnitEnum.FOOT.toString() );
        Boolean x1 = a.contains( "FOOT" );
        Boolean x2 = a.contains( UnitEnum.FOOT.toString() );

        try {
            Unit foot = new Meter( 1.0 );
            Enum test1 = UnitEnum.FOOT;
            Enum test2 = UnitEnum.POUND;
            Unit newUnit = foot.convertTo( UnitEnum.INCH.toString() );
            Boolean found1 = foot.isClassMember( test1.toString() );
            Boolean found2 = foot.isClassMember( test2.toString() );
            Boolean found3 = foot.isClassMember( (String) "Pizza" );
            Boolean found4 = foot.isClassMember( UnitEnum.KILOGRAM.toString() );
            Boolean found5 = foot.isClassMember( "FOOT" );
            String info = foot.getName();
            String info1 = newUnit.getName();
            foot.isMetric();
            newUnit.isMetric();
            foot.set( 5.0 );
            Number n = foot.get();
        } catch( Exception e ) {
            int i = 1;
        }

        Unit f = new Foot();
        f.set( 5.0 );
        //String s = Foot.UnitClassMemberEnum.METER.toString();
        //f.convertTo( Foot.UnitClassMemberEnum.METER.toString() );
        Unit m = new Meter();

        Boolean xcc = test( UnitClassEnum.LENGTH );


    }

    public Boolean test( UnitClassEnum e ) {
        if( e == UnitClassEnum.LENGTH ) { return true; } else { return false; }
    }

    public void doListenerSetup() {
        EditText fromAmountView = (EditText) findViewById( R.id.fromAmount );
        final TextView toAmountView = (TextView) findViewById( R.id.toAmountFast );

        fromAmountView.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Double input = Double.parseDouble( s.toString() );
                String output = reformat( calculate( input ));

                toAmountView.setText( output );
            }
            public void afterTextChanged(Editable s) {}
        });
    }

    public void convertAmount( View view ) {
        String input, output;
        Double fromAmount;

        // bind views and grab value
        EditText fromAmountView = (EditText) findViewById( R.id.fromAmount );
        TextView toAmountView = (TextView) findViewById( R.id.toAmountSlow );

        input = (String) fromAmountView.getText().toString();
        fromAmount = Double.parseDouble( input );

        output = reformat( calculate( fromAmount ));
        toAmountView.setText( output );
    }

    public Double calculate( Double value ) {
        Double output = value / 12;
        return output;
    }

    public String reformat( Double value ) {
        // http://stackoverflow.com/questions/153724/how-to-round-a-number-to-n-decimal-places-in-java
        DecimalFormat df = new DecimalFormat( "#.####" );
        df.setRoundingMode(RoundingMode.CEILING );

        String output = df.format( value );
        return output;
    }
}
