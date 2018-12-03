package majapp.anamnestickydotaznik;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Questionnaire
{
    protected LinearLayout layout;
    protected Activity activity;
    protected List<QuestionnaireItem> questionnaireItems;
    protected StringBuilder resultBuilder;
    private String fileName = "questionnaire.txt";

    public Questionnaire(Activity activity, LinearLayout layout)
    {
        this.activity = activity;
        this.layout = layout;

        questionnaireItems = new ArrayList<QuestionnaireItem>();
        resultBuilder =  new StringBuilder();
    }

    public void Build()
    {
        for (int i = 0; i < questionnaireItems.size(); i++ )
        {
            QuestionnaireItem item = questionnaireItems.get(i);
            item.AddToLayout();
        }
    }

    public void Evaluate()
    {
        for (QuestionnaireItem item: questionnaireItems)
        {
            String question = item.GetQuestion();
            String answer = item.GetAnswer();

            resultBuilder.append(question + " | " + answer + System.getProperty("line.separator"));
        }
    }

    public String GetResult()
    {
        return resultBuilder.toString();
    }

    public String GetFileName()
    {
        return activity.getApplicationContext().getFileStreamPath(fileName).getPath();
//        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS) + "/" + fileName;
    }

    public Boolean WriteToFile()
    {
        BufferedWriter output = null;
        try
        {
            File file = new File(GetFileName());
            output = new BufferedWriter(new FileWriter(file));
            output.write(GetResult());

            if (output != null)
                output.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return true;
    }
}
