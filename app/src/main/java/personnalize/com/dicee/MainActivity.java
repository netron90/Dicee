package personnalize.com.dicee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button rollDicee;
    private ImageView leftDice, rightDice;
    private TextView numberDice, textDice;
    private int numberOne = 0, numberTwo = 0, numberTotal = 0;
    private String str1, str2, str3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leftDice = findViewById(R.id.leftDice);
        rightDice = findViewById(R.id.rightDice);
        numberDice = findViewById(R.id.dice_number);
        textDice = findViewById(R.id.dice_text);
        rollDicee = findViewById(R.id.roll_dicee);

        //-------------- Array that containt dicee image -------------

        str1 = getString(R.string.dice_text1);
        str2 = getString(R.string.dice_text2);
        str3 = getString(R.string.dice_text3);

        final int[] diceeArray = {
                R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6};

        //-------------- Array that containt result dicee text -------------

        final String []  diceTextArray = {

                str1,
                str2,
                str3
        } ;

        rollDicee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //-------------- Generate random number - Random Class -------------

                numberOne = 0;
                numberTwo = 0;
                numberTotal = 0;

                Random randomGenerator = new Random();
                int numberGenerate = randomGenerator.nextInt(6);
                numberOne = checkNumber(numberGenerate);
                leftDice.setImageResource(diceeArray[numberGenerate]);
                numberGenerate = randomGenerator.nextInt(6);
                numberTwo = checkNumber(numberGenerate);
                Log.d("ResultaDice", "Resultat: "+ numberOne + " et "+ numberTwo);
                rightDice.setImageResource(diceeArray[numberGenerate]);

                numberTotal = numberOne + numberTwo;
                numberDice.setText(String.valueOf(numberTotal));
                if (numberTotal < 5)
                {
                    textDice.setText(String.valueOf(diceTextArray[0]));
                }
                else if(numberTotal >= 5 && numberTotal < 10)
                {
                    textDice.setText(String.valueOf(diceTextArray[1]));
                }
                else {
                    textDice.setText(String.valueOf(diceTextArray[2]));
                }

            }
        });
    }
    public int checkNumber(int number)
    {
        int returnNumber = 0;
        int compt = 0;

        if(number == 0)
        {
            returnNumber = 0 + 1;
        }
        else if (number == 1)
        {
            returnNumber = 1 + 1;
        }
        else if (number == 2)
        {
            returnNumber = 2 + 1;
        }
        else if (number == 3)
        {
            returnNumber = 3 + 1;
        }
        else if (number == 4)
        {
            returnNumber = 4 + 1;
        }
        else if (number == 5)
        {
            returnNumber = 5 + 1;
        }
        else if (number == 6)
        {
            returnNumber = 6 + 1;
        }
        return returnNumber;
    }
}
