package majapp.anamnestickydotaznik;

import android.app.Activity;
import android.widget.LinearLayout;

public class EntryQuestionnaire extends Questionnaire
{
    public EntryQuestionnaire(Activity activity, LinearLayout layout)
    {
        super(activity, layout);
        activity.setTitle("Vstupný formulár pred liečbou");
    }

    public void Build()
    {

        int id = 1000;

        QuestionnaireItem item = new QuestionnaireItem(layout, "Aké významnejšie zákroky v ústach Vám vykonali(vytrhnutie zubov, implantáty, korunky, vyberanie nervu/umŕtvenie zuba" +
                "prerezanie uzdičky a podobne)", id++, QuestionnaireItemType.EditTextItem, null);
        questionnaireItems.add(item);

        item = new QuestionnaireItem(layout, "Ako vnímate estetiku Vašich zubov na škále 1-10, kde 10 sú najškaredšie zuby, aké si viete predstaviť?", id++,
                QuestionnaireItemType.RadioGroupItem,
                new String[]
                        {
                                "1 - esteticky ideálny zhryz",
                                "2 - takmer ideálny",
                                "3 - sotva postrehnuteľné estetické nedostatky",
                                "4 - esteticky mierne rušivé",
                                "5 - hraničná estetická indikácia pre liečbu",
                                "6 - mierne rušivé pre laika",
                                "7 - viditeľne rušivé aj pre laika",
                                "8 - jasná estetická indikácia",
                                "9 - silná estetická indikácia",
                                "10 - najvyššia estetická potreba liečby"
                        });
        questionnaireItems.add(item);

        item = new QuestionnaireItem(layout, "Aké lieky aktuálne užívate?", id++, QuestionnaireItemType.EditTextItem, null);
        questionnaireItems.add(item);

        item = new QuestionnaireItem(layout, "Súrodenci/rodičia majú alebo mali krivé zuby?", id++, QuestionnaireItemType.EditTextItem, null);
        questionnaireItems.add(item);

        item = new QuestionnaireItem(layout, "Máte citlivé zuby napr. na studené/teplé/kyslé/sladnké nápoje?", id++, QuestionnaireItemType.EditTextItem, null);
        questionnaireItems.add(item);

        item = new QuestionnaireItem(layout, "Máte alergiu na nejaké kovy? (napr. začervenanie kože po náušniciach, prsteni)", id++, QuestionnaireItemType.CheckBoxItem, new String[]{"Áno"});
        questionnaireItems.add(item);

        item = new QuestionnaireItem(layout, "Máte alergiu na pele (sezónna nádcha)?)", id++, QuestionnaireItemType.CheckBoxItem, new String[]{"Áno"});
        questionnaireItems.add(item);

        item = new QuestionnaireItem(layout, "Aké zlozvyky máte pri stravovani? Napr. veľa kari/kurkumy,čaje,100% džúsy, červené víno...?", id++, QuestionnaireItemType.EditTextItem, null);
        questionnaireItems.add(item);

        item = new QuestionnaireItem(layout, "Čo je z Vášho pohľadu najvýznamnejší problém, pre ktorý ste sa rozhodli pre liečbu?", id++, QuestionnaireItemType.EditTextItem, null);
        questionnaireItems.add(item);

        item = new QuestionnaireItem(layout, "Aké pomôcky používate na osobnú ústnu hygienu?", id++, QuestionnaireItemType.EditTextItem, null);
        questionnaireItems.add(item);

        item = new QuestionnaireItem(layout, "Absolvovali ste liečbu strojčekom už v minulosti? Ak áno, približne akú a kedy?", id++, QuestionnaireItemType.EditTextItem, null);
        questionnaireItems.add(item);

        item = new QuestionnaireItem(layout, "Krvácajú Vám niekedy ďasná?", id++, QuestionnaireItemType.EditTextItem, null);
        questionnaireItems.add(item);

        item = new QuestionnaireItem(layout, "Ženy - Ste tehotná?", id++, QuestionnaireItemType.CheckBoxItem, new String[]{"Áno", "Nie"});
        questionnaireItems.add(item);

        item = new QuestionnaireItem(layout, "Pre aký hlavný problém ste vyhladali liečbu? (napr.\"vyrovnať hornú pravú trojku\" a pod.)?", id++, QuestionnaireItemType.EditTextItem, null);
        questionnaireItems.add(item);

        item = new QuestionnaireItem(layout, "Fajčenie", id++, QuestionnaireItemType.EditTextItem, null);
        questionnaireItems.add(item);

        item = new QuestionnaireItem(layout, "Podstúpili ste doteraz nejaký zákrok v nemocnici? Aké zákroky a kedy?", id++, QuestionnaireItemType.EditTextItem, null);
        questionnaireItems.add(item);

        item = new QuestionnaireItem(layout, "Mali ste niekedy žltačku/mononukleózu/herpes či iné infekčné ochorenie?", id++, QuestionnaireItemType.EditTextItem, null);
        questionnaireItems.add(item);

        item = new QuestionnaireItem(layout, "Akú liečbu strojčekom ste absolvovali v minulosti, a prečo zlyhala?", id++, QuestionnaireItemType.EditTextItem, null);
        questionnaireItems.add(item);

        item = new QuestionnaireItem(layout, "Máte niekde odbité zo zuba alebo škvrny na zube?", id++, QuestionnaireItemType.EditTextItem, null);
        questionnaireItems.add(item);

        item = new QuestionnaireItem(layout, "Kliká, puká či bolí vás čeľustný kĺb? Ktorý, ako, kedy?", id++, QuestionnaireItemType.EditTextItem, null);
        questionnaireItems.add(item);

        item = new QuestionnaireItem(layout, "Akými ochoreniami trpíte resp. ste nedávno prekonali? (napr. Choroby srdca,Reumatizmus,Alergie,Epilepsia,Cukrovka,HIV,AIDS,)Iné " +
                "vážne ochorenia? Osteoporóza,nádory?", id++, QuestionnaireItemType.EditTextItem, null);
        questionnaireItems.add(item);

        item = new QuestionnaireItem(layout, "Máte nejaké alergie?", id++, QuestionnaireItemType.EditTextItem, null);
        questionnaireItems.add(item);

        item = new QuestionnaireItem(layout, "S postavením svojich pier ste spokojný/a? (či ich chcete viac dopredu alebo dozadu)?", id++, QuestionnaireItemType.EditTextItem, null);
        questionnaireItems.add(item);

        item = new QuestionnaireItem(layout, "Váš email:", id++, QuestionnaireItemType.EditTextItem, null);
        questionnaireItems.add(item);

        item = new QuestionnaireItem(layout, "Vaše meno:", id++, QuestionnaireItemType.EditTextItem, null);
        questionnaireItems.add(item);

        item = new QuestionnaireItem(layout, "Vaše priezvisko:", id++, QuestionnaireItemType.EditTextItem, null);
        questionnaireItems.add(item);

        item = new QuestionnaireItem(layout, "Váš dátum narodenia:", id++, QuestionnaireItemType.EditTextItem, null);
        questionnaireItems.add(item);

        item = new QuestionnaireItem(layout, "Váš mobil:", id++, QuestionnaireItemType.EditTextItem, null);
        questionnaireItems.add(item);

        item = new QuestionnaireItem(layout, "Ako sa volal Váš predchádzajúci čeľustný ortopéd a ako sa volá Váš súčasný zubný lekár?", id++, QuestionnaireItemType.EditTextItem, null);
        questionnaireItems.add(item);

        item = new QuestionnaireItem(layout, "Adresa (ulica, mesto, PSČ):", id++, QuestionnaireItemType.EditTextItem, null);
        questionnaireItems.add(item);

        item = new QuestionnaireItem(layout, "Zamestnanie:", id++, QuestionnaireItemType.EditTextItem, null);
        questionnaireItems.add(item);

        super.Build();
    }

    public void Evaluate()
    {
        super.Evaluate();
    }

    public String GetResult()
    {
        return super.GetResult();
    }

    public String GetFileName()
    {
        return super.GetFileName();
    }
    public Boolean WriteToFile()
    {
        return super.WriteToFile();
    }

}
