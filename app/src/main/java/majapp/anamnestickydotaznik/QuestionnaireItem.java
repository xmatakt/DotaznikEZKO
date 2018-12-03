package majapp.anamnestickydotaznik;

import android.content.Context;
import android.text.Layout;
import android.view.Gravity;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuestionnaireItem
{
    private int idAddition = 132;

    private int id;
    private QuestionnaireItemType type;
    private TextView labelTextView;
    private EditText editText;
    private RadioGroup radioGroup;
    private RadioButton[] radioButtons;
    private CheckBox[] checkBoxes;

    private LinearLayout layout;
    private Context context;
    private String[] fields;

    public QuestionnaireItem(LinearLayout layout, String label, float size)
    {
        this.layout = layout;
        this.context = layout.getContext();

        InitializeLabel(label, size);
    }

    public QuestionnaireItem(LinearLayout layout, String label, int id, QuestionnaireItemType type, String[] fields)
    {
        this.id = id;
        this.layout = layout;
        this.context = layout.getContext();
        this.type = type;
        this.fields = fields;

        InitializeLabel(label);
        InitializeItem();
    }

    public void AddToLayout()
    {
        if(labelTextView != null)
            layout.addView(labelTextView);
        if(editText != null)
            layout.addView(editText);
        if(radioGroup != null)
            layout.addView(radioGroup);
        if(checkBoxes != null)
        {
            for (int i = 0; i < checkBoxes.length; i++)
                layout.addView(checkBoxes[i]);
        }
    }

    public String GetQuestion()
    {
        String result = "";
        if(labelTextView != null)
            result = labelTextView.getText().toString();

        return result;
    }

    public String GetAnswer()
    {
        String result = "";
        switch(type)
        {
            case EditTextItem:
                result = editText.getText().toString();
                break;
            case CheckBoxItem:
                for (int i = 0; i < checkBoxes.length; i++)
                {
                    if(checkBoxes[i].isChecked())
                        result += checkBoxes[i].getText().toString() + "; ";
                }
                break;
            case RadioGroupItem:
                for (int i = 0; i < radioButtons.length; i++)
                {
                    if(radioButtons[i].isChecked())
                    {
                        result = radioButtons[i].getText().toString();
                        break;
                    }
                }
                break;
            default:
                break;
        }

        return result;
    }


    private void InitializeItem()
    {
        switch(type)
        {
            case EditTextItem:
                editText = new EditText(context);
                editText.setHint("Zadajte Vašu odpoveď...");
                editText.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                break;
            case CheckBoxItem:
                checkBoxes = new CheckBox[fields.length];
                for (int i = 0; i < fields.length; i++)
                {
                    checkBoxes[i] = new CheckBox(context);
                    checkBoxes[i].setText(fields[i]);
                }
                break;
            case RadioGroupItem:
                radioButtons = new RadioButton[fields.length];
                radioGroup = new RadioGroup(context);
                radioGroup.setOrientation(RadioGroup.VERTICAL);
                for (int i = 0; i < fields.length; i++)
                {
                    radioButtons[i] = new RadioButton(context);
                    radioButtons[i].setText(fields[i]);
                    radioGroup.addView(radioButtons[i]);
                }
                break;
            default:
                break;
        }
    }

    private void InitializeLabel(String label)
    {
        labelTextView = new TextView(context);
        labelTextView.setTextSize(18f);
        labelTextView.setText(label);
        labelTextView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
    }

    private void InitializeLabel(String label, float size)
    {
        labelTextView = new TextView(context);
//        labelTextView.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
        labelTextView.setText(label);
        labelTextView.setTextSize(size);
        labelTextView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        labelTextView.setPadding(5, 5, 5,10);
        labelTextView.setGravity(Gravity.CENTER_HORIZONTAL);
    }
}
