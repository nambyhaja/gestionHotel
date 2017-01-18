/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formatage;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author nambi
 */
public class Formater {
    public static Date setDate(String date) throws ParseException {
        String[] separateurs={":","/",".","-"};
        String[] valiny=new String[3];
        int indiceSep=0;
        for(int i=0;i<separateurs.length;i++)
        {
            date=date.replace(separateurs[i],separateurs[3]);
        }
        valiny=date.split(separateurs[3]);
        if(valiny[2].length()==2)
        {
           valiny[2] = "20"+valiny[2];
        }
        date=valiny[0]+"-"+valiny[1]+"-"+valiny[2];
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date parsed=null;
        parsed =  sdf.parse(date);
        java.sql.Date data = new java.sql.Date(parsed.getTime());
        return data;
    }
    public static Time setHeure(String heure) throws ParseException, Exception {
        
        String[] separateurs={":","/","h","H",".","-"};
        String[] englishType={"AM "," AM","AM","PM "," PM","PM"};
        boolean pm=false;
        String[] valiny=new String[2];
        for(int i=0;i<separateurs.length;i++)
        {
            heure=heure.replace(separateurs[i],separateurs[0]);
        }
        for(int i=0;i<englishType.length;i++)
        {
            if(heure.startsWith(englishType[i]) || heure.startsWith(englishType[i].toLowerCase()))
            {
                heure = heure.substring(englishType[i].length());
                if(englishType[i].contains("PM"))
                {
                    pm=true;
                }
                break;
            }
            else if(heure.endsWith(englishType[i]) || heure.endsWith(englishType[i].toLowerCase()))
            {
                heure = heure.substring(0,heure.length()-englishType[i].length());
                if(englishType[i].contains("PM"))
                {
                    pm=true;
                }
                 break;
            }
        }
        valiny = heure.split(separateurs[0]);
        if(pm==true)
        {
            if(Integer.parseInt(valiny[0])>=12)
            {
                throw new Exception("Format heure invalide");
            }
            else
            {
                Integer pass=Integer.parseInt(valiny[0])+12;
                valiny[0]=pass.toString();
            }
        }
        heure=valiny[0]+":"+valiny[1];
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        long ms = sdf.parse(heure).getTime();
        Time t = new Time(ms);
        return t;
    }
}
