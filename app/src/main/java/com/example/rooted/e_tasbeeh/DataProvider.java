package com.example.rooted.e_tasbeeh;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.rooted.e_tasbeeh.database.DbZikrHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class DataProvider {

    String   color;
    SharedPreferences mySharedPreferences = null;
    String event;
    String dbevent;
    Context context;
    Intent [] arr;
    List <String[]>allArabicDua=new ArrayList();
    List <String[]> allEngDua=new ArrayList();

    public DataProvider(String event,Context context) {
        this.event = event;
        dbevent=event;
        this.context=context;
        mySharedPreferences = context.getSharedPreferences("Test PREFS", Activity.MODE_PRIVATE);
        if(new SharedPrefsReader(mySharedPreferences).enableNight())
        {

            color="color=\'#FFEBE7E7\'";
        }else
        {
            color="color=\'#000\'";
        }

    }
    public void setIntents(Intent[] arr)
    {
        this.arr=arr;


    }

public void startThreadActivities()
{




    new Thread(new Runnable() {
        @Override
        public void run() {
            context.startActivities(arr);
        }
    }).start();
}




    String[] friday={
            "َلااِلهَ اِلَّااللّه",
            "َاللّه ُاَكْبَر",
            "سُبْحَانَ اللّه",
            "أَسْتَغْفِرُاللَّهَ",
            " الحمد لله",
            "لا حول ولاقوة إلا بالله",
            "سُبْحَانَ اللّهِ،والْحَمْدُللّهِ،وَلااِلهَ اِلَّااللّهُ،وَاللّهُ اَكْبَرُ،وَلاحَوْلَوَلاقُوَّةَاِلَّابِاللّهِ"  ,

            "لااِلهَ اِلَّااللّهُ وَحْدَه ُلاشَرِيكَ لَهُ،لَهُ الْمُلْك ُوَلَهُ الْحَمْدُوَهُوَعَلَى كُلِّ شَيْءٍقَدِيرٌ",

            "أَسْتَغْفِرُاللَّهَ الْعَظِيم َالَّذِي لاَإِلَه َإِلاَّهُوَالْحَيُّ الْْقَيُّوم ُوَأَتُوبُ إِلَيْهِ"
    };


    String[] saturday ={
            "الله أَكْبَر",
            "سُبْحَانَ اللّه وَبِحَمْدِه",
            "سبحان الله"
            ," الحمد لله",
            "أَسْتَغْفِرُاللَّهَ",
            "لا إله إلا الله",
            "لا حول ولاقوة إلا بالله"
            ,"سُبْحَانَ اللّهِ،والْحَمْدُللّهِ،وَلااِلهَ اِلَّااللّهُ،وَاللّه اَكْبَرُ" ,

            "أَسْتَغْفِرُاللَّه َالْعَظِيم َالَّذِي لاَإِلَه َإِلاَّهُوَالْحَيُّ الْْقَيُّوم ُوَأَتُوب ُإِلَيْه"

    };
    String[]wednesday={ "سُبْحَانَ اللّه"
            ,"الله أَكْبَر",
            "الْحَمْدُللّه",
            "أَسْتَغْفِرُاللَّهَ",
            "َلاحَوْل َوَلاقُوَّةَاِلَّابِاللّه",
            "لا إله إلا الله",
            "سُبْحَانَ اللّه ِوَبِحَمْدِه",
            "سُبْحَان اللّهِ وَبِحَمْدِهِ،سُبْحَانَ اللّهِ الْعَظِيم",
            "لااِلهَ اِلَّااللّه ُوَحْدَهُ لاشَرِيك َلَهُ،لَه الْمُلْك ُوَلَهُ الْحَمْدُوَهُوَعَلَى كُلِّ شَيْءٍقَدِير"
           };

    String[] tuesday={"سُبْحَان َاللّه ِوَبِحَمْدِهَِ",
            "لا إله إلا الله",
            " الحمد لله"
            ,"سُبْحَان َاللّهِ الْعَظِيم ِوَبِحَمْدِهِ",
            "سُبْحَانَ اللّهِ وَبِحَمْدِهِ،سُبْحَانَ اللّه ِالْعَظِيمِ","سُبْحَانَاللّهِ"
            ,"لاحَوْل وَلاقُوَّةَاِلَّابِاللّهِ"
            ,"سُبْحَان َاللّهِ،والْحَمْدُللّهِ،وَلااِلهَ اِلَّااللّهُ،وَاللّه ُاَكْبَرُ",



    };
    String[] sunday={"الْحَمْدُللّه",
            "َلاحَوْل وَلاقُوَّةَاِلَّابِاللّه",
            "أَسْتَغْفِرُاللَّهَ",
            "سُبْحَانَ اللّهِ وَبِحَمْدِه"
            ,"سُبْحَان َاللّه ِوَبِحَمْدِهِ،سُبْحَان َاللّه ِالْعَظِيم",
            "لااِله َاِلَّااللّه",
            "الله أَكْبَر"
    };
    String[]monday={"الْحَمْدُللّهِ",
            "لااِله َاِلَّااللّهُ",
            "أَسْتَغْفِرُاللَّهَ",
            "لاحَوْل وَلاقُوَّةَاِلَّابِاللّهِ",
            "لااِله َاِلَّااللّه ُوَحْدَه ُلاشَرِيك َلَهُ،لَهُ الْمُلْك ُوَلَهُ الْحَمْدُوَهُوَعَلَى كُل ِّشَيْءٍقَدِيرٌ",

            "أَسْتَغْفِرُاللَّه َالْعَظِيم َالَّذِي لاَإِلَه َإِلاَّهُوَالْحَي ُّالْْقَيُّوم ُوَأَتُوب ُإِلَيْهِ",



            "سُبْحَانَ اللّهِ،والْحَمْدُللّهِ،وَلااِلهَ اِلَّااللّهُ،وَاللّهُ اَكْبَرُ"};
    String[]  thursday ={
            "سُبْحَانَ اللّه",
            "سُبْحَان َاللّه ِوَبِحَمْدِهَِ"  ,
            "الْحَمْدُللّهِ",
            "َلااِلهَ اِلَّااللّه",
            "سُبْحَانَ اللّه ِالْعَظِيم ِوَبِحَمْدِهِ",
            "سُبْحَان َاللّهِ وَبِحَمْدِهِ،سُبْحَانَ اللّهِ الْعَظِيمِ",
            "أَسْتَغْفِرُاللَّهَ",
            "لاحَوْل َوَلاقُوَّةَاِلَّابِاللّهِ",
            "سُبْحَان َاللّهِ،والْحَمْدُللّهِ،وَلااِلهَ اِلَّااللّهُ،وَاللّه ُاَكْبَرُ",

            "سُبْحَانَ اللّهِ،والْحَمْدُللّهِ،وَلااِلهَ اِلَّااللّهُ،وَاللّه ُاَكْبَرُ،وَلاحَوْلَوَلاقُوَّةَاِلَّابِاللّهِ"





    };

    public List getZikar(String day) {

        List zikr = Arrays.asList(saturday);
        switch (day) {
            case "sunday":
                zikr = Arrays.asList(sunday);
                break;
            case "monday":
                zikr = Arrays.asList(monday);
                break;
            case "tuesday":
                zikr = Arrays.asList(tuesday);

                break;
            case "wednesday":
                zikr = Arrays.asList(wednesday);
                break;
            case "thursday":
                zikr = Arrays.asList(thursday);
                break;
            case "friday":
                zikr = Arrays.asList(friday);
                break;
            case "saturday":
                zikr = Arrays.asList(saturday);
                break;




        }

        return zikr;
    }













    List a=null;
    List b=null;
public List<List> getAllDua()
{
    List<List> lis=new ArrayList();
    lis.add(allEngDua);
    lis.add(allArabicDua);
  return  lis;
}
    public List getA() {

        String []journey1={
                "\n O Allah! Keep me and all the things with me safe and sound and let them reach the destination safely",
                "\nO My Lord! Cause me to enter a goodly entrance and cause me to go out (of) a goodly exit, and grant me from unto Thee an authority to assist (me)",

                "\n Not fearing to be overtaken, nor being afraid",
                "\n May there be peace on us from our God",
                "\n O Allah! I leave unto Thy care my life, my wife and children, my merchandise, my generation, my world here and hereafter, deposits under my custody and place my end of life Thy hands",
                "\n O Saleh! Render help unto me!",
                "\n O My Lord! Cause me to enter a goodly entrance and cause me to go out (of) a goodly exit, and grant me from unto Thee an authority to assist (me)",
                "\nVerily my protector is God who sent down the Book (Qur’an) and He gradeth the virtuous once They have esteemed not God, as is His due: while the whole earth shall Be in His grip on the Day of judgement and heavens rolled up (shall be) in His right hand, Hallowed is He, and Exalted is He, high above what they associate (with Him)",
                "\nHe is Allah who sent down the book (Quran) and He guardeth the virtuous one They have esteemed not Allah, as is His due: While the whole earth shall be in His grip on the day of Judgement and heavens rolled up (shall be) in the right hand: Hallowed is He and Exalted is He, high above what they associate (with Him)",
                "\n Allah! the Lord of the seven heavens and whatever is between them the Lord of the Great throne; the Lord of Jibraeel, Meekaeel and Israfeel; the lord of the Great Quran; and the Lord of Muhammad the seal of the Prophets. I beseech Thee through Him by whose command the gathering is dispersed, and the scattered are gathered; the living are provided subsistence, the number of sand particles is counted, the weight of the mountains (is known) and the quantity of the Ocean water (is comprehended\n",
                "\nVerily in the creation of the heavens and the earth and the alteration of the night and the day, there are signs for men who possess wisdom. Those who remember Allah standing, and sitting and reclining on their sided and think (Seriously) in the creation of the heaven and the earth saying ‘O Our Lord! Thou hast not created (all) this in vain! Glory be to Thee! Save us then from the torment of the (Hell) fire.’ O Our Lord! Whomsoever Thou causeth to enter the (Hell) fire surely thou hast put him to disgrace; there is not, for the unjust, any of the helpers. O Our Lord! We Have indeed heard the voice of a Crier (Messenger) calling (us) unto faith, saying, “Believe ye in your Lord!” Therefore “Forgive us then our sins and remove away from us our evil deeds and cause us to die with the virtuous ones”. O Our Lord! And give us what Thou didst promise us through Thy prophet, and disgrace us not on the Day of Resurrection; Verily, Thou breakest not Thy Promise",
                "\nI begin with the name of Allah. Allah is enough for me and him only I rely. O Allah I pray Thee for the welfare of all ray affairs and seek Thy shelter from the evils in this world and the torments of the Day of Judgement"
                ,"\nIn the name of Allah the Beneficent the Merciful. By Allah! By Allah! By Allah! O the First and Eternal King of Kings! O He whose personality exists from times eternal and for whom there is no change or times eternal and for whom there is no change or deterioration (fall). I beg of Thee Who is the Almighty God, enough for everything and Who holds everything under His sway: O Allah on behalf of Thy Great name, Uniqueness and needlessness from Whom no one is born and Who is born of no one and Who does not have a single partner, look after me and protect me from the mischief of men, my enemies and their swords and put a stop to all types of torture. When God has surrounded them from all sides then where links the danger. O Allah do protect me from the danger who intend harming me, cover me with avail as is Thy sacred veil which does not let the mischief of bad and mad people come near Thee or be hurt by the swords, the iron and all those which ordinarily people are afraid of and keep away from and all the difficulties and mischief of all these things which are well known to Thee or be hurt by the swords, the iron and all those which ordinarily people are afraid and keep away from, and all the difficulties and the mischief of all those things which are well known to thee and on whom thou hast complete authority. No doubt Thy power encompasses everything. Shower Thy blessing on Thy prophet and his dear and near ones and a greeting which they have the right of."
                ,"\nO Allah! I leave unto Thy care my life, my wife and children, my merchandise, my generation, my world here and hereafter, deposits under my custody and place my end of life Thy hands."
                ,"\nO Saleh! Render help unto me!"
                ,"\n O Allah make my arrival over here rewarding, for Thou art the best host and care-taker."
                ,"\n Not fearing to be overtaken, nor being afraid"



        };
        String []journey2={
                "<b><font "+color+" ;size='10'>"+"Before starting journey"+"</font></b><br><hr>"+ "  اَللّٰهُمَّ احْفَظْنِي وَ احْفَظْ مَا مَعِيَ وَ سَلِّمْنِي وَ سَلِّمْ مَا مَعِيَ وَ بَلِّغْنِيْ وَ بَلِّغْ مَا مَعِيَ بِبَلَاغِكَ الْحَسَنِ الْجَمِيْلِِ",
                "<hr><b><font "+color+";size='5'>At the time of visiting a dangerous place</font></b><br>"+ "رَبِّ اَدْخِلْنِىْ مُدْخَلَ صِدْقٍ وَّ اَخْرِجْنِىْ مُخْرَجَ صِدْقٍ وَّ اجْعَلْ لِّىْ مِنْ لَّدُنْكَ سُلْطَانًا نَصِيْرًا ",
                "<b><font "+color+";size='2'>For safety from robbers</font></font></b><br>"+  "لَا تَخَافُ دَرَكاً وَ لَا تَخْشٰى‏",
                "<b><font "+color+">While Leaving House For Special Work/Object/Purpose</font></b><br>"+ "اَلسَّلاَمُ عَلَيْنَا مِنْ رَبِّنَا",
                "<b><font "+color+">For a traveller’s family </font></b><br>"+ "اَللّٰهُمَّ إِنِّيْ أَسْتَوْدِعُكَ نَفْسِيْ وَ أَهْلِيْ وَ مَالِيْ وَ دِيْنِيْ وَ دُنْيَايَ وَ آخِرَتِيْ وَ أَمَانَتِيْ وَ خَوَاتِيْمَ عَمَلِيْ",
                "<b><font "+color+">When anyone loses way </font></b><br>"+ "يَا صَالِحُ اَغِثْنِيْ",
                "<b><font "+color+">At the time of visiting a dangerous place</font></b><br>"+ "رَبِّ اَدْخِلْنِىْ مُدْخَلَ صِدْقٍ وَّ اَخْرِجْنِىْ مُخْرَجَ صِدْقٍ وَّ اجْعَلْ لِّىْ مِنْ لَّدُنْكَ سُلْطَانًا نَصِيْرًا",
                "<b><font "+color+">For safety from drowning</font></b><br>"+ "اِنَّ وَلِىِّىَ اللهُ الَّذِىْ نَزَّلَ الْكِتَابَ، وَ هُوَ يَتَوَلَّى الصَّالِحِيْنَ وَ مَا قَدَرُوْا اللهَ حَقَّ قَدْرِهٖ، وَ الْاَرْضُ جَمِيْعًا قَبْضَتُهٗ يَوْمَ الْقِيَامَةِ وَ السَّمٰوَاتُ مَطْوِيَّاتٌۢ بِيَمِيْنِهٖ، سُبْحَانَهٗ وَ تَعَالٰى عَمَّا يُشْرِكُوْنَ",
                "<b><font "+color+">Dua and prayer at the time of storm in the sea</font></b><br>"+"اَللهُ الَّذِىْ نَزَّلَ الْكِتَابَ، وَ هُوَ يَتَوَلَّى الصَّالِحِيْن وَ مَا قَدَرُوْا اللهَ حَقَّ قَدْرِهٖ، وَ الْاَرْضُ جَمِيْعًا قَبْضَتُهٗ يَوْمَ الْقِيَامَةِ وَ السَّمٰوَاتُ مَطْوِيَّاتٌۢ بِيَمِيْنِهٖ، سُبْحَانَهٗ وَ تَعَالٰى عَمَّا يُشْرِكُوْنَ",
                "<b><font "+color+">For all purposes</font></b><br>"+"اَللّٰهُمَّ رَبَّ السَّمَاوَاتِ السَّبْعِ وَ مَا بَيْنَهُنَّ وَ رَبَّ الْعَرْشِ الْعَظِيْمِ وَ رَبَّ جَبْرَئِيْلَ وَ مِيْكَـائِيْلَ وَ إِسْرَافِيْلَ وَ رَبَّ الْقُرْآنِ الْعَظِيْمِ وَ رَبَّ مُحَمَّدٍ خَاتَمِ النَّبِيِّيْنَ إِنِّي أَسْأَلُكَ بِالَّذِيْ تَقُوْمُ بِهِ السَّمَآءَ وَ بِهٖ تَقُوْمُ الْأَرْضَ وَ بِهٖ تُفَرِّقُ بَيْنَ الْجَمْعِ وَ بِهٖ تَجْمَعُ بَيْنَ الْمُتَفَرِّقِ وَ بِهٖ تَرْزُقُ الْأَحْيَآءَ وَ بِهٖ أَحْصَيْتَ عَدَدَ الرِّمَالِ وَ وَزْنَ الْجِبَالِ وَ كَيْلَ الْبُحُوْرِ",
                "<b><font "+color+">While Leaving House For Special Work/Object/Purpose</font></b><br>"+ "اَلسَّلاَمُ عَلَيْنَا مِنْ رَبِّنَا اِنَّ فِىْ خَلْقِ السَّمَاوَاتِ وَالْاَرْضِ وَاخْتِلاَفِ الَّيْلِ وَالنَّهَارِ لَاٰيَاتٍ لّاُِولِى الْاَلْبَابِ.الَّذِيْنَ يَذْكُرُوْنَ اللهَ قِيَامًا وَّ قُعُوْدًا وَّ عَلٰي جُنُوْبِهِمْ وَ يَتَفَكَّرُوْنَ فِى خَلْقِ السَّمَاوَاتِ وَالْاَرْضِ، رَبَّنَا مَا خَلَقْتَ هٰذَا بَاطِلاً، سُبْحَانَكَ فَقِنَا عَذَابَ النَّارِ.رَبَّنَآ اِنَّكَ مَنْ تُدْخِلِ النَّارَ فَقَدْ اَخْزَيْتَهٗ، وَمَا لِلظَّالِمِيْنَ مِنْ اَنْصَارٍ.رَبَّنَآ اِنَّنَا سَمِعْنَا مُنَادٍيًا يُّنَادِىْ لِلْاِيْمَانِ اَنْ اٰمِنُوْا بِرَبِّكُمْ فَاٰمَنَّا، رَبَّنَا فَاغْفِرْ لَنَا ذُنُوْبَنَا وَ كَفِّرْعَنَّا سَيِّاٰتِنَا وَ تَوَفَّنَا مَعَ الْاَبْرَارِ.رَبَّنَا وَ اٰتِنَا مَا وَعَدْتَّنَا عَلٰي رُسُلِكَ وَلاَ تُخْزِنَا يَوْمَ الْقِيَامَةِ، اِنَّكَ لاَ تُخْلِفُ الْمِيْعَادَ",
                "<b><font "+color+">While salvation of worldly and spiritual tasks at the time of leaving house</font></b><br>"+ "بِسْمِ اللَّهِ حَسْبِيَ اللَّهُ تَوَكَّلْتُ عَلَى اللَّهِ اَللّٰهُمَّ إِنِّي أَسْأَلُكَ خَيْرَ أُمُوْرِيْ كُلِّهَا وَ أَعُوْذُ بِكَ مِنْ خِزْيِ الدُّنْيَا وَ عَذَابِ الْآخِرَةِ",
                "<b><font "+color+">For talisman to be keep by traveller</font></b><br>"+ "بِسْمِ اللهِ الرَّحْمٰنِ الرَّحِيْمِ. بِاللَّهِ بِاللَّهِ بِاللَّهِ أَسْأَلُكَ يَا مَلِكَ الْمُلُوكِ الْأَوَّلَ الْقَدِيمَ الْأَبَدِيَّ الَّذِي لَا يَزُولُ وَ لَا يَحُولُ أَنْتَ اللَّهُ الْعَظِيمُ الْكَـافِي كُلَّ شَيْ\u200Fءٍ الْمُحِيْطُ بِكُـلِّ شَيْ\u200Fءٍ اَللّٰهُمَّ اكْفِنِيْ بِاسْمِكَ الْأَعْظَمِ الْأَجَلِّ الْوَاحِدِ الْأَحَدِ الصَّمَدِ الَّذِيْ لَمْ يَلِدْ وَ لَمْ يُولَدْ وَ لَمْ يَكُنْ لَهٗ كُفُواً أَحَدٌ احْجُبْ عَنِّي شُرُوْرَهُمْ وَ شُرُوْرَ الْأَعْدَاءِ كُلِّهِمْ وَ سُيُوْفِهِمْ وَ بَأْسَهُمْ وَ اللَّهُ مِنْ وَرَائِهِمْ مُحِيْطٌ اَللّٰهُمَّ احْجُبْ عَنِّي شَرَّ مَنْ أَرَادَنِيْ بِسُوءٍ بِحِجَابِكَ الَّذِي احْتَجَبْتَ بِهٖ فَلَمْ يَنْظُرْ إِلَيْهِ أَحَدٌ مِنْ شَرِّ فَسَقَةِ الْجِنِّ وَ الْإِنْسِ وَ مِنْ شَرِّ سِلَاحِهِمْ وَ مِنَ الْحَدِيْدِ وَ مِنْ شَرِّ كُلِّ مَا نَتَخَوَّفُ وَ نَحْذَرُ وَ مِنْ شَرِّ كُلِّ شِدَّةٍ وَ بَلِيَّةٍ وَ مِنْ شَرِّ مَا أَنْتَ بِهٖ أَعْلَمُ وَ عَلَيْهِ أَقْدَرُ إِنَّكَ عَلٰى كُلِّ شَيْءٍ قَدِيْرٌ وَ صَلَّى اللَّهُ عَلٰى مُحَمَّدٍ نَبِيِّهٖ وَ آلِهٖ وَ سَلَّمَ تَسْلِيْماً كَثِيْرًا"
                ,  "<b><font "+color+">For a traveller’s family</font></b><br>"+"اَللّٰهُمَّ إِنِّيْ أَسْتَوْدِعُكَ نَفْسِيْ وَ أَهْلِيْ وَ مَالِيْ وَ دِيْنِيْ وَ دُنْيَايَ وَ آخِرَتِيْ وَ أَمَانَتِيْ وَ خَوَاتِيْمَ عَمَلِيْ"
                ,  "<b><font "+color+">When anyone loses way</font></b><br>"+"يَا صَالِحُ اَغِثْنِيْ"
                , "<b><font "+color+">At the time of arrival in new place</font></b><br>"+"اَللّٰهُمَّ أَنْزِلْنِيْ مُنْزَلًا مُبَارَكًا وَ أَنْتَ خَيْرُ الْمُنْزِلِيْنَ"

                ,  "<b><font "+color+">For safety from robbers</font></b><br>"+"لَا تَخَافُ دَرَكاً وَ لَا تَخْشٰى"
        };








        String []mix1={
                "\nThe Almighty God is pure and I begin with His praise. I pray salvation from Him and supplicate His Blessings.",
                "\n  There is no power and strength except with Allah the Grand, The Great",
                "\n At the place of scorpion bite salt should be poured and then recite Surah “Al-Kaferoon” (Chap. 109), Surah “Al-Falaq” (Chap. 113) and Surah “Al-Naas” (Chap. 114) one time each.",
                "\n  O Allah! I beseech Thee for forgiveness, health, and safety from every calamity of this world & hereafte",
                "\n There is no god but ALLAH,and ALLAH is greatest",
                "\n May there be peace on us from our God.",
                "\n  O our Lord! Grant us from our wives and our offsprings, the joy of our eyes, and make us for the pious ones",
                "\n O Allah! Keep me away from rebellious jins and men and devils and bless me in this house",
                "\n  O Allah let the sign of faith be the cause of my recognition! Let my end be worthwhile and let there be good for me even in the world to come. It is well known that Thou art All Mighty, All-Wise and All Generous!",
                "\n o Hallowed is thy Lord, the Lord of Majesty, far above from that which they ascribe (unto Him) And peace be upon the prophet. And all praise is God’s the Lord of the worlds."
                ,"\n  I begin with the name of Allah. Allah is enough for me and him only I rely. O Allah I pray Thee for the welfare of all ray affairs and seek Thy shelter from the evils in this world and the torments of the Day of Judgement."

                ,"\n O Allah! I seek you benefits for this bazar and those who through it.",
                "\n I stand witness that there is no God except One who has no partner and I also stand witness to Mohammed Mustafa (s.a.w.a.) being His servant and His Prophet O Allah! I beg You to give me permissible and purified daily bread with our blessings; and seek shelter for myself doing any cruelty on any one or anyone doing any cruelty with me and also seek refuge from trade which incurs losses and false oaths",


                "\n O Allah! the Lord of the seven heavens and whatever is between them the Lord of the Great throne; the Lord of Jibraeel, Meekaeel and Israfeel; the lord of the Great Quran; and the Lord of Muhammad the seal of the Prophets. I beseech Thee through Him by whose command the gathering is dispersed, and the scattered are gathered; the living are provided subsistence, the number of sand particles is counted, the weight of the mountains (is known) and the quantity of the Ocean water (is comprehended",
                "\n O the Ever-living the Self subsisting; the Eternal the Generous the Merciful, I bind Thee and by thy dignity, Thy might and all those thing which are in thy knowledge and beg Thee to increase my prosperity and respect and make my end good through today’s trade, as those things whose end is not good are never good"

        };
        String []mix2={
                "<b><font "+color+">For removing Worries</font></b><br>"+ "سُبْحَانَ اللَّهِ الْعَظِيْمِ وَ بِحَمْدِهٖ أَسْتَغْفِرُ اللَّهَ وَ أَسْأَلُهٗ مِنْ فَضْلِهٖ",
                "<b><font "+color+">For removal of Poverty and Worries</font></b><br>"+"لَا حَوْلَ وَ لاَ قُوَّةَ اِلاَّ بِاللهِ الْعَلِيِّ الْعَظِيْمِِِ",
                "<b><font "+color+">For Scorpion Bite</font></b><br>",
                "<b><font "+color+">For release from Prison</font></b><br>"+"اَللّٰهُمَّ إِنِّيْ أَسْتَوْدِعُكَ نَفْسِيْ وَ أَهْلِيْ وَ مَالِيْ وَ دِيْنِيْ وَ دُنْيَايَ وَ آخِرَتِيْ وَ أَمَانَتِيْ وَ خَوَاتِيْمَ عَمَلِيْ",
                "<b><font "+color+">While on hill or on great height</font></b><br>"+ "لَا اِلٰهَ اِلاَّ اللهُ وَ اللهُ اَكْبَرُْ",
                "<b><font "+color+">While Leaving House For Special Work-Object/Purpose</font></b><br>"+"اَلسَّلاَمُ عَلَيْنَا مِنْ رَبِّنَا",
                "<b><font "+color+">For true belief for one’s family </font></b><br>"+"رَبَّنَا هَبْ لَنَا مِنْ اَزْوَاجِنَا وَ ذُرِّيَّاتِنَا قُرَّةَ اَعْيُنٍ وَّ اجْعَلْنَا لِلْمُتَّقِيْنَ اِمَامًاَ",
                "<b><font "+color+">While Building New House </font></b><br>"+"اَللّٰهُمَّ ادْحَرْ عَنِّي مَرَدَةَ الْجِنِّ وَ الْإِنْسِ وَ الشَّيَاطِيْنِ وَ بَارِكْ لِي فِيْ بِنَائِيَ",
                "<b><font "+color+">At the time of wearing Jewels</font></b><br>"+"اَللّٰهُمَّ سِمْنِي بِسِيْمَاءِ الْإِيمَانِ وَ اخْتِمْ لِي بِالْخَيْرِ وَ اجْعَلْ عَاقِبَتِيْ إِلٰى خَيْرٍ وَ إِنَّكَ أَنْتَ الْعَزِيْزُ الْكَرِيْمُِِ",

                "<b><font "+color+">Whenever one sits in gathering</font></b><br>"+"سُبْحَانَ رَبِّكَ رَبِّ الْعِزَّةِ عَمَّا يَصِفُوْنَ. وَ سَلَامٌ عَلَى الْمُرْسَلِيْنَ. وَالْحَمْدُ لِلّٰهِ رَبِّ الْعَالَمِيْنَ",
                "<b><font "+color+">While salvation of worldly and spiritual tasks at the time of</font></b><br>"+"بِسْمِ اللَّهِ حَسْبِيَ اللَّهُ تَوَكَّلْتُ عَلَى اللَّهِ اَللّٰهُمَّ إِنِّي أَسْأَلُكَ خَيْرَ أُمُوْرِيْ كُلِّهَا وَ أَعُوْذُ بِكَ مِنْ خِزْيِ الدُّنْيَا وَ عَذَابِ الْآخِرَةِِ",
                "<b><font "+color+">Dua to be Recited at the Time of Going to Market</font></b><br>"+" اَللّٰهُمَّ اِنِّيْۤ اَسْئَلُكَ مِنْ خِيْرِهَا وَ خَيْرِ اَهْلِهَا."

                ,"<b><font "+color+">Dua to be Recited when one sets in his Shop</font></b><br>"+"  اَشْهَدُ اَنْ لَّا اِلٰهَ اِلاَّ اللهُ وَحْدَهٗ لاَ شَرِيْكَ لَهٗ وَ اَشْهَدُ اَنَّ مُحَمَّدًا صَلَّي اللهُ عَلَيْهِ وَ اٰلِهٖ عَبْدُهٗ وَ رَسُوْلُهٗ اَللّٰهُمَّ اِنِّيْۤ اَسْئَلُكَ مِنْ فَضْلِكَ رِزْقًا حَلاَلًا طَيِّبًا وَ اَعُوْذُ بِكَ مِنْ اَنْ اَظْلِمَ اَوْ اُظْلِمَ وَ اَعُوْذُ بِكَ مِنْ صَفْقَةٍ خَاسِرَةٍ وَ يَمِيْنٍ كَاذِبَةٍ"

                ,"<b><font "+color+">For all purposes</font></b><br>"+"اَللّٰهُمَّ رَبَّ السَّمَاوَاتِ السَّبْعِ وَ مَا بَيْنَهُنَّ وَ رَبَّ الْعَرْشِ الْعَظِيْمِ وَ رَبَّ جَبْرَئِيْلَ وَ مِيْكَـائِيْلَ وَ إِسْرَافِيْلَ وَ رَبَّ الْقُرْآنِ الْعَظِيْمِ وَ رَبَّ مُحَمَّدٍ خَاتَمِ النَّبِيِّيْنَ إِنِّي أَسْأَلُكَ بِالَّذِيْ تَقُوْمُ بِهِ السَّمَآءَ وَ بِهٖ تَقُوْمُ الْأَرْضَ وَ بِهٖ تُفَرِّقُ بَيْنَ الْجَمْعِ وَ بِهٖ تَجْمَعُ بَيْنَ الْمُتَفَرِّقِ وَ بِهٖ تَرْزُقُ الْأَحْيَآءَ وَ بِهٖ أَحْصَيْتَ عَدَدَ الرِّمَالِ وَ وَزْنَ الْجِبَالِ وَ كَيْلَ الْبُحُوْرِ" ,
                "<b><font "+color+"> Dua at the time of purchase</font></b><br>"+ " يَا حَيُّ يَا قَيُّوْمُ يَا دَآئِمُ يَا رَءُوْفُ يَا رَحِيْمُ أَسْأَلُكَ بِعِزَّتِكَ وَ قُدْرَتِكَ وَ مَا أَحَاطَ بِهٖ عِلْمُكَ أَنْ تَقْسِمَ لِي مِنَ التِّجَارَةِ الْيَوْمَ أَعْظَمَهَا رِزْقاً وَ أَوْسَعَهَا فَضْلًا وَ خَيْرَهَا عَاقِبَةً فَإِنَّهٗ لَا خَيْرَ فِيْمَا لَا عَاقِبَةَ لَهٗ"



        };


        String []forgive1={"\n O My Lord! Verily I have been unjust to myself So forgive me (for it) Indeed none pardons the sins except Thee",
                "\nI bear witness that there is no deity but Allah He is alone and without any partner. He is (the only) Deity Single, Peerless and Independent. He neither took a wife nor begot any child"
                ,"\nSo Glory be to Allah when you enter evening and when you enter the morning, and for Him (alone) is all the praise in the heavens and the earth. At the sun’s decline and when you enter the noon"};
        String []forgive2={
                "<b><font "+color+">For seeking forgiveness of sins (Dua in Sajdah)</font></b><br>"+"رَبِّ إِنِّي ظَلَمْتُ نَفْسِيْ فَاغْفِرْ لِيْ اِنَّهٗ لَا يَغْفِرُ الذُّنُوْبَ اِلاَّ اَنْتَ" ,

                "<b><font "+color+">For Forgiveness, Protection from Sins and Sawab for reciting 12 Qurans</font></b><br>"+  "اَشْهَدُ اَنْ لاَ اِلٰهَ اِلاَّ اللهُ وَحْدَهُ لاَ شَرِيْكَ لَهٗ اِلٰهًا وَاحِدًا اَحَدًا صَمَدًا لَمْ يَتَّخِذْ صَاحِبَةً وَ لاَ وَلَدًا"
                ,"<b><font "+color+">For great sawab and protection from major sins</font></b><br>"+ "فَسُبْحَانَ اللهِ حِيْنَ تُمْسُوْنَ وَ حِيْنَ تُصْبِحُوْنَ. وَ لَهُ الْحَمْدُ فِى السَّمَاوَاتِ وَ الْاَرْضِ وَ عَشِيًّا وَّ حِيْنَ تُظْهِرُوْن "};


        String [] avoid1={"\n I begin with the name of Allah and rely on Him O Allah by giving me faith Thou hast obliged me unto Thou. Thou hast made responsible for Qur’an-e-Majeed and presented me with the fasts of Ramazan. Make me now the centre of all Thy Kindness. Charity, good Benefactor! O the doer of Kindness. Charity, good will, rewards and obligations and O the great art pure and purified and I seek. Thy refuge from my downfall after showering me with these gifts and respect and pray you to alleviate those doubts superstitions and grief which are crowding on me and send innumerable durood on Hazrat Mohammad (s.a.w.a.) and his offspring (Ahle Bayt)",
                "\n Then we did set a seal on their ears for a number of years, then We raised them up that We might Know (i.e. ...show) which of the two parties reckoneth best the duration of their stay ",
                "\n O Allah! the Lord of the seven heavens and whatever is between them the Lord of the Great throne; the Lord of Jibraeel, Meekaeel and Israfeel; the lord of the Great Quran; and the Lord of Muhammad the seal of the Prophets. I beseech Thee through Him by whose command the gathering is dispersed, and the scattered are gathered; the living are provided subsistence, the number of sand particles is counted, the weight of the mountains (is known) and the quantity of the Ocean water (is comprehended"};

        String [] avoid2={
                "<b><font "+color+">For avoiding bad thoughts and temptation</font></b><br>"+  "بِسْمِ اللَّهِ وَ بِاللَّهِ اَللّٰهُمَّ مَنَنْتَ عَلَيَّ بِالْإِيمَانِ وَ أَوْدَعْتَنِي الْقُرْآنَ وَ رَزَقْتَنِيْ صِيَامَ شَهْرِ رَمَضَانَ فَامْنُنْ عَلَيَّ بِالرَّحْمَةِ وَ الرِّضْوَانِ وَ الرَّأْفَةِ وَ الْغُفْرَانِ وَ تَمَامِ مَا أَوْلَيْتَنِيْ مِنَ النِّعَمِ وَ الْإِحْسَانِ يَا حَنَّانُ يَا مَنَّانُ يَا دَائِمُ يَا رَحْمٰنُ سُبْحَانَكَ وَ لَيْسَ لِي أَحَدٌ سِوَاكَ سُبْحَانَكَ أَعُوْذُ بِكَ بَعْدَ هٰذِهِ الْكَرَامَاتِ مِنَ الْهَوَانِ وَ أَسْأَلُكَ أَنْ تُجْلِيَ عَنْ قَلْبِي الْأَحْزَان" ,

                "<b><font "+color+">Dua for avoiding bad dreams</font></b><br>"+  "فَضَرَبْنَا عَلٰى اٰذَانِهِمْ فِى الْكَهْفِ سِنِيْنَ عَدَدًا. ثُمَّ بَعَثْنَاهُمْ لِنَعْلَمَ اَىُّ الْحِزْبَيْنِ اَحْصٰى لِمَا لَبِثُوْآ اَمَدًا",
                "<b><font "+color+">For all purposes</font></b><br>"+  "اَللّٰهُمَّ رَبَّ السَّمَاوَاتِ السَّبْعِ وَ مَا بَيْنَهُنَّ وَ رَبَّ الْعَرْشِ الْعَظِيْمِ وَ رَبَّ جَبْرَئِيْلَ وَ مِيْكَـائِيْلَ وَ إِسْرَافِيْلَ وَ رَبَّ الْقُرْآنِ الْعَظِيْمِ وَ رَبَّ مُحَمَّدٍ خَاتَمِ النَّبِيِّيْنَ إِنِّي أَسْأَلُكَ بِالَّذِيْ تَقُوْمُ بِهِ السَّمَآءَ وَ بِهٖ تَقُوْمُ الْأَرْضَ وَ بِهٖ تُفَرِّقُ بَيْنَ الْجَمْعِ وَ بِهٖ تَجْمَعُ بَيْنَ الْمُتَفَرِّقِ وَ بِهٖ تَرْزُقُ الْأَحْيَآءَ وَ بِهٖ أَحْصَيْتَ عَدَدَ الرِّمَالِ وَ وَزْنَ الْجِبَالِ وَ كَيْلَ الْبُحُوْرِ"};



        String [] recover1={
                "\nIn the name of Allah, the Beneficent, the Merciful. I have entered into the evening in the protection of Allah and I shall enter upon the morning in the refuge of Allah",
                "\n O Allah! the Lord of the seven heavens and whatever is between them the Lord of the Great throne; the Lord of Jibraeel, Meekaeel and Israfeel; the lord of the Great Quran; and the Lord of Muhammad the seal of the Prophets. I beseech Thee through Him by whose command the gathering is dispersed, and the scattered are gathered; the living are provided subsistence, the number of sand particles is counted, the weight of the mountains (is known) and the quantity of the Ocean water (is comprehended"};
        String [] recover2={
                "<b><font "+color+">For recovery of misplaced or lost thing</font></b><br>"+ "بِسْمِ اللهِ الرَّحْمٰنِ الرَّحِيْمِ اَمْسَيْتُ فِيْ اَمَانِ اللهِ وَ اَصْبَحْتُ فِيْ جَوَارِ اللهِ" ,
                "<b><font "+color+">For all purposes</font></b><br>"+ "اَللّٰهُمَّ رَبَّ السَّمَاوَاتِ السَّبْعِ وَ مَا بَيْنَهُنَّ وَ رَبَّ الْعَرْشِ الْعَظِيْمِ وَ رَبَّ جَبْرَئِيْلَ وَ مِيْكَـائِيْلَ وَ إِسْرَافِيْلَ وَ رَبَّ الْقُرْآنِ الْعَظِيْمِ وَ رَبَّ مُحَمَّدٍ خَاتَمِ النَّبِيِّيْنَ إِنِّي أَسْأَلُكَ بِالَّذِيْ تَقُوْمُ بِهِ السَّمَآءَ وَ بِهٖ تَقُوْمُ الْأَرْضَ وَ بِهٖ تُفَرِّقُ بَيْنَ الْجَمْعِ وَ بِهٖ تَجْمَعُ بَيْنَ الْمُتَفَرِّقِ وَ بِهٖ تَرْزُقُ الْأَحْيَآءَ وَ بِهٖ أَحْصَيْتَ عَدَدَ الرِّمَالِ وَ وَزْنَ الْجِبَالِ وَ كَيْلَ الْبُحُوْرِ"};


        String [] reward1={
                " \n He is Allah There is no god. Save He: The Knower of the unseen and the seen He is the Beneficent The Most Merciful. He is Allah There is no god Save He: the king the Holy, the peace loving (the Bestower of) conviction. The Guardian (over all) the Ever-Prevalent. The Supreme, the Great Absolute! Hallowed is Allah from what they associate (with Him). He is Allah the Creator, the Maker, The Fashioner. His are all the Excellent names: Halloweth Him whatsoever is in the heavens the earth: and He is the Ever Prevalent the All-Wise",
                " \n I bear witness that there is no deity but Allah He is alone and without any partner. He is (the only) Deity Single, Peerless and Independent. He neither took a wife nor begot any child.",
                "\n O Lord! Thou hast not created (all) this in vain! Glory be to Thee! Save us then from the torment of the (Hell) fire. O Lord! Whomsoever Thou Causeth to enter the (Hell) fire. Surely Thou hast put him to disgrace: there is not. For the unjust any of the helpers. O Lord! We have indeed heard the voice of a crier (Messenger), calling (us) unto faith. Saying “Believe ye in your Lord!” And we did believe. O Lord! Therefore “Forgive us then our sins and remove away from us our evil deeds, and cause us to die with the virtuous ones.” O Our Lord! And give us what Thou didst promise us through thy messengers, and disgrace us not on the Day of Resurrection: Verily, Thou breakfast not Thy promise. O Our Lord! And give us what Thou didst promise us through thy messengers. And disgrace us not on the Day of Resurrection: Verily, Thou breakfast not Thy promise",
                " \n All praise is due to Allah for every past bounty and every nature (bounty)",
                " \n O Allah! the Lord of the seven heavens and whatever is between them the Lord of the Great throne; the Lord of Jibraeel, Meekaeel and Israfeel; the lord of the Great Quran; and the Lord of Muhammad the seal of the Prophets. I beseech Thee through Him by whose command the gathering is dispersed, and the scattered are gathered; the living are provided subsistence, the number of sand particles is counted, the weight of the mountains (is known) and the quantity of the Ocean water (is comprehended"
                ,"\nHe is Allah There is no god. Save He: The Knower of the unseen and the seen He is the Beneficent The Most Merciful. He is Allah There is no god Save He: the king the Holy, the peace loving (the Bestower of) conviction. The Guardian (over all) the Ever-Prevalent. The Supreme, the Great Absolute! Hallowed is Allah from what they associate (with Him). He is Allah the Creator, the Maker, The Fashioner. His are all the Excellent names: Halloweth Him whatsoever is in the heavens the earth: and He is the Ever Prevalent the All-Wise"};
        String [] reward2={
                "<b><font "+color+">Dua for reward of paradise</font></b><br>"+ " هُوَ اللهُ الَّذِىْ لَآ اِلٰهَ اِلاَّ هُوَ، عَالِمُ الْغَيْبِ وَالشَّهَادَةِ هُوَ الرَّحْمٰنُ الرَّحِيْمُ. هُوَ اللهُ الَّذِىْ لَآ اِلٰهَ اِلاَّ هُوَ، الْمَلِكُ الْقُدُّوْسُ السَّلَامُ الْمُؤْمِنُ الْمُهَيْمِنُ الْعَزِيْزُ الْجَبَّارُ الْمُتَكَبِّرُ، سُبْحَانَ اللهِ عَمَّا يُشْرِكُوْنَ . هُوَ اللهُ الْخَالِقُ الْبَارِئُ الْمُصَوِّرُ لَهُ الْاَسْمَآءُ الْحُسْنٰى، يُسَبِّحُ لَهٗ مَا فِى السَّمَاوَاتِ وَالْاَرْضِ، وَ هُوَ الْعَزِيْزُ الْحَكِيْمُ."
                ,  "<b><font "+color+">For Forgiveness, Protection from Sins and Sawab for reciting 12 Qurans</font></b><br>"+ "اَشْهَدُ اَنْ لاَ اِلٰهَ اِلاَّ اللهُ وَحْدَهُ لاَ شَرِيْكَ لَهٗ اِلٰهًا وَاحِدًا اَحَدًا صَمَدًا لَمْ يَتَّخِذْ صَاحِبَةً وَ لاَ وَلَدًا",
                "<b><font "+color+">For Sawab of whole Night Ibadat</font></b><br>"+ "    رَبَّنَا مَا خَلَقْتَ هٰذَا بَاطِلاً، سُبْحَانَكَ فَقِنَا عَذَابَ النَّارِ. رَبَّنَآ اِنَّكَ مَنْ تُدْخِلِ النَّارَ فَقَدْ اَخْزَيْتَهٗ، وَمَا لِلظَّالِمِيْنَ مِنْ اَنْصَارٍ. رَبَّنَآ اِنَّنَا سَمِعْنَا مُنَادٍيًا يُّنَادِىْ لِلْاِيْمَانِ اَنْ اٰمِنُوْا بِرَبِّكُمْ فَاٰمَنَّا، رَبَّنَا فَاغْفِرْ لَنَا ذُنُوْبَنَا وَ كَفِّرْعَنَّا سَيِّاٰتِنَا وَ تَوَفَّنَا مَعَ الْاَبْرَارِ. رَبَّنَا وَ اٰتِنَا مَا وَعَدْتَّنَا عَلٰي رُسُلِكَ وَلاَ تُخْزِنَا يَوْمَ الْقِيَامَةِ، اِنَّكَ لاَ تُخْلِفُ الْمِيْعَادَ."
                ,   "<b><font "+color+">For offering thanks for the bounties bestowed by Allah</font></b><br>"+"اَلْحَمْدُ لِلَّهِ عَلٰى كُلِّ نِعْمَةٍ كَانَتْ أَوْ هِيَ كَائِنَةٌ",
                "<b><font "+color+">For all purposes</font></b><br>"+ "اَللّٰهُمَّ رَبَّ السَّمَاوَاتِ السَّبْعِ وَ مَا بَيْنَهُنَّ وَ رَبَّ الْعَرْشِ الْعَظِيْمِ وَ رَبَّ جَبْرَئِيْلَ وَ مِيْكَـائِيْلَ وَ إِسْرَافِيْلَ وَ رَبَّ الْقُرْآنِ الْعَظِيْمِ وَ رَبَّ مُحَمَّدٍ خَاتَمِ النَّبِيِّيْنَ إِنِّي أَسْأَلُكَ بِالَّذِيْ تَقُوْمُ بِهِ السَّمَآءَ وَ بِهٖ تَقُوْمُ الْأَرْضَ وَ بِهٖ تُفَرِّقُ بَيْنَ الْجَمْعِ وَ بِهٖ تَجْمَعُ بَيْنَ الْمُتَفَرِّقِ وَ بِهٖ تَرْزُقُ الْأَحْيَآءَ وَ بِهٖ أَحْصَيْتَ عَدَدَ الرِّمَالِ وَ وَزْنَ الْجِبَالِ وَ كَيْلَ الْبُحُوْرِ"
                ,  "<b><font "+color+">Dua for reward of paradise</font></b><br>"+ "هُوَ اللهُ الَّذِىْ لَآ اِلٰهَ اِلاَّ هُوَ، عَالِمُ الْغَيْبِ وَالشَّهَادَةِ هُوَ الرَّحْمٰنُ الرَّحِيْمُ. هُوَ اللهُ الَّذِىْ لَآ اِلٰهَ اِلاَّ هُوَ، الْمَلِكُ الْقُدُّوْسُ السَّلَامُ الْمُؤْمِنُ الْمُهَيْمِنُ الْعَزِيْزُ الْجَبَّارُ الْمُتَكَبِّرُ، سُبْحَانَ اللهِ عَمَّا يُشْرِكُوْنَ . هُوَ اللهُ الْخَالِقُ الْبَارِئُ الْمُصَوِّرُ لَهُ الْاَسْمَآءُ الْحُسْنٰى، يُسَبِّحُ لَهٗ مَا فِى السَّمَاوَاتِ وَالْاَرْضِ، وَ هُوَ الْعَزِيْزُ الْحَكِيْمُ"  };



        String[] prayer1={
                "\nI seek forgiveness of Allah Who, there is no deity other than He, the Ever-Living the Self-Subsistent the Glorious and the Gracious. I turn unto Him (repentant)",
                "\n In the name of Allah the Beneficent the Merciful There is no deity but Allah the One the All Dominant: There is no deity but Allah the Ever Prevalent the All Forgiving There is no deity but Allah, He has no associate: Allah the One and we submit to Him. There has no associate, Allah the One and we are (Exclusively) loyal to Him. There is no deity but Allah, He is One, He has no associate. Allah the One and Him (alone) do we worship. There is no deity but Allah. Mohammed is the Messenger of Allah. ‘Ali is the friend of Allah: Allah’s blessing be on the best of His creation, the manifestation of His Benignity Mohammad and his (pure) progeny, all of them the pure the purified by thy Mercy. O the Most Merciful, Sufficient is for us Allah, and (He is) the most Excellent Protector, the Most Excellent Lord and the Most Excellent helper",
                "\nIn the name of Allah the Beneficent the Merciful There is no god but Allah, the Great the clement; there is no god but Allah the Lord of (the throne) of Grace: and all praise is for Allah, the Lord of the worlds; O Allah I beseech thee for all that time which is the cause of Thy Mercy, and that which ascertain Thy Forgiveness: and the benefit of every virtue and safety from every sin: O ‘Allah leave not any sin on me but that You forgive it, and any affliction but that You remove it. and any illness but that You heal it and any defect but You increase it and any fear but that You protect (me) from it; and any evil but that You repel it, and any of my need in which is Thy pleasure and which is beneficial for me, but that You grant it; O the Most Merciful, grant me my supplication O the Lord of the Worlds",
                "\nO Allah! this evening I seek thy protection and pardon of my sin: this evening I seek Thy Protection and shelter from my fears this evening I seek Thy protection and Opulence for my destitution: this evening I seek Thy protection and Grace from my disgrace: O Allah send Thy blessing on Mohammad (s.a.w.a.) and the (purified) progeny of Mohammad (s.a.w.a.) and forgive me and have mercy on me. Indeed Thou art praise worthy, the Most Glorious.\n" +
                        "O Allah! Thy Light is perfected and thou hast guided so all praise to Thee. O Our Lord. Thy Face is the Most Gracious of all the faces. Thy Eminence is the Greatest of all Thy gift is the Most Excellent gift; O Our Lord (if) Thou art obeyed Thou accept: if Thou art disobeyed Thou for giveth: Thou answer to (the call of) the distressed: Thou dispelleth the grief: Thou relieveth from the affliction:Thou enricheth the poor: Thou cureth the sick: and none can repay Thy bounties O the Most Merciful",
                "\nIn the name of Allah the most Beneficent, the Merciful O Allah I beseech Thee for the causes of Thy Mercy the right of Thy pardon: safety from every sin; the benefit from every virtue; salvation from (Hell) Fire and every Calamity; achievement of the Paradise and (Thy) Pleasure in the abode of peace; and the proximity of thy prophet Mohammed and his purified progeny peace be on all of them. O Allah! Whatever bounties we have all are from Thee there is no deity except Thee; I beseech Thy forgiveness and turn unto thee.",
                "\n In the name of Allah the Beneficent, the Merciful I seek protection with the Honour of Allah; I seek protection with the Might of Allah; I seek Protection with the forgiveness of Allah I seek protection with the mercy of Allah I Seek Protection with the Authority of Allah who is All Powerful over everything. I seek protection with the Grace of Allah and I Seek protection with All-Prevalent Allah from the evil of every insolent tyrant and the despised Devil. Every Killer, thief and every one approaching (to harm); and from the evil of poisonous (animals). Vermin’s and those causing injury; and from the evil of every animal, small or big, by night and by day; and from the evil of the transgressor of Arabs and non-Arabs; and of loose-conduct from among them; and from the evil of the transgressors from among the genii and men: and from the evil of every animal Thou takes by its fore-lock; indeed my Lord is on the right path",
                " \nIn the name of Allah the Most Beneficent the Merciful. My Allah this my prayer which 1 have offered not for any need of Thine for it nor for any linking of Thine towards it but out of esteem and obedience and by way of carrying out what Thou hast commanded me. My Allah if there be any interstice therein or any deficiency in its kneeling postures or its prostrations do not haul me up favour me with acceptance and forgiveness"};

        String [] prayer2={
                "<b><font "+color+">Dua after every prayer</font></b><br>"+ "اَسْتَغْفَرُوْ ا اللهَ الَّذِيْ لَا اَلٰهَ اِلاَّ هُوَ الْحَيُّ الْقَيُّوْمُ ذُوْ الْجَلَالِ وَ الْاِكْرَامِ وَ اَتُوْبُ اِلَيْهِ" ,
                "<b><font "+color+">An excellent invocation Dua after Morning Prayer</font></b><br>"+ "  بِسْمِ اللهِ الرَّحْمٰنِ الرَّحِيْمِ. لَا اِلٰهَ اِلاَّ اللهُ الْجَلِيْلُ الْجَبَّارُ لَا اِلٰهَ اِلاَّ اللهُ الْعَزِيْزُ الْغَفَّارُ لَا اِلٰهَ اِلاَّ اللهُ الْوَاحِدُ الْقَهَّارُ لَا اِلٰهَ اِلاَّ اللهُ وَحْدَهٗ لَا شَرِيْكَ لَهٗ اِلٰهًا وَّاحِدًا وَّ نَحْنُ لَهٗ مُسْلِمُوْنَ لَا اِلٰهَ اِلاَّ اللهُ وَحْدَهٗ لاَ شَرِيْكَ لَهٗ اِلٰهًا وَّاحِدًا وَ نَحْنُ لَهٗ مُخْلِصُوْنَ لَا اِلٰهَ اِلَّا اللهُ وَحْدَهٗ لاَ شَرِيْكَ لَهٗ اِلٰهًا وَّاحِدًا وَّ نَحْنُ لَهٗ عَابِدُوْنَ لاَ اِلٰهَ اِلاَّ اللهُ مُحَمَّدٌ رَّسُوْلُ اللهِ عَلِیٌّ وَلِیُّ اللهِ وَ صَلَّی اللهُ عَلٰی خَيْرِ خَلْقِهٖ وَ مَظْهَرِ لُطْفِهٖ مُحَمَّدٍ وَّ اٰلِهٖ اَجْمَعِيْنَ الطَّيِّبِيْنَ الطَّاهِرِيْنَ بِرَحْمَتِكَ يَا اَرْحَمَ الرَّاحِمِيْنَ حَسْبُنَا اللهُ وَ نِعْمَ الْوَكِيْلُ نِعْمَ الْمَوْلٰی وَ نِعْمَ النَّصِيْرُ."
                ,
                "<b><font "+color+">Dua after Duhar Prayers</font></b><br>"+  "بِسْمِ اللهِ الرَّحْمٰنِ الرَّحِيْمِ. لاَ اِلٰـهَ اِلاَّ اللهُ الْعَظِيْمُ الْحَلِيْمُ لاَ اِلٰـهَ اِلاَّ اللهُ رَبُّ الْعَرْشِ الْكَرِيْمُ الْحَمْدُ لِلّٰهِ رَبِّ الْعَالَمِيْنَ اَللّٰهُمَّ اِنِّيْ أَسْأَلُكَ مُوْجِبَاتِ رَحْمَتِكَ وَ عَزَآئِمَ مَغْفِرَتِكَ وَ الْغَنِيْمَةَ مِنْ كُلِّ بِرٍّ وَ السَّلاَمَةَ مِنْ كُلِّ اِثْمٍ اَللّٰهُمَّ لاَ تَدَعْ لِيْ ذَنْباً اِلاَّ غَفَرْتَهٗ وَ لاَ هَمّاً اِلاَّ فَرَّجْتَهٗ وَ لاَ سُقْمًا اِلاَّ شَفَيْتَهٗ وَ لاَ عَيْباً اِلاَّ سَتَرْتَهٗ وَ لاَ رِزْقاً اِلاَّ بَسَطْتَهٗ وَ لاَ خَوْفاً اِلاَّ اٰمَنْتَهٗ وَ لاَ سُوْءاً اِلاَّ صَرَفْتَهٗ وَ لاَ حَاجَةً هِيَ لَكَ رِضاً وَ لِيَ فِيْهَا صَلاَحٌ اِلاَّ قَضَيْتَهَا يَا اَرْحَمَ الرَّاحِمِيْنَ اٰمِيْنَ رَبَّ الْعَالَمِيْنَ." ,
                "<b><font "+color+">Dua after Asr Prayer</font></b><br>"+  "بِسْمِ اللهِ الرَّحْمٰنِ الرَّحِيْمِ. سُبْحَانَ اللَّهِ وَ الْحَمْدُ لِلَّهِ وَ لَا إِلٰهَ إِلَّا اللَّهُ وَ اللَّهُ أَكْبَرُ وَ لَا حَوْلَ وَ لَا قُوَّةَ إِلَّا بِاللَّهِ الْعَلِيِّ الْعَظِيْمِ سُبْحَانَ اللَّهِ بِالْغُدُوِّ وَ الْآصَالِ سُبْحَانَ اللَّهِ بِالْعَشِيِّ وَ الْإِبْكـَارِ فَسُبْحانَ اللَّهِ حِينَ تُمْسُوْنَ وَ حِيْنَ تُصْبِحُونَ وَ لَهُ الْحَمْدُ فِي السَّمٰوَاتِ وَ الْأَرْضِ وَ عَشِيًّا وَ حِيْنَ تُظْهِرُوْنَ سُبْحَانَ رَبِّكَ رَبِّ الْعِزَّةِ عَمَّا يَصِفُوْنَ وَ سَلَامٌ عَلَى الْمُرْسَلِيْنَ وَ الْحَمْدُ لِلَّهِ رَبِّ الْعالَمِينَ سُبْحَانَ ذِي الْمُلْكِ وَ الْمَلَكُوْتِ سُبْحَانَ ذِي الْعِزِّ وَ الْجَبَرُوْتِ سُبْحَانَ الْحَيِّ الَّذِيْ لَا يَمُوْتُ سُبْحَانَ الْقَائِـمِ الدَّائِـمِ سُبْحَانَ اللَّهِ الْحَيِّ الْقَيُّوْمِ سُبْحَانَ الْعَلِيِّ الْأَعْلَى سُبْحَانَهٗ وَ تَعَالٰى سُبُّوْحٌ قُدُّوْسٌ رَبُّ الْمَلَآئِكَةِ وَ الرُّوْحِ اَللّٰهُمَّ إِنَّ ذَنْبِيْ أَمْسٰى مُسْتَجِيْراً بِعَفْوِكَ وَ خَوْفِي أَمْسٰى مُسْتَجِيْراً بِأَمْنِكَ وَ فَقْرِيْ أَمْسٰى مُسْتَجِيْراً بِغِنَاكَ وَ ذُلِّيْ أَمْسٰى مُسْتَجِيْراً بِعِزِّكَ اَللّٰهُمَّ صَلِّ عَلٰى مُحَمَّدٍ وَ آلِ مُحَمَّدٍ وَ اغْفِرْ لِي وَ ارْحَمْنِيْ إِنَّكَ حَمِيْدٌ مَجِيْدٌ اَللّٰهُمَّ تَمَّ نُوْرُكَ فَهَدَيْتَ فَلَكَ الْحَمْدُ وَ عَظُمَ حِلْمُكَ فَعَفَوْتَ فَلَكَ الْحَمْدُ وَجْهُكَ رَبَّنَا أَكْرَمُ الْوُجُوْهِ وَ جَاهُكَ أَعْظَمُ الْجَاهِ وَ عَطِيَّتُكَ أَفْضَلُ الْعَطَاءِ تُطَاعُ رَبُّنَا وَ تَشْكُرُ وَ تُعْصٰى فَتَغْفِرُ وَ تُجِيْبُ الْمُضْطَرَّ وَ تَكْشِفُ الضُّرَّ وَ تُنَجِّيْ مِنَ الْكَرْبِ وَ تُغْنِي الْفَقِيْرَ وَ تَشْفِي السَّقِيْمَ وَ لَا يُجَازِيْ آلَائَكَ أَحَدٌ وَ أَنْتَ أَرْحَمُ الرَّاحِمِيْنَ",
                "<b><font "+color+">Dua after Maghrib Prayer</font></b><br>"+  "بِسْمِ اللهِ الرَّحْمٰنِ الرَّحِيْمِ. اَللّٰهُمَّ اِنِّیْ اَسْاَلُكَ مُوجِبَاتِ رَحْمَتِكَ وَ عَزَائِمَ مَغْفِرَتِكَ وَ النَّجَاةَ مِنَ النَّارِ وَ مِنْ کُلِّ بَلِيَّةٍ وَ الْفَوْزَ بِالْجَنَّةِ وَ الرِّضْوَانَ فِیْ دَارِ السَّلاَمِ وَ جِوَارِ نَبِّيِّكَ مُحَمَّدٍ عَلَيْهِ وَآلِهِ السَّلاَمُ اَللّٰهُمَّ مَا بِنَا مِنْ نِعْمَةٍ فَمِنْكَ لآَ اِلٰهَ اِلاَّ اَنْتَ اَسْتَغْفِرُكَ وَ اَتُوْبُ اِلَيْكَ" ,
                "<b><font "+color+">Dua after Isha Prayer</font></b><br>"+ " بِسْمِ اللهِ الرَّحْمٰنِ الرَّحِيْمِ. أَعُوْذُ بِعِزَّةِ اللَّهِ وَ أَعُوْذُ بِقُدْرَةِ اللَّهِ وَ أَعُوْذُ بِمَغْفِرَةِ اللَّهِ وَ أَعُوْذُ بِرَحْمَةِ اللَّهِ وَ أَعُوْذُ بِسُلْطَانِ اللَّهِ الَّذِيْ هُوَ عَلٰى كُلِّ شَيْ\u200Fءٍ قَدِيْرٌ وَ أَعُوْذُ بِكَرَمِ اللَّهِ وَ أَعُوْذُ بِجَمْعِ اللَّهِ مِنْ شَرِّ كُلِّ جَبَّارٍ عَنِيْدٍ وَ شَيْطَانٍ مَرِيْدٍ وَ كُلِّ مُغْتَالٍ وَ سَارِقٍ وَ عَارِضٍ وَ مِنْ شَرِّ السَّامَّةِ وَ الْهَامَّةِ وَ الْعَامَّةِ وَ مِنْ شَرِّ كُلِّ دَابَّةٍ صَغِيرَةٍ أَوْ كَبِيرَةٍ بِلَيْلٍ أَوْ نَهَارٍ وَ مِنْ شَرِّ فُسَّاقِ الْعَرَبِ وَ الْعَجَمِ وَ فُجَّارِهِمْ وَ مِنْ شَرِّ فَسَقَةِ الْجِنِّ وَ الْإِنْسِ وَ مِنْ شَرِّ كُـلِّ دَابَّةٍ اَنْتَ آخِذٌ بِناصِيَتِها إِنَّ رَبِّي عَلى صِراطٍ مُسْتَقِيمٍ",
                "<b><font "+color+">Do after every prayer</font></b><br>"+ " بِسْمِ اللهِ الرَّحْمٰنِ الرَّحِيْمِ. إِلٰهِي هٰذِهٖ صَلَاتِيْ صَلَّيْتُهَا لَا لِحَاجَةٍ مِنْكَ إِلَيْهَا وَ لَا رَغْبَةٍ مِنْكَ فِيهَا إِلَّا تَعْظِيمْاً وَ طَاعَةً وَ إِجَابَةً لَكَ إِلٰى مَا أَمَرْتَنِيْ. إِلٰهِي إِنْ كَانَ فِيْهَا خَلَلٌ أَوْ نَقْصٌ مِنْ رُكُوعِهَا أَوْ سُجُوْدِهَا فَلَا تُؤَاخِذْنِي وَ تَفَضَّلْ عَلَيَّ بِالْقَبُوْلِ وَ الْغُفْرَانِ"


        };


        String [] d1={
                "\nIn the name of Allah the Beneficent the Merciful O Allah! Pardon my sins which are many, accept my prayers which are very little",
                "\n In the name of Allah the Beneficent the Merciful. Except Allah, the Generous and Patient, there is no Lord except the Almighty and All wise Allah, there is no lord, Pure is that Allah Who is the Creator of the seven heavens and seven earths and all that is in them and between them. He is due to that God who is the Lord of all the creation",
                "\nIn the name of Allah the Beneficent the Merciful. O Allah! We are only aware of the good deeds of this dead body but you know much more about its acts and deeds",
                "\nIn the name of Allah the Beneficent the Merciful. O Allah the Lord of these souls that have left (this world) and these stale bodies and these rotten bones that have made and exit from this world in the state of having faith in thee, Grant them ease from Thyself and greeting from me"
        };

        String []d2={
                "<b><font "+color+">To be recited at the Time of Death</font></b><br>"+" اَللّٰهُمَّ اغْفِرْ لِيَ الْكَثِيْرَ مِنْ مَعَاصِيْكَ وَ اقْبَلْ مِنِّي الْيَسِيْرَ مِنْ طَاعَتِكَ",

                "<b><font "+color+">To be Recited at the Time of Death</font></b><br>"+  " لَا إِلٰهَ إِلَّا اللَّهُ الْحَلِيْمُ الْكَرِيْمُ لَا إِلٰهَ إِلَّا اللَّهُ الْعَلِيُّ الْعَظِيْمُ سُبْحَانَ اللَّهِ رَبِّ السَّمَاوَاتِ السَّبْعِ وَ رَبِّ الْأَرَضِيْنَ السَّبْعِ وَ مَا فِيْهِنَّ وَ مَا بَيْنَهُنَّ وَ رَبِّ الْعَرْشِ الْعَظِيْمِ وَ الْحَمْدُ لِلَّهِ رَبِّ الْعَالَمِيْنَ" ,

                "<b><font "+color+">To be Recited by 40 Momins at Death Body of Momin</font></b><br>"+ "بِسْمِ اللهِ الرَّحْمٰنِ الرَّحِيْمِ. اَللّٰهُمَّ إِنَّا لَا نَعْلَمُ مِنْهُ إِلَّا خَيْراً وَ أَنْتَ أَعْلَمُ بِهٖ مِنَّا" +
                        "    ",
                "<b><font "+color+">While Entering the Graveyard</font></b><br>"+ " بِسْمِ اللهِ الرَّحْمٰنِ الرَّحِيْمِ. اَللّٰهُمَّ رَبَّ هٰذِهِ الْأَرْوَاحِ الْفَانِيَةِ وَ الْأَجْسَادِ الْبَالِيَةِ وَ الْعِظَامِ النَّخِرَةِ الَّتِيْ خَرَجَتْ مِنَ الدُّنْيَا وَ هِيَ بِكَ مُؤْمِنَةٌ أَدْخِلْ عَلَيْهِمْ رَوْحاً مِنْكَ وَ سَلَاماً مِنِّي"};



        String [] good1={
                "\nThen we did set a seal on their ears for a number of years, then We raised them up that We might Know (i.e. ...show) which of the two parties reckoneth best the duration of their stay",
                "\n O Allah! the Lord of the seven heavens and whatever is between them the Lord of the Great throne; the Lord of Jibraeel, Meekaeel and Israfeel; the lord of the Great Quran; and the Lord of Muhammad the seal of the Prophets. I beseech Thee through Him by whose command the gathering is dispersed, and the scattered are gathered; the living are provided subsistence, the number of sand particles is counted, the weight of the mountains (is known) and the quantity of the Ocean water (is comprehended"};
        String [] good2={
                "<b><font "+color+">Dua for avoiding bad dreams</font></b><br>"+"فَضَرَبْنَا عَلٰى اٰذَانِهِمْ فِى الْكَهْفِ سِنِيْنَ عَدَدًا. ثُمَّ بَعَثْنَاهُمْ لِنَعْلَمَ اَىُّ الْحِزْبَيْنِ اَحْصٰى لِمَا لَبِثُوْآ اَمَدًا",
                "<b><font "+color+">Dua For all purposes</font></b><br>"+ "اَللّٰهُمَّ رَبَّ السَّمَاوَاتِ السَّبْعِ وَ مَا بَيْنَهُنَّ وَ رَبَّ الْعَرْشِ الْعَظِيْمِ وَ رَبَّ جَبْرَئِيْلَ وَ مِيْكَـائِيْلَ وَ إِسْرَافِيْلَ وَ رَبَّ الْقُرْآنِ الْعَظِيْمِ وَ رَبَّ مُحَمَّدٍ خَاتَمِ النَّبِيِّيْنَ إِنِّي أَسْأَلُكَ بِالَّذِيْ تَقُوْمُ بِهِ السَّمَآءَ وَ بِهٖ تَقُوْمُ الْأَرْضَ وَ بِهٖ تُفَرِّقُ بَيْنَ الْجَمْعِ وَ بِهٖ تَجْمَعُ بَيْنَ الْمُتَفَرِّقِ وَ بِهٖ تَرْزُقُ الْأَحْيَآءَ وَ بِهٖ أَحْصَيْتَ عَدَدَ الرِّمَالِ وَ وَزْنَ الْجِبَالِ وَ كَيْلَ الْبُحُوْرِ"
        };



        String [] marriage1={
                "\nIf the proposal for the marriage of a girl of age is not forthcoming recite Surah “Taahaa” (Chap. 20) and blow the breath towards water through hand and offer the water to the girl for drinking. Insha Allah it will bring suitable proposals for her marriage" ,
                "\nVerily I have loved the good things besides the remembrance of my Lord. Until got hidden in the veil (of the darkness of the Night",
                "\nVerily those who believe and work good deeds the Beneficent (God) will appoint love for them",
                "\nO Lord… do good unto me in respect of my offspring: Verily 1 turn unto Thee (repentant), and verily I am one of the Muslims",
                "\nO My Lord! Leave me not alone (without an issue) though Thou art the Best of heirs",
                "\nLord! Grant me from unto Thee a good offspring: Verily, Thou art the Hearer of Prayer",
                "\nO my Lord! Leave me not alone (without an issue) though Thou art the Best of heirs",
                "\n And the throes (of child birth) forced her to betake herself unto the trunk of a palm tree. She said, “O! Had I died before this, and had been lost in oblivion totally forgotten!” Then (a voice) called out unto her from beneath her, “Grieve not thou, verily Thy Lord hath caused from beneath thee. (To flow) a stream!” And shale towards thee the trunk of the palm tree in will drop on the dates fresh (and) ripe: And say loudly:",
                "\nIf the children of a woman die young and do not grow up one should recite Surah “Muzzammil” (Chap 73) seven times. Every time blowing the breath towards betel-nut round his/her neck with a cotton thread passed through the betel-nut Insha Allah the child will grow up",
                "\nI begin with the name of Allah and with reliance with Him O Allah this Aqiqa is of (take the name of the child and his father) this meat is instead of his meat. This blood is instead of his blood and these bones are instead of his bones. O Allah. (I beseech Thee) through Mohammad and ale-Mohammad to consider this Aqiqa instead of the child",
                "\nO Allah! This is Thy Sunnat and that of Thy Prophet on whom and on whose Aal (dear ones) Thou shower Thy blessing We follow Thou and Thy Prophet which is in accordance with Thy will Intention and the affair about which Thou had willed and decided and commanded according to which Thou hast made him taste the temperature of iron and Hajamat (vivisection) the suitability of which Thou art more aware than us,O Allah! Cleanse him of his sins. Lengthen his age. All his bodily pains, and make him healthy and let him not suffer from poverty for Thou hast knowledge whereas we do not have",
                "\nSurah Qaaf (Chap. 50) he written saffron and washed and child’s mouth be washed with that water, Insha Allah the child will cut teeth easily.",
                "\nThem He loveth and they love Him. Lowly before the believers, mighty against the infidels",
                "\n  O Allah! I beseech Thee through those who were referred to by Zakaria. He had said “O my Allah! Leave me not alone and there is no better guardian than Thee.” O Allah! Bless me through Thee with a pious child; undoubtedly Thou art the Hearer of all prayers. O Allah! Through Thy name I have made this woman permissible unto me and have taken her from Thy guardianship. If Thou intend this woman’s womb to be filled with the child then make this child virtuous and pure and let partake anything of the Satan",
                "\nAnd (O Our Prophet Mohammed!) remember her (Mary) who guarded her chastity We breathed into her Our Sprit, and We made her and her son a sign unto all peoples. Verily the (Islam) is your group, one group and I am your Lord! Therefore worship ye Me (alone)! But they have rent as under (this) their concern among themselves (into sects), (and yet) unto Us shall all of them return",


        };




        String [] marriage2={
                "<b><font "+color+">For marriage proposal</font></b><br>",
                "<b><font "+color+">For love (Wife & Husband)</font></b><br>"+  "اِنِّىْٓ اَحْبَبْتُ حُبَّ الْخَيْرِ عَنْ ذِكْرِ رَبِّىْ، حَتّٰى تَوَارَتْ بِالْحِجَابِ",
                "<b><font "+color+">For love (Wife & Husband)</font></b><br>"+   "اِنَّ الَّذِيْنَ اٰمَنُوْا وَ عَمِلُوا الصَّالِحَاتِ سَيَجْعَلُ لَهُمُ الرَّحْمٰنُ وُدًّا",
                "<b><font "+color+">For Obedience</font></b><br>"+   "رَبِّ ...اَصْلِحْ لِىْ فِىْ ذُرِّيَّتِىْ، اِنِّىْ تُبْتُ اِلَيْكَ وَ اِنِّىْ مِنَ الْمُسْلِمِيْنَ",
                "<b><font "+color+">For getting a child</font></b><br>"+   " رَبِّ لاَ تَذَرْنِىْ فَرْدًا وَّ اَنْتَ خَيْرُ الْوَارِثِيْنَ" ,
                "<b><font "+color+">For Getting a Child</font></b><br>"+  "رَبِّ هَبْ لِىْ مِنْ لَّدُنْكَ ذُرِّيَّةً طَيِّبَةً، اِنَّكَ سَمِيْعُ الدُّعَآءِ",
                "<b><font "+color+">For getting a child</font></b><br>"+    " رَبِّ لاَ تَذَرْنِىْ فَرْدًا وَّ اَنْتَ خَيْرُ الْوَارِثِيْنَ",
                "<b><font "+color+">For easy and safe delivery of child</font></b><br>"+    "فَاَجَآءَ هَا الْمَخَاضُ اِلٰى جِذْعِ النَّخْلَةِ، قَالَتْ يَالَيْتَنِىْ مِتُّ قَبْلَ هٰذَا وَ كُنْتُ نَسْيًا مَّنْسِيًّا. فَنَادَاهَا مِنْ تَحْتِهَآ اَلاَّ تَحْزَنِىْ قَدْ جَعَلَ رَبُّكِ تَحْتَكِ سَرِيًّا. وَ هُزِّىْٓ اِلَيْكِ بِجِذْعِ النَّخْلَةِ تُسَاقِطْ عَلَيْكِ رُطَبًا جَنِيًّا" ,
                "<b><font "+color+">For avoiding early deaths of children</font></b><br>"+  "  ",
                "<b><font "+color+">Dua for Aqiqa of child</font></b><br>"+   "بِسْمِ اللهِ وَبِاللهِ اَللّٰہُمَّ هٰذِهٖ عَقِیْقَةٌ عَنْ فُلانٍ  لَحْمُہَا بِلَحْمِہٖ وَدَمُہَا بِدَمِہٖ وَعَظْمُہَا بِعَظْمِہٖ اَللّٰہُمَّ اجْعَلْہَا وِقَاءً لِآلِ مُحَمَّدٍ عَلَیْہِ وَآلِہِ السَّلَامُ",
                "<b><font "+color+">At the time of Circumcision</font></b><br>"+   "اَللّٰهُمَّ هٰذِهٖ سُنَّتُكَ وَ سُنَّةُ نَبِيِّكَ صَلَوَاتُكَ عَلَيْهِ وَ آلِهٖ وَ اتِّبَاعٌ مِنَّا لَكَ وَ لِنَبِيِّكَ بِمَشِيَّتِكَ وَ بِإِرَادَتِكَ وَ قَضَآئِكَ لِأَمْرٍ أَنْتَ أَرَدْتَهٗ وَ قَضَآءٍ حَتَمْتَهٗ وَ أَمْرٍ أَنْفَذْتَهٗ فَأَذَقْتَهٗ حَرَّ الْحَدِيْدِ فِي خِتَانِهٖ وَ حِجَامَتِهٖ لِأَمْرٍ أَنْتَ أَعْرَفُ بِهٖ مِنِّي اَللّٰهُمَّ فَطَهِّرْهُ مِنَ الذُّنُوبِ وَ زِدْ فِي عُمُرِهٖ وَ ادْفَعِ الْآفَاتِ عَنْ بَدَنِهٖ وَ الْأَوْجَاعَ عَنْ جِسْمِهٖ وَ زِدْهُ مِنَ الْغِنٰى وَ ادْفَعْ عَنْهُ الْفَقْرَ فَإِنَّكَ تَعْلَمُ وَ لَا نَعْلَمُ" ,
                "<b><font "+color+">Dua for easy Teething</font></b><br>"+   "",
                "<b><font "+color+">For love (Wife & Husband)</font></b><br>"+   "  يُّحِبُّهُمْ وَ يُحِبُّوْنَهٗٓ، اَذِلَّةٍ عَلَى الْمُؤْمِنِيْنَ اَعِزَّةٍ عَلَى الْكَافِرِيْنَ",
                "<b><font "+color+">Dua and prayers for getting a child</font></b><br>"+   "اَللّٰهُمَّ إِنِّي أَسْأَلُكَ بِمَا سَأَلَكَ بِهٖ زَكَرِيَّا يَا رَبِّ لَا تَذَرْنِي فَرْداً وَ أَنْتَ خَيْرُ الْوَارِثِيْنَ اَللّٰهُمَّ هَبْ لِي مِنْ لَدُنْكَ ذُرِّيَّةً طَيِّبَةً إِنَّكَ سَمِيْعُ الدُّعَآءِ اَللّٰهُمَّ بِاسْمِكَ اسْتَحْلَلْتُهَا وَ فِي أَمَانَتِكَ أَخَذْتُهَا فَإِنْ قَضَيْتَ فِي رَحِمِهَا وَلَداً فَاجْعَلْهُ غُلَاماً مُبَارَكاً زَكِيّاً وَ لَا تَجْعَلْ لِلشَّيْطَانِ فِيْهِ شِرْكاً وَ لَا نَصِيْبًا" ,
                "<b><font "+color+">Dua for Safety of Pregnancy</font></b><br>"+   "وَالَّتِىْٓ اَحْصَنَتْ فَرْجَهَا فَنَفَخْنَا فِيْهَا مِنْ رُّوْحِنَا وَ جَعَلْنَاهَا وَابْنَهَآ اٰيَةً لِّلْعَالَمِيْنَ. اِنَّ هٰذِهٖٓ اُمَّتُكُمْ اُمَّةً وَّاحِدَةً، وَّاَنَا رَبُّكُمْ فَاعْبُدُوْنِ. وَ تَقَطَّعُوْآ اَمْرَهُمْ بَيْنَهُمْ، كُلٌّ اِلَيْنَا رَاجِعُوْنَ",
        };




        String [] protect1={
                "\nI beseech Allah (to grant me) Paradise and I seek protection of Allah from the (Hell) Fire: at this the Hell Says: O Allah grant him/her Protection",
                "\nSo Glory be to Allah when you enter evening and when you enter the morning, and for Him (alone) is all the praise in the heavens and the earth. At the sun’s decline and when you enter the noon",
                "\nIn the name of Allah the Beneficent the Merciful O Allah! O Allah! O Allah! The Security, the Security the Security from the vanishment of the faith. O the Eternally Known! O the Eternally Obliging and O the Guide of those gone astray, Thee alone do we worship and of Thee (only) do we seek help. May Allah’s blessings be upon His best creation Mohammed and all his (pure) progeny.",
                "\nThere is no Lord except Allah: He is such a One Who has no partner and holds the power of the life and death of His creatures and Himself is such a Being Who never",
                "\nNot fearing to be overtaken, nor being afraid",
                "\nVerily my protector is God who sent down the Book (Qur’an) and He gradeth the virtuous once They have esteemed not God, as is His due: while the whole earth shall Be in His grip on the Day of judgement and heavens rolled up (shall be) in His right hand, Hallowed is He, and Exalted is He, high above what they associate (with Him)",
                "\nIn the name of Allah the Beneficent and the Merciful. I seek protection against evil, I find around me through the honour of Allah and the might of Allah and the strength of Allah and the grandeur of Allah and the proof of Allah and the Supremacy as Allah and the protection by Allah and the succour of Allah and the safe guard by Allah and the fortification by Allah and safe guard by Allah and the pride of Allah and superintendence of Allah and the splendour of Allah and the majesty of Allah and the perfection of Allah and the glory of Allah and through “Laa elaaha illal laah Mohammadun Rusoolul laah,” (i.e. there is no deity but Allah. Muhammad, Allah’s blessings and peace be upon him and his holy posterity, is the Messenger of Allah.)",
                "\nThere is no god but Allah. I trust in Him for He is the Lord of the throne.[31] Whatever He wishes it happens and whatever He does not desire does not happen. I bear witness that indeed Allah has power over everything and indeed his knowledge encompasses everything.[32] O my lord I seek “Thy refuge from the evil of myself and from the evil of every creature of the earth who is under Your control and power in the way of my Lord is the right path",
                "\n In the name of Allah the Beneficent and the Merciful. Verily your Lord is Allah who created the heavens and the earth in six days, then established Himself upon the arsh (throne). He throweth the veil of night over the day, which pursueth it incessantly, and the sun and the moon and the star, made (absolutely) subservient to his command; Be it known! (That) His is the creation and the command; Blessed is Allah the Lord of the Worlds. Call ye on you Lord humbly and secretly verily loveth not Allah the transgressors. And make ye not mischief in the earth after its reformation call ye on him fearing His wrath and Hoping (for his mercy) verily the Mercy of Allah is well-night unto those who do good",
                "\nO Allah! O the Lord of Moosa (a.s.) who honoured him with His communion, who prevailed with Moosa (a.s.) and who retransformed it in to a serpent, after transforming it to its original state who got the falsehood of the liars swallowed up who reduced to naught the craft of the magician and O Thou who nullified the mischief of the mischief-monger; grant me with metaphysical whoever vexes me with magic, or inflicts harm on me intentionally or otherwise, whether I know about it or not, whether I am afraid of it or not, with heavenly means cut off his action, till it be warded off from me without being executed, without being harmful to me, and without having malevolent effect on me. Indeed, with Thy Greatness, I ward off my enemies; so (O Allah). You be my Protector against them with the Best Protection with Perfection O the Benevolent"
                ,"\n O my Rescuer in my difficulties: O my Helper in my afflictions Guard me with the eye that sleepeth not, and suffice me with the pillar of Might which cannot be reached: O the Master of great artifice. And O the Purchaser of the honour before whom all Thy creation is low and humble: Send the blessings on Mohammad and (holy) progeny of Mohammad. Help me against the oppressor and take my revenge from him",
                "\nI begin be relying on the name and relity of Allah and Mohammad (s.a.w.a.) The Prophet of God. Except Allah no one possesses power might. O Allah! Alleviate the pain I am suffering from."
                ,"\n There is no power and strength except with Allah the Grand, The Great",
                "\nThe Almighty God is pure and I begin with His praise. I pray salvation from Him and supplicate His Blessings"
                ,"\nO my Rescuer in my difficulties: O my Helper in my afflictions: Guard me with the eye that sleepeth not, and suffice me with the pillar of Might which cannot be reached: O the Master of great artifice. And O the Purchaser of the honour before whom all Thy creation is low and humble: Send the blessings on Mohammad and (holy) progeny of Mohammad. Help me against the oppressor and take my revenge from him"
                ,"\nAlif Laam Mim. This is the Book, there is no doubt in it, (being the word of God) (it is) a guidance for the pious. (Ones). Who believe in the unseen, and establish the prayers and of what We have provided them with. They give (in the way of their Lord). And who believe in that which hath been sent down unto thee (O Our Prophet Mohammad) and that which hath been sent down (unto the other Prophets) before thee, and of the hereafter they are sure.[11]\n" +
                "Allah is He besides Whom there is no god, the Everliving, the Self-subsisting by Whom all subsist; slumber does not overtake Him nor sleep; whatever is in the heavens and whatever is in the earth is His; who is he that can intercede with Him but by His permission? He knows what is before them and what is behind them, and they cannot comprehend anything out of His knowledge except what He pleases. His knowledge extends over the heavens and the earth, and the preservation of them both tires Him not, and He is the Most High, the Great. There is no compulsion in religion; truly the right way has become clearly distinct from error; therefore, whoever disbelieves in the Shaitan and believes in Allah he indeed has laid hold on the firmest handle, which shall not break off, and Allah is Hearing, Knowing. Allah is the guardian of those who believe. He brings them out of the darkness into the light; and (as to) those who disbelieve, their guardians are Shaitans who take them out of the light into the darkness; they are the inmates of the fire, in it they shall abide.[12]" +
                "Whatever is in the heavens and whatever is in the earth is Allah’s; and whether you manifest what is in your minds or hide it, Allah will call you to account according to it; then He will forgive whom He pleases and chastise whom He pleases, and Allah has power over all things. The apostle believes in what has been revealed to him from his Lord and (so do) the believers; they all believe in Allah and His angels and His books and His apostles; We make no difference between any of His apostles; and they say: We hear and obey, our Lord! Thy forgiveness (do we crave), and to Thee is the eventual course. Allah does not impose upon any soul a duty but to the extent of its ability; for it is (the benefit of) what it has earned and upon it (the evil of) what it has wrought: Our Lord! Do not punish us if we forget or make a mistake; Our Lord! do not lay on us a burden as Thou didst lay on those before us; Our Lord do not impose upon us that which we have not the strength to bear; and pardon us and grant us protection and have mercy on us, Thou art our Patron, so help us against the unbelieving people"



        };


        String [] protect2={
                "<b><font "+color+">For protection from Hell</font></b><br>"+ "أَسْأَلُ اللَّهَ الْجَنَّةَ وَ أَعُوذُ بِاللَّهِ مِنَ النَّارِ" ,
                "<b><font "+color+">For great sawab and protection from major sins</font></b><br>"+" فَسُبْحَانَ اللهِ حِيْنَ تُمْسُوْنَ وَ حِيْنَ تُصْبِحُوْنَ. وَ لَهُ الْحَمْدُ فِى السَّمَاوَاتِ وَ الْاَرْضِ وَ عَشِيًّا وَّ حِيْنَ تُظْهِرُوْنَ",
                "<b><font "+color+">For preservation of faith</font></b><br>"+ " بِسْمِ اللهِ الرَّحْمٰنِ الرَّحِيْمِ. يَا اَللهُ يَا اَللهُ يَا اَللهُ اَلْاَمَانُ اَلْاَمَانُ اَلْاَمَانُ مِنْ زَوَالِ الْاِيْمَانِ يَا دَآئِمَ الْمَعْرُوْفِ يَا قَدِيْمَ الْاِحْسَانِ وَ يَا هَادِيَ الْمُضِلِّيْنَ اِيَّاكَ نَعْبُدُ وَ اِيَّاكَ نَسْتَعِيْنُ وَ صَلَّي اللهُ عَلٰي خَيْرِ خَلْقِهٖ مُحَمَّدٍ وَآلِهٖ اَجْمَعِيْنَ",
                "<b><font "+color+">Dua for not getting afraid in sleep</font></b><br>"+ "  لَا إِلٰهَ إِلَّا اللَّهُ وَحْدَهٗ لَا شَرِيْكَ لَهٗ لَهُ الْمُلْكُ وَ لَهُ الْحَمْدُ يُحْيِيْ وَ يُمِيْتُ وَ يُمِيْتُ وَ يُحْيِيْ وَ هُوَ حَيٌّ لَا يَمُوْتُ",
                "<b><font "+color+">For safety from robbers</font></b><br>"+"  لَا تَخَافُ دَرَكاً وَ لَا تَخْشٰى",
                "<b><font "+color+">For safety from drowning</font></b><br>"+"<b><font "+color+"></font></b><br>"+" اِنَّ وَلِىِّىَ اللهُ الَّذِىْ نَزَّلَ الْكِتَابَ، وَ هُوَ يَتَوَلَّى الصَّالِحِيْنَ وَ مَا قَدَرُوْا اللهَ حَقَّ قَدْرِهٖ، وَ الْاَرْضُ جَمِيْعًا قَبْضَتُهٗ يَوْمَ الْقِيَامَةِ وَ السَّمٰوَاتُ مَطْوِيَّاتٌۢ بِيَمِيْنِهٖ، سُبْحَانَهٗ وَ تَعَالٰى عَمَّا يُشْرِكُوْنَ",
                "<b><font "+color+">Dua for Banishing the Effect of Black Magic</font></b><br>"+"اَعُوْذُ بِعِزَّةِ الله وَ قُدْرَةِ اللهِ وَ قُوَّةِ اللهِ وَ عَظَمَةِ اللهِ وَ بُرْهَانِ اللهِ وَ سُلْطَانِ اللهِ وَ كَنَفِ اللهِ وَ جَوَارِ اللهِ وَ اَمَانِ اللهِ وَ حِرْزِ اللهِ وَ صُنْعِ اللهِ وَ كِبْرِيَآءِ اللهِ وَ نَظَرِ اللهِ وَ بَهَآءِ اللهِ وَ جَلاَلِ اللهِ وَ كَمَالِ اللهِ وَ جَمَالِ اللهِ لَآ اِلٰهَ اِلاَّ اللهُ مُحَمَّدٌ رَّسُوْلُ اللهِ مِنْ شَرِّ مَا اَجِدُ.",
                "<b><font "+color+">Dua for Protection from Satan and Enchantment</font></b><br>"+" لَا إِلٰهَ إِلَّا اللَّهُ عَلَيْهِ تَوَكَّلْتُ وَ هُوَ رَبُّ الْعَرْشِ الْعَظِيْمِ مَا شَاءَ اللَّهُ كَانَ وَ مَا لَمْ يَشَأْ لَمْ يَكُنْ أَشْهَدُ أَنَّ اللَّهَ عَلٰى كُلِّ شَيْءٍ قَدِيْرٌ وَ أَنَّ اللَّهَ قَدْ أَحاطَ بِكُـلِّ شَيْءٍ عِلْماً اَللّٰهُمَّ إِنِّي أَعُوْذُ بِكَ مِنْ شَرِّ نَفْسِي وَ شَرِّ كُلِّ دَابَّةٍ أَنْتَ آخِذٌ بِنَاصِيَتِهَا إِنَّ رَبِّيْ عَلٰى صِرَاطٍ مُسْتَقِيْمٍ",
                "<b><font "+color+">Dua for Repelling Devil and Dispelling Magic</font></b><br>"+ " اِنَّ ربَّكُمُ اللهُ الَّذِىْ خَلَقَ السَّمَاوَاتِ وَالْاَرْضَ فِىْ سِتَّةِ اَيَّامٍ ثُمَّ اسْتَوٰى عَلَى الْعَرْشِ يُغْشِى اللَّيْلَ النَّهَارَ يَطْلُبُهٗ حَثِيْثًا وَّالشَّمْسَ وَالْقَمَرَ وَالنُّجُوْمَ مُسَخَّرَاتٍ بِاَمْرِهٖ اَلاَ لَهُ الْخَلْقُ والْاَمْرُ تَبَارَكَ اللهُ رَبُّ الْعَالَمِيْنَ. اُدْعُوْا رَبَّكُمْ تَضَرُّعًا وَّخُفْيَةً اِنَّهٗ لاَيُحِبُّ الْمُعْتَدِيْنَ. وَلاَ تُفْسِدُوْا فِى اْلاِرْضِ بَعْدَ اِصْلاَحِهَا وَادْعُوْهُ خَوْفًا وَّطَمَعًا اِنَّ رَحْمَتَ اللهِ قَرِيْبٌ مِّنَ الْمُحْسِنِيْنَ."
                , "<b><font "+color+">Dua for security against Witch Craft</font></b><br>"+"اَللّٰهُمَّ رَبَّ مُوْسٰى وَ خَاصَّهٗ بِكَـلَامِهٖ وَ هَازِمَ مَنْ كَادَهٗ بِسِحْرِهٖ بِعَصَاهُ وَ مُعِيْدَهَا بَعْدَ الْعَوْدِ ثُعْبَاناً وَ مُلَقِّفَهَا إِفْكَ أَهْلِ الْإِفْكِ وَ مُفْسِدَ عَمَلِ السَّاحِرِيْنَ وَ مُبْطِلَ كَيْدِ أَهْلِ الْفَسَادِ مَنْ كَادَنِي بِسِحْرٍ أَوْ بِضُرٍّ عَامِداً أَوْ غَيْرَ عَامِدٍ أَعْلَمُهٗ أَوْ لَا أَعْلَمُهٗ وَ أَخَافُهٗ أَوْ لَا أَخَافُهٗ فَاقْطَعْ مِنْ أَسْبَابِ السَّمَاوَاتِ عَمَلَهٗ حَتّٰى تُرْجِعَهٗ عَنِّي غَيْرَ نَافِذٍ وَ لَا ضَارٍّ لِيْ وَ لَا شَامِتٍ بِيْ إِنِّيْ أَدْرَأُ بِعَظَمَتِكَ فِي نُحُوْرِ الْأَعْدَاءِ فَكُنْ لِي مِنْهُمْ مُدَافِعاً أَحْسَنَ مُدَافَعَةٍ وَ أَتَمَّهَا يَا كَرِيْمُ"
                , "<b><font "+color+">For safety from enemy</font></b><br>"+"يَا عُدَّتِي عِنْدَ شِدَّتِي وَ يَا غَوْثِي عِنْدَ كُرْبَتِي اُحْرُسْنِي بِعَيْنِكَ الَّتِيْ لَا تَنَامُ وَ اكْنُفْنِي بِرُكْنِكَ الَّذِي لَا يُرَامُ يَا ذَا الْقُوَّةِ الْقَوِيَّةِ وَ يَا ذَا الْمِحَالِ الشَّدِيْدِ وَ يَا ذَا الْعِزَّةِ الَّتِيْ كُلُّ خَلْقِكَ لَهَا ذَلِيلٌ صَلِّ عَلٰي مُحَمَّدٍ وَ آلِ مُحَمَّدٍ وَ اكْفِنِيْ ظَالِمِيْ وَ انْتَقِمْ لِي مِنْهُ"
                , "<b><font "+color+">Dua for avoiding temptation & greed</font></b><br>"+"بِسْمِ اللَّهِ وَ بِاللَّهِ وَ مُحَمَّدٌ رَسُوْلُ اللَّهِ صَلَّي اللهُ عَلَيْهِ وَ آلِهٖ وَ سَلَّمَ وَ لَا حَوْلَ وَ لَا قُوَّةَ إِلَّا بِاللَّهِ الْعَلِيِّ الْعَظِيْمِ اَللّٰهُمَّ امْسَحْ عَنِّيْ مَا أَجِدُ"
                ,  "<b><font "+color+">For removal of Poverty and Worries</font></b><br>"+"لَا حَوْلَ وَ لاَ قُوَّةَ اِلاَّ بِاللهِ الْعَلِيِّ الْعَظِيْمِ"
                , "<b><font "+color+">For removing Worries</font></b><br>"+ " سُبْحَانَ اللَّهِ الْعَظِيْمِ وَ بِحَمْدِهٖ أَسْتَغْفِرُ اللَّهَ وَ أَسْأَلُهٗ مِنْ فَضْلِه"
                ,  "<b><font "+color+">For safety from enemy</font></b><br>"+"يَا عُدَّتِي عِنْدَ شِدَّتِي وَ يَا غَوْثِي عِنْدَ كُرْبَتِي اُحْرُسْنِي بِعَيْنِكَ الَّتِيْ لَا تَنَامُ وَ اكْنُفْنِي بِرُكْنِكَ الَّذِي لَا يُرَامُ يَا ذَا الْقُوَّةِ الْقَوِيَّةِ وَ يَا ذَا الْمِحَالِ الشَّدِيْدِ وَ يَا ذَا الْعِزَّةِ الَّتِيْ كُلُّ خَلْقِكَ لَهَا ذَلِيلٌ صَلِّ عَلٰي مُحَمَّدٍ وَ آلِ مُحَمَّدٍ وَ اكْفِنِيْ ظَالِمِيْ وَ انْتَقِمْ لِي مِنْهُ"
                , "<b><font "+color+">For protection of self and wealth</font></b><br>"+"بِسْمِ اللهِ الرَّحْمٰنِ الرَّحِيْمِ. الٓمّٓ. ذٰلِكَ الْكِتَابُ لاَ رَيْبَ، فِيْهِ، هُدًى لِّلْمُتَّقِيْنَ. الَّذِيْنَ يُؤْمِنُوْنَ بِالْغَيْبِ وَ يُقِيْمُوْنَ الصَّلوٰةَ وَ مِمَّا رَزَقْنَاهُمْ يُنْفِقُوْنَ. وَالَّذِيْنَ يُؤْمِنُوْنَ بِمَآ اُنْزِلَ اِلَيْكَ وَمَآ اُنْزِلَ مِنْ قَبْلِكَ، وَ بِالْاٰخِرَةِ هُمْ يُوْقِنُوْن." +
                "اَللهُ لَآاِلٰهَ اِلاَّ هُوَ، اَلْحَىُّ الْقَيُّوْمُ، لاَ تَاْخُذُهٗ سِنَةٌ وَّلاَ نُوْمٌ، لَهٗ مَا فِى السَّمَاوَاتِ وَمَا فِى الْاَرْضِ، مَنْ ذَا الَّذِىْ يَشْفَعُ عِنْدَهٗٓ اِلاَّ بِاِذْنِهٖ، يَعْلَمُ مَا بَيْنَ اَيْدِيْهِمْ وَمَا خَلْفَهُمْ، وَلاَ يُحِيْطُوْنَ بِشَىْءٍ مِّنْ عِلْمِهٖٓ اِلاَّ بِمَا شَآءَ، وَسِعَ كُرْسِيُّهُ السَّمَاوَاتِ وَالْاَرْضَ، وَلاَ يَئُوْدُهٗ حِفْظُهُمَا، وَهُوَ الْعَلِىُّ الْعَظِيْمُ. لَآ اِكْرَاهَ فِى الدِّيْنَ، قَدْ تّبَيَّنَ الرُّشْدُ مِنَ الْغَىِّ، فَمَنْ يَّكْفُرْ بِالطَّاغُوْتِ وَيُؤْمِنْۢ بِاللهِ فَقَدِ اسْتَمْسَكَ بِالْعُرْوَةِ الْوُثْقٰى، لَانْفِصَامَ لَهَا، وَاللهُ سَمِيْعٌ عَلِيْمٌ. اَللهُ وَلِىُّ الَّذِيْنَ اٰمَنُوْا، يُخْرِجُهُمْ مِّنَ الظُّلُمَاتِ اِلَى النُّوْرِ، وَ الَّذِيْنَ كَفَرُوْآ اَوْلِيَآئُهُمُ الطَّاغُوْتُ، يُخْرِجُوْنَهُمْ مِّنَ النُّوْرِ اِلَى الظُّلُمَاتِ، اُولٰۤئِكَ اَصْحَابُ النَّارِ، هُمْ فِيْهَا خَالِدُوْنَ." +
                "لِلّٰهِ مَا فِى السَّمَاوَاتِ وَمَا فِى الْاَرْضِ، وَ اِنْ تُبْدُوْا مَا فِىْٓ اَنْفُسِكُمْ اَوْ تُخْفُوْهُ يُحَاسِبْكُمْ بِهِ اللهُ، فَيَغْفِرُ لِمَنْ يَّشَآءُ وَ يُعَذِّبُ مَنْ يَّشَآءُ، وَاللهُ عَلٰي كُلِّ شَىْ ءٍ قَدِيْرٌ . اٰمَنَ الرَّسُوْلُ بِمَآ اُنْزِلَ اِلَيْهِ مِنْ رَّبِّهٖ وَالْمُؤْمِنُوْنَ، كُلٌّ اٰمَنَ بِاللهِ وَ مَلَآئِكَتِهٖ وَ كُتُبِهٖ وَ رُسُلِهٖ، لاَ نُفَرِّقُ بَيْنَ اَحَدٍ مِّنْ رُّسُلِهٖ، وَقَالُوْا سَمِعْنَا وَ اَطَعْنَا، غُفْرَانَكَ رَبَّنَا وَ اِلَيْكَ الْمَصِيْرُ . لاَ يُكَلِّفُ اللهُ نَفْسًا اِلاَّ وُسْعَهَا، لَهَا مَا كَسَبَتْ وَ عَلَيْهَا مَا اكْتَسَبَتْ، رَبَّنَا لاَ تُوٴَاخِذْنَآ اِنْ نَّسِيْنَآ اَوْ اَخْطَاْنَا، رَبَّنَا وَلاَ تَحْمِلْ عَلَيْنَآ اِصْرًا كَمَا حَمَلْتَهٗ عَلَى الَّذِيْنَ مِنْ قَبْلِنَا، رَبَّنَا وَلاَ تُحَمِّلْنَا مَا لاَ طَاقَةَ لَنَا بِهٖ، وَاعْفُ عَنَّا، وَاغْفِرْلَنَا، وَارْحَمْنَا، اَنْتَ مَوْلَانَا فَانْصُرْنَا عَلَى الْقَوْمِ الْكَافِرِيْنَ"
        };




        String [] dis1={
                "\nIn the name of Allah the Beneficent and the Merciful. O Allah! I beseech Thee for the speedy recovery or patience on the affliction and going out of this world toward Thy mercy",
                "\n In the name of Allah the Beneficent and the Merciful. My Allah I ask Thee quick recovery or else endurance on Thy trail from this world towards Thy Mercy",
                "\n In the name of Allah the Beneficent and the Merciful. O the Light! Which is the Light of everything and guides of it, Thou art the One, Who splitted the darkness by His Light"};

        String []dis2={
                "<b><font "+color+">Dua for cure of all Diseases</font></b><br>"+ "بِسْمِ اللهِ الرَّحْمٰنِ الرَّحِيْمِ. اَللّٰهُمَّ إِنِّي أَسْأَلُكَ تَعْجِيْلَ عَافِيَتِكَ أَوْ صَبْراً عَلٰى بَلِيَّتِكَ أَوْ خُرُوْجًا إِلٰى رَحْمَتِكَ.",
                "<b><font "+color+">Dua for all Diseases and for all Purposes</font></b><br>"+  "بِسْمِ اللهِ الرَّحْمٰنِ الرَّحِيْمِ. اَللّٰهُمَّ إِنِّي أَسْأَلُكَ تَعْجِيْلَ عَافِيَتِكَ وَ صَبْراً عَلٰى بَلِيَّتِكَ وَ خُرُوْجًا مِنَ الدُّنْيَا إِلٰى رَحْمَتِكَ.",
                "<b><font "+color+">Dua for Cure from All Diseases</font></b><br>"+  " بِسْمِ اللهِ الرَّحْمٰنِ الرَّحِيْمِ. يَا نُوْرَ كُلِّ شَيْءٍ وَ هُدَاهُ أَنْتَ الَّذِيْ فَلَقَ الظُّلُمَاتِ نُوْرُهٗ"};

        String [] learn1={
                "\nIn the name of Allah the Beneficent, and the Merciful. Glory be to be him who does not oppress His subject Glory be to him who does not chastise the people of the earth with various punishments. Glory be to Him who is kind (and) Merciful O my Lord establish in my mind, light insight wisdom and knowledge indeed you have power on everything",
                "\nO Allah! Be merciful on me by making me obedient to thee and not to be disobedient till my life time. Be merciful on me by not commanding me what is beyond my capacity. Grant me such virtuous conduct which makes Thee Pleased with me. Make my heart to preserve thy book (Quran) as thou has taught me. Grant me so that I may recite it in the manner which makes Thee pleased with me. O Allah! Brighten my eyes: and expend for my breast with it; and open my mind with it and free with my tongue: and devote my body to it; and strengthen me over it and help me over it because certainly there is no helper in this matter save thee. There is no god except Thee",
                "\nHe is Allah who sent down the book (Quran) and He guardeth the virtuous one They have esteemed not Allah, as is His due: While the whole earth shall be in His grip on the day of Judgement and heavens rolled up (shall be) in the right hand: Hallowed is He and Exalted is He, high above what they associate (with Him)"};

        String []learn2={
                "<b><font "+color+">Dua for Increasing Memory</font></b><br>"+ "سُبْحَانَ مَنْ لَا يَعْتَدِي عَلٰى أَهْلِ مَمْلَكَتِهٖ سُبْحَانَ مَنْ لَا يَأْخُذُ أَهْلَ الْأَرْضِ بِأَلْوَانِ الْعَذَابِ سُبْحَانَ الرَّءُوْفِ الرَّحِيْمِ اَللّٰهُمَّ اجْعَلْ لِي فِي قَلْبِيْ نُوراً وَ بَصَراً وَ فَهْماً وَ عِلْماً إِنَّكَ عَلٰى كُلِّ شَيْءٍ قَدِيْرٌ.",
                "<b><font "+color+">Dua for Learning Quran by Heart</font></b><br>"+  "  اَللّٰهُمَّ ارْحَمْنِيْ بِتَرْكِ مَعَاصِيْكَ أَبَداً مَا أَبْقَيْتَنِيْ وَ ارْحَمْنِيْ مِنْ تَكَـلُّفِ مَا لَا يَعْنِيْنِيْ وَ ارْزُقْنِيْ حُسْنَ الْمَنْظَرِ فِيْمَا يُرْضِيْكَ عَنِّيْ وَ أَلْزِمْ قَلْبِيْ حِفْظَ كِتَابِكَ كَمَا عَلَّمْتَنِيْ وَ ارْزُقْنِيْ أَنْ أَتْلُوَهٗ عَلَى النَّحْوِ الَّذِي يُرْضِيْكَ عَنِّي اَللّٰهُمَّ نَوِّرْ بِكِتَابِكَ بَصَرِيْ وَ اشْرَحْ بِهٖ صَدْرِيْ وَ فَرِّحْ بِهٖ قَلْبِيْ وَ أَطْلِقْ بِهٖ لِسَانِيْ وَ اسْتَعْمِلْ بِهٖ بَدَنِيْ وَ قَوِّنِيْ عَلٰى ذٰلِكَ وَ أَعِنِّيْ عَلَيْهِ إِنَّهٗ لَا مُعِيْنَ عَلَيْهِ إِلَّا أَنْتَ لَا إِلٰهَ إِلَّا أَنْتَ" ,

                "<b><font "+color+">Dua and prayer at the time of storm in the sea</font></b><br>"+  "  اَللهُ الَّذِىْ نَزَّلَ الْكِتَابَ، وَ هُوَ يَتَوَلَّى الصَّالِحِيْن وَ مَا قَدَرُوْا اللهَ حَقَّ قَدْرِهٖ، وَ الْاَرْضُ جَمِيْعًا قَبْضَتُهٗ يَوْمَ الْقِيَامَةِ وَ السَّمٰوَاتُ مَطْوِيَّاتٌۢ بِيَمِيْنِهٖ، سُبْحَانَهٗ وَ تَعَالٰى عَمَّا يُشْرِكُوْنَ"
        };

        String [] daily1={
                "\nAll praise be to Allah who has forgiven us today and not destroyed us due to our sin",
                "\nO Allah, forgive my sins and widen my grave and grant barakat in my Rizq (sustenance)",
                "\nIn the name of Allah and with the blessings of Allah I begin (eating)",
                "\nO Allah, grant us blessings in it",
                "\n",
                "\nO Allah, I seek beneficial knowledge, wide sustenance and cure from all ailments from You",
                "\n\"All praise belongs to Allah, who fed us and quenched our thirst and made us Muslims",
                "\nO Allah, by Your name I live and die",
                "\nI seek refuge in Allah from the accursed Satan",
                "\n\"O Allah, the One who returns the lost, by Your power and awe return what I have lost, for surely I have received it as Your gift and favour (boon)",
                "\nO Lord, forgive my sins and open the doors of mercy for me",
                "\nThen we did set a seal on their ears for a number of years, then We raised them up that We might Know (i.e. ...show) which of the two parties reckoneth best the duration of their stay",
                "\nO Allah, all praise is to You, just as You have dressed me, I seek Your blessings of it and the blessings of what it is made of and I seek protection and Your refuge from all evil and the evil of that which it is made of",
                "\nO Allah, I seek refuge with you from all evil and evil-doers",
                "\nThere is no Lord except Allah: He is such a One Who has no partner and holds the power of the life and death of His creatures and Himself is such a Being Who never dies.",
                "\nO Allah! Keep me away from rebellious jins and men and devils and bless me in this house of mine",
                "\nHallowed is thy Lord, the Lord of Majesty, far above from that which they ascribe (unto Him) And peace be upon the prophet. And all praise is God’s the Lord of the worlds."
                ,"\nO Allah! Keep me and all the things with me safe and sound and let them reach the destination safely"
                ,"\nAt the place of scorpion bite salt should be poured and then recite Surah “Al-Kaferoon” (Chap. 109), Surah “Al-Falaq” (Chap. 113) and Surah “Al-Naas” (Chap. 114) one time each."

        };
        String [] daily2={
                "<b><font "+color+">At Morning</font></b><br>"+ " الْحَمْدُ لِلَّهِ الَّذِي أَقَالَنَا يَوْمَنَا هَذَا وَلَمْ يُهْلِكْنَا بِذُنُوبِنَا",
                "<b><font "+color+">During Wudhu</font></b><br>"+ " اللَّهُمَّ اغْفِرْ لِي ذَنْبِي وَوَسِّعْ لِي فِي دَارِي وَبَارِكْ لِي فِي رِزْقِي"
                ,"<b><font "+color+">Before Meal</font></b><br>"+ " بِسْمِ اللَّهِ وَعَلَى بَرَكَةِ اللَّهِ",
                "<b><font "+color+">Before Drinking Milk</font></b><br>"+  "اللَّهُمَّ بَارِكْ لَنَا فِيهِ وَزِدْنَا مِنْهُ",
                "<b><font "+color+">While Drinking Water</font></b><br>"+ " بِسْمِ اللَّه__ِafter finishing__الْحَمْدُ لِلَّهَِّ  ",
                "<b><font "+color+">Drinking Zam Zam water</font></b><br>"+ "اللَّهُمَّ إِنِّي أَسْأَلُكَ عِلْمَاً نَافِعَاًً وَرِزْقَاً وَاسِعَاًَ وَشِفَاءً مِنْ كُلِّ دَاءٍ",
                "<b><font "+color+">After Meal</font></b><br>"+ " الْحَمْدُ لِلَّهِ الَّذِي أَطْعَمَنَا وَسَقَانَا وَجَعَلَنَا مِنَ الْمُسْلِمِينَ",
                "<b><font "+color+">Before Sleep</font></b><br>"+ " اللَّهُمَّ بِاسْمِكَ أَمُوتُ وَأَحْيَا",
                "<b><font "+color+">At the Time of Anger</font></b><br>"+ " أَعُوذُ بِاللَّهِ مِنَ الشَّيْطَانِ الرَّجِيمِ",
                "<b><font "+color+">When something is lost</font></b><br>"+ " اللَّهُمَّ رَادَّ الضَّالَّةِ وَهَادِي الضَّالَّةِ أَنْتَ تَهْدِي مِنَ الضَّلَالَةِ ارْدُدْ عَلَيَّ ضَالَّتِي بِقُدْرَتِكَ وَسُلْطَانِكَ فَإِنَّهَا مِنْ عَطَائِكَ وَفَضْلِكَ",
                "<b><font "+color+">When entering the Masjid</font></b><br>"+ " اللَّهُمَّ افْتَحْ لِي أَبْوَابَ رَحْمَتِكَ",
                "<b><font "+color+">Dua for avoiding bad dreams</font></b><br>"+" فَضَرَبْنَا عَلٰى اٰذَانِهِمْ فِى الْكَهْفِ سِنِيْنَ عَدَدًا. ثُمَّ بَعَثْنَاهُمْ لِنَعْلَمَ اَىُّ الْحِزْبَيْنِ اَحْصٰى لِمَا لَبِثُوْآ اَمَدًا",
                "<b><font "+color+">When wearing new clothes</font></b><br>"+" اللَّهُمَّ لَكَ الْحَمْدُ كَمَا كَسَوْتَنِيهِ أَسْأَلُكَ خَيْرَهُ وَخَيْرَ مَا صُنِعَ لَهُ وَأَعُوذُ مِنْ شَرِّهِ وَشَرِّ مَا صُنِعَ لَهُ",
                "<b><font "+color+">Dua before entering the toilet</font></b><br>"+ " اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنَ الْخُبُثِ وَالْخَبَائِثِ",
                "<b><font "+color+">Dua for not getting afraid in sleep</font></b><br>"+ " لَا إِلٰهَ إِلَّا اللَّهُ وَحْدَهٗ لَا شَرِيْكَ لَهٗ لَهُ الْمُلْكُ وَ لَهُ الْحَمْدُ يُحْيِيْ وَ يُمِيْتُ وَ يُمِيْتُ وَ يُحْيِيْ وَ هُوَ حَيٌّ لَا يَمُوْتُ",
                "<b><font "+color+">While Building New House</font></b><br>"+ " اَللّٰهُمَّ ادْحَرْ عَنِّي مَرَدَةَ الْجِنِّ وَ الْإِنْسِ وَ الشَّيَاطِيْنِ وَ بَارِكْ لِي فِيْ بِنَائِي"
                ,"<b><font "+color+">Whenever one sits in gathering</font></b><br>"+ " سُبْحَانَ رَبِّكَ رَبِّ الْعِزَّةِ عَمَّا يَصِفُوْنَ. وَ سَلَامٌ عَلَى الْمُرْسَلِيْنَ. وَالْحَمْدُ لِلّٰهِ رَبِّ الْعَالَمِيْنَ."
                ,"<b><font "+color+">Before starting journey</font></b><br>"+ " اَللّٰهُمَّ احْفَظْنِي وَ احْفَظْ مَا مَعِيَ وَ سَلِّمْنِي وَ سَلِّمْ مَا مَعِيَ وَ بَلِّغْنِيْ وَ بَلِّغْ مَا مَعِيَ بِبَلَاغِكَ الْحَسَنِ الْجَمِيْلِ"
                ,"<b><font "+color+">For Scorpion Bite</font></b><br>"+""
        };



        String[] solv1={
                "\nO Allah make me contented with Your legitimate (things) in lace of Your forbidden things; and make me contented with Your favours, instead of other than thee. O The Ever Living, the Self Subsistent"
                ,"\nThere is no power and strength except with Allah the Grand, The Great",
                "\nThe Almighty God is pure and I begin with His praise. I pray salvation from Him and supplicate His Blessings."
                ,"\nIn the name of Allah The Beneficent, the Merciful There is no might and no power except with Allah"
                ,"\nIn the name of Allah the Beneficent and the Merciful. O Allah! Save My face by granting me prosperity and destroy not my prestige by reducing me to poverty so that I may have to seek my sustenance from those who seek (the same) from thee, or I may look forward for the kindness to thy evil Creatures; and consequently I may indulge in praise of those who may give and dispraise those who refused, though (indeed) Thou alone art responsible of all for grant or refusal, verily Thou art all-powerful over everything.",
                "\nIn the name of Allah the Beneficent, and the Merciful. Glory be to be him who does not oppress His subject Glory be to him who does not chastise the people of the earth with various punishments. Glory be to Him who is kind (and) Merciful O my Lord establish in my mind, light insight wisdom and knowledge indeed you have power on everything"

        };
        String [] solv2={
                "<b><font "+color+">For Disbursement of Debts</font></b><br>"+ "اَللّٰهُمَّ اكْـفِنِيْ بِحَلاَلِكَ عَنْ حَـرَامِكَ وَ اَغْنِنِيْ بِفَضْلِكَ عَمَّنْ سِوَاكَ يَا حَيُّ يَا قَيُّوْمُ",
                "<b><font "+color+">For removal of Poverty and Worries</font></b><br>"+"لَا حَوْلَ وَ لاَ قُوَّةَ اِلاَّ بِاللهِ الْعَلِيِّ الْعَظِيْمِ",
                "<b><font "+color+">For removing Worries</font></b><br>"+"سُبْحَانَ اللَّهِ الْعَظِيْمِ وَ بِحَمْدِهٖ أَسْتَغْفِرُ اللَّهَ وَ أَسْأَلُهٗ مِنْ فَضْلِهٖ",
                "<b><font "+color+">For Warding off Calamities</font></b><br>"+ "بِسْمِ اللهِ الرَّحْمٰنِ الرَّحِيْمِ. وَ لَا حَوْلَ وَ لاَ قُوَّةَ اِلاَّ بِاللهِ",
                "<b><font "+color+">Dua for increase in Sustenance</font></b><br>"+ "اَللّٰهُمَّ صُنْ وَجْهِي بِالْيَسَارِ وَ لَا تَبَذَّلْ جَاهِي بِالْإِقْتَارِ فَأَسْتَرْزِقَ طَالِبِي رِزْقِكَ وَ أَسْتَعْطِفَ شِرَارَ خَلْقِكَ وَ أَبْتَلِيَ بِحَمْدِ مَنْ أَعْطَانِي وَ أَفْتَتِنَ بِذَمِّ مَنْ مَنَعَنِيْ وَ أَنْتَ مِنْ وَرَاءِ ذٰلِكَ كُلِّهٖ وَلِيُّ الْإِعْطَاءِ وَ الْمَنْعِ إِنَّكَ عَلٰى كُلِّ شَيْءٍ قَدِيْرٌ"
                , "<b><font "+color+">Dua for Increasing Memory</font></b><br>"+ "سُبْحَانَ مَنْ لَا يَعْتَدِي عَلٰى أَهْلِ مَمْلَكَتِهٖ سُبْحَانَ مَنْ لَا يَأْخُذُ أَهْلَ الْأَرْضِ بِأَلْوَانِ الْعَذَابِ سُبْحَانَ الرَّءُوْفِ الرَّحِيْمِ اَللّٰهُمَّ اجْعَلْ لِي فِي قَلْبِيْ نُوراً وَ بَصَراً وَ فَهْماً وَ عِلْماً إِنَّكَ عَلٰى كُلِّ شَيْءٍ قَدِيْرٌ"
        };

        String[] istakara1={"\nO Allah, with Your knowledge I seek the good, with Your power I seek ability and Your mighty favour for certainly You have the power that I don't have, You know and I do not Know and You Know the unseen. O Allah, in Your knowledge if this work is good for me in this Duniya and the Akhirah (hereafter), then let it be for me, grant me blessings in it and if it is bad for me then keep it far away from me and grant me any destiny that will make me happy\".\n" +
                "\n"  +
                "While reading, think of the matter on hand",
                "\nO Allah, You have power (control) and I have no control and You know and I do not know, and You know the condition of the Unseen. Thus if You see (deem fit) that this woman (here mention her name) is good for me concerning my Deen, world and Akhirah then grant me her control (make it possible that I marry her) and if besides her there be (another woman) which is better for me concerning Deen and Akhirah then specify her for me (grant me control over he)\".\n" +
                        "\n" +" A woman should read \"him\" instead of \"her\"."
        };
        String[] istakara2={
                "<b><font "+color+">Istikhara</font></b><br>"+ "اللَّهُمَّ إِنِّي أَسْتَخِيرُكَ بِعِلْمِكَ وَأَسْتَقْدِرُكَ بِقُدْرَتِكَ وَأَسْأَلُكَ مِنْ فَضْلِكَ الْعَظِيمِ فَإِنَّكَ تَقْدِرُ وَلَا أَقْدِرُ وَتَعْلَمُ وَلَا أَعْلَمُ وَأَنْتَ عَلَّامُ الْغُيُوبِ اللَّهُمَّ إِنْ كُنْتَ تَعْلَمُ أَنَّ هَذَا الْأَمْرَ خَيْرٌ لِي فِي دِينِي وَمَعَاشِي وَعَاقِبَةِ أَمْرِي فَاقْدُرْهُ لِي وَيَسِّرْهُ لِي ثُمَّ بَارِكْ لِي فِيهِ وَإِنْ كُنْتَ تَعْلَمُ أَنَّ هَذَا الْأَمْرَ شَرٌّ فِي دِينِي وَمَعَاشِي وَعَاقِبَةِ أَمْرِي فَاصْرِفْهُ عَنِّي وَاصْرِفْنِي عَنْهُ وَاقْدُرْ لِيَ الْخَيْرَ حَيْثُ كَانَ ثُمَّ ارْضِنِي بِهِ"
                ,"<b><font "+color+">Istikhara for Marriage</font></b><br>"+"اللَّهُمَّ إِنَّكَ تَقْدِرُ وَلَا أَقْدِرُ وَتَعْلَمُ وَلَا أَعْلَمُ وَأَنْتَ عَلَّامُالْغُيُوبِ ، فَإِنْ رَأَيْتَ أَنَّ فِي فُلَانَةِ خَيْرَاً لِي فِي دِينِي وَدُنْيَايَ وَآخِرَتِي فَاقْدُرْهَا لِي وَإِنْ كَانَ غَيْرُهَا خَيْرٌ مِنْهَا لِي فِي دِينِي وَآخِرَتِي فَاقْدُرْهَا لِي"
        };


        allEngDua.add(journey1);
        allEngDua.add(daily1);
        allEngDua.add(solv1);
        allEngDua.add(istakara1);
        allEngDua.add(forgive1);
        allEngDua.add(mix1);
        allEngDua.add(avoid1); allEngDua.add(prayer1);
        allEngDua.add(reward1);
        allEngDua.add(d1);
        allEngDua.add(good1);
        allEngDua.add(marriage1);
        allEngDua.add(protect1);
        allEngDua.add(learn1);
        allEngDua.add(dis1);



        allArabicDua.add(journey2);
        allArabicDua.add(daily2);
        allArabicDua.add(solv2);
        allArabicDua.add(istakara2);
        allArabicDua.add(forgive2);
        allArabicDua.add(mix2);
        allArabicDua.add(avoid2); allArabicDua.add(prayer2);
        allArabicDua.add(reward2);
        allArabicDua.add(d2);
        allArabicDua.add(good2);
        allArabicDua.add(marriage2);
        allArabicDua.add(protect2);
        allArabicDua.add(learn2);
        allArabicDua.add(dis2);


        switch (event)
        {
            case "Journey":
                a=Arrays.asList(journey1);
                b=Arrays.asList(journey2);
                break;
            case "Daily Routine":

                a=Arrays.asList(daily1);
                b=Arrays.asList(daily2);
                break;
            case "Common Problems":

                a=Arrays.asList(solv1);
                b=Arrays.asList(solv2);
                break;
            case "Istikhara":
                a=Arrays.asList(istakara1);
                b=Arrays.asList(istakara2);
                break;
            case "Forgiveness":
                a=Arrays.asList(forgive1);
                b=Arrays.asList(forgive2);
                break;
            case "Mix Duas":
                a=Arrays.asList(mix1);
                b=Arrays.asList(mix2);
                break;
            case "Avoidance of Bad Habits":
                a=Arrays.asList(avoid1);
                b=Arrays.asList(avoid2);
                break;
            case "Recovery":
                a=Arrays.asList(recover1);
                b=Arrays.asList(recover2);
                break;
            case "Get Amazing Rewards":
                a=Arrays.asList(reward1);
                b=Arrays.asList(reward2);
                break;
            case "After Prayers":
                a=Arrays.asList(prayer1);
                b=Arrays.asList(prayer2);
                break;
            case "On Death":
                a=Arrays.asList(d1);
                b=Arrays.asList(d2);
                break;
            case "Good-Deeds":
                a=Arrays.asList(good1);
                b=Arrays.asList(good2);
                break;
            case "Marriage Related":
                a=Arrays.asList(marriage1);
                b=Arrays.asList(marriage2);
                break;
            case "Protection":
                a=Arrays.asList(protect1);
                b=Arrays.asList(protect2);
                break;
            case "Learinng":
                a=Arrays.asList(learn1);
                b=Arrays.asList(learn2);
                break;
            case "Curing Diseases":
                a=Arrays.asList(dis1);
                b=Arrays.asList(dis2);
                break;
            default:
//
                a=new ArrayList();
                b=new ArrayList();
                try
                {

                    DbZikrHelper db=new DbZikrHelper(context);
                    ArrayList res= db.getData(event);



                    for(int i=0;i<res.size();i++)
                    {
                        a.add("<font color=\'#1E7BE8\'>"+res.get(i).toString()+"</font>"  );
                        b.add("<font color=\'#000\'>"+event+"</font>");
                    }



                }catch(Exception exp)
                {



                }


                break;



        }

        journey1=null;
        journey2=null;
        daily1=null;
        daily2=null;
        solv1=null;
        solv2=null;
        dis1=null;
        dis2=null;
        learn1=null;
        learn2=null;
        protect1=null;
        protect2=null;
        marriage1=null;
        marriage2=null;
        good1=null;
        d1=null;
        good2=null;
        d2=null;
        prayer1=null;
        prayer2=null;
        recover1=null;
        recover2=null;
        reward1=null;
        reward2=null;
        mix1=null;
        mix2=null;
        avoid1=null;
        avoid2=null;
        forgive1=null;
        forgive2=null;
        istakara1=null;
        istakara2=null;

        return a;
    }

    public List getB() {
        return b;
    }

    String getDay()
    {
        Calendar c = Calendar.getInstance();
        int day=c.get(Calendar.DAY_OF_WEEK);
        String present_day="Monday";


        switch(day)
        {
            case 1:
                present_day="Sunday";
                break;
            case 2:
                present_day="Monday";
                break;
            case 3:
                present_day="Tuesday";
                break;
            case 4:
                present_day="Wednesday";
                break;
            case 5:
                present_day="Thursday";
                break;
            case 6:
                present_day="Friday";
                break;
            case 7:
                present_day="Saturday";
                break;
            default:
                present_day="Sunday";
                break;
        }
        return  present_day;

    }



}
