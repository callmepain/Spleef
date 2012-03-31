package de.callmepain.SPL;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.logging.Logger;

public class SPLIO {
	public SPLIO() {
		
	}
	public static void saveHash(HashMap<String, Integer>X, Logger log) {
		try
		{
			String path = "plugins/SPL";
			BufferedWriter bw = new BufferedWriter(new FileWriter(path + "/highscore.ini"));
		   
		   for(String p:X.keySet())
		   {
		      bw.write(p + "," + X.get(p));
		      bw.newLine();
		   }
		   bw.flush();
		   bw.close();
		}
		catch (IOException e){
            log.info("[ServerNews] + '"  + "/highscore.ini' not found.");
        }
	}
	public static void loadHash(HashMap<String, Integer>X,Logger log) {
		try
		{
			String path = "plugins/SPL";
		   BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path + "/highscore.ini")));
		   String l;
		   while((l = br.readLine()) != null)
		   {
		      String[] args = l.split("[,]", 2);
		      if(args.length != 2)continue;
		      String p = args[0].replaceAll(" ", "");
		      int b = Integer.parseInt(args[1].replaceAll(" ", ""));
		      X.put(p, b);
		   }
		   br.close();
		}
		catch (IOException e){
            log.info("[ServerNews] + '" + "/highscore.ini' not found.");
        }
	}
}
