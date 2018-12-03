package majapp.anamnestickydotaznik;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {

    private EntryQuestionnaire questionnaire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layout = this.findViewById(R.id.scrollLinearLayout);

        questionnaire = new EntryQuestionnaire(this, layout);
        questionnaire.Build();

        Button sendButton = new Button(this);
        sendButton.setText("Odoslať");
        sendButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                SendEmail();
            }
        });
        layout.addView(sendButton);

        ScrollView sv = this.findViewById(R.id.mainScrollView);
        sv.invalidate();
        sv.requestLayout();
    }

    private void SendEmail()
    {
        questionnaire.Evaluate();

        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("Prebieha odosielanie dotazníku");
        dialog.setMessage("Prosím počkajte");
        dialog.show();

        Context context = this;
        CharSequence text = "Boli zadané nesprávne emailové údaje!";
        int duration = LENGTH_LONG;
        final Toast toast = Toast.makeText(context, text, duration);

        Thread sender = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    EmailSender sender = new EmailSender("timotej.matak@gmail.com", "5vcj1hqb4xgmail");
                    if(questionnaire.WriteToFile())
                        sender.addAttachment(questionnaire.GetFileName());

                    sender.sendMail("Test email",
                            questionnaire.GetResult(),
                            "timotej.matak@gmail.com",
                            "timotej.matak@gmail.com");
                    dialog.dismiss();
                } catch (javax.mail.AuthenticationFailedException e) {
                    Log.e("mylog", "Error: " + e.getMessage());
                    dialog.dismiss();
                    toast.show();
                }
                catch (Exception e) {
                    Log.e("mylog", "Error: " + e.getMessage());
                    dialog.dismiss();
                }
            }
        });
        sender.start();
    }
}
